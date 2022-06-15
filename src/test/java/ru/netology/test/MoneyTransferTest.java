package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");

    }

    @Test
    void replenishmentSecondCardFromFirstCard() {

        var authInfo = DataHelper.getAuthInfo(); //авторизация
        var verificationCode = DataHelper.getVerificationCode(authInfo); //ввод проверочного кода

        var loginPage = new LoginPage().validLogin(authInfo).validVerify(verificationCode);

        DashboardPage dashboardPage = new DashboardPage();
        var firstNumber = DataHelper.getFirstCardInfo(authInfo);
        var secondNumber = DataHelper.getSecondCardInfo(authInfo);

        int amount = 2000;

        var expectedBalanceFirstCard = dashboardPage.getFirstCardBalance(firstNumber) - amount;
        var expectedBalanceSecondCard = dashboardPage.getSecondCardBalance(secondNumber) + amount;
        var replenishmentCardPage = dashboardPage.selectSecondCard(secondNumber);

        dashboardPage = replenishmentCardPage.replenishmentCard(String.valueOf(amount), firstNumber);
        var actualBalansFirstCard = dashboardPage.getFirstCardBalance(firstNumber);
        var actualBalansSecondCard = dashboardPage.getSecondCardBalance(secondNumber);
        assertEquals(expectedBalanceFirstCard, actualBalansFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalansSecondCard);


    }

    @Test
    void replenishmentFirstCardFromSecondCard() {

        var authInfo = DataHelper.getAuthInfo();
        var verificationCode = DataHelper.getVerificationCode(authInfo);

        var loginPage = new LoginPage().validLogin(authInfo).validVerify(verificationCode);

        DashboardPage dashboardPage = new DashboardPage();
        var firstNumber = DataHelper.getFirstCardInfo(authInfo);
        var secondNumber = DataHelper.getSecondCardInfo(authInfo);

        int amount = 500;

        var expectedBalanceFirstCard = dashboardPage.getFirstCardBalance(firstNumber) + amount;
        var expectedBalanceSecondCard = dashboardPage.getSecondCardBalance(secondNumber) - amount;
        var replenishmentCardPage = dashboardPage.selectFirstCard(firstNumber);

        dashboardPage = replenishmentCardPage.replenishmentCard(String.valueOf(amount), secondNumber);
        var actualBalansFirstCard = dashboardPage.getFirstCardBalance(firstNumber);
        var actualBalansSecondCard = dashboardPage.getSecondCardBalance(secondNumber);
        assertEquals(expectedBalanceFirstCard, actualBalansFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalansSecondCard);


    }
    @Test
    void replenishmentSecondCardFromIncorrectCard() {

        var authInfo = DataHelper.getAuthInfo();
        var verificationCode = DataHelper.getVerificationCode(authInfo);

        var loginPage = new LoginPage().validLogin(authInfo).validVerify(verificationCode);

        DashboardPage dashboardPage = new DashboardPage();
        var firstNumber = DataHelper.getIncorrectCardInfo(authInfo);
        var secondNumber = DataHelper.getSecondCardInfo(authInfo);

        int amount = 1000;

        var replenishmentCardPage = dashboardPage.selectSecondCard(secondNumber);

        dashboardPage = replenishmentCardPage.replenishmentIncorrectCard(String.valueOf(amount), firstNumber);

    }
}
