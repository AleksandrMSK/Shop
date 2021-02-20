package servis;
import java.util.Date;

public class Greeting {
        public static void getGreeting(){
            Date date = new Date();
            if (date.getHours() < 13) System.out.print("Good morning ");
            if (date.getHours() >= 13 && date.getHours() <= 17) System.out.print("Good day ");
            if (date.getHours() > 17) System.out.print("Good evening ");
    }
}
