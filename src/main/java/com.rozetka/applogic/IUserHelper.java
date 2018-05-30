package com.rozetka.applogic;

import com.rozetka.model.User;

public interface IUserHelper {

    void loginAs(User user);
    void logout();
    boolean isLoggedIn();
    boolean isLoggedInAs(User user);
    boolean isNotLoggedIn();
    void signUpAs(User user);


}
