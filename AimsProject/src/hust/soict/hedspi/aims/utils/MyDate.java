package hust.soict.hedspi.aims.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Scanner;

public class MyDate {
    private int day;
    private int month;
    private int year;

    Scanner keyboard = new Scanner(System.in);

    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    int currentDay = calendar.get(Calendar.DATE);
    int currentMonth = calendar.get(Calendar.MONTH);
    int currentYear = calendar.get(Calendar.YEAR);

    //Getter & Setter
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    // Constructors
    public MyDate(){
        setDay(currentDay);
        setMonth(currentMonth+1);
        setYear(currentYear);
    }
    public MyDate(int day, int month, int year){
        if (isValidDate(day,month,year)) {
            setDay(day);
            setMonth(month);
            setYear(year);
        }
    }
    public MyDate(String DateRaw){
        String[] SplitDate = DateRaw.split("\\s");
        String StrMonth = SplitDate[0];
        String StrDay = SplitDate[1];
        String StrYear = SplitDate[2];

        this.month = StrToIntMonth(StrMonth);
        this.day = StrToIntDay(StrDay);
        this.year = StrToIntYear(StrYear);

        if(!isValidDate(this.day,this.month,this.year)){
            System.out.println(("Date is invalid! Please try again!"));
            accept();
        }

    }
    public MyDate(String day, String month, String year){
    	int intDay = WordStrToIntDay(day);
    	int intMonth = StrToIntMonth(month);
    	int intYear = WordStrToIntYear(year);
    	
    	if(isValidDate(WordStrToIntDay(day), StrToIntMonth(month), WordStrToIntYear(year))) {
	        setDay(intDay);
	        setMonth(intMonth);
	        setYear(intYear);
    	}	else {
    		setDay(currentDay);
	        setMonth(currentMonth+1);
	        setYear(currentYear);
	        System.out.println("Unknown error. Date is set to current date");
    	}   	   	
    }

    // Valid checker
    public boolean isLeapYear(int year){
        if (year%400 == 0) return true;
        else if (year%100 == 0) return false;
        else return year%4 == 0;
    }
    public boolean isValidDate(int day, int month, int year){
        if (year < 0) return false;
        if (month < 1 || month > 12) return false;
        if (day < 1 || day > 31) return false;

        if (month == 2){
            if (isLeapYear(year)) return day <= 29;
            else return day <= 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) return day <= 30;
        return true;
    }

    public int StrToIntDay(String strDay){
        strDay = strDay.replace("st", "");
        strDay = strDay.replace("nd", "");
        strDay = strDay.replace("rd", "");
        strDay = strDay.replace("th", "");
        return Integer.parseInt(strDay);
    }
    public int StrToIntMonth(String strMonth){
        switch (strMonth.toLowerCase()) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
                return 1;
            case "february":
            case "feb.":
            case "feb":
            case "2":
                return 2;
            case "march":
            case "mar.":
            case "mar":
            case "3":
                return 3;
            case "april":
            case "apr.":
            case "apr":
            case "4":
                return 4;
            case "may":
            case "5":
                return 5;
            case "june":
            case "jun":
            case "6":
                return 6;
            case "july":
            case "jul":
            case "7":
                return 7;
            case "august":
            case "aug.":
            case "aug":
            case "8":
                return 8;
            case "september":
            case "sept.":
            case "sep":
            case "9":
                return 9;
            case "october":
            case "oct.":
            case "oct":
            case "10":
                return 10;
            case "november":
            case "nov.":
            case "nov":
            case "11":
                return 11;
            case "december":
            case "dec.":
            case "dec":
            case "12":
                return 12;
            default:
                return 0;
        }
    }
    public int StrToIntYear(String strYear){
        return Integer.parseInt(strYear);
    }

    public int WordStrToIntDay(String strDay){
        switch (strDay.toLowerCase()){
            case "first": return 1;
            case "second": return 2;
            case "third": return 3;
            case "fourth": return 4;
            case "fifth": return 5;
            case "sixth": return 6;
            case "seventh": return 7;
            case "eighth": return 8;
            case "ninth": return 9;
            case "tenth": return 10;
            case "eleventh": return 11;
            case "twelfth": return 12;
            case "thirteenth": return 13;
            case "fourteenth": return 14;
            case "fifteenth": return 15;
            case "sixteenth": return 16;
            case "seventeenth": return 17;
            case "eighteenth": return 18;
            case "nineteenth": return 19;
            case "twentieth": return 20;
            case "twentyfirst": return 21;
            case "twentysecond": return 22;
            case "twentythird": return 23;
            case "twentyfourth": return 24;
            case "twentyfifth": return 25;
            case "twentysixth": return 26;
            case "twentyseventh": return 27;
            case "twentyeighth": return 28;
            case "twentyninth": return 29;
            case "thirtieth": return 30;
            case "thirtyfirst": return 31;
            default: System.out.println("Please enter day from 1 to 31!"); return 0;
        }
    }

    public int WordStrToIntYear(String strYear){
    	int IntYear_hundreds = -1;
    	int IntYear_units = -1;
    	
    	String[] split_strYear = strYear.split("\\s");
    	switch (split_strYear[0].toLowerCase()) {
    		case "zero": IntYear_hundreds = 0; break;
    		case "one" : IntYear_hundreds = 1;break;
    		case "two" : IntYear_hundreds = 2; break;
    		case "three" : IntYear_hundreds = 3; break;
    		case "four" : IntYear_hundreds = 4; break;
    		case "five" : IntYear_hundreds = 5; break;
    		case "six" : IntYear_hundreds = 6; break;
    		case "seven" : IntYear_hundreds = 7; break;
    		case "eight" : IntYear_hundreds = 8; break;
    		case "nine" : IntYear_hundreds = 9; break;
    		case "ten" : IntYear_hundreds = 10; break;
    		case "eleven" : IntYear_hundreds = 11; break;
    		case "twelve" : IntYear_hundreds = 12; break;
    		case "thirteen" : IntYear_hundreds = 13; break;
    		case "fourteen" : IntYear_hundreds = 14; break;
    		case "fifteen" : IntYear_hundreds = 15; break;
    		case "sixteen" : IntYear_hundreds = 16; break;
    		case "seventeen" : IntYear_hundreds = 17; break;
    		case "eighteen" : IntYear_hundreds = 18; break;
    		case "nineteen" : IntYear_hundreds = 19; break;
    		case "twenty" : IntYear_hundreds = 20; break;
    		case "twentyone" : IntYear_hundreds = 21; break;
    		case "twentytwo" : IntYear_hundreds = 22; break;
    		case "twentythree" : IntYear_hundreds = 23; break;
    		case "twentyfour" : IntYear_hundreds = 24; break;
    		case "twentyfive" : IntYear_hundreds = 25; break;
    		case "twentysix" : IntYear_hundreds = 26; break;
    		case "twentyseven" : IntYear_hundreds = 27; break;
    		case "twentyeight" : IntYear_hundreds = 28; break;
    		case "twentynine" : IntYear_hundreds = 29; break;
    		case "thirty" : IntYear_hundreds = 30; break;
    		case "thirtyone" : IntYear_hundreds = 31; break;
    		case "thirtytwo" : IntYear_hundreds = 32; break;
    		case "thirtythree" : IntYear_hundreds = 33; break;
    		case "thrityfour" : IntYear_hundreds = 34; break;
    		case "thirtyfive" : IntYear_hundreds = 35; break;
    		case "thirtysix" : IntYear_hundreds = 36; break;
    		case "thirtyseven" : IntYear_hundreds = 37; break;
    		case "thirtyeight" : IntYear_hundreds = 38; break;
    		case "thirtynine" : IntYear_hundreds = 39; break;
    		case "forty" : IntYear_hundreds = 40; break;
    		case "fortyone" : IntYear_hundreds = 41; break;
    		case "fortytwo" : IntYear_hundreds = 42; break;
    		case "fortythree" : IntYear_hundreds = 43; break;
    		case "fortyfour" : IntYear_hundreds = 44; break;
    		case "fortyfive" : IntYear_hundreds = 45; break;
    		case "fortysix" : IntYear_hundreds = 46; break;
    		case "fortyseven" : IntYear_hundreds = 47; break;
    		case "fortyeight" : IntYear_hundreds = 48; break;
    		case "fortynine" : IntYear_hundreds = 49; break;
    		case "fifty" : IntYear_hundreds = 50; break;
    		case "fiftyone" : IntYear_hundreds = 51; break;
    		case "fiftytwo" : IntYear_hundreds = 52; break;
    		case "fiftythree" : IntYear_hundreds = 53; break;
    		case "fiftyfour" : IntYear_hundreds = 54; break;
    		case "fiftyfive" : IntYear_hundreds = 55; break;
    		case "fiftysix" : IntYear_hundreds = 56; break;
    		case "fiftyseven" : IntYear_hundreds = 57; break;
    		case "fiftyeight" : IntYear_hundreds = 58; break;
    		case "fiftynine" : IntYear_hundreds = 59; break;
    		case "sixty" : IntYear_hundreds = 60; break;
    		case "sixtyone" : IntYear_hundreds = 61; break;
    		case "sixtytwo" : IntYear_hundreds = 62; break;
    		case "sixtythree" : IntYear_hundreds = 63; break;
    		case "sixtyfour" : IntYear_hundreds = 64; break;
    		case "sixtyfive" : IntYear_hundreds = 65; break;
    		case "sixtysix" : IntYear_hundreds = 66; break;
    		case "sixtyseven" : IntYear_hundreds = 67; break;
    		case "sixtyeight" : IntYear_hundreds = 68; break;
    		case "sixtynine" : IntYear_hundreds = 69; break;
    		case "seventy" : IntYear_hundreds = 70; break;
    		case "seventyone" : IntYear_hundreds = 71; break;
    		case "seventytwo" : IntYear_hundreds = 72; break;
    		case "seventythree" : IntYear_hundreds = 73; break;
    		case "seventyfour" : IntYear_hundreds = 74; break;
    		case "seventyfive" : IntYear_hundreds = 75; break;
    		case "seventysix" : IntYear_hundreds = 76; break;
    		case "seventyseven" : IntYear_hundreds = 77; break;
    		case "seventyeight" : IntYear_hundreds = 78; break;
    		case "seventynine" : IntYear_hundreds = 79; break;
    		case "eighty" : IntYear_hundreds = 80; break;
    		case "eightyone" : IntYear_hundreds = 81; break;
    		case "eightytwo" : IntYear_hundreds = 82; break;
    		case "eightythree" : IntYear_hundreds = 83; break;
    		case "eightyfour" : IntYear_hundreds = 84; break;
    		case "eightyfive" : IntYear_hundreds = 85; break;
    		case "eightysix" : IntYear_hundreds = 86; break;
    		case "eightyseven" : IntYear_hundreds = 87; break;
    		case "eightyeight" : IntYear_hundreds = 88; break;
    		case "eightynine" : IntYear_hundreds = 89; break;
    		case "ninety" : IntYear_hundreds = 90; break;
    		case "ninetyone" : IntYear_hundreds = 91; break;
    		case "ninetytwo" : IntYear_hundreds = 92; break;
    		case "ninetythree" : IntYear_hundreds = 93; break;
    		case "ninetyfour" : IntYear_hundreds = 94; break;
    		case "ninetyfive" : IntYear_hundreds = 95; break;
    		case "ninetysix" : IntYear_hundreds = 96; break;
    		case "ninetyseven" : IntYear_hundreds = 97; break;
    		case "ninetyeight" : IntYear_hundreds = 98; break;
    		case "ninetynine" : IntYear_hundreds = 99; break;
    		case "tenno" : IntYear_hundreds = 100; break;
    	}
    	
    	switch (split_strYear[1].toLowerCase()) {
    		case "zero": IntYear_units = 0; break;
			case "one" : IntYear_units  = 1; break;
			case "two" : IntYear_units  = 2; break;
			case "three" : IntYear_units  = 3; break;
			case "four" : IntYear_units  = 4; break;
			case "five" : IntYear_units  = 5; break;
			case "six" : IntYear_units  = 6; break;
			case "seven" : IntYear_units  = 7; break;
			case "eight" : IntYear_units  = 8; break;
			case "nine" : IntYear_units  = 9; break;
			case "ten" : IntYear_units  = 10; break;
			case "eleven" : IntYear_units  = 11; break;
			case "twelve" : IntYear_units  = 12; break;
			case "thirteen" : IntYear_units  = 13; break;
			case "fourteen" : IntYear_units  = 14; break;
			case "fifteen" : IntYear_units  = 15; break;
			case "sixteen" : IntYear_units  = 16; break;
			case "seventeen" : IntYear_units  = 17; break;
			case "eighteen" : IntYear_units  = 18; break;
			case "nineteen" : IntYear_units  = 19; break;
			case "twenty" : IntYear_units  = 20; break;
			case "twentyone" : IntYear_units  = 21; break;
			case "twentytwo" : IntYear_units  = 22; break;
			case "twentythree" : IntYear_units  = 23; break;
			case "twentyfour" : IntYear_units  = 24; break;
			case "twentyfive" : IntYear_units  = 25; break;
			case "twentysix" : IntYear_units  = 26; break;
			case "twentyseven" : IntYear_units  = 27; break;
			case "twentyeight" : IntYear_units  = 28; break;
			case "twentynine" : IntYear_units  = 29; break;
			case "thirty" : IntYear_units  = 30; break;
			case "thirtyone" : IntYear_units  = 31; break;
			case "thirtytwo" : IntYear_units  = 32; break;
			case "thirtythree" : IntYear_units  = 33; break;
			case "thrityfour" : IntYear_units  = 34; break;
			case "thirtyfive" : IntYear_units  = 35; break;
			case "thirtysix" : IntYear_units  = 36; break;
			case "thirtyseven" : IntYear_units  = 37; break;
			case "thirtyeight" : IntYear_units  = 38; break;
			case "thirtynine" : IntYear_units  = 39; break;
			case "forty" : IntYear_units  = 40; break;
			case "fortyone" : IntYear_units  = 41; break;
			case "fortytwo" : IntYear_units  = 42; break;
			case "fortythree" : IntYear_units  = 43; break;
			case "fortyfour" : IntYear_units  = 44; break;
			case "fortyfive" : IntYear_units  = 45; break;
			case "fortysix" : IntYear_units  = 46; break;
			case "fortyseven" : IntYear_units  = 47; break;
			case "fortyeight" : IntYear_units  = 48; break;
			case "fortynine" : IntYear_units  = 49; break;
			case "fifty" : IntYear_units  = 50; break;
			case "fiftyone" : IntYear_units  = 51; break;
			case "fiftytwo" : IntYear_units  = 52; break;
			case "fiftythree" : IntYear_units  = 53; break;
			case "fiftyfour" : IntYear_units  = 54; break;
			case "fiftyfive" : IntYear_units  = 55; break;
			case "fiftysix" : IntYear_units  = 56; break;
			case "fiftyseven" : IntYear_units  = 57; break;
			case "fiftyeight" : IntYear_units  = 58; break;
			case "fiftynine" : IntYear_units  = 59; break;
			case "sixty" : IntYear_units  = 60; break;
			case "sixtyone" : IntYear_units  = 61; break;
			case "sixtytwo" : IntYear_units  = 62; break;
			case "sixtythree" : IntYear_units  = 63; break;
			case "sixtyfour" : IntYear_units  = 64; break;
			case "sixtyfive" : IntYear_units  = 65; break;
			case "sixtysix" : IntYear_units  = 66; break;
			case "sixtyseven" : IntYear_units  = 67; break;
			case "sixtyeight" : IntYear_units  = 68; break;
			case "sixtynine" : IntYear_units  = 69; break;
			case "seventy" : IntYear_units  = 70; break;
			case "seventyone" : IntYear_units  = 71; break;
			case "seventytwo" : IntYear_units  = 72; break;
			case "seventythree" : IntYear_units  = 73; break;
			case "seventyfour" : IntYear_units  = 74; break;
			case "seventyfive" : IntYear_units  = 75; break;
			case "seventysix" : IntYear_units  = 76; break;
			case "seventyseven" : IntYear_units  = 77; break;
			case "seventyeight" : IntYear_units  = 78; break;
			case "seventynine" : IntYear_units  = 79; break;
			case "eighty" : IntYear_units  = 80; break;
			case "eightyone" : IntYear_units  = 81; break;
			case "eightytwo" : IntYear_units  = 82; break;
			case "eightythree" : IntYear_units  = 83; break;
			case "eightyfour" : IntYear_units  = 84; break;
			case "eightyfive" : IntYear_units  = 85; break;
			case "eightysix" : IntYear_units  = 86; break;
			case "eightyseven" : IntYear_units  = 87; break;
			case "eightyeight" : IntYear_units  = 88; break;
			case "eightynine" : IntYear_units  = 89; break;
			case "ninety" : IntYear_units  = 90; break;
			case "ninetyone" : IntYear_units  = 91; break;
			case "ninetytwo" : IntYear_units  = 92; break;
			case "ninetythree" : IntYear_units  = 93; break;
			case "ninetyfour" : IntYear_units  = 94; break;
			case "ninetyfive" : IntYear_units  = 95; break;
			case "ninetysix" : IntYear_units  = 96; break;
			case "ninetyseven" : IntYear_units  = 97; break;
			case "ninetyeight" : IntYear_units  = 98; break;
			case "ninetynine" : IntYear_units  = 99; break;
			case "tenno" : IntYear_units  = 100; break;
    	}
    	
		return IntYear_hundreds*100 + IntYear_units;
    }

    public String IntToStrMonth(int month){
        switch (month){
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: System.out.println("Month not exist!"); return "";
        }
    }
    public String IntToStrDay_Symbol(int day){
        switch(day){
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31: return "th";
            default: return "Unknown error (StrToIntDay_Symbol)";
        }
    }


    public void accept(){
        while (true) {
            System.out.println("Enter a String Date (Format: January 01th 2000): ");
            String DateRaw = keyboard.nextLine();
            String[] SplitDate = DateRaw.split("\\s");

            String StrMonth = new String(SplitDate[0]);
            String StrDay = new String(SplitDate[1]);
            String StrYear = new String(SplitDate[2]);

            this.month = StrToIntMonth(StrMonth);
            this.day = StrToIntDay(StrDay);
            this.year = StrToIntYear(StrYear);

            if(!isValidDate(this.day,this.month,this.year)){
                System.out.println(("Date is invalid! Please try again!"));
                continue;
            }
            break;
        }

    }
    public void print(){
        System.out.println(this.day + "/" + this.month + "/" + this.year);
    }

    public void printformat1(){
        System.out.println(IntToStrMonth(this.month) + " " + this.day + IntToStrDay_Symbol(this.day)+ " " + this.year);
    }

    public void printformat2(){
        System.out.print("yyyy-MM-DD: ");
        System.out.println(this.year + "-" + this.month + "-" + this.day);
    }

    public void cloneTo(MyDate newDate){
        newDate.setDay(this.day);
        newDate.setMonth(this.month);
        newDate.setYear(this.year);
    }

    public static void swapDate(MyDate date1, MyDate date2){
        MyDate tmp = new MyDate();
        date1.cloneTo(tmp);
        date2.cloneTo(date1);
        tmp.cloneTo(date2);
    }
    
    public String toString() {
    	return (this.day +"/" + this.month + "/" + this.year);
    }

}
