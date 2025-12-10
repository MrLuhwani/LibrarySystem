package com.mrLuhwani.librarySystem.resourceModel;

public abstract class ResourceModel {

    private String title;
    private String author;
    private String isbn;
    //for now we might use the hashcode as the isbn
    private boolean issued;
    
    ResourceModel(String title, String author, boolean issued) {
        this.title = title;
        this.author = author;
        this.issued = issued;
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
    public void toString() {
        System.out.println("Title: " + this.getTitle() + " Author: " + this.getAuthor());
    }
}
