package Question3;

import Question2.Wheel;

public class MonthWheel extends Wheel<Integer> {

    private int minValue = 1;
    private int maxValue = 12;
    private boolean hasRolledOver;
    private int initialValue;

    private int[] monthListDays = {31,0,31,30,31,30,31,31,30,31,30,31}; //0 is a placeholder cuz calced at runtime
    private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Sep", "Oct", "Nov", "Dec"};

    public MonthWheel(int initial){
        this.setValue(initial);
        initialValue = initial;
    }

    public int getMin(){
        return minValue;
    }
    public int getMax(){
        return maxValue;
    }

    public String getMonth(){
        return months[getValue()-1];
    }//returns month value, is -1 cuz indexes

    public void rollUp(){ //increases value, rolls if too large
        hasRolledOver = false;
        setValue(getValue() + 1);
        if(getValue() > getMax()){
            hasRolledOver = true;
            reset();
        }
    }
    public void rollDown(){//decreases value, rolls if too small
        hasRolledOver = false;
        setValue(getValue() - 1);
        if(getValue() < getMin()){
            hasRolledOver = true;
            reset();
        }
    }

    public void reset(){ //resets to small if too large, to large if too small
        if((int)getValue() > getMax()) {
            setValue(getMin());
        }
        else if((int)getValue() < getMin()) {
            setValue(getMax());
        }
    }

    public void kindaReset(){
        setValue(initialValue);
    } //resets to initial values

    public Boolean isRolledOver(){
        return getValue() == getMin();
    } //checks if last step rolled
}
