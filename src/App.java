import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu.exibirMenu(scanner);
        scanner.close();
    }
}