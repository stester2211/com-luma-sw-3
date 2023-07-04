package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility
{
    @Before
    public void openBrowser()
    {
        setUpBrowser();
    }

    @Test
    //1. userShouldAddProductSuccessFullyToShoppinCart()
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        /**
         * 2 Steps together in 1 line
         * 1.1 Mouse Hover on Gear Menu
         * 1.2 Click on Bags
         */
        mouseHoverAction(By.xpath("//span[contains(text(),'Gear')]"),By.xpath("//span[contains(text(),'Bags')]"));
        Thread.sleep(1000);

        //1.3 Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));

        //1.4 Verify the text ‘Overnight Duffle’
        assertVerifyText("Duffle text not found","Overnight Duffle",By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        Thread.sleep(1000);

        //1.5 Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"),"3");

        //1.6 Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
        Thread.sleep(1000);

        //1.7 Verify the text ‘You added Overnight Duffle to your shopping cart.’
        assertVerifyText("Added to cart message not found","You added Overnight Duffle to your shopping cart.", By.xpath("//div[@class='message-success success message']"));

        //1.8 Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(1000);

        //1.9 Verify the product name ‘Cronus Yoga Pant’
        //assertVerifyText("Yoga Pant text not found","Cronus Yoga Pant", By.xpath("//div[@class='product-item-details']//a[text()='Cronus Yoga Pant ']"));

        //1.10 Verify the Qty is ‘3’
        //assertVerifyText("Qty is not 3","3",By.xpath("//input[@class='input-text qty']"));
        Thread.sleep(1000);

        //1.11 Verify the product price ‘$135.00’
        assertVerifyText("Price is not 135","$135.00",By.xpath("//span[contains(text(),'$135.00')]"));

        //1.12 Change Qty to ‘5’
        driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
        sendTextToElement(By.xpath("//input[@class='input-text qty']"),"5");
        Thread.sleep(1000);

        //1.13 Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

        //1.14 Verify the product price ‘$225.00’
        assertVerifyText("Price is not updated", "$225.00", By.xpath("//span[contains(text(),'$225.00')]"));
        Thread.sleep(1000);
    }

    @After
    public void quitBrowser()
    {
        closeBrowser();
    }
}
