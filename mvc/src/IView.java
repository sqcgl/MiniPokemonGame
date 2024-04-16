import java.util.List;

public interface IView {
    // Method to display the list of starter Pokemon to the user
    void displayStarters(List<Pokemon> starters);

    // Method to prompt the user to choose a starter Pokemon
    int promptForStarterChoice();

    // Method to display a generic message
    void displayMessage(String message);

    // Method to notify the user of an invalid choice
    void displayInvalid();
}