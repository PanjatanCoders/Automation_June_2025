package com.saddy.exceptionhandling;

public class ExceptionDemo1 {
    public void displayNumber(int index) {
        int[] nums = {10, 20, 30, 40};
        try {
            System.out.println("Data at index: " + index + " is: " + nums[index]);
            System.out.println(String.format("Data at index: %d is: %d", index, nums[index]));

        } catch (ArithmeticException e) {
            System.out.println("Inside ArithmeticException. " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Inside IndexOutOfBoundsException");
        } catch (RuntimeException e) {
            System.out.println("Inside RuntimeException");
        } catch (Exception e) {
            System.out.println("Inside Exception");
        }

        System.out.println("End of Array Method");
    }
}

//String -> %s
// int -> %d


//Data at index: 2 is: 30