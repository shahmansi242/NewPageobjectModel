package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ComputerCategory extends Utils {
    private By _noteBooks = By.linkText("Notebooks");
    private By _dropDown = By.id("products-orderby");
    private String priceHighToLow = "Price: High to Low";




    //Verify user on computer catagories page
    public void verifyUserOnComputerCatagoriesPage()
    {
        assertURL("computers");
    }

    // user click on notebooks
    public void userClickOnNoteBook(){
        sleep(1);
        clickOnElement(_noteBooks);
    }
    //verify that user click on dropdown price high to low
    public void userSelectFromPositionPriceHighToLow(){

        selectFromDropdownByVisibleText(_dropDown,priceHighToLow);
    }
    public void verifyUserShouldBeAbleToSeePriceHighToLow() {
        List<WebElement> priceList = driver.findElements(By.className("prices"));

        //myList contains all the web elements
        //if you want to get all elements text into array list
        List<String> WebSortedPrice = new ArrayList<String>();
        List<Double> DoubleWebSortedPrice = new ArrayList<Double>();

        for (int i = 0; i < priceList.size(); i++) {
            WebSortedPrice.add(priceList.get(i).getText().replaceAll("[^0-9.]", ""));
        }
        System.out.println("String sorted list from web page" + WebSortedPrice);
        for (String s : WebSortedPrice) {
            DoubleWebSortedPrice.add(Double.valueOf(s));
        }
        System.out.println("Double sorted list from web page" + DoubleWebSortedPrice);

        for (int m = 0; m<DoubleWebSortedPrice.size(); m++){
            for (int n = m + 1; n < DoubleWebSortedPrice.size(); n++){
                if(DoubleWebSortedPrice.get(m)>= DoubleWebSortedPrice.get(n))
                {
                    System.out.println("price Sorted");
                }
                else {
                    System.out.println("Price not sorted");
                }
            }


        }
    }

}
