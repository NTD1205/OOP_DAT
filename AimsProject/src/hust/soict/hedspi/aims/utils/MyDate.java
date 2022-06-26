package hust.soict.hedspi.aims.utils;
import java.util.Arrays;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MyDate {
	private int day;
	private int month;
	private int year;
	public String[] monthOfYear = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(month == 2) {
			if(checkLeapYear(year)) {
				if(day > 0 && day <= 29) {
					this.day = day;
				}else {
					System.err.println("Error in input day");
				}
			}else {
				if(day > 0 && day <= 28) {
					this.day = day;
				}else {
					System.err.println("Error in input day");
				}
			}
		}else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if(day > 0 && day <= 31) {
				this.day = day;
			}else {
				System.err.println("Error in input day");
			}
		}else {
			if(day > 0 && day <= 30) {
				this.day = day;
			}else {
				System.err.println("Error in input day");
			}
		}
	}
	
	public void setDay(String day) {
        String[] dayOfMonth = new String[]{"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth", "twenty-first", "twenty-second", "twenty-third", "twenty-fourth", "twenty-fifth", "twenty-sixth", "twenty-seventh", "twenty-eighth", "twenty-ninth", "thirtieth", "thiry-first"};
        for (int i = 0; i < dayOfMonth.length; i++)
            if (day.equalsIgnoreCase(dayOfMonth[i])) {
                setDay(i+1);
                return;
            }
        System.err.println("Error in input syntax!");
    }

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month > 0 && month <= 12) {
			this.month = month;
		}else {
			System.err.println("Error in input month");
			return;
		}
	}
	
	public void setMonth(String month) {
        for (int i = 0; i < monthOfYear.length; i++) {
            if (month.equalsIgnoreCase(monthOfYear[i])) {
            	setMonth(i+1);
            	return;
            }
        }
        System.err.println("Error in input syntax!");
    }

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void setYear(String year) {
		this.year = convertWordToNumber(year);
	}

	// Constructor with current time
	public MyDate() {
		super();
		// Create Calendar object return current date
		Calendar calObj = Calendar.getInstance();
		// set day, month, year of current date
		setYear(calObj.get(Calendar.YEAR));
		setMonth(calObj.get(Calendar.MONTH) + 1);
		setDay(calObj.get(Calendar.DAY_OF_MONTH));
	}
	
	// Constructor with 3 parameter
	public MyDate(int day, int month, int year) {
		super();
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	// Constructor with date(string) -> convert to date
	public MyDate(String dateInString) {
		super();
		// Set a new format of date
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
		try {
			// Convert string to Date object
			Date date = formatter.parse(dateInString);
			Calendar calObj = Calendar.getInstance();
			calObj.setTime(date);
			setYear(calObj.get(Calendar.YEAR));
			setMonth(calObj.get(Calendar.MONTH) + 1);
			setDay(calObj.get(Calendar.DAY_OF_MONTH));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	// Constructor with 3 parameter String
	public MyDate(String day, String month, String year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	// static fixed value in every object when constructing
	public static String accept() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter date(example:'July 15 1999'): ");
		String dateInString = sc.nextLine();
		sc.close();
		return dateInString;
	}
	
	// Check Leap Year
	public static boolean checkLeapYear(int year) {
		if(year%4 == 0) {
			if(year%100 == 0 && year%400 != 0) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	// Print current date to the screen
	public void print() {
		if(day == 0 || month == 0 || year == 0) {
			System.out.println("Invalid Month/Day/Year");
		}else {
			int ngay = getDay();
			String strDay;
			if(ngay == 1) {
				strDay = Integer.toString(ngay) + "st";
			}else if(ngay == 2) {
				strDay = Integer.toString(ngay) + "nd";
			}else if(ngay == 3) {
				strDay = Integer.toString(ngay) + "rd";
			}else {
				strDay = Integer.toString(ngay) + "th";
			}
			System.out.printf("Month-Day-Year: %s %s %d %n", monthOfYear[getMonth() - 1], strDay, getYear());
		}
	}
	
	// Method convert year
	private int convertWordToNumber(String input) {
		int result = 0;
		
		// if input have "thousand" or "hundred" --> two thousand twenty
		if(input.lastIndexOf("thousand") != -1 || input.lastIndexOf("hundred") != -1) {
			result = convertWordToNumber1(input);
		}else {
			// else --> twenty twenty
			result = convertWordToNumber2(input);
		}
		
		return result;
	}
	
	// type 1
	private int convertWordToNumber1(String input) {
		boolean isValidInput = true;
	    int result = 0;
	    int finalResult = 0;
	    List<String> allowedStrings = Arrays.asList
	    (
	    "zero","one","two","three","four","five","six","seven",
	    "eight","nine","ten","eleven","twelve","thirteen","fourteen",
	    "fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
	    "thirty","forty","fifty","sixty","seventy","eighty","ninety",
	    "hundred","thousand"
	    );

	    if(input != null && input.length()> 0)
	    {
	        input = input.toLowerCase().replaceAll(" and", " ");
	        String[] splittedParts = input.trim().split("\\s+");

	        for(String str : splittedParts)
	        {
	            if(!allowedStrings.contains(str))
	            {
	                isValidInput = false;
	                System.out.println("Invalid word found : "+str);
	                break;
	            }
	        }
	        if(isValidInput)
	        {
	            for(String str : splittedParts)
	            {	
	                if(str.equalsIgnoreCase("zero")) {
	                    result += 0;
	                }
	                else if(str.equalsIgnoreCase("one")) {
	                    result += 1;
	                }
	                else if(str.equalsIgnoreCase("two")) {
	                    result += 2;
	                }
	                else if(str.equalsIgnoreCase("three")) {
	                    result += 3;
	                }
	                else if(str.equalsIgnoreCase("four")) {
	                    result += 4;
	                }
	                else if(str.equalsIgnoreCase("five")) {
	                    result += 5;
	                }
	                else if(str.equalsIgnoreCase("six")) {
	                    result += 6;
	                }
	                else if(str.equalsIgnoreCase("seven")) {
	                    result += 7;
	                }
	                else if(str.equalsIgnoreCase("eight")) {
	                    result += 8;
	                }
	                else if(str.equalsIgnoreCase("nine")) {
	                    result += 9;
	                }
	                else if(str.equalsIgnoreCase("ten")) {
	                    result += 10;
	                }
	                else if(str.equalsIgnoreCase("eleven")) {
	                    result += 11;
	                }
	                else if(str.equalsIgnoreCase("twelve")) {
	                    result += 12;
	                }
	                else if(str.equalsIgnoreCase("thirteen")) {
	                    result += 13;
	                }
	                else if(str.equalsIgnoreCase("fourteen")) {
	                    result += 14;
	                }
	                else if(str.equalsIgnoreCase("fifteen")) {
	                    result += 15;
	                }
	                else if(str.equalsIgnoreCase("sixteen")) {
	                    result += 16;
	                }
	                else if(str.equalsIgnoreCase("seventeen")) {
	                    result += 17;
	                }
	                else if(str.equalsIgnoreCase("eighteen")) {
	                    result += 18;
	                }
	                else if(str.equalsIgnoreCase("nineteen")) {
	                    result += 19;
	                }
	                else if(str.equalsIgnoreCase("twenty")) {
	                    result += 20;
	                }
	                else if(str.equalsIgnoreCase("thirty")) {
	                    result += 30;
	                }
	                else if(str.equalsIgnoreCase("forty")) {
	                    result += 40;
	                }
	                else if(str.equalsIgnoreCase("fifty")) {
	                    result += 50;
	                }
	                else if(str.equalsIgnoreCase("sixty")) {
	                    result += 60;
	                }
	                else if(str.equalsIgnoreCase("seventy")) {
	                    result += 70;
	                }
	                else if(str.equalsIgnoreCase("eighty")) {
	                    result += 80;
	                }
	                else if(str.equalsIgnoreCase("ninety")) {
	                    result += 90;
	                }
	                else if(str.equalsIgnoreCase("hundred")) {
	                    result *= 100;
	                }
	                else if(str.equalsIgnoreCase("thousand")) {
	                    result *= 1000;
	                    finalResult += result;
	                    result=0;
	                }
	            }

	            finalResult += result;
	            result=0;
	        }
	    }
	    return finalResult;
	}
	
	// type 2
	private int convertWordToNumber2(String input) {
//		boolean isValidInput = true;
//	    int result = 0;
	    int finalResult = 0;
//	    List<String> allowedStrings = Arrays.asList
//	    (
//	    "zero","one","two","three","four","five","six","seven",
//	    "eight","nine","ten","eleven","twelve","thirteen","fourteen",
//	    "fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
//	    "thirty","forty","fifty","sixty","seventy","eighty","ninety"
//	    );

	    if(input != null && input.length()> 0)
	    {
	        input = input.toLowerCase().replaceAll(" and", " ");
	        String[] splittedParts = input.trim().split("\\s+");
	        int arrLenght = splittedParts.length;
	        if (arrLenght == 1) {
				finalResult +=  (wordtonum(splittedParts[0]));
			} else if (arrLenght == 2) {
				String strNumb = "";
				for (int i = 0; i < arrLenght; i++) {
					strNumb += (wordtonum(splittedParts[i]));
				}
				finalResult = Integer.parseInt(strNumb);
			}else {
				String strNumb = "";
				for (int i = 0; i < arrLenght; i++) {
					if ((wordtonum(splittedParts[i]) > 19 && wordtonum(splittedParts[i])< 100) && wordtonum(splittedParts[i+1]) <10)  {
						int sum = wordtonum(splittedParts[i]) +  wordtonum(splittedParts[i+1]);
						i++;
						strNumb += sum;
					}
					else {
						strNumb += (wordtonum(splittedParts[i]));
					}
					finalResult = Integer.parseInt(strNumb);
				}
			}
	        
	    }
	    return finalResult;
	}
	
	public int wordtonum(String word) {
		String num = null;
		switch (word) {
		case "one":
			num = "1";
			break;
		case "two":
			num = "2";
			break;
		case "three":
			num = "3";
			break;
		case "four":
			num = "4";
			break;
		case "five":
			num = "5";
			break;
		case "six":
			num = "6";
			break;
		case "seven":
			num = "7";
			break;
		case "eight":
			num = "8";
			break;
		case "nine":
			num = "9";
			break;
		case "ten":
			num = "10";
			break;
		case "eleven":
			num = "11";
			break;
		case "twelve":
			num = "12";
			break;
		case "thirteen":
			num = "13";
			break;
		case "fourteen":
			num = "14";
			break;
		case "fifteen":
			num = "15";
			break;
		case "sixteen":
			num = "16";
			break;
		case "seventeen":
			num = "17";
			break;
		case "eighteen":
			num = "18";
			break;
		case "nineteen":
			num = "19";
			break;
		case "twenty":
			num = "20";
			break;
		case "thirty":
			num = "30";
			break;
		case "forty":
			num = "40";
			break;
		case "fifty":
			num = "50";
			break;
		case "sixty":
			num = "60";
			break;
		case "seventy":
			num = "70";
			break;
		case "eighty":
			num = "80";
			break;
		case "ninety":
			num = "90";
			break;
		case "hundred":
			num = "100";
			break;
		case "thousand":
			num = "1000";
			break;
		/*
		 * default: num = "Invalid month"; break;
		 */
		}
		int result = Integer.parseInt(num);
		return result;
	}
	
	
}
