package com.mrLuhwani.librarySystem.utilities;

import java.util.ArrayList;
import com.mrLuhwani.librarySystem.resourceModel.*;
import java.util.Scanner;

public class ResourceUtilities {

    private static ArrayList<ResourceModel> resources = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    static void showResources() {
        for (ResourceModel resource : resources) {
            resource.toString();
        }
    }

    public static void borrowResource(UserModel user) {
        String category;
        boolean validCategory = true;
        System.out.print("What do you wish to borrow: \n1.Book\n2.DVD\n3.E-book\nReponse: ");
        category = sc.nextLine();
        ArrayList<? extends ResourceModel> specificResources = null;
        if (category.equals("1")) {
            specificResources = sortByType(resources, Book.class);
        } else if (category.equals("2")) {
            specificResources = sortByType(resources, Dvd.class);
        } else if (category.equals("3")) {
            specificResources = sortByType(resources, Ebook.class);
        } else {
            System.out.println("Invalid Input!");
            validCategory = false;
        }
        if (validCategory) {
            String title;
            String author;
            System.out.print("Enter the title: ");
            title = sc.nextLine().toLowerCase();
            System.out.print("Enter the name of the author: ");
            author = sc.nextLine().toLowerCase();

            boolean foundResource = true;
            ResourceModel resourceToBorrow = null;
            // books arent unlimited, they can be out of stock
            for (ResourceModel resource : specificResources) {
                if (resource.getTitle().toLowerCase().equals(title)
                        && resource.getAuthor().toLowerCase().equals(author)) {
                    foundResource = true;
                    resourceToBorrow = resource;
                    break;
                }
            }
            if (!foundResource) {
                System.out.println("Resource not found!");
                return;
            }
            if (!(resourceToBorrow.getCopyCount() > 0)) {
                System.out.println("Resource is currently out of stock!");
                return;
            }
            user.getBorrwedItems().add(resourceToBorrow);

            resourceToBorrow.setCopyCount(resourceToBorrow.getCopyCount() - 1);

            System.out.println("You have successfully borrowed " + resourceToBorrow.getTitle());

        }

    }

    private static <T> ArrayList<T> sortByType(ArrayList<T> list, Class<? extends T> type) {
        //This method was made to sort different child instances in an arrayList of the parent class
        //The T data type makess it able to work for arrayLists of different data types
        //The other parameter type, represents the actual class reference of the child
        //That is why the data type was made to extend T
        ArrayList<T> sortedList = new ArrayList<>();
        for (T t : list) {
            //for each t in the parent list, if t is an instance of the passed in child, then t
            //will be added to the  sorted list
            if (type.isInstance(t)) {
                sortedList.add(type.cast(t));
            }
        }
        return sortedList;
    }
}