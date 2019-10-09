package com.emailapp;

import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Email em1 = new Email("", "");
        int accounts = 0;
        accounts++;

        boolean running = true;
        boolean loggedIn = true;

        while (running) {
            if (loggedIn) {
                System.out.println("Logged in as: " + em1.firstName);
                System.out.println("Choose an action:\n1 for Show Info\n2 for Change Password\n3 for Log Out\n0 for Exit");
                int action = in.nextInt();

                if (action == 1) {
                    System.out.println(em1.showInfo());
                } else if (action == 2) {
                    String password = em1.getNewPassword();
                    em1.changePassword(password);
                } else if (action == 3) {
                    loggedIn = false;
                } else if (action == 0) {
                    System.exit(0);
                }
            }
            if (!loggedIn) {
                // Get action
                System.out.println("Choose an action:\n1 for Log In\n2 for Sign Up\n0 for Exit App");
                int action = in.nextInt();

                // Log in
                if (action == 1) {
                    loggedIn = em1.logIn(em1);
                }
                // Sign up
                else if (action == 2) {
                    Email em = new Email("", "");
                    loggedIn = true;
                }
                // Exit app
                else if (action == 0) {
                    System.exit(0);
                }
            }
        }
    }
}