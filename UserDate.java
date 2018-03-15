public class UserDate {
    private int month;
    private int day;
    private int year;

    UserDate(int month, int day, int year) throws IllegalArgumentException{
        this.month = month;
        this.day = day;
        this.year = year;
        isValid();
    }
 
    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }
 
    public int getYear(){
        return year;
    }
    
    public boolean isValid() throws IllegalArgumentException{
        boolean validDate = false;
        if (month<1 || month>12){
            throw new IllegalArgumentException("Month incorrect! Should be between 1 and 12");
        }
        if (year<1900 || year>2017){
            throw new IllegalArgumentException("Year incorrect! Should be between 1900 and 2017");
        }

        //31 Day Months
        if ((day >= 1 && day <= 31) && (year >= 1900 && year <= 2017) && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12))
        {
            validDate = true;
        }
        //30 Day months
        else if ((day >= 1 && day <= 30) && (year >= 1900 && year <= 2017) && (month == 4 || month == 6 || month == 9 || month == 11))
        {
            validDate = true;
        }
        //February
        else if (month == 2 && (year >= 1900 && year <= 2017))
        {
            //leap year
            if (year % 4 == 0)
            {
                if (year % 100 == 0)
                {
                    if (year % 400 == 0)
                    {
                        if (day >= 1 && day <= 29)
                        {
                            validDate = true;
                        }
                    }
                    }
                else
                {
                    if (day >= 1 && day <= 29)
                    {
                        validDate = true;
                    }
                }
            }
            //non leap year
            if (day >= 1 && day <= 28)
            {
                validDate = true;
            }
        }
        if (validDate == false){
            throw new IllegalArgumentException("Day incorrect! Should be greated than 1 and less than 28, 29, 30, or 31 depending on the month");
        }
        return validDate;
    }

    public String findDay() {
        int d = day;
        int m = month;
        int y = year;
        
       
        if (month == 1 || month == 2) {
            m += 12;
            y--;
        }

        //zeller's algorithm (found online)
        int h = (d + (int)((26 * (m + 1)) / 10.0) + y + (int)(y / 4.0) +
                6 * (int)(y / 100.0) + (int)(y / 400.0)) % 7;
 
        //return result in string format
        if (h == 0) 
            return "Saturday";
        else if (h == 1)
            return "Sunday";
        else if (h == 2)
            return "Monday";
        else if (h == 3)
            return "Tuesday";
        else if (h == 4)
            return "Wednesday";
        else if (h == 5)
            return "Thursday";
        else
            return "Friday";
    }
}
