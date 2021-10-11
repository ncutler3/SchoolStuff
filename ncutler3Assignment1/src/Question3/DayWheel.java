package Question3;

import Question2.Wheel;

public class DayWheel extends Wheel<Integer> {

    private int minValue  = 1;
    private boolean hasRolledOver;
    private int initialValue;
    private int month;
    private int year;

    private int[] monthListDays = {31,0,31,30,31,30,31,31,30,31,30,31}; //days for months

    public DayWheel(int initial){ //constructor
        this.setValue(initial);
        initialValue = initial;
    }

    public int getMin(){ //getter
        return minValue;
    }
    public int getMax(){ //getter
        return daysInMonth(month, year);
    }

    public void setMonth(int month){ //setter
        this.month = month;
    }
    public void setYear(int year){ //settter
        this.year = year;
    }

    public void rollUp(){ //increases value, rolls over if max is exceeded
        hasRolledOver = false;
        setValue(getValue() + 1);
        if(getValue() > getMax()){
            reset();
            month++;
            if(month == 12){
                year++;
                month = 0;
            }
            hasRolledOver = true;

        }
    }
    public void rollDown(){ //decreases value, rolls over if value < min
        hasRolledOver = false;
        setValue(getValue() - 1);
        if(getValue() < getMin()){
            month--;
            if(month == -1){
                year--;
                month = 11;
            }
            hasRolledOver = true;
            reset();
        }
    }

    public void reset(){ // resets to min values if increasing, to max if decreasing
        if(getValue() > getMax()) {
            setValue(getMin());
        }
        else if(getValue() < getMin()) {
            setValue(getMax());
        }
    }

    public void kindaReset(){ //resets to initial values, hence "kinda" reset
        setValue(initialValue);
    }

    public Boolean isRolledOver(){ //checks if last step rolled over
        return hasRolledOver;
    }

    public int daysInMonth(int month, int year){ //calcs how many days in a month based on year and month
        if(month == 2){
            if(isLeapYear(year))
                return 29;
            return 28;
        }
        return monthListDays[month-1];
    }

    public boolean isLeapYear(int year){ //checks if leap year
        if (year % 4 != 0)
            return false;
        else if (year % 400 == 0)
            return true;
        else if (year % 100 == 0)
            return false;
        return true;
    }
}
