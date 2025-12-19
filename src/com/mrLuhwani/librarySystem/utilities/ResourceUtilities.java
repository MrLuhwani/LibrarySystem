package com.mrLuhwani.librarySystem.utilities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import com.mrLuhwani.librarySystem.resourceModel.*;
import com.mrLuhwani.librarySystem.userModel.UserModel;
import java.util.Scanner;

class ResourceUtilities {

    private static ArrayList<ResourceModel> resources = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    static void showResources(UserModel user) {
        String category;
        System.out.print("Enter the number for the category: \n1.Books\n2.DVDs\n3.E-books\nReponse: ");
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
            return;
        }
        if (specificResources.isEmpty()) {
            System.out.println("No resource is currently available in this category");
            return;
        }
        for (ResourceModel resource : specificResources) {
            System.out.println(resource.toString());
        }
    }

    static void borrowResource(UserModel user) {
        // the same is repeated in the two methods, so build a helper method for
        // the two of them.
        if (!user.canBorrow()){
            System.out.println("Max number of items to borrow has been reached.\nPlease return any of your borrowed items and try again");
            return;
        }
        String category;
        System.out.print("Enter the number for the category: \n1.Book\n2.DVD\n3.E-book\nReponse: ");
        category = sc.nextLine();
        ArrayList<? extends ResourceModel> specificResources = null;
        if (category.equals("1")) {
            specificResources = sortByType(resources, Book.class);
        } else if (category.equals("2")) {
            specificResources = sortByType(resources, Dvd.class);
        } else if (category.equals("3")) {
            if (user.getMembershipLevel().getEbookAccess() == false) {
                System.out.println("Free Users do not have access to E-books");
                return;
            }
            specificResources = sortByType(resources, Ebook.class);
        } else {
            System.out.println("Invalid Input!");
            return;
        }
        if (specificResources.isEmpty()) {
            System.out.println("No resource is currently available in this category");
            return;
        }

        String title;
        String author;
        System.out.print("Enter the title: ");
        title = sc.nextLine().toLowerCase();
        System.out.print("Enter the name of the author: ");
        author = sc.nextLine().toLowerCase();
        boolean foundResource = false;
        ResourceModel resourceToBorrow = null;
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
        user.getItemsAndDueDates().put(resourceToBorrow.toString(), user.getMembershipLevel().setDueDate(LocalDateTime.now()));
        resourceToBorrow.setCopyCount(resourceToBorrow.getCopyCount() - 1);
        System.out.println("You have successfully borrowed " + resourceToBorrow.getTitle());
    }

    static void returnResource(UserModel user) {
        String category;
        System.out.print("Enter the number for the category: \n1.Book\n2.DVD\n3.E-book\nReponse: ");
        category = sc.nextLine();
        ArrayList<? extends ResourceModel> specificResources = null;
        ArrayList<Integer> indexList = null;
        if (category.equals("1")) {
            specificResources = sortByType(resources, Book.class);
            if (!specificResources.isEmpty())
                indexList = indexes(Book.class);
        } else if (category.equals("2")) {
            specificResources = sortByType(resources, Dvd.class);
            if (!specificResources.isEmpty())
                indexList = indexes(Dvd.class);
        } else if (category.equals("3")) {
            specificResources = sortByType(resources, Ebook.class);
            if (!specificResources.isEmpty())
                indexList = indexes(Ebook.class);
        } else {
            System.out.println("Invalid Input!");
            return;
        }
        if (specificResources.isEmpty()) {
            System.out.println("No resource in this category");
            return;
        }
        String title;
        String author;
        System.out.print("Enter the title of the book: ");
        title = sc.nextLine().toLowerCase();
        System.out.print("Enter the author of the book: ");
        author = sc.nextLine().toLowerCase();
        boolean foundResource = false;
        ResourceModel resourceToReturn = null;
        int index = 0;
        for (int i = 0; i < specificResources.size(); i++) {
            if (specificResources.get(i).getTitle().toLowerCase().equals(title)
                    && specificResources.get(i).getAuthor().toLowerCase().equals(author)) {
                resourceToReturn = specificResources.get(i);
                index = i;
                foundResource = true;
                break;
            }
        }
        if (!(foundResource)) {
            System.out.println("Resource was not found");
            return;
        }
        boolean userBorrowed = false;
        for (String resourceInBorrowedList : user.getItemsAndDueDates().keySet()) {
            if (resourceToReturn.toString().equals(resourceInBorrowedList)) {
                /*
                we are comparing the toString(), try refactoring
                to isbn later */
                userBorrowed = true;
                break;
            }
        }
        if (!(userBorrowed)) {
            System.out.println("No record of you borrowing this resource");
            return;
        }
        // Need to refactor this, cuz this a lot of dotChaining
        resources.get(indexList.get(index)).setCopyCount(resources.get(indexList.get(index)).getCopyCount() + 1);
        // it might actually be faster if I just looped thru the whole
        // arrayList of resources instead of the multiple smaller loops I had to
        // previously do to get the index
        user.getItemsAndDueDates().remove(resourceToReturn.toString());
        System.out.println("You have successfully returned: "+ resourceToReturn.getTitle());

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

    private static ArrayList<Integer> indexes(Class<? extends ResourceModel> type) {
        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < resources.size(); i++) {
            if (type.isInstance(resources.get(i))) {
                indexList.add(i);
            }
        }
        return indexList;
    }
}