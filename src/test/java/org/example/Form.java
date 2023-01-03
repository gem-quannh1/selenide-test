package org.example;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/*
* fill in all the fields
* click submit button
* verify submit messages
* */

public class Form {
    static String formUrl = "https://practice.automationbro.com/support-form/";

    @Test
    public void testFormFields() {
        open(this.formUrl);

        $(".support-name input").val("Luffy here");
        $(".support-email input").val("luffy@onepiece.com");
        $(".support-subject input").val("Luffy is da bet");

        // dropdown and checkbox
        $(".support-dropdown select").selectOption("Integration Issue");
        $(".support-checkboxes ul li:nth-child(2) input").click();

        // date input field
        $(".support-date input").click();
        $(".flatpickr-day nextMonthDay").click();

        // text area
        $(".support-message textarea").val("Luffy take a message for you");

        // submit button
        $("button[type=submit]").click();

        // verify success message
        $("div[role=alert]").shouldHave(Condition.text("\t\tThanks for contacting us! We will be in touch with you shortly.\t"));
    }
}
