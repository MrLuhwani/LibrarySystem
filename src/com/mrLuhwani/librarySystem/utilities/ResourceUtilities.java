package com.mrLuhwani.librarySystem.utilities;

import java.util.ArrayList;
import com.mrLuhwani.librarySystem.resourceModel.*;
import java.util.Scanner;

public class ResourceUtilities {

    private static ArrayList<ResourceModel> resources = new ArrayList<>();
    private static Scanner sc = new Scanner(System.im);

    public static void showResources() {
        for (ResourceModel resource:resources) {
            resource.toString();
        }
    }

    public static void borrowResource() {
        String category;
        boolean validCategory = true;
        System.out.print("What do you wish to borrow: \n1.Book\n2.DVD\n3.E-book\nReponse: ")
        category = sc.nextLine();
        ArrayList<? extends ResourceModel> specificResources;
        if (category.equals("1")) {
            specificResources = sortByType(resources, Book.class);
        } else if (category.equals("2")) {
            specificResources = sortByType(resources, Dvd.class);
        } else if (category.equals("3")) {
            specificResources = sortByType(resources, Ebook.class);
        } else {
            System.put.println("Invalid Input!");
            validCategory = false;
        }
        if (validCategory) {
            String title;
            String author;
            System.out.print("Enter the title: ").toLowerCase();
            title = sc.nextLine();
            System.out.print("Enter the name of the author: ").toLowerCase();
            author = sc.nextLine();
            for (ResourceModel resource: specificResources) {
                //to be continued
            }
        }
    
    }

    private static <T> ArrayList<T> sortByType(ArrayList<U> list, Class<T> type) {
        ArrayList<T> sortedList = new ArrayList<>();
        for (U u : list) {
            if (type.isInstance(u)) {
                sortedList.add(type.cast(u));
            }
        }
        return sortedList;
    }
}