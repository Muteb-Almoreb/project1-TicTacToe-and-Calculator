import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    //array list
    ArrayList<Double> history = new ArrayList<>();

        //double variable to take last result
        double lastResult = 0;


    while (true) {
        //methode to print the menu
        printMenu();

        int choice;
        try {
            //take choice from the user
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

        }catch (InputMismatchException e) {
            System.out.println("Please enter a valid number!");
            input.nextLine();
            continue;
        }

        if (choice == 0) {
            System.out.println("Exit from calculator. Goodbye!");
            break;
        }
        //If user want to calculate take tow number
        if (choice >= 1 && choice <= 8) {

            double num1 = getNumber(input, "Enter first number: ");
            double num2 = getNumber(input, "Enter second number: ");


            switch (choice) {
                case 1:
                    lastResult = add(num1, num2);
                    break;
                case 2:
                    lastResult = subtract(num1, num2);
                    break;
                case 3:
                    lastResult = multiply(num1, num2);
                    break;
                    //if divide by 0 return to the menu
                case 4:
                    if (num2 == 0) {
                        System.out.println("Cannot divide by zero.");
                        continue;
                    }
                    lastResult = divide(num1, num2);
                    break;
                case 5:
                    lastResult = modulus(num1, num2);
                    break;
                case 6:
                    lastResult = min(num1, num2);
                    break;
                case 7:
                    lastResult = max(num1, num2);
                    break;
                case 8:
                    lastResult = average(num1, num2);
                    break;
                default:
                    System.out.println("Invalid option!");
                    continue;
            }


            history.add(lastResult);
            System.out.println("Result = " + lastResult);

        } else if (choice == 9) {
            if (history.isEmpty()) {
                System.out.println("No results available.");
            } else {
                System.out.println("Last result: " + history.get(history.size() - 1));
            }

        } else if (choice == 10) {
            if (history.isEmpty()) {
                System.out.println("No results in history.");
            } else {
                System.out.println("All results:");
                for (int i = 0; i < history.size(); i++) {
                    System.out.println((i + 1) + ") " + history.get(i));
                }
            }

        } else {
            System.out.println("Invalid option. Please try again.");
        }
    }







        }


    private static double getNumber(Scanner input, String message) {
        //methode to take number 1 and 2 from user

        while (true) {
            try {
                System.out.print(message);
                return input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // clear buffer
            }
        }
    }

    private static void printMenu() {
        //methode to print the menu

        System.out.println("\n======== Calculator Menu ========");

        System.out.println("1) Addition");

        System.out.println("2) Subtraction");

        System.out.println("3) Multiplication");

        System.out.println("4) Division");

        System.out.println("5) Modulus");

        System.out.println("6) Minimum");

        System.out.println("7) Maximum");

        System.out.println("8) Average");

        System.out.println("9) Show last result");

        System.out.println("10) Show all results");

        System.out.println("0) Exit");

        System.out.println("=================================");
    }

    private static double add(double x, double y)
            //methode to add
    {
        return x + y;
    }
    private static double subtract(double x, double y)
            //methode to subtract
    {
        return x - y;
    }
    private static double multiply(double x, double y) {
        //methode to multiply
        return x * y;
    }
    private static double divide(double x, double y) {
        //methode to divide
        return x / y;
    }
    private static double modulus(double x, double y)  {
        //methode to find modulus
        return x % y;
    }
    private static double min(double x, double y) {
        //methode to find the min
        return Math.min(x, y);
    }
    private static double max(double x, double y){
        //methode to find the max
        return Math.max(x, y);
    }
    private static double average(double x, double y){
        //methode to find th average
        return (x + y) / 2.0;
    }
}




