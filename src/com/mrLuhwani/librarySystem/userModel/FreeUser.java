package com.mrLuhwani.librarySystem.userModel;

public class FreeUser extends UserModel {
    public FreeUser(String username, String password, String email) {
        super(username, password, email);
    }
    @Override
    public LocalDateTime setDueDates(LocalDateTime instant) {
        return instant.plusDays(10);
    }
}
