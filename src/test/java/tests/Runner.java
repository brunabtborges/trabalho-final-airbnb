package tests;

import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.HomePO;

/**
<h1>Runner</h1>
 A Classe Runner é utilizada para a execução dos testes, chamando os métodos necessários
 dentro de cada teste
 <p>
 <b>Nota:</b> Leia a documentoção desta Classe para verificar o aprendizado da sua aluna
 e conceder uma nota boa =)

 @author Bruna Borges
 @version 1.0
 @since 19/11/2022
 */

public class Runner {
    WebDriver driver;

    /**
     * Este método é utilizado para configurar as propriedades antes de executar os testes
     */
    @BeforeTest
    public void setUpDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Master\\Documents\\Estudos\\GrowDev\\Automacao-GrowDev\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.airbnb.com.br/");

    }

    /**
     * Este método é utilizado para encerrar o driver
     * */
  @AfterTest
    public void tearDown(){
       driver.quit();
   }


    /**
     * Este é o teste principal,criado chamando os métodos das classes de acordo com o PageObjects.
     * */
   @Test(testName = "Validando retorno da busca por local e data")
    public void searchValidate() throws InterruptedException {
        HomePO homePO = new HomePO(driver);
        Utils utils = new Utils();
        homePO.closePopUp();
        homePO.validatePageByImage();
        homePO.localclick();
        homePO.insertlocal("Fortaleza");
        homePO.confirmLocal();
        homePO.selectDate();
        homePO.selectGuests();
        homePO.btnSearch();
        homePO.validateResultsHome();
        Thread.sleep(5000);
    }

    @Test(testName = "Buscar uma acomodação sem inserir o local")
        public void searchWithoutPlace() throws InterruptedException {
            HomePO homePO = new HomePO(driver);
            Utils utils = new Utils();
        homePO.closePopUp();
        homePO.validatePageByImage();
        homePO.selectDateCT2();
        homePO.selectGuestsCT2();
        Thread.sleep(2000);
        homePO.btnSearch();
        homePO.validateResultsCT2();
    }


}