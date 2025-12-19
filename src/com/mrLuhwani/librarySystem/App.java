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
                        Map<UserModel, Integer> userAndIndex = UserUtilities.userLogin();
                        /*
                        try and refactor to something else other than a hashmap,
                        maybe try a class called session and build index logic
                        or you jusst refactor and pas in the index like that */
                        if (!(Objects.isNull(userAndIndex))) {    
                            UserUtilities.menu(userAndIndex);   
                        }
                    }
                    case "2" -> {
                        Map<UserModel, Integer> userAndIndex = UserUtilities.createUser();
                        UserUtilities.menu(userAndIndex);
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