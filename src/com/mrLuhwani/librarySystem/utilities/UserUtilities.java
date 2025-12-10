package com.mrLuhwani.librarySystem.utilities;

import java.util.Scanner;
import java.util.ArrayList;
import com.mrLuhwani.librarySystem.userModel.*;

public class UserUtilities {

    private static Scanner sc = new Scanner(System.in);
    
    static ArrayList<UserModel> users = new ArrayList<>();

    public static UserModel userLogin() {

        boolean loggedIn = false;
        System.out.print("Enter username: ");
        String usernameInput = sc.nextLine();
        // Most ppl remeber their emails, than username, so when you have advance email
        // logic, validate email instead of username
        System.out.print("Enter password: ");
        String passwordInput = sc.nextLine();

        for (UserModel user : users) {
            if (user.getUsername().equals(usernameInput) && user.getPassword().equals(passwordInput)) {
                System.out.println("Login successful! Welcome, " + user.getUsername());
                loggedIn = true;
                return user;
            }
        }
        if (!loggedIn) {
            System.out.println("Invalid username or password. Please try again.");
        }
        return null;
    }

    public static UserModel createUser() {
        String username;
        String password;
        String email;

        // validate user email for later
        System.out.print("Enter your email address: ");
        email = sc.nextLine();
        while (true) {
            boolean newUsername = true;
            System.out.print("Enter a username: ");
            username = sc.nextLine();
            for (UserModel user : users) {
                if (user.getUsername().equals(username)) {
                    System.out.println("This username is already taken.");
                    newUsername = false;
                }
            }
            if (newUsername) {
                break;
            }
        }
        // Do further implementation for more secure passwords later with hexcode and
        // hashing/encryption
        System.out.print("Enter password: ");
        password = sc.nextLine();
        UserModel user = new FreeUser(username, password, email);
        users.add(user);
        System.out.println("New Account successfully created.");
        return user;
    }

    public static void menu(UserModel user) {
        String response;
        while (true) {
            System.out.print(
                    "Enter the number for the task you wish to perform\n1.Show Available Resources\n2.Borrow Resource\n3.Return Resource\n4.Check your borrowed list\n5.Upgrade Account\n6.Change Password\n0.Log Out\nResponse: ");
            response = sc.nextLine();
            switch (response) {
                case "1" -> ResourceUtilities.showResources();
                case "2" -> System.out.println("borrow resource");
                case "3" -> System.out.println("return book");
                case "4" -> System.out.println("check borrowed list along with due dates");
                case "5" -> System.out.println("upgrade acct");
                case "6" -> UserUtilities.changePassword(user);
                case "0" -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid input!");
            }
        }
    }

    static void changePassword(UserModel user) {
        String oldPassword = user.getPassword();
        System.out.print("Enter your previous password: ");
        String input = sc.nextLine();
        if (!(input.equals(oldPassword))) {
            System.out.println("Invalid Password");
            return;
        }
        String newPassword;
        System.out.print("Enter your new password: ");
        newPassword = sc.nextLine();
        user.setPassword(newPassword);
        System.out.println("Password change successful");
        // create a set password method, bcuz you are doing the same logic in both
        // create user and change password

    }
}