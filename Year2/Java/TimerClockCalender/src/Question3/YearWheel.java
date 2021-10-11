package Question3;

import Question2.Wheel;

public class YearWheel extends Wheel<Integer> {

    private int minValue;
    private int maxValue;
    private int initialValue;

    public YearWheel(int initial){ //constructor
        this.setValue(initial);
        initialValue = initial;
    }

    public void rollUp(){
        setValue(getValue() + 1);
    }//increases value
    public void rollDown(){
        setValue(getValue() - 1);
    }//decreases value

    public void kindaReset(){
        setValue(initialValue);
    } //resets to initial value

    @Override
    public void reset() { //reset to min, if there was a min?
    }

    @Override
    public Boolean isRolledOver() {
        return null;
    } //checks if rolled over, idk if a year can roll over
}