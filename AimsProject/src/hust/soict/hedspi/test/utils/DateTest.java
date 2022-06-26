package hust.soict.hedspi.test.utils;
import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

public class DateTest {

	public static void main(String[] args) {
		
//		Test Constructor no parameter 
		MyDate testDate = new MyDate();
		System.out.println("Test Case 1: ");
		testDate.print();
		
//		Test Constructor 3 parameter
		MyDate testDate2 = new MyDate(30, 4, 2019);
		System.out.println("Test Case 2: ");
		testDate2.print();
		
//		Test Constructor with 1 string parameter 
		MyDate testDate3 = new MyDate("June 08 2020");
		System.out.println("Test Case 3: ");
		testDate3.print();
		
//		Test accept method from MyDate Class
		// System.out.println("Test Case 4: ");
		// MyDate testDate4 = new MyDate(MyDate.accept());
		// testDate4.print();
		
//		Test Constructor with 3 parameter string (day, month, year)
		System.out.println("Test Case 5: ");
		MyDate testDate5 = new MyDate("second", "january", "twenty twenty one ");
		testDate5.print();
		
		
		// Compare and Sorting DATE
		System.out.println("Test Case Compare and Sorting: ");
       String[] date = new String[]{"2020/10/03", "2021/04/16", "2009/05/10", "2017/03/20"};

       // Before Sorting
       System.out.println("Before Sorting: ");
       for (int i = 0; i < date.length; i++) {
           System.out.println(date[i]);
       }

       DateUtils.sortingDate(date);

       // After Sorting
       System.out.println("After Sorting: ");
       for (int i = 0; i < date.length; i++) {
           System.out.println(date[i]);
       }
		
		System.exit(0);
	}

}
