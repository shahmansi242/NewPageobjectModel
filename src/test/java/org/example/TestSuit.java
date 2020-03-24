package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    JewelryPage jewelryPage = new JewelryPage();
    ProductComparison productComparison = new ProductComparison();
    Catagories catagories = new Catagories();
    EmailFriendPage emailFriendPage = new EmailFriendPage();
    ProductPage productPage = new ProductPage();
    ComputerCategory computerCategory = new ComputerCategory();
    GuestCheckout guestCheckout = new GuestCheckout();
    ShippingAddress shippingAddress = new ShippingAddress();
    PaymentMethod paymentMethod = new PaymentMethod();
    CheckOutResult checkOutResult = new CheckOutResult();
    NewsPage newsPage = new NewsPage();
    ChangeCurrency changeCurrency = new ChangeCurrency();
    AddToCartButton addToCartButton = new AddToCartButton();



    @Test
    public void userShouldAbleToRegisterSuccessfully()
    {
        homePage.clickOnRegisterButton();
        registrationPage.verifyUserOnRegisterPage();
        takeScreenShot("sample");
        registrationPage.userEnterRegistrationDetails();
        registrationResultPage.verifyUserSeeRegistrationSuccessMessage();
}
    @Test
    public void userShouldAbleToCompareTwoDifferentProductSuccessfully()
    {
        homePage.clickOnJewellery();
        jewelryPage.verifyUserIsOnJewelryPage();
        jewelryPage.chooseProductsToCompare();
        productComparison.VerifyUserIsOnComparisionPage();

    }
    @Test
    public void registerUserShouldAbleToReferAFriendSuccessfully(){
        homePage.clickOnRegisterButton();
        registrationPage.verifyUserOnRegisterPage();
        registrationPage.userEnterRegistrationDetails();
        registrationResultPage.verifyUserSeeRegistrationSuccessMessage();
        homePage.clickOnComputerCategory();
        catagories.verifyUserOnComputerCatagoriesPage();
        catagories.userClickOnNoteBook();
        catagories.userClickOnAppleMac();
        catagories.UserClickOnEmailAFriend();
        emailFriendPage.verifyUserOnEmailAFriendPage();
        emailFriendPage.emailAFriendDetails();
        emailFriendPage.verifyUserSeeSuccessMessageOfEmailAFriend();
    }
    @Test
    public void  nonRegisterUserShouldNotBeAbleToReferAProductToaFriend(){
        homePage.clickOnComputerCategory();
        productPage.verifyUserOnComputerCatagoriesPage();
        productPage.userClickOnNoteBook();
        productPage.userClickOnAppleMac();
        productPage.UserReferToFriend();
        productPage.verifyUserSeeErrorMessage();
    }
    @Test
    public void userShouldBeAbleToSortProductHighToLowByPrice(){
        homePage.clickOnComputerCategory();
        computerCategory.verifyUserOnComputerCatagoriesPage();
        computerCategory.userClickOnNoteBook();
        computerCategory.userSelectFromPositionPriceHighToLow();
        computerCategory.verifyUserShouldBeAbleToSeePriceHighToLow();
    }
    @Test
    public void verifyGuestUserShouldBeAbleToCheckOutSuccessfully(){
        homePage.clickOnJewellery();
        jewelryPage.verifyUserIsOnJewelryPage();
        jewelryPage.addToCartProduct();
        guestCheckout.checkoutAsGuest();
        shippingAddress.userClickOnShippingAddress();
        paymentMethod.userFillPaymentMethodDetails();
        checkOutResult.verifycheckoutsuccessmessage();
    }
    @Test
    public void guestUserShouldBeAbleToAddNewComment(){
        homePage.clickOnViewNewsArchive();
        newsPage.userClickOnDetails();
        newsPage.verifysuccessmessageofcomment();

    }
    @Test
    public void userShouldBeAbleToChangeTheCurrency(){
        changeCurrency.selectCurrencyFromDropDown();
        changeCurrency.verifyingCurrencySymbolPresent();

    }
    @Test
    public void verifyAddToCartButtonIsPresentOnAllFeaturedProduct(){
        addToCartButton.verifyAddToCartButtonPresent();


    }











}
