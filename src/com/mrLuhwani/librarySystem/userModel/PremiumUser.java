package com.mrLuhwani.librarySystem.userModel;

import java.time.LocalDateTime;
public class PremiumUser extends UserModel {
    public PremiumUser(String username, String password, String email) {
        super(username, password, email);
    }
    @Override
    public LocalDateTime setDueDate(LocalDateTime instant) {
        return instant.plusDays(30);
    }
    @Override
    public boolean canBorrow() {
        if (this.getItemsAndDueDates().size() == 10) {
            return false;
        }
        return true;
    }
}
