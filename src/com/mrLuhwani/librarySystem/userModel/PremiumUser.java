package com.mrLuhwani.librarySystem.userModel;

public class PremiumUser extends UserModel {
    public PremiumUser(String username, String password, String email) {
        super(username, password, email);
        this.membershipLevel = MembershipLevel.PREMIUM;
    }
}
