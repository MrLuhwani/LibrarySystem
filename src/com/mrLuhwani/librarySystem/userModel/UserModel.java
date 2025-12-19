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
    /*
    Not sure its wise to make the key as a string
    Try refactoring to make it the resource object instead.
    Consider overriding the hashcoding, or using the hashcode
    as the isbn, that way it might be easier to find
     */
    protected MembershipLevel membershipLevel;
    
    public UserModel(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.itemsAndDueDates = new HashMap<>(this.membershipLevel.getBorrowLimit());
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
        if (itemsAndDueDates.isEmpty()) {
            System.out.println("Borrow List is empty");
            return;
        }
        for (String item : this.itemsAndDueDates.keySet()) {
            System.out.println(item + " Return date: " + this.itemsAndDueDates.get(item).format(formatter));
        }
    }
    public MembershipLevel getMembershipLevel() {
        return this.membershipLevel;
    }
    public void accountUpgrade() {
        this.membershipLevel = MembershipLevel.PREMIUM;
        System.out.println("Account Upgrade Successful!");
    }
    public void accountDegrade() {
        this.membershipLevel = MembershipLevel.FREE;
        System.out.println("Premium subscription cancelled!");
    }
    public int getBorrowLimit() {
        return this.membershipLevel.getBorrowLimit();
    }
    public boolean canBorrow() {
        if (itemsAndDueDates.size() == getBorrowLimit()) {
            return false;
        }
        return true;
    }
}