package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;

import static java.lang.String.valueOf;

import static com.codeborne.selenide.Selenide.*;

public class ReplenishmentCardPage {

    private static SelenideElement summa = $("[data-test-id=amount] input");
    private static SelenideElement cardFrom = $("[data-test-id=from] input");
   private static SelenideElement button = $("[data-test-id=action-transfer]");

    public static DashboardPage replenishmentCard(String amount, DataHelper.CardInfo cardInfo) {
        $("[data-test-id=amount] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        summa.setValue(valueOf(amount));
        $("[data-test-id=from] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        cardFrom.setValue(valueOf(cardInfo.getNumber()));
        button.click();
        return new DashboardPage();
    }

    public static DashboardPage replenishmentIncorrectCard(String amount, DataHelper.CardInfo cardInfo) {

        $("[data-test-id=amount] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        summa.setValue(valueOf(amount));
        $("[data-test-id=from] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        cardFrom.setValue(valueOf(cardInfo.getNumber()));
        button.click();
        $(".notification__content").shouldHave(Condition.text("Ошибка! Произошла ошибка"));
        return null;
    }



}
