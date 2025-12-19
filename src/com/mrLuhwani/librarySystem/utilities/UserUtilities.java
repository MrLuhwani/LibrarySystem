package com.mrLuhwani.librarySystem.utilities;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mrLuhwani.librarySystem.userModel.*;

public class UserUtilities {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<UserModel> users = new ArrayList<>();

    public static HashMap<UserModel, Integer> userLogin() {
        System.out.print("Enter username: ");
        String usernameInput = sc.nextLine();
        // Most ppl remeber their emails, than username, so when you have advance email
        // logic, validate email instead of username
        System.out.print("Enter password: ");
        String passwordInput = sc.nextLine();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(usernameInput) && users.get(i).getPassword().equals(passwordInput)) {
                HashMap<UserModel, Integer> userAndIndex = new HashMap<>(1);
                System.out.println("Login successful! Welcome, " + users.get(i).getUsername());
                userAndIndex.put(users.get(i), i);
                return userAndIndex;
            }
        }
        System.out.println("Invalid username or password. Please try again.");
        return null;
    }

    public static HashMap<UserModel, Integer> createUser() {
        String username;
        String password;
        String email;

        // validate userMap email for later
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
        int index = users.size() - 1;
        System.out.println("New Account successfully created.");
        HashMap<UserModel, Integer> userAndIndex = new HashMap<>(1);
        System.out.println("Welcome, " + user.getUsername());
        userAndIndex.put(users.get(index), index);
        return userAndIndex;
    }

    private static String menuChoices(boolean isFree) {
        // trying to write DRY code, LOL
        String menu1 = "Enter the number for the task you wish to perform\n1.Show Available Resources\n2.Borrow Resource\n3.Return Resource\n4.Check your borrowed list\n5.Upgrade Account\n6.Change Password\n0.Log Out\nResponse: ";
        String menu2 = "Enter the number for the task you wish to perform\n1.Show Available Resources\n2.Borrow Resource\n3.Return Resource\n4.Check your borrowed list\n5.Terminate premium package\n6.Change Password\n0.Log Out\nResponse: ";
        if (isFree) {
            return menu1;
        }
        return menu2;
    }

    public static void menu(Map<UserModel, Integer> userMap) {
        UserModel loggedInUser = null;
        for (UserModel u : userMap.keySet()) {
            loggedInUser = u;
        }
        String response;
        if (loggedInUser.getMembershipLevel() == MembershipLevel.FREE ) {
            while (true) {
                System.out.print(UserUtilities.menuChoices(true));
                response = sc.nextLine();
                switch (response) {
                    case "1" -> ResourceUtilities.showResources(loggedInUser);
                    case "2" -> ResourceUtilities.borrowResource(loggedInUser);
                    case "3" -> ResourceUtilities.returnResource(loggedInUser);
                    case "4" -> loggedInUser.printItemsAndDueDates();
                    case "5" -> UserUtilities.upgradeAccount(userMap);
                    case "6" -> UserUtilities.changePassword(loggedInUser);
                    case "0" -> {
                        System.out.println("Logging out...");
                        return;
                    }
                    default -> System.out.println("Invalid input!");
                }
            }
        } else {
            while (true) {
                System.out.print(UserUtilities.menuChoices(false));
                response = sc.nextLine();
                switch (response) {
                    case "1" -> ResourceUtilities.showResources(loggedInUser);
                    case "2" -> ResourceUtilities.borrowResource(loggedInUser);
                    case "3" -> ResourceUtilities.returnResource(loggedInUser);
                    case "4" -> loggedInUser.printItemsAndDueDates();
                    case "5" -> UserUtilities.downgradeAccount(userMap);
                    case "6" -> UserUtilities.changePassword(loggedInUser);
                    case "0" -> {
                        System.out.println("Logging out...");
                        return;
                    }
                    default -> System.out.println("Invalid input!");
                }
            }
        }
    }

    private static void changePassword(UserModel user) {
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

    private static void upgradeAccount(Map<UserModel, Integer> userMap) {
        String response;
        System.out.println("Premium plan costs ₦1,200/month");
        while (true) {
            System.out.print(
                    "Enter a choice based on the numbers (1|2)\n1. Confirm Upgrade\n2. Cancel request\nResponse: ");
            response = sc.nextLine();
            // I'll think of a better way to implemet this
            switch (response) {
                case "1" -> {
                    System.out.println("Processing payment...");
                    System.out.println("Payment Successful");
                    users.get(new ArrayList<>(userMap.values()).get(0)).accountUpgrade();
                    return;
                }
                case "2" -> {
                    System.out.println("Returning to main menu...");
                    return;
                }
                default -> System.out.println("Invalid Input");
            }
        }
    }

    private static void downgradeAccount(Map<UserModel, Integer> userMap) {
        String response;
        while (true) {
            System.out.print(
                "Enter the number for your choice (1|2)\n1. Confirm premium subscription termination\n2. Cancel request\nResponse: ");
            response = sc.nextLine();
            // I'll think of a better way to implemet this
            switch (response) {
                case "1" -> {
                    users.get(new ArrayList<>(userMap.values()).get(0)).accountDegrade();
                    return;
                }
                case "2" -> {
                    System.out.println("Returning to main menu...");
                    return;
                }
                default -> System.out.println("Invalid Input");
            }
        }
    }
}