package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.Utils;


public class HomePO {

    WebDriver driver;
    Utils utils = new Utils();


    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    //Fechando a PopUp da home.
    public void closePopUp() {
        utils.waitUntilClickable(driver,By.cssSelector("body > div:nth-child(78) > sectio" +
                "n > div > div > div._z4lmgp > div > div._1wv4knt > button > span > svg")).click();
    }

    //Validando a página inicial pela presença do logo.
    public void validatePageByImage() {
        utils.waitUntilIsVisible(driver,By.cssSelector("body > div:nth-child(7) > div > div > div:nth-child(1) > div > div > di" +
                "v._1unac3l > div > div > div > div > div > div > div.h1wqqi3k.dir.dir-ltr > div > div > div > div > header > " +
                "div > div.cqul55.dir.dir-ltr > div > div > div > a > div.l10sdlqs.dir.dir-ltr > svg"));
        }

        //Clicando no input de "Local".
    public void localclick() {
        utils.waitUntilClickable(driver, By.cssSelector("body > div:nth-child(7) > div > div > div:nth-child" +
                "(1) > div > div > div._1unac3l > div > div > div > div > div > div > div.h1wqqi3k.dir.dir-lt" +
                "r > div > div > div > div > header > div > div.cylj8v3.dir.dir-ltr > div > div > div > div.lkm6i7z.l1r" +
                "zxhu2.lr5v90m.dir.dir-ltr > div > button:nth-child(2) > div")).click();
    }

    //Inserindo a cidade desejada para a busca.
    public void insertlocal(String cidade) throws InterruptedException {
        utils.elementSendKeys(driver,By.cssSelector("#bigsearch-query-location-input"), cidade);
    }

    //Confirmando a cidade escolhida.
    public void confirmLocal() {
        utils.waitUntilClickable(driver, By.cssSelector("#bigsearch-query-location-suggestion-0 > div._1825a1k > div")).click();
    }

    //Selecionando as datas de checkin e checkout.
    public void selectDate() {
       WebElement dateCheckIn = utils.waitUntilClickable(driver,By.cssSelector("#panel--tabs--0 > div > div.dhjkeof.dir.dir-ltr > div > div > div > div > div._14676s3 > div._1foj6yps > div > div:nth-child(3) > div > table > tbody > tr:nth-child(3) > td:nth-child(2) > div"));
       dateCheckIn.click();

       WebElement dateCheckOut = utils.waitUntilClickable(driver,By.cssSelector("#panel--tabs--0 > div > div.dhjkeof.dir.dir-ltr > div > div > div > div > div._14676s3 > div._1foj6yps > div > div:nth-child(3) > div > table > tbody > tr:nth-child(5) > td:nth-child(2) > div"));
       dateCheckOut.click();
    }

    //Selecionando a quantidade de hóspedes.
    public void selectGuests() {
        utils.elementClick(driver,By.cssSelector("#search-tabpanel > div > div.c6ezw63.c1geg2ah.dir.dir-ltr" +
                " > div.c2frgdd.crbzydf.dir.dir-ltr > div.b192dx2b.b174x59c.bkmyqgh.dir.dir-ltr > div > div.p1kudodg.dir.dir-ltr"));
        utils.elementClick(driver,By.cssSelector("#stepper-adults > button:nth-child(3) > span > svg > path"));
        utils.elementClick(driver,By.cssSelector("#stepper-adults > button:nth-child(3) > span > svg > path"));
        utils.elementClick(driver,By.cssSelector("#stepper-children > button:nth-child(3) > span > svg > path"));
    }

    //Clicando no botão pesquisar
    public void btnSearch()throws InterruptedException {
        utils.elementClick(driver,By.cssSelector("#search-tabpanel > div > div.c6ezw63.c1geg2ah.dir.dir-ltr " +
                "> div.c2frgdd.crbzydf.dir.dir-ltr > div.s1i622mb.dir.dir-ltr > button > span._jxxpcd > span"));
    }

    /*NOTA:
    * Will, eu gostaria de ter feito essa validação de outra forma: ou validar que o mapa mostra a cidade selecionada
    * ou validar que as acomodações que o site retorna contem o nome da cidade selecionada no texto.
    * Porém o AirBnb mostra os resultados de forma dinâmica, nem sempre elas aparecem na mesma posição e nem sempre
    * no texto do link ou na própria descrição tem o nome da cidade, ou também o site tras cidades próximas.
    * Por este motivo eu fiz a validação conforme orientado, apenas validando que o mapa está visível.*/
    //Validando o resultado da busca pela presença do mapa.
    public void validateResultsHome(){
        utils.validatePageByImage(driver,By.cssSelector("#site-content > div.fhusglq.dir.dir-ltr > div.p1lc3mon.dir.dir-ltr > div > div > div > div > section > h1 > span"));
    }
}
