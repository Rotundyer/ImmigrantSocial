package com.pskovhack.immigrantsocial.firebase;

import android.widget.EditText;

public class User {
    public String first_name, second_name;
    public Integer gender;

    public User() {}

    public User( String first_name, String second_name, Integer gender) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.gender = gender;
    }
}
