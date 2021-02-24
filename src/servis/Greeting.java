package servis;

import java.time.LocalDateTime;

/**
 * Класс приветствие
 * в зависимости от времени суток приветствует в соответствующей форме
 *
 * @author Aleksandr Moskalchuk
 * @version 1.0
 */
public class Greeting {
    public static void getGreeting() {
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        if (hour < 13) System.out.print("Доброе утро ");
        if (hour >= 13 && hour <= 17) System.out.print("Добрый день ");
        if (hour > 17) System.out.print("Добрый вечер ");
    }
}
