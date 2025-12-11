package com.mrLuhwani.librarySystem.userModel;

public class PremiumUser extends UserModel {
    public PremiumUser(String username, String password, String email) {
        super(username, password, email);
    }
    @Override
    public LocalDateTime setDueDates(LocalDateTime instant) {
        return instant.plusDays(30);
    }
}
