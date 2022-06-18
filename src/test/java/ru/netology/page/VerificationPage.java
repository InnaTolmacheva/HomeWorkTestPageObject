package ru.netology.page;

import ru.netology.data.DataHelper;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {
    public DashboardPage validVerify(DataHelper.VerificationCode verificationCode) {
        $("[data-test-id='code'] input").setValue(verificationCode.getCode());
        $x("//*[text()=\"Продолжить\"]").click();
        return new DashboardPage();

    }
}
