package Question2;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo extends TimerTask {
    static IntegerWheel seconds = new IntegerWheel(20); //creates wheel
    static IntegerWheel minutes = new IntegerWheel(0);//creates wheel
    static IntegerWheel hours = new IntegerWheel(0);//creates wheel
    static IntegerWheelCounter theTimer = new IntegerWheelCounter(hours, minutes, seconds);
    static Timer timer = new Timer(); //creates timer

    public void run() {
        System.out.print("\r" + theTimer);
         if (theTimer.toString().equals("00:00:00") ) { //if string is equal to this stop the timer
             {
                 timer.cancel();
                 timer.purge();
                 return;
             }
         }
        theTimer.decrease();
    }

    public static void main(String[] args) {
        System.out.println("Wheels based timer");
        System.out.println("==================");
        timer.schedule(new TimerDemo(), 0, 1000);
    }
}