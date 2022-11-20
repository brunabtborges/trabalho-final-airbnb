package tests;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

        /**
         * Validar página pelo logo - utilizado para validar se a página correta foi acessada
         * @param driver (WebDriver)
         * @param by (inserir o valor para capturar o elemento)
         * */
        public WebElement validatePageByImage(WebDriver driver, By by) {
            WebElement element = new WebDriverWait
                    (driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(by));

            Assert.assertTrue(element.isDisplayed());
            return element;
        }


        /**
        * Scroll - utilizado para rolar a página para baixo
        * @param driver (WebDriver)
        * @param pixels (inserir o valor desejado para informar até onde deseja rolar a página)
        * */
        public void scrollPage(WebDriver driver, String pixels) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("window.scrollBy(0,"+ pixels +")");
        }

    /**
     * Capturar um elemento - utilizado para capturar um elemento
     * @param driver (WebDriver)
     * @param by (inserir o valor para capturar o elemento)
      */
    public WebElement getElement(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        return element;
        }

    /**
     * WebDriverWait(elementToBeClickable) - utilizado para aguardar até que o elemento seja clicável
     * ou aguardar até 10 segundos.
     * @param driver (WebDriver)
     * @param by (inserir o valor para capturar o elemento)
     * */
        public WebElement waitUntilClickable(WebDriver driver, By by) {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(by));
            return element;
        }

    /**
     * WebDriverWait(elementIsVisible) - utilizado para aguardar até que o elemento esteja visível
     * ou aguardar até 10 segundos.
     * @param driver (WebDriver)
     * @param by (inserir o valor para capturar o elemento)
     * */
    public WebElement waitUntilIsVisible(WebDriver driver, By by) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.assertTrue(element.isDisplayed());
        return element;
    }

    /**
     * Click - função clicar em um elemento
     * @param driver (WebDriver)
     * @param by (inserir o valor para capturar o elemento)
     * */
        public void elementClick(WebDriver driver, By by) {
            WebElement element = getElement(driver, by);
            element.click();
        }

    /**
     * Clear - função limpar/apagar os valores de um input
     * @param driver (WebDriver)
     * @param by (inserir o valor para capturar o elemento)
     * */
        public void elementClear(WebDriver driver, By by) throws InterruptedException {
            WebElement element = getElement(driver, by);
            element.clear();
        }

    /**
     * SendKeys - função inserir valores (texto) em um input
     * @param driver (WebDriver)
     * @param by (inserir o valor para capturar o elemento)
     * @param text (inserir o texto desejado)
     * */
        public void elementSendKeys(WebDriver driver, By by, String text) throws InterruptedException {
            WebElement element = getElement(driver, by);
            Thread.sleep(5000);
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    /**
     * SendKeys (Sobrecarga) - função inserir valores (texto) em um input
     * @param driver (WebDriver)
     * @param by (inserir o valor para capturar o elemento)
     * @param text (inserir o texto desejado)
     * @param key (inserir texto)
     * */
        public void elementSendKeys(WebDriver driver, By by, String text, Keys key) throws InterruptedException {
            WebElement element = getElement(driver, by);
            element.click();
            element.clear();
            element.sendKeys(text, key);
        }

    }

