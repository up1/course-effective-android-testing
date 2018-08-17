package com.example.somkiat.hello;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUser {

    private final SharedPreferences preferences;

    public SharedPreferencesUser(Context context) {
        preferences = context.getSharedPreferences("user.xml", Context.MODE_PRIVATE);
    }

    public boolean get(String id) {
        return preferences.getBoolean(id, false);
    }

    public void loggedIn(String id) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(id, true);
        editor.apply();
    }

}
