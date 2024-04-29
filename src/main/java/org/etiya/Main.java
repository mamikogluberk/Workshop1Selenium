package org.etiya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.saucedemo.com/v1/");

        //getTitle geçerli sayfanın başlığını alır. Sayfanın <title> etiketi içeriğini döndürür.
        String title = webDriver.getTitle();
        System.out.println(title);

        /*webDriver.manage().window().maximize() ifadesi, Selenium WebDriver üzerinde kullanılan bir fonksiyondur
        ve bu fonksiyonun amacı, tarayıcı penceresini maksimum boyuta getirmektir. .*/
        webDriver.manage().window().maximize();


        /*findElement belirtilen seçici (By nesnesi) kullanarak bir web elementi bulur.
        Seçici, elementin nasıl bulunacağını tanımlar (id, name, xpath, cssSelector gibi).
        Eğer element bulunamazsa NoSuchElementException hatası fırlatılır.
         */
        WebElement userNameinput = webDriver.findElement(By.id("user-name"));

        /*sendKeys bir WebElement'e metin girişi yapar. sendKeys metoduna iletilen parametreler,
        WebElement'in içine yazılır.*/
        userNameinput.sendKeys("standard_user");
        Thread.sleep(1000);

        //clear bir input alanının içeriğini temizler. Özellikle metin girişi alanlarını temizlemek için kullanılır.
        userNameinput.clear();
        Thread.sleep(1000);

        userNameinput.sendKeys("standard_user");
        Thread.sleep(1000);
        WebElement passwordinput = webDriver.findElement(By.id("password"));
        passwordinput.sendKeys("secret_sauce");
        Thread.sleep(1000);
        WebElement loginbutton = webDriver.findElement(By.id("login-button"));

        //click bir WebElement'e tıklama işlemi gerçekleştirir. Bu genellikle butonlar veya linkler için kullanılır.
        loginbutton.click();
        Thread.sleep(3000);

        /*getText, bir WebElement'in metin içeriğini alır. Özellikle <div>, <p>, <span> gibi elementlerin
        içeriğini almak için kullanılır.*/
        WebElement firstItem = webDriver.findElement(By.className("inventory_item_name"));
        String text = firstItem.getText();
        System.out.println("Element text: " + text);

        /*isDisplayed bir WebElement'in görünür olup olmadığını kontrol eder. Eğer element sayfada mevcutsa ve
        görünüyorsa true değeri döner.*/
        WebElement addToCartButton = webDriver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
        if (addToCartButton.isDisplayed()) {
            System.out.println("Add to cart button is visible.");
            addToCartButton.click();
        } else {
            System.out.println("Add to cart button is not visible.");
        }
        Thread.sleep(1000);

        WebElement removeButton = webDriver.findElement(By.className("btn_secondary"));
        boolean isButtonVisible = removeButton.isDisplayed();

        if (isButtonVisible) {
            System.out.println("REMOVE button is visible");
        } else {
            System.out.println("REMOVE button is not visible");
        }

        /*Bu fonksiyon, WebDriver'ı belirtilen URL'ye gitmek için kullanır. Bu, tarayıcıyı belirli bir web sayfasına
         yönlendirir.*/

        webDriver.get("https://www.saucedemo.com/v1/cart.html");
        Thread.sleep(1000);


        /*
        Thread.sleep(1000);
        WebElement basketbutton = webDriver.findElement(By.id("shopping_cart_container"));
        basketbutton.click();
        Thread.sleep(1000);
        */

        /*Bu fonksiyon, bir WebElement'in etkin olup olmadığını kontrol eder. Özellikle butonların etkin veya
        etkisiz olup olmadığını kontrol etmek için kullanılır.*/
        WebElement checkoutEnable = webDriver.findElement(By.className("checkout_button"));
        if (checkoutEnable.isEnabled()) {
            System.out.println("Checkout Button is enabled.");
        } else {
            System.out.println("Checkout Button is disabled.");
        }

        WebElement menuButton = webDriver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button"));
        menuButton.click();
        Thread.sleep(1000);

        WebElement logoutLink = webDriver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logoutLink.click();
        Thread.sleep(1000);


        Thread.sleep(3000);

        webDriver.quit();

    }
}