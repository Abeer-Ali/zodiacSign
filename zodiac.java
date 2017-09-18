import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.Scanner;
//import java.util.Random;

public class zodiac{
  static int mm;
  static int dd;
  static int yyyy;
  
    public static void main(String[] args) {

        String exampledates[] ={"02-23-2017","2/24/17","2-25-17","02/26/2017","02272017","02-28-2017","02/29/2017","03/01-2017","03/2/2017","3/03-17","3-4-17","02/30/2017","02/31/2017","04/31/2017","06/31/2017","09/31/2017","11/31/2017","##/04/2015","26/##/1999","15/07/####"};
        String exampledays[] ={"ferr","ferr","ferr","Sunday","ferr","ferr","err1","ferr","ferr","ferr","ferr","ferr","ferr","ferr","err2","err2","err2","err2","err2","err2",};
        int num=0;
        Scanner userInput = new Scanner(System.in);
        String[] res2= new String[3];
        int counter =0;
        while(counter<=3){
        if(counter==3){
            System.err.println("YOU HAVE EXCEEDED THE MAXIMUM NUMBER OF ATTEMPTS");
            break;
        //return 1;
        }else{
  System.out.println("--------------------------------------");
        System.out.println("Please enter your date of birth in the correct format mm/dd/yyyy: ");
        String input = userInput.nextLine();

        String res=weekdayTest(input);
       // System.out.println(res);
        if(res.equals("ferr")){
        System.err.println("FORMAT ERROR: ENTER THE DATE IN THE CORRECT FORMAT MM/DD/YYY");
        res2[counter]=res;
        counter++;
        
        }else if(res.equals("err1")){
        System.err.println("LEAP YEAR ERROR: THE YEAR YOU HAVE ENTERED IS NOT A LEAP YEAR");
        res2[counter]=res;
        counter++;
        
        }else if(res.equals("err2")){
        System.err.println("DAYS IN MONTH ERROR: THE DAY YOU HAVE ENTERED IS INCORRECT/INVALID FOR THE MONTH");
        res2[counter]=res;
        counter++;
        
        }else{
        System.out.println("You were born on a " + res + ".");
       
        System.out.print("Your zodiac sign is " );
                getZodiac(mm,dd);
                 System.out.println("--------------------------------------");
        }}}
        // num++;
        
    //return 0;
    }
   public static void runTest(String a,String b){
    if(a.equals(b)){
    System.out.println("Test Successful");
    }else{
    System.out.println("Test Failed");
    }
    }
    public static String weekdayTest(String a){
    String input=a;
    String m,d,y;
    String day="";
    //try{
    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
    Date d1 = null;
    try{
      d1 = format.parse(input);
   }  

  /*  catch (ParseException e){
           System.out.println("Parse Exception");
           return "Try Again";
       }
    
    catch (IllegalArgumentException e) {
     System.out.println("Illegal Exception");
     return "Try Again";
    }*/
    catch(Exception e){
          //System.out.println("Exception");
          //return "ferr";
          
    }
    
    /*if(input.contains("-")|| !input.contains("/")|| input.length()< 10||){
    return "ferr";
    }*/
    try{
     m= input.substring(0,2);
     d= input.substring(3,5);
     y= input.substring(6,10);
     mm=Integer.parseInt(input.substring(0,2));
     dd=Integer.parseInt(input.substring(3,5));
     yyyy=Integer.parseInt(input.substring(6,10));
	 
	if(input.length()>10)
	{
		return "ferr";
	}
    }
    catch(Exception e){
        
        //e.printStackTrace();
        return "ferr";
    }
     
     if(mm>12){
    return "ferr";
    }

    if(mm==4 || mm==6 || mm==9 || mm==11){
		if(dd>30){
			return "err2";
		}
    }
	else{
		if(dd>31){
		return "err2";
		}
	}
    
	
	if(mm==2&&dd>29){
    return "err2";
    }
    if(dd==29 && !((yyyy%4)==0)){
    return "err1";
    }
   
 input=input.substring(0,2)+input.substring(3, 5)+input.substring(6,10);
   //Date d1 = format.parse(input);

    String x=format.format(new Date());
    DateFormat f2= new SimpleDateFormat("EEEE");
    day= f2.format(d1);
    return day;
        }

    public static void getZodiac(int month, int day){
    	
    	if(((month == 3) && (day > 21)) || ((month == 4) && (day < 20))) {
            System.out.println("Aries.");
        }
        else if(((month == 4) && (day > 21)) || ((month == 5) && (day < 20))) {
            System.out.println("Taurus.");
        }
        else if(((month == 5) && (day > 21)) || ((month == 7) && (day < 22))){
            System.out.println("Cancer.");
        }
        else if(((month == 7) && (day > 23)) || ((month == 8) && (day < 22))) {
            System.out.println("Leo.");
        }
        else if((month == 8) && (day > 23) || (month == 9) && (day < 22)) {
            System.out.println("Virgo.");
        }
        else if((month == 9) && (day > 23) || (month == 10) && (day < 22)) {
            System.out.println("Libra.");
        }
        else if((month == 10) && (day > 23) || (month == 11) && (day < 22)) {
            System.out.println("Scorpio.");
        }
        else if((month == 11) && (day > 23) || (month == 12) && (day < 21)) {
            System.out.println("Sagittarius.");
        }
        else if((month == 12) && (day > 22) || (month == 1) && (day < 19)) {
            System.out.println("Capricorn.");
        }
        else if((month == 1) && (day > 20) || (month == 2) && (day < 19)) {
            System.out.println("Aquarius.");
        }
        else if((month == 2) && (day > 20) || (month == 3) && (day < 20)) {
            System.out.println("Pisces.");
        }
        else{            
            System.out.println("Please check the day and month again");
        }
        }
    public static int getDay(){
    return dd;
    }
    public static int getMonth(){
    return mm;
    }
    public static int getYear(){
    return yyyy;
    }
}
