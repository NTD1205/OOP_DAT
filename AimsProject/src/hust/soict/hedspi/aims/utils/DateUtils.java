package hust.soict.hedspi.aims.utils;

public class DateUtils {
    public static int Compare(MyDate date1, MyDate date2) {
        if (date1.getYear() == date2.getYear() && date1.getMonth() == date2.getMonth() && date1.getDay() == date2.getDay()) {
            return 0;
        } else if (date1.getYear() > date2.getYear()) {
             return 1;
        } else if (date1.getYear() < date2.getYear()) {
            return -1;
        } else if (date1.getMonth() > date2.getMonth()) {
            return 1;
        } else if (date1.getMonth() < date2.getMonth()) {
             return -1;
        } else if (date1.getDay() > date2.getDay()){
            return 1;
        }else if (date1.getDay() < date2.getDay()){
            return -1;
        }
        else return -2;
    }

    public static void sortDate(MyDate... dates){
        int size = 0;
        for (MyDate date : dates) size ++;

        int smallestDate_index;

        //SELECTION SORT
        for(int i =0; i<size;i++){
            smallestDate_index = i;
            for (int j = i+1; j<size; j++) {
                if (Compare(dates[smallestDate_index],dates[j]) == 1){
                    smallestDate_index = j;
                }
            }
            if(smallestDate_index != i) {
                MyDate.swapDate(dates[smallestDate_index], dates[i]);
            }
        }
    }

    public static void printCompareResult(MyDate date1, MyDate date2){
        switch(Compare(date1,date2)){
            case 0: System.out.println("Left date is the same as right date"); break;
            case 1: System.out.println("Left date is after right date"); break;
            case -1: System.out.println("Left date is before right date"); break;
            default: break;
        }
    }
}
