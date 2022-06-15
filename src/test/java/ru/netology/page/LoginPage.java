package ru.netology.page;

import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public VerificationPage validLogin(DataHelper.AuthInfo info){
        $("[data-test-id='login'] input").setValue(info.getLogin());
        $("[data-test-id='password'] input").setValue(info.getPassword());
        $x("//*[text()=\"Продолжить\"]").click();
        return new VerificationPage();
    }
}
