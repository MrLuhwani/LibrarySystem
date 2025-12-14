package com.mrLuhwani.librarySystem;

import java.util.Objects;
import java.util.Scanner;
import com.mrLuhwani.librarySystem.userModel.UserModel;
import com.mrLuhwani.librarySystem.utilities.UserUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("__Library App__");
        boolean usingSystem = true;
        try (Scanner sc = new Scanner(System.in)) {
            while (usingSystem) {
                String response;
                System.out.print(
                        "Enter the number for the task you wish to perform\n1.Login\n2.Create Free Account\n3.Exit\nResponse: ");
                response = sc.nextLine();
                switch (response) {
                    case "1" -> {
                        System.out.println("Login to your account");
                        UserModel user = UserUtilities.userLogin();
                        if (!(Objects.isNull(user))) {
                            UserUtilities.menu(user);
                        }
                    }
                    case "2" -> {
                        UserModel user = UserUtilities.createUser();
                        UserUtilities.menu(user);
                    }
                    case "3" -> {
                        usingSystem = false;
                        System.out.println("Exitting Program...");
                    }
                    default -> System.out.println("Invalid Input");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*
 * Each person has a username and password
 * password can be changed
 * Maybe you create a librarian model
 * Resources are books, dvds, and online books
 * maybe youll try looking for books based on their hashcode rather than name
 * basic users have a limit to how much they can borrow
 * there is a date stuff that checks if the book is due
 * basic users have only 10 days
 * basic users can't get license to online books
 * special users have unlimited boorowing
 * 30 days borrowing
 * have access to online resources
 * you can create a card
 * 
 * CLI:
 * welcome message
 * 1. Login
 * 1. Show available books
 * 2. Borrow book
 * 3. Return book
 * 4. Check what youve borrowed
 * 5. Check due dates(maybe merge 4 and 5)
 * 6. Future feature(upgrade card)
 * 7. Change password
 * 2. Create Card
 * 1. Ask for username, email and password
 * 2. Future featuure(check for actual valid stuff like with google and stuff)
 * 3. Exit
 */
