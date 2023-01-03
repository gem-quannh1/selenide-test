package org.example;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

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

        // verify url contains
        String currentURl = WebDriverRunner.url();
        assertTrue(currentURl.contains("get-started"));

        // verify heading by CssSelector
        $("h1").shouldHave(text("Think different. Make different."));

        // verify by XPath
        $(By.xpath("//a[class=\"custom-logo-link\"]"))
                .should(be(visible));
    }

    @Test
    public void testMultipleElements() {
        this.openPage();
        List<String> expectedLinks = List.of("Home", "About", "Shop", "Blog", "Contact", "My account");

        ElementsCollection linkLists = $$("#primary-menu>li[id*=menu-item]");

        // List<String> linkListsText = linkLists.texts();

        // assertion
        // assertEquals(linkListsText, expectedLinks);
        linkLists.shouldHave(CollectionCondition.texts(expectedLinks));
    }
}
