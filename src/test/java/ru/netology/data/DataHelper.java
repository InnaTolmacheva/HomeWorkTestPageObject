package ru.netology.data;


import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }
    @Value
    public static class CardInfo {
        private String number;
    }

    public static CardInfo getFirstCardInfo(AuthInfo authInfo) {
        return new CardInfo("5559000000000001");
    }

    public static CardInfo getSecondCardInfo(AuthInfo authInfo) {
        return new CardInfo("5559000000000002");
    }

    public static CardInfo getIncorrectCardInfo(AuthInfo authInfo) {
        return new CardInfo(("5559000000000003"));
    }


}
