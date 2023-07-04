package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility
{
    @Before
    public void openBrowser()
    {
        setUpBrowser();
    }

    //1. verifyTheSortByProductNameFilter
    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException
    {
        /**
         * 3 steps in 1 mouse hover step
         * 1.1 Mouse Hover on Women Menu
         * 1.2 Mouse Hover on Tops
         * 1.3 Click on Jackets
         */
        mouseHoverActionforThree(By.xpath("//span[contains(text(),'Women')]"), By.xpath("//li[@class='level1 nav-2-1 category-item first parent ui-menu-item']//span[text()='Tops']"), By.xpath("//li[@class='level2 nav-2-1-1 category-item first ui-menu-item']//span[text()='Jackets']"));
        Thread.sleep(2000);

        //1.4 Select Sort By filter “Product Name”
        selectByValueFromDropDown(By.xpath("//div[@class='toolbar-sorter sorter']//select[@id='sorter']"),"name");
        Thread.sleep(1000);

        //1.5 Verify the products name display in alphabetical order
        List<WebElement> productsName = driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));
        System.out.println("Product List in ascending order : ");
        for (WebElement products: productsName)
        {
            System.out.println(products.getText());
        }
    }

    @Test
    //2. verifyTheSortByPriceFilter
    public void verifyTheSortByPriceFilter() throws InterruptedException
    {
        /**
         * 3 steps in 1 mouse hover step
         * 1.1 Mouse Hover on Women Menu
         * 1.2 Mouse Hover on Tops
         * 1.3 Click on Jackets
         */
        mouseHoverActionforThree(By.xpath("//span[contains(text(),'Women')]"), By.xpath("//li[@class='level1 nav-2-1 category-item first parent ui-menu-item']//span[text()='Tops']"), By.xpath("//li[@class='level2 nav-2-1-1 category-item first ui-menu-item']//span[text()='Jackets']"));
        Thread.sleep(2000);

        //2.4 Select Sort By filter “Price”
        selectByValueFromDropDown(By.xpath("//div[@class='toolbar-sorter sorter']//select[@id='sorter']"),"price");
        Thread.sleep(1000);

        //2.5 Verify the products price display in Low to High
        List<WebElement> productsName = driver.findElements(By.xpath("//span[@class='price-container price-final_price tax weee']"));
        System.out.println("Product List Low to High : ");
        for (WebElement products: productsName)
        {
            System.out.println(products.getText());
        }
        Thread.sleep(1000);
    }

    @After
    public void quitBrowser()
    {
        closeBrowser();
    }
}
