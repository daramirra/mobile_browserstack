package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("selenide_android")
public class BrowserStackAndroidSelenideTests extends TestBase {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchBrowserstackTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Open login page in Wikipedia")
    void openSettingsTest() {
        step("Expand menu panel", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });

        step("Select menu item 'Log in to Wikipedia'", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_account_name")).click();
        });

        step("Verify content on opened page", () ->
                $(MobileBy.className("android.widget.TextView")).shouldHave(text("Log in to Wikipedia")));
    }
}