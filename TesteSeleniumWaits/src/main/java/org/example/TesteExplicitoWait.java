package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TesteExplicitoWait {

    private WebDriver driver;
    String URL = "https://igorsmasc.github.io/praticando_waits/";

    private WebDriverWait wait;

    @BeforeEach
    public void BeforeEach(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(URL);
    }

    @AfterEach
    public void AfterEach(){
        driver.quit();
    }

    @Test
    public void TestBotaoEscondido(){

        WebElement element = driver.findElement(By.id("botao-escondido"));
        wait.until(ExpectedConditions.visibilityOf(element));

//        wait.until(ExpectedConditions.alertIsPresent());

        element.click();

        Alert alert = driver.switchTo().alert();

        Assertions.assertEquals("Você clicou no botão escondido!", alert.getText());

    }

    @Test
    public void TestBotaoAlerta() throws InterruptedException {
        WebElement element = driver.findElement(By.id("botao-alerta"));
        element.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        Assertions.assertEquals("Alerta após 3 segundos!", alert.getText());

    }

    @Test
    public void TestBotaoTitulo() {
        WebElement element = driver.findElement(By.id("botao-titulo"));

        WebElement titulo = driver.findElement(By.tagName("h1"));

        Assertions.assertEquals("Título da Página", titulo.getText());


        element.click();



        Assertions.assertEquals("Novo Título da Página", titulo.getText());

    }

    @Test
    public void TestBotaoParagrafo() {
        WebElement element = driver.findElement(By.id("botao-paragrafo"));
        element.click();


        WebElement paragrafo = driver.findElement(By.tagName("p"));

        Assertions.assertEquals("Este é um novo parágrafo adicionado após 3 segundos.", paragrafo.getText());

    }

    @Test
    public void TestBotaoNovo() {

        WebElement element = driver.findElement(By.id("botao-novo"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

        Alert alert = driver.switchTo().alert();

        Assertions.assertEquals("Botão clicado!", alert.getText());


    }






}
