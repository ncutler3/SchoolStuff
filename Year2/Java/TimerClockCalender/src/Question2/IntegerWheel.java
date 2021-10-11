package Question2;

import Question1.Rollable;

public class IntegerWheel extends Wheel<Integer> implements Rollable {
    private int minValue; //declares min value;
    private int maxValue; //declares max value;

    public IntegerWheel(int max){ //constructor with one parameter
        minValue = 0;
        maxValue = max;
        this.setValue(getMax());
    }
    public IntegerWheel(int min, int max){ //constructor with two parameters
        minValue = min;
        maxValue = max;
        this.setValue(getMin());
    }

    public int getMin(){
        return minValue;
    } //getter
    public int getMax(){
        return maxValue;
    } //getter

    public void rollUp(){ //increases wheel #
        setValue((int)getValue() + 1);
        if((int)getValue() > getMax()){
            reset();
        }
    }
    public void rollDown(){ //decreases wheel #
        setValue((int)getValue() - 1);
        if((int)getValue() < getMin()){
            reset();
        }
    }

    @Override
    public void reset(){ //resets to min or max depending on decreasing or increasing
        if((int)getValue() > getMax()) {
            setValue(getMin());
        }
        else if((int)getValue() < getMin()) {
            setValue(getMax());
        }
    }
    @Override
    public Boolean isRolledOver(){ //checks if last step is rolled over? even tho we have no variable to record the previous state?
        return getValue() == getMin();
    }
}