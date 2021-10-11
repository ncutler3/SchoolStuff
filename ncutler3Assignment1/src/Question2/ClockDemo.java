package Question2;

import java.util.Timer;
import java.util.TimerTask;

public class ClockDemo extends TimerTask {
    static IntegerWheel seconds = new IntegerWheel(0, 59); //creates new wheel
    static IntegerWheel minutes = new IntegerWheel(0, 59);//creates new wheel
    static IntegerWheel hours = new IntegerWheel(0, 23);//creates new wheel
    static IntegerWheelCounter theClock = new IntegerWheelCounter(hours, minutes, seconds);

    public void run() {
        System.out.print("\r" + theClock);
        theClock.increase(); //increase
    }

    public static void main(String[] args)
    {
        System.out.println("Wheels based clock");
        System.out.println("==================");
        System.out.println("HH:MM:SS");
        // Starts at any random time
        theClock.shuffle();
        Timer timer = new Timer();
        timer.schedule(new ClockDemo(), 0, 1000);
    }
}
