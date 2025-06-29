package com.saddy;

import com.saddy.enumdemo.PaymentType;
import com.saddy.enumdemo.TestStatus;

public class TestEnum {
    public static void main(String[] args) {
//        System.out.println(PaymentType.UPI);
//        System.out.println(PaymentType.CREDIT_CARD);

        System.out.println(TestStatus.PASS.getStatusDescription());
    }
}
