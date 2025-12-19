package com.mrLuhwani.librarySystem.userModel;

import java.time.LocalDateTime;

 public enum MembershipLevel {
    FREE(3, false) {
        @Override
        public LocalDateTime setDueDate(LocalDateTime instant) {
            return instant.plusDays(10);
        }
    },
    PREMIUM(10, true) {
        @Override
        public LocalDateTime setDueDate(LocalDateTime instant) {
            return instant.plusDays(30);
        }
    };
    private final int borrowLimit;
    private final boolean ebookAcess;
    public abstract LocalDateTime setDueDate(LocalDateTime instant);
    MembershipLevel(int borrowLimit, boolean ebookAcess) {
        this.borrowLimit = borrowLimit;
        this.ebookAcess = ebookAcess;
    }
    public int getBorrowLimit() {
        return borrowLimit;
    }
    public boolean getEbookAccess() {
        return ebookAcess;
    }
}
