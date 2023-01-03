package org.example;

import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class HomeTest {
    static String url = "https://practice.automationbro.com/";
    static String expectPageTitle = "Practice E-Commerce Site – Automation Bro";

    private void openPage() {
        open(this.url);
    }

    @Test
    public void testPageAndUrlTitle() {
        this.openPage();
        String currentURl = WebDriverRunner.url();
        assertEquals(currentURl, this.url);

        String title = title();
        assertEquals(title, this.expectPageTitle);
    }

    @Test
    public void testInteractingElements() {
        this.openPage();

        // by element id
        $(By.id("get-started")).click();
    }
}
