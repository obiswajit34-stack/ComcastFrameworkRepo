package javabasics;

import org.testng.annotations.Test;

public class LoginTest {

    @Test(priority = 1)
    public void login() {
        System.out.println("Login");
    }

    @Test(priority = 2)
    public void logout() {
        System.out.println("Logout");
    }
}