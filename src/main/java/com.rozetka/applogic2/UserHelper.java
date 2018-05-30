package com.rozetka.applogic2;

import com.rozetka.applogic.IUserHelper;
import com.rozetka.model.User;
import com.rozetka.pages.ProfilePage;


public class UserHelper extends DriverBasedHelper implements IUserHelper {

    public UserHelper(ApplicationManager manager) {
        super(manager.getWebDriver());
    }

    @Override
    public void loginAs(User user) {
        pages.homePage
                .setEmailField(user.getEmail())
                .setPassowrdField(user.getPassword())
                .clickSubmitButton();
    }

    @Override
    public void signUpAs(User user) {
     pages.signUpPage
             .setUsername(user.getLogin())
             .setPasswrod(user.getPassword())
             .setEmail(user.getEmail())
             .clickSumbit();

    }


    @Override
    public void logout() {
        pages.profilePage.ensurePageLoaded()
                .clickLogoutLink();
    }

    @Override
    public boolean isLoggedIn() {
        return pages.homePage.waitPageLoaded();
    }

    @Override
    public boolean isLoggedInAs(User user) {
        return isLoggedIn()
                && getLoggedUser().getLogin().equals(user.getLogin());
    }

    @Override
    public boolean isNotLoggedIn() {
        return pages.homePage.waitPageLoaded();
    }



    private User getLoggedUser() {
        ProfilePage userProfile = pages.homePage.ensurePageLoaded()
                .clickUserProfilePage()
                .ensurePageLoaded();
        return new User()
                .setLogin(userProfile.getUsername())  //nuzhno dopisat metodu i "Field"
                .setEmail(userProfile.getEmail());

    }

    public static User basicUser = new User().setEmail("homework" + System.currentTimeMillis()/100000 + "@yopmail.com").setPassword("Qwerty1").setLogin("userTest");
    public static User userLogIn = new User().setEmail("testhomework@yopmail.com").setPassword("Qwerty1");
    public static User userWrongPass = new User().setEmail("testhomework@yopmail.com").setPassword("admin");


}
