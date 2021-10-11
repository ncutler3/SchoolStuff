package Question3;

import Question2.Wheel;

public class WeekDaysWheel extends Wheel<Integer> {

    private int minValue = 0;
    private int maxValue = 6;
    private boolean rolledOver;
    private int initialValue;
    String dayOfWeek;

    String[] daysOfWeek = {"Sat", "Sun", "Mon", "Tues", "Wed", "Thurs", "Fri"}; //list of string of weekdays, ordered for Z congruence

    public WeekDaysWheel(Wheel<Integer> initialYear, Wheel<Integer> initialMonth, Wheel<Integer> initialDay){ //constructor
        int numDayOfWeek;
        int dayOfMonth = initialDay.getValue();
        int monthNumber = initialMonth.getValue();
        int moddedYear = initialYear.getValue();

        // Required for Zeller's algorithm
        if (monthNumber < 3) {
            monthNumber += 12;
            moddedYear--;
        }

        double yearOfCentury = moddedYear % 100;
        double zeroBasedCentury = moddedYear / 100;

        numDayOfWeek = (int)(dayOfMonth + (int)((13*(monthNumber+1))/5) + yearOfCentury + (int)(yearOfCentury/4) + (int)(zeroBasedCentury/4) + 5*zeroBasedCentury) %7; //formula for calculating weekday

        dayOfWeek = daysOfWeek[(int)numDayOfWeek]; //convert to one of string names in list
        initialValue = (int)numDayOfWeek;
        setValue(initialValue); //sets initial value for kinda reset
    }

    public int getMin(){
        return minValue;
    } //getter
    public int getMax(){
        return maxValue;
    } //getter

    public void reset(){ //resets to min value if too large, to max if too small
        if(getValue() > getMax()) {
            setValue(getMin());
        }
        else if(getValue() < getMin()) {
            setValue(getMax());
        }
    }

    public void rollUp(){ //increases value, rolls if too large
        setValue(getValue() + 1);
        if(getValue() > getMax()){
            reset();
        }
    }
    public void rollDown(){ //decreases value, rolls if too small
        setValue(getValue() - 1);
        if(getValue() < getMin()){
            reset();
        }
    }

    public String getWeekDay(){
        return daysOfWeek[getValue()];
    }//getter

    public void kindaReset(){
        setValue(initialValue);
    }//resets to initial value

    public Boolean isRolledOver(){
        return getValue() == getMin();
    }//checks if last step rolled over
}
