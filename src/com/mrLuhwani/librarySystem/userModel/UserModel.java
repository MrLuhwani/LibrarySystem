package com.mrLuhwani.librarySystem.userModel;

import java.util.ArrayList;
import java.time.LocalDateTime;
import com.mrLuhwani.librarySystem.resourceModel.ResourceModel;
import java.time.Instant;
import java.util.HashMap;

public abstract class UserModel {
    //This is a base class for user models
    private String username;
    private String password;
    private String email;
    private HashMap<ResourceModel, LocalDateTime> itemsAndDueDates;
    //to be continued
    // private ArrayList<ResourceModel> borrowedItems;
    // private ArrayList<LocalDateTime> dueDates;
    
    UserModel(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        // this.borrowedItems = new ArrayList<>();
        // this.dueDates = new ArrayList<>();
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
    // public ArrayList<ResourceModel> getBorrowedItems() {
    //     return borrowedItems;
    // }
    // public ArrayList<LocalDateTime> getDueDates() {
    //     return dueDates;
    // }

    public void getItemAndDueDate() {
        return this.itemsAndDueDates;
    }

    public abstract LocalDateTime setDueDate(LocalDateTime instant);
}