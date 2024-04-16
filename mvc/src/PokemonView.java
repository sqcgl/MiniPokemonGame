import java.util.List;
import java.util.Scanner;

public class PokemonView implements IView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayStarters(List<Pokemon> starters) {
        System.out.println("Choose your starter Pokemon: ");
        for(int i = 0; i < starters.size(); i++) {
            Pokemon p = starters.get(i);
            System.out.println(i + ". " + p.getName());
        }
    }

    @Override
    public int promptForStarterChoice() {
        System.out.println("Enter the number of your choice");
        while (!scanner.hasNextInt()) {
            scanner.next(); // Consume non-integer input to avoid infinite loop
            System.out.println("That's not a number! Please enter a valid number:");
        }
        return scanner.nextInt();
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayInvalid() {
        System.out.println("Invalid choice, please pick again!");
    }
}