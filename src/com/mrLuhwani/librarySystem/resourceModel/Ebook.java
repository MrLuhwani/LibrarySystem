package com.mrLuhwani.librarySystem.resourceModel;

public class Ebook extends ResourceModel {
    String webpage;
    //try and validate websites later on
    public Ebook (String title, String author, int copyCount, String webpage) {
        super(title, author, copyCount);
        //An E-boook cant literally have a copy count, copyCount instead
        //is used to refernce how many ppl can license to borrow the book at once
        this.webpage = webpage;
    }
    
}
