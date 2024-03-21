package com.minhkakart.midtest1.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UserModel {
    private int id = -1;
    private final String username;
    private final String password;
    private final String name;
    private final String created_at;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyyy", Locale.US);

    public UserModel(int id, String username, String password, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        Date createdDate = new Date();
        this.created_at = sdf.format(createdDate);
    }

    public UserModel(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        Date createdDate = new Date();
        this.created_at = sdf.format(createdDate);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getCreated_at() {
        return created_at;
    }
}
