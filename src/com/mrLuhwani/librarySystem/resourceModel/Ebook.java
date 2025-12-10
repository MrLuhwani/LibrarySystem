package com.mrLuhwani.librarySystem.resourceModel;

public class Ebook extends ResourceModel {
    String webpage;
    //try and validate websites later on
    public Ebook (String title, String author, boolean issued, String webpage) {
        super(title, author, issued);
        this.webpage = webpage;
    }
    
}
