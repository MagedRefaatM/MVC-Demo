package com.me.demo;

import java.util.regex.Pattern;

class Model {

    String Message;
    String Name;
    String Password;

    Model(String name, String password) {
        Name = name;
        Password = password;
    }

    private static final Pattern NAME_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[A-Z])" +
                    "(?=\\S+$)" +
                    ".{4,}" +
                    "$"
            );

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[A-Z])" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{4,}" +
                    "$");

    String validateNameAndPassword(){

        if (Name.isEmpty() || Password.isEmpty()) {
            Message = "Enter Your Name And Password First";
            return Message;
        } else if (!NAME_PATTERN.matcher(Name).matches()) {
            Message ="Name Must Contain The Following : "+"\n"+"1-At least One Upper-Case Letter"+"\n"+"2-No White Spaces"+"\n"+"3-At Least 4 Characters";
            return Message;
        } else if (!PASSWORD_PATTERN.matcher(Password).matches()){
            Message ="Password Too Weak Follow The Following : "+"\n"+"1-At least One Upper-Case Letter"+"\n"+"2-At Least One Special Character"+"\n"+"3-No White Spaces"+"\n"+"4-At Least 4 Characters";
            return Message;
        } else {
            Message = "Finished";
            return Message;
        }
    }
}