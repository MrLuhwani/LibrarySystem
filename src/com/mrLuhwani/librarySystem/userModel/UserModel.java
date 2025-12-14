package com.mrLuhwani.librarySystem.userModel;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.time.format.DateTimeFormatter;

public abstract class UserModel {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private String username;
    private String password;
    private String email;
    private HashMap<String, LocalDateTime> itemsAndDueDates;
    
    public UserModel(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.itemsAndDueDates = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    public String getEmail() {
        return email;
    }
    public HashMap<String, LocalDateTime> getItemsAndDueDates() {
        return this.itemsAndDueDates;
    }
    public void printItemsAndDueDates() {
        for (String item : this.itemsAndDueDates.keySet()) {
            System.out.println(item + " Return date: " + this.itemsAndDueDates.get(item).format(formatter));
        }
    }

    public abstract LocalDateTime setDueDate(LocalDateTime instant);
}