package com.uni.lab03;

public class DateTest {
    public static void main(String[] args) {
        MyDate date1 = new MyDate();
        date1.print();
        MyDate date2 = new MyDate(11, 5, 2001);
        date2.print();
        MyDate date3 = new MyDate("February 18th 2019");
        date3.print();
        date2.accept();
        date2.print();
    }
}
