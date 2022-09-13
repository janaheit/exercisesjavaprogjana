import java.util.Scanner;

public class Welcome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a language code: ");
        String languageCode = scanner.nextLine();

        switch (languageCode){
            case "NL":
                System.out.println("Goeiedag!");
                break;
            case "FR":
                System.out.println("Bonjour!");
                break;
            case "EN":
                System.out.println("Good Day!");
                break;
            default:
                System.out.println("Goeiedag, bonjour and good day!");
                break;
        }
    }
}


