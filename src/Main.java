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

            String choice = scanner.nextLine();

            if (choice.equals("3")) {
                System.out.println("Programmet avslutas.");
                break;


            }

            System.out.print("Skriv in den texten du vill översätta: ");
            String input = scanner.nextLine();
            try {
                if (choice.equals("1")) {
                    System.out.println("Morsekod: " + Logic.toMorse(input));
                } else if (choice.equals("2")) {
                    System.out.println("Engelsk text: " + Logic.toEnglish(input));
                } else {
                    System.out.println("Ogiltigt val, försök igen.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Fel: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
