package com.emailapp;

import java.util.Scanner;

public class Email {
    // Initialize Public Variables
    public Scanner in = new Scanner(System.in);

    // Initialize Private Variables
    public String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Constructor to receive first and last name
    public Email(String firstName, String lastName) {

        System.out.println("What is your first name?");
        this.firstName = in.nextLine();
        System.out.println("What is your last name?");
        this.lastName = in.nextLine();

        // Call a method asking for department - return the department
        this.department = setDepartment();

        // Call a method to return a random password
        this.password = randomPassword(defaultPasswordLength);

        // Combine elements to generate email
        email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("New worker: " + firstName + ".\nDepartment Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: \n");
        int depChoice = in.nextInt();

        if (depChoice == 1) {
            return "sales";
        }
        else if (depChoice ==2) {
            return "dev";
        }
        else if (depChoice == 3) {
            return "acct";
        }
        else {
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwyxz1234567890!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb\n" +
                "PASSWORD: " + password + "\n";
    }

    public static String getNewPassword() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a new password: ");
        String password = in.nextLine();
        return password;
    }

    public boolean logIn(Email em1) {
        Scanner in = new Scanner(System.in);

        System.out.println(showInfo());

        System.out.println("Enter email:");
        String em = in.nextLine();
        System.out.println("Enter password:");
        String pw = in.nextLine();

        if (em.equals(email) && pw.equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }
}
