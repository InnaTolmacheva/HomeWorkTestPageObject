package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import ru.netology.data.DataHelper;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.text;

public class DashboardPage {
    // к сожалению, разработчики не дали нам удобного селектора, поэтому так
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public int getCardBalance(DataHelper.CardInfo cardInfo) {
        var text = cards.findBy(text(cardInfo.getNumber().substring(12, 16))).text();
        return extractBalance(text);
    }

    public ReplenishmentCardPage selectFirstCard() {
        cards.first().$("button").click();
        return new ReplenishmentCardPage();
    }

    public ReplenishmentCardPage selectSecondCard() {
        cards.last().$("button").click();
        return new ReplenishmentCardPage();
    }


    public int extractBalance(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

}






