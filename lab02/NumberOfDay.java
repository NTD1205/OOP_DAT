package com.uni.lab02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberOfDay {
    static class MonthOfYear {
        String month, abbreviation, in3Letter;
        int number, dayCommon, dayLeap;


        public MonthOfYear(String month, String abbreviation, String in3Letter, int number, int dayCommon, int dayLeap) {
            this.month = month;
            this.abbreviation = abbreviation;
            this.in3Letter = in3Letter;
            this.number = number;
            this.dayCommon = dayCommon;
            this.dayLeap = dayLeap;
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<MonthOfYear> month = new ArrayList<>(List.of(
                new MonthOfYear("January", "Jan.", "Jan", 1, 31, 31),
                new MonthOfYear("February", "Feb.", "Feb", 2, 28, 29),
                new MonthOfYear("March", "Mar.", "Mar", 3, 31, 31),
                new MonthOfYear("April", "Apr.", "Apr", 4, 30, 30),
                new MonthOfYear("May", "May", "May", 5, 31, 31),
                new MonthOfYear("June", "June", "Jun", 6, 30, 30),
                new MonthOfYear("July", "July", "Jul", 7, 31, 31),
                new MonthOfYear("August", "Aug.", "Aug", 8, 31, 31),
                new MonthOfYear("September", "Sept.", "Sep", 9, 30, 30),
                new MonthOfYear("October", "Oct", "Oct", 10, 31, 31),
                new MonthOfYear("November", "Nov.", "Nov", 11, 30, 30),
                new MonthOfYear("December", "Dec.", "Dec", 12, 31, 31)
        ));
        boolean isLeapYear = false;
        String mont;
        int year;
        AtomicInteger result = new AtomicInteger(-1);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập tháng: ");
            mont = sc.next();
            System.out.println("Nhập năm: ");
            try {
                year = sc.nextInt();
                sc.close();
            } catch (Exception e) {
                System.out.println("Nhập sai. Nhập lại\n");
                continue;
            }

            if (year % 4 == 0 && (year % 100 != 0 || (year % 100 == 0 && year % 400 == 0)))
                isLeapYear = true;

            final String finalMont = mont;
            System.out.println(mont);
            final boolean finalIsLeapYear = isLeapYear;
            month.forEach(o -> {
                if (o.month.equals(finalMont) || o.abbreviation.equals(finalMont) || o.in3Letter.equals(finalMont) ||
                        finalMont.equals(o.number + "")
                ) {
                    System.out.println("ok");
                    result.set(o.dayCommon);
                    if (finalIsLeapYear)
                        result.set(o.dayLeap);
                }
            });
            if (result.get() != -1) {
                System.out.println(mont + "/" + year + ": " + result.get() + " days.");
                System.exit(0);
            } else {
                System.out.println("Nhập sai. Nhập lại\n");
            }
        }

    }
}
