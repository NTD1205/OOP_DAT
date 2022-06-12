package hust.soict.hedspi.test.utils;

import java.util.Date;

import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

public class DateTest {
    public static void main(String[] args){
        MyDate testDate1 = new MyDate();
        testDate1.printformat1();
        testDate1.printformat2();

        MyDate testDate2 = new MyDate();
        MyDate testDate3 = new MyDate("Feb 2nd 2020");
        DateUtils.printCompareResult(testDate1,testDate2);
        DateUtils.printCompareResult(testDate2,testDate3);
        DateUtils.printCompareResult(testDate3,testDate2);

        MyDate testDate4 = new MyDate("March 2nd 2000");

        MyDate[] datelist = {testDate1,testDate2,testDate3,testDate4};

        System.out.println("\nBefore sorting:");
        for( MyDate date : datelist){
            date.printformat1();
        }

        System.out.println("\nAfter sorting:");
        DateUtils.sortDate(datelist);

        for( MyDate date : datelist){
            date.printformat1();
        }
        
        
        MyDate testDate5 = new MyDate("second","September","twenty nineteen");
        testDate5.printformat1();

    }
}
