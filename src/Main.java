import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hejsan och välkommen till Morse-kod översättaren!");

        while (true) {

            System.out.println("Välj ett av Tre alternativ");
            System.out.println("1. Översätt Engelska till Morsekod");
            System.out.println("2. Översätt Morsekod till engelska");
            System.out.println("3. Avsluta översättaren");

            System.out.print("Vad är ditt val?");

            //Lägger in en felhantering som kontrollerar att man endast kan använda valen 1,2 och 3
            String choice;
            while (true) {
                choice = scanner.nextLine().trim();
                if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
                    break;
                }
                System.out.println("Ogiltigt val, försök igen genom att välja 1, 2 eller 3.");
                System.out.print("Vad är ditt val? ");
            }

            if (choice.equals("3")) {
                System.out.println("Programmet avslutas.");
                break;

            }

            System.out.print("Skriv in den texten du vill översätta: ");
            String input = scanner.nextLine();
            try {
                if (choice.equals("1")) {
                    System.out.println("Morsekod: " + Logic.toMorse(input));
                } else {
                    System.out.println("Engelsk text: " + Logic.toEnglish(input));
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Fel: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
