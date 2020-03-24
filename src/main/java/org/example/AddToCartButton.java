package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToCartButton extends Utils {
    public void verifyAddToCartButtonPresent () {
        By _itemBoxesfield = By.className("product-item");
        By _addcartButtonfield = By.cssSelector("[type='button'][value='Add to cart']");
        By _productnamefield = By.cssSelector("h2.product-title > a");

        List<WebElement> webElementList = driver.findElements(_itemBoxesfield);
        int count = 0;
        for (WebElement element : webElementList) {
            //finding add to cart element present in each product box
            if (element.findElements(_addcartButtonfield).size() == 1) {
                //adding add to cart button for counting
                count++;
            } else {
                //if add to cart element not present, then printing product title/name from that product box
                System.out.println("   " + "NO ADD TO CART BUTTON >>> " + element.findElement(_productnamefield).getText() + "\n");
            }
        }

    }
}
