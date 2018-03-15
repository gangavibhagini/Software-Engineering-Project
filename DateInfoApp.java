import java.util.Scanner;
public class DateInfoApp 
{

    public static void main(String[] args) 
    {
        System.out.println("I will tell you the day of the week you were born. ");
        System.out.println("Please enter a valid DOB and follow instructions. ");
        Scanner keyboard = new Scanner(System.in);
        String input;
        boolean validInput = false;
        UserDate date;
        int incorrect = 0;
        int day = 0;
        int month = 0;
        int year = 0;
        boolean exit = false;
        while(!exit)
        {
            validInput = false;
            while (!validInput) 
            {
                try
                {
                    System.out.println("Enter your birth month as a number between 1 and 12:");
                    input = keyboard.nextLine();
                    month = Integer.parseInt(input);

                    System.out.println("Enter your birth day as a valid calender day number of your month:");
                    input = keyboard.nextLine();
                    day = Integer.parseInt(input);
                
                    System.out.println("Enter your birth year as a number from 1900 to 2017:");
                    input = keyboard.nextLine();
                    year = Integer.parseInt(input);
                    validInput = true;
                }
            
                catch (NumberFormatException e)
                {
                    System.out.println("Enter Integers for the Dates");
                    System.out.println("NumberFormatExcept : " + e.getMessage());
                }
            }
        
               try 
               {
                    date = new UserDate(month, day, year);
                    System.out.println("\n##### RESULTS #####\n");
                    System.out.println("You were born on a " + date.findDay());
                    if (validInput != false){
                    	incorrect = 0;
                    }
                } 
            
                catch (IllegalArgumentException e) 
                {
                	incorrect++;
                    System.out.println(e.getMessage());
                    if (incorrect == 3){
                 	   System.out.println("GoodBye!, You have reached the max number of consecutive invalid inputs."
                 	   		+ " Please try again later!");
                        keyboard.close();
                 	   exit = true;
                    }
                }
               
        if      ((month == 12 && day >= 22 && day <= 31) || (month ==  1 && day >= 1 && day <= 19))
            System.out.println(" Your zodiac sign is Capricorn");
        else if ((month ==  1 && day >= 20 && day <= 31) || (month ==  2 && day >= 1 && day <= 17))
            System.out.println("Your zodiac sign is Aquarius");
        else if ((month ==  2 && day >= 18 && day <= 29) || (month ==  3 && day >= 1 && day <= 19))
            System.out.println("Your zodiac sign is Pisces");
        else if ((month ==  3 && day >= 20 && day <= 31) || (month ==  4 && day >= 1 && day <= 19))
            System.out.println("Your zodiac sign is Aries");
        else if ((month ==  4 && day >= 20 && day <= 30) || (month ==  5 && day >= 1 && day <= 20))
            System.out.println("Your zodiac sign is Taurus");
        else if ((month ==  5 && day >= 21 && day <= 31) || (month ==  6 && day >= 1 && day <= 20))
            System.out.println("Your zodiac sign is Gemini");
        else if ((month ==  6 && day >= 21 && day <= 30) || (month ==  7 && day >= 1 && day <= 22))
            System.out.println("Your zodiac sign is Cancer");
        else if ((month ==  7 && day >= 23 && day <= 31) || (month ==  8 && day >= 1 && day <= 22))
            System.out.println("Your zodiac sign is Leo");
        else if ((month ==  8 && day >= 23 && day <= 31) || (month ==  9 && day >= 1 && day <= 22))
            System.out.println("Your zodiac sign is Virgo");
        else if ((month ==  9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22))
            System.out.println("Your zodiac sign is Libra");
        else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21))
            System.out.println("Your zodiac sign is Scorpio");
        else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21))
            System.out.println("Your zodiac sign is Sagittarius");
        else
            System.out.println("Illegal date"); 
            
                System.out.println("Do you want to enter antoher date? Y/N");
                input = keyboard.nextLine().toUpperCase();
                if (input.equals("N"))
                {
                    exit = true;
                }
          
        }
           System.out.println("GoodBye!");
           keyboard.close();
        }
}