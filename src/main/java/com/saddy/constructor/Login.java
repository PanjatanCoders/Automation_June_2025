package com.saddy.constructor;

public class Login {

    private String env;

    public Login() {
        System.out.println("Default constructor called.");
    }
    // Constructor
    public Login(String env) {
        // Initialization code can go here if needed
        this.env = env;
        System.out.println("Login class initialized.");
    }

    public void connectToDatabase() {
        // Simulate a database connection
        System.out.println("Connecting to the database...");
        // Here you would typically add code to establish a connection to your database
    }

    public void login(String username, String password) {
        System.out.println("Environment: " + env);
        // Simulate a login process
        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }

    }
}
