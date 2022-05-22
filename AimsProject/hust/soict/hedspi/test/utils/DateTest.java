package AimsProject.hust.soict.hedspi.test.utils;

import AimsProject.hust.soict.hedspi.aims.utils.DateUtils;
import AimsProject.hust.soict.hedspi.aims.utils.MyDate;

public class DateTest {
    public static void main(String[] args) {
        MyDate date1 = new MyDate();
        date1.print();
        MyDate date2 = new MyDate(11, 5, 2001);
        date2.print();
        MyDate date3 = new MyDate("February 18th 2019");
        date3.print();
        //date2.accept();
        date2.print();

        MyDate date4 = new MyDate("second", "September", "nineteen twenty-one");
        date4.print("MMM d yyyy");

        DateUtils.compare(date1, date4);

        for (MyDate myDate : DateUtils.sortDate(date1, date2, date3, date4)) {
            myDate.print();
        }
    }
}