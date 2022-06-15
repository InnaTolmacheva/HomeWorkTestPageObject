package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import ru.netology.data.DataHelper;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    // к сожалению, разработчики не дали нам удобного селектора, поэтому так
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public int getFirstCardBalance(DataHelper.CardInfo cardInfo) {
       var text = cards.first().text();
                return extractBalance(text);
    }
    public int getSecondCardBalance(DataHelper.CardInfo cardInfo) {
        var text = cards.last().text();
        return extractBalance(text);
    }

    public ReplenishmentCardPage selectFirstCard(DataHelper.CardInfo cardInfo) {
        cards.first().$("button").click();
        return new ReplenishmentCardPage();
    }

    public ReplenishmentCardPage selectSecondCard(DataHelper.CardInfo cardInfo) {
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






