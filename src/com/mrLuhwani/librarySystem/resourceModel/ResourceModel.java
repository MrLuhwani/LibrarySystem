package com.mrLuhwani.librarySystem.resourceModel;

public abstract class ResourceModel {

    private String title;
    private String author;
    //private String isbn;
    //for now we might use the hashcode as the isbn, or just ignpre for now
    private boolean issued;
    private int copyCount;
    
    ResourceModel(String title, String author, boolean issued, int copyCount) {
        this.title = title;
        this.author = author;
        this.issued = issued;
        this.copyCount = copyCount;
    }

    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public boolean getIssued() {
        return this.issued;
    }
    public void setIssued(boolean issued) {
        this.issued = issued;
    }
    @Override
    public String toString() {
        return "Title: " + this.getTitle() + " Author: " + this.getAuthor();
    }
    public int getCopyCount() {
        return this.copyCount;
    }
    public void setCopyCount(int copyCount) {
        this.copyCount = copyCount;
    }
}