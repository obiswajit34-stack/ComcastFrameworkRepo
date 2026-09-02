package javabasics;

import org.testng.annotations.Test;

public class OrganizationTest {

    @Test(priority = 3)
    public void createOrganization() {
        System.out.println("Create Organization");
    }
}