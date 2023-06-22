import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.lang.Thread.*;

public class BasePage {
    private WebDriver driver;

    public BasePage(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    public void fechar() {
        this.driver.quit();
    }

    public void pesquisarAlgoNoGoogle(String texto) {
        WebElement inputPesquisar = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        inputPesquisar.sendKeys(texto);
        inputPesquisar.submit();
    }

    public void acessarPesquisa(String resultadoPesquisa) {
        WebElement txtEmpresa = driver.findElement(By.xpath("//h3[.='"+ resultadoPesquisa +"']"));
        txtEmpresa.click();
    }

    public void termoDeUsabilidade(String botao) throws InterruptedException {
        sleep(5000);
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='ifrmCookieBanner']"));
        driver.switchTo().frame(iframe);
        WebElement btnAceitar = driver.findElement(By.xpath("//button[contains(., '"+ botao +"')]"));
        btnAceitar.click();
        driver.switchTo().defaultContent();
    }

    public void acessarCarreiras() {
        WebElement txtCarers = driver.findElement(By.xpath("//a[contains(.,'Careers')]"));

        txtCarers.click();
        WebElement txtJobOpportunities = driver.findElement(By.xpath("//a[contains(.,'Job opportunities')]"));
        txtJobOpportunities.click();
    }

    public void mudarDeAba() throws InterruptedException {
        String originalWindow = driver.getWindowHandle();
        sleep(5000);
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void procurarCarreira(String buscarCarreira) throws InterruptedException {
        sleep(5000);
        WebElement searchCarers = driver.findElement(By.xpath("//input[contains(@name,'sGlobal')]"));
        searchCarers.sendKeys(buscarCarreira);
        searchCarers.sendKeys(Keys.ENTER);
    }

    public String carreiraEncontrada(){
        return driver.findElement(By.xpath("//a[contains(.,'Pessoa Engenheira de Dados - Híbrido')]")).getText().toUpperCase();
    }
}
