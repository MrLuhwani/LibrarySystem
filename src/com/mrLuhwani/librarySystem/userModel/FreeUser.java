package com.mrLuhwani.librarySystem.userModel;

public class FreeUser extends UserModel {
    public FreeUser(String username, String password, String email) {
        super(username, password, email);
        this.membershipLevel = MembershipLevel.FREE;
    }
}
