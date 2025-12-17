package com.mrLuhwani.librarySystem.userModel;

public enum MembershipLevel {
    FREE(3),PREMIUM(10);
    private final int borrowLimit;
    MembershipLevel(int borrowLimit) {
        this.borrowLimit = borrowLimit;
    }
    public int getBorrowLimit() {
        return borrowLimit;
    }
}
