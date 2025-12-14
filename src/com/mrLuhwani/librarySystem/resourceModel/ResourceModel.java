package com.mrLuhwani.librarySystem.resourceModel;

public abstract class ResourceModel {

    private String title;
    private String author;
    //private String isbn;
    //for now we might use the hashcode as the isbn, or just ignpre for now
    private int copyCount;
    
    public ResourceModel(String title, String author, int copyCount) {
        this.title = title;
        this.author = author;
        this.copyCount = copyCount;
    }

    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
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