import servis.FileManager;

/**
 * Главный класс
 * - при запуске читает файлы из БД
 * - вызывае стартовое меню программы
 *
 * @author Aleksandr Moskalchuk
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        FileManager.initialization();
        StartMenu.startProgram();
    }
}

