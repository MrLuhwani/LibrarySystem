package com.mrLuhwani.librarySystem.userModel;

import java.time.LocalDateTime;

public class FreeUser extends UserModel {
    public FreeUser(String username, String password, String email) {
        super(username, password, email);
    }
    @Override
    public LocalDateTime setDueDate(LocalDateTime instant) {
        return instant.plusDays(10);
    }
    @Override
    public boolean canBorrow() {
        if (this.getItemsAndDueDates().size() == 3) {
            return false;
        }
        return true;
    }
}
