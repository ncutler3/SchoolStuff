package Question3;

import Question1.CounterDisplay;
import Question2.Wheel;

public class CalendarCounter implements CounterDisplay {

    private YearWheel yearWheel;
    private MonthWheel monthWheel;
    private DayWheel dayWheel;
    private WeekDaysWheel weekDaysWheel;

    CalendarCounter(int initialMonth, int initialDay, int initialYear){
        yearWheel = new YearWheel(initialYear);
        monthWheel = new MonthWheel(initialMonth);
        dayWheel = new DayWheel(initialDay);
        dayWheel.setMonth(initialMonth);
        dayWheel.setYear(initialYear);
        weekDaysWheel = new WeekDaysWheel(yearWheel, monthWheel, dayWheel);
    }
    @Override
    public void reset(){
        yearWheel.kindaReset();
        monthWheel.kindaReset();
        dayWheel.kindaReset();
        dayWheel.setMonth(monthWheel.getValue());
        dayWheel.setYear(yearWheel.getValue());
        weekDaysWheel.kindaReset();
    }
    @Override
    public void shuffle(){

    }
    @Override
    public void increase(){ //increases wheel, rolls over if value is greater than max
        dayWheel.rollUp();
        weekDaysWheel.rollUp();
        if(dayWheel.isRolledOver()) {
            monthWheel.rollUp();
            if(monthWheel.isRolledOver()){
                yearWheel.rollUp();
            }
        }
    }
    @Override
    public void decrease(){ //decreases wheel, rolls over if value is less than min
        dayWheel.rollDown();
        weekDaysWheel.rollDown();
        if(dayWheel.isRolledOver()) {
            monthWheel.rollDown();
            if(monthWheel.isRolledOver()){
                yearWheel.rollDown();
            }
        }
    }

    @Override
    public String toString(){ //formats string to what lab describes
        return weekDaysWheel.getWeekDay() + " " + dayWheel.getValue() + " " + monthWheel.getMonth() + ", " + yearWheel.getValue();
    }
}
