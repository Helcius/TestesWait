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

public class TesteSemWait {

    private WebDriver driver;
    String URL = "https://igorsmasc.github.io/praticando_waits/";

    @BeforeEach
    public void BeforeEach(){
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterEach
    public void AfterEach(){
        driver.quit();
    }

    @Test
    public void TestBotaoEscondido() throws InterruptedException {

        Thread.sleep(5000);
        WebElement element = driver.findElement(By.id("botao-escondido"));

        element.click();

        Alert alert = driver.switchTo().alert();

        Assertions.assertEquals("Você clicou no botão escondido!", alert.getText());

    }

    @Test
    public void TestBotaoAlerta() throws InterruptedException {
        WebElement element = driver.findElement(By.id("botao-alerta"));
        element.click();

        Thread.sleep(5000);

        Alert alert = driver.switchTo().alert();

        Assertions.assertEquals("Alerta após 3 segundos!", alert.getText());

    }

    @Test
    public void TestBotaoTitulo() throws InterruptedException {
        WebElement element = driver.findElement(By.id("botao-titulo"));

        WebElement titulo = driver.findElement(By.tagName("h1"));

        Assertions.assertEquals("Título da Página", titulo.getText());


        element.click();

        Thread.sleep(5000);


        Assertions.assertEquals("Novo Título da Página", titulo.getText());

    }

    @Test
    public void TestBotaoParagrafo() throws InterruptedException {
        WebElement element = driver.findElement(By.id("botao-paragrafo"));
        element.click();

        Thread.sleep(5000);

        WebElement paragrafo = driver.findElement(By.tagName("p"));

        Assertions.assertEquals("Este é um novo parágrafo adicionado após 3 segundos.", paragrafo.getText());

    }

    @Test
    public void TestBotaoNovo() throws InterruptedException {

        Thread.sleep(5000);
        WebElement element = driver.findElement(By.id("botao-novo"));
        element.click();

        Alert alert = driver.switchTo().alert();

        Assertions.assertEquals("Botão clicado!", alert.getText());


    }

}
