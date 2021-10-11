package Question2;

import Question1.CounterDisplay;
import java.util.Random;

public class IntegerWheelCounter implements CounterDisplay {
    private IntegerWheel[] integerWheels = new IntegerWheel[3];
    private int noOfWheels = 3;

    public IntegerWheelCounter(IntegerWheel wheelThree, IntegerWheel wheelTwo, IntegerWheel wheelOne){
        integerWheels[0] = wheelOne; //creates wheel
        integerWheels[1] = wheelTwo;//creates wheel
        integerWheels[2] = wheelThree;//creates wheel
        if(wheelThree == null){
            this.noOfWheels--;
        }
        if(wheelTwo == null){
            this.noOfWheels--;
        }
        if(wheelOne == null){
            this.noOfWheels--;
        }
    }

    @Override
    public void reset(){ //resets wheels to their min values
        for(int c=0; c<integerWheels.length;c++){
            integerWheels[c].setValue(integerWheels[c].getMin());
        }
    }
    @Override
    public void shuffle(){ //randomizes the wheels values
        Random rand = new Random();
        for(int c=0; c<integerWheels.length;c++){
            integerWheels[c].setValue(rand.nextInt(integerWheels[c].getMax() - integerWheels[c].getMin()) + integerWheels[c].getMin());
        }
    }
    @Override
    public void increase() { //increases the wheels, rolls over to next wheel if max is exceeded
        integerWheels[0].rollUp();
        if (integerWheels[0].isRolledOver()) {
            integerWheels[1].rollUp();
            if (integerWheels[1].isRolledOver()) {
                integerWheels[2].rollUp();
                if (integerWheels[2].isRolledOver()) {
                    integerWheels[0].rollUp();
                }
            }
        }
    }
    @Override
    public void decrease(){//decreases the wheels, rolls over to next wheel if value is less than min
        integerWheels[0].rollDown();
        if (integerWheels[0].isRolledOver()) {
            integerWheels[1].rollDown();
            if (integerWheels[1].isRolledOver()) {
                integerWheels[2].rollDown();
                if (integerWheels[2].isRolledOver()) {
                    integerWheels[0].rollDown();
                }
            }
        }
    }
    @Override
    public String toString(){ //formats the string to be what the lab describes
        String formattedOne = String.format("%02d", integerWheels[0].getValue());
        String formattedTwo = String.format("%02d", integerWheels[1].getValue());
        String formattedThree = String.format("%02d", integerWheels[2].getValue());
        return formattedThree + ":" +  formattedTwo + ":" + formattedOne;
    }
}
