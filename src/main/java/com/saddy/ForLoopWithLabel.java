package com.saddy;

public class ForLoopWithLabel {
    public static void main(String[] args) {
        label1: // Label for the outer loop
        for (int i = 0; i < 5; i++) {
            System.out.println("Outer loop iteration: " + i);
            label2:
            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    System.out.println("Breaking out of both loops at i=" + i + ", j=" + j);
                    break label1; // Breaks out of the outer loop
                }
                System.out.println("Inner loop iteration: " + j);
            }
        }
        System.out.println("Exited both loops.");
    }
}
