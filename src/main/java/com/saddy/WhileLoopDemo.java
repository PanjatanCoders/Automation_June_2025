package com.saddy;

public class WhileLoopDemo {
    public static void main(String[] args) {
        whileLoopDemo();
    }

    static void whileLoopDemo() {
        int i = 1;
        while (i <= 10) {

            if (i == 5) {
                System.out.println("Skipping iteration 5");
                i++; // Increment to avoid infinite loop
                continue; // Skip the rest of the loop when i is 5
            }
            if (i == 8) {
                System.out.println("Breaking at iteration 8");
                break; // Exit the loop when i is 8
            }
            System.out.println("Iteration: " + i);
            i++; // Increment i to avoid infinite loop
        }
        System.out.println("While loop completed successfully.");
    }

    static void dowhileLoopDemo() {
        int i = 1;
        do {
            if (i == 5) {
                System.out.println("Skipping iteration 5");
                i++; // Increment to avoid infinite loop
                continue; // Skip the rest of the loop when i is 5
            }
            if (i == 8) {
                System.out.println("Breaking at iteration 8");
                break; // Exit the loop when i is 8
            }
            System.out.println("Iteration: " + i);
            i++; // Increment i to avoid infinite loop
        } while (i <= 10);
        System.out.println("Do-while loop completed successfully.");
    }
}
