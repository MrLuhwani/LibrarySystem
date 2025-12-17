package com.mrLuhwani.librarySystem;

import java.util.Map;
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
                        //if the person is a premium user, no need for them to see upgrade
                        //acct in the menu
                        Map<UserModel, Integer> user = UserUtilities.userLogin();
                        if (!(Objects.isNull(user))) {    
                            UserUtilities.menu(user);   
                        }
                    }
                    case "2" -> {
                        Map<UserModel, Integer> user = UserUtilities.createUser();
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
 * Maybe you create a librarian model
 * there is a date stuff that checks if the book is due
 * basic users have a limit to how much they can borrow, 3
 * basic users have only 10 days
 * basic users can't get license to online books
 * special users have 10 borrowing
 * 30 days borrowing
 * have access to online resources
 */
