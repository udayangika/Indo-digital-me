package tech.lolc.indo.digitalme.testng;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "login-credentials")
    public Object[][] UserCredentials() {
        return new Object[][]{
                {"NOVI", "Lolc@1234", "Select a User Role to Continue", "Administrator", "Dashboard"},//admin
                {"DEAP", "Lolc@1234", "Select a User Role to Continue", "Customer Service Assistance", "Dashboard"},//CSA
                {"DIKOP", "Lolc@1234", "Select a User Role to Continue", "Credit Analyst", "Dashboard"},//CA
                {"RINDIA", "Lolc@1234", "Select a User Role to Continue", "Branch Manager", "Dashboard"},//BM
                {"FIRGANS", "Lolc@1234", "Select a User Role to Continue", "Area Manager", "Dashboard"},//AM
                {"LUGIP", "Lolc@1234", "Select a User Role to Continue", "SLIK User", "Dashboard"},//sllik user
                {"STEVEI", "Lolc@1234", "Select a User Role to Continue", "Regional Manager", "Dashboard"},//RM
                {"DEDYE", "Lolc@1234", "Select a User Role to Continue", "Director", "Dashboard"},//Director
                {"RIA", "Lolc@1234", "Select a User Role to Continue", "Board of Member 1", "Dashboard"},//BOD1
                {"SUPRIYON", "Lolc@1234", "Select a User Role to Continue", "Board of Member 2", "Dashboard"},//BOD2
                {"PRABAT", "Lolc@1234", "Select a User Role to Continue", "Board of Member 3", "Dashboard"},//BOD3


        };
    }

    @DataProvider(name = "invalid-login-credentials")
    public Object[][] UserCredentialsInvalidData() {
        return new Object[][]{
                {"NOVI", "", "Login failed! Please recheck the username and password and try again."},
                {"NOVI", "3456", "Login failed! Please recheck the username and password and try again."},
                {"ssss", "Lolc@1234", "Login failed! Please recheck the username and password and try again."},
                {"XX", "XXXX", "Login failed! Please recheck the username and password and try again."},
                {"", "", "Please fill out this field."},
                {"", "Lolc@1234", "Please fill out this field."}

        };
    }

    @DataProvider(name = "empty-login-credentials")
    public Object[][] UserCredentialsEmptyData() {
        return new Object[][]{

                {"", ""},
                {"", "Lolc@1234"}

        };
    }
    @DataProvider(name = "userRoles")
    public Object[][] getUserRoles() {
        return new Object[][]{
                {"NOVI", "Lolc@1234", "Select a User Role to Continue", "Administrator", "Dashboard","Administrator"},//admin
                {"DEAP", "Lolc@1234", "Select a User Role to Continue", "Customer Service Assistance", "Dashboard","Customer Service Assistance"},//CSA
                {"DIKOP", "Lolc@1234", "Select a User Role to Continue", "Credit Analyst", "Dashboard","Credit Analyst"},//CA
                {"RINDIA", "Lolc@1234", "Select a User Role to Continue", "Branch Manager", "Dashboard","Branch Manager"},//BM
                {"FIRGANS", "Lolc@1234", "Select a User Role to Continue", "Area Manager", "Dashboard","Area Manager"},//AM
                {"LUGIP", "Lolc@1234", "Select a User Role to Continue", "SLIK User", "Dashboard","SLIK User"},//sllik user
                {"STEVEI", "Lolc@1234", "Select a User Role to Continue", "Regional Manager", "Dashboard","Regional Manager"},//RM
                {"DEDYE", "Lolc@1234", "Select a User Role to Continue", "Director", "Dashboard", "Director"},//Director
                {"RIA", "Lolc@1234", "Select a User Role to Continue", "Board of Member 1", "Dashboard","Board of Member 1"},//BOD1
                {"SUPRIYON", "Lolc@1234", "Select a User Role to Continue", "Board of Member 2", "Dashboard","Board of Member 2"},//BOD2
                {"PRABAT", "Lolc@1234", "Select a User Role to Continue", "Board of Member 3", "Dashboard","Board of Member 3"}

        };
    }

}