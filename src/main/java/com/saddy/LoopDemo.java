package com.saddy;

public class LoopDemo {
    public static void main(String[] args) {
//        for (int i = 1; i <= 10; i++) {
//            System.out.println("Iteration: " + i);
//        }

//        int i = 1;
//        for (; i <= 10; i++) {
//            System.out.println("Iteration: " + i);
//        }
//
//        int i = 1;
//        for (; i <= 10;) {
//            System.out.println("Iteration: " + i);
//            i++;
//        }

//        display();
//        Nested for loop
        for (int j = 1; j <= 3; j++) {
            System.out.println("Outer Loop Iteration: " + j);
            for (int k = 1; k <= 2; k++) {
                System.out.println("    Inner Loop Iteration: " + k);
                break;
            }
        }
//    }
//    static void display() {
//        System.out.println("This is a static method in LoopDemo class.");

//    Loop with break and continue
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Skipping iteration 5");
                continue; // Skip the rest of the loop when i is 5
            }
            if (i == 8) {
                System.out.println("Breaking at iteration 8");
                break; // Exit the loop when i is 8
            }
            System.out.println("Iteration: " + i);
        }

        System.out.println("Loop completed successfully.");

    }
}
