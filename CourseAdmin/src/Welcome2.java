import java.util.Scanner;

public class Welcome2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String answer;
        do {
            System.out.println("Welcome!");
            System.out.println("Would you like to be greeted again? (Y/N)");
            answer = scanner.next();

            if (answer.equals("Y")){
                continue;
            } else if (answer.equals("N")){
                break;
            }

        } while(answer.equals("Y"));



    }
}
