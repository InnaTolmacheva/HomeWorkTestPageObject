package ru.netology.data;


import lombok.Data;
import lombok.Value;

@Data
public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;

        public AuthInfo(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;

        public VerificationCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public static VerificationCode getVerificationCode(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    public static class CardInfo {
        private String number;


        public CardInfo(String number) {
            this.number = number;

        }


        public String getNumber() {
            return number;
        }


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
