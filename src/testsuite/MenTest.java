package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility
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
         * 3 Steps in one line of mouse hover
         * 1.1 Mouse Hover on Men Menu
         * 1.2 Mouse Hover on Bottoms
         * 1.3 Click on Pants
         */
        mouseHoverActionforThree(By.xpath("//span[contains(text(),'Men')]"),By.xpath("//li[@class='level1 nav-3-2 category-item last parent ui-menu-item']//span[text()='Bottoms']"),By.xpath("//li[@class='level2 nav-3-2-1 category-item first ui-menu-item']//span[text()='Pants']"));

        //1.4 Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverAction(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"), By.xpath("//div[@id='option-label-size-143-item-175']"));
        Thread.sleep(1000);

        //1.5 Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverAction(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"), By.xpath("//div[@id='option-label-color-93-item-49']"));

        //1.7 Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverAction(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"), By.xpath("//span[text()='Add to Cart']"));
        Thread.sleep(1000);

        //1.8 Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        assertVerifyText("Added message not found", "You added Cronus Yoga Pant to your shopping cart.", By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Thread.sleep(1000);

        //1.9 Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //1.10 Verify the text ‘Shopping Cart.’
        assertVerifyText("Shopping cart text not found","Shopping Cart", By.xpath("//span[text()='Shopping Cart']"));
        Thread.sleep(1000);

        //1.11 Verify the product name ‘Cronus Yoga Pant’
        //assertVerifyText("Yoga Pant text not found","Cronus Yoga Pant", By.xpath("//div[@class='product-item-details']//a[text()='Cronus Yoga Pant ']"));

        //1.12 Verify the product size ‘32’
        assertVerifyText("Size 32 text not found","32", By.xpath("//dd[contains(text(),'32')]"));
        Thread.sleep(1000);

        //1.13 Verify the product colour ‘Black’
        assertVerifyText("Black text not found","Black", By.xpath("//dd[contains(text(),'Black')]"));
        Thread.sleep(1000);
    }


    @After
    public void quitBrowser()
    {
        closeBrowser();
    }

}
