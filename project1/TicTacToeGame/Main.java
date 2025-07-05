import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // create empty 2d array
        char[][] bord = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        try {
            //print to the user he want play one or three round
            System.out.println("Enter [ 1 ] to play one round or Enter [ 2 ] to play 3 rounds ");
            int numSh = input.nextInt();
            input.nextLine();

            if (numSh == 1) {
                //to print the board
                printBord(bord);
                //while loop to call the methods and play the game
                while (true) {
                    userTurn(input, bord);
                    //if game finished break the loop
                    if (isGameFinished(bord)) {
                        break;

                    }
                    printBord(bord);
                    computerTurn(bord);
                    //if game finished break the loop
                    if (isGameFinished(bord)) {
                        break;

                    }
                    printBord(bord);
                }
                //if user chose play three round
            } else if (numSh == 2) {
                //to calculate user wins and computer wins
                int userWin = 0;
                int ComputerWin = 0;
                //for loop to calculate 3 round
                for (int i = 1; i <= 3; i++) {

                    //print the board and while loop to call the methods and play the game
                    printBord(bord);
                    while (true) {
                        userTurn(input, bord);
                        if (isGameFinished(bord)) {
                            break;

                        }
                        printBord(bord);
                        computerTurn(bord);
                        if (isGameFinished(bord)) {
                            break;

                        }
                        printBord(bord);
                    }
                    if (whoIsWon(bord, 'X')) {
                        userWin++;

                    } else if (whoIsWon(bord, 'O')) {
                        ComputerWin++;

                    }
                    bord = new char[][]{{' ', ' ', ' '},
                            {' ', ' ', ' '},
                            {' ', ' ', ' '}};
                }
                //display user wins and computer wins
                System.out.println("User Wins: " + userWin);
                System.out.println("Computer Wins: " + ComputerWin);

                // if statement to know who is the winner
                if (userWin > ComputerWin) {
                    System.out.println("You are the WINNER!");
                } else if (ComputerWin > userWin) {
                    System.out.println("Computer WINS !");
                } else {
                    System.out.println("It's a TIE!");
                }

            } else {
                throw new NumberFormatException(" Please enter only 1 or 2 ");

            }

        }catch (InputMismatchException e)
        {
            System.out.println("Please chose Correct Number");

        }
    }
    public static void computerTurn(char[][] bord) {
        //method to the computer Turn

        System.out.println("Computer Turn");
        Random random = new Random();
        int computerPlay;
        while (true) {
            //computer chose random Integer
            computerPlay = random.nextInt(9) + 1;
            //check the position available or not
            if (isValidMove(bord, computerPlay))
                break;
        }
        //print what computer chose
        System.out.println("Computer Chose "+ computerPlay);
        //Choose a location and write O
        placeMove(bord,Integer.toString(computerPlay),'O');
    }

    public static boolean isValidMove(char[][] board, int position) {
        //methode to check is the position is empty or not
        switch (position) {

            case 1:
                return board[0][0] == ' ';
            case 2:
                return board[0][1] == ' ';
            case 3:
                return board[0][2] == ' ';
            case 4:
                return board[1][0] == ' ';
            case 5:
                return board[1][1] == ' ';
            case 6:
                return board[1][2] == ' ';
            case 7:
                return board[2][0] == ' ';
            case 8:
                return board[2][1] == ' ';
            case 9:
                return board[2][2] == ' ';
            default:
                return true;

        }
    }

        public static void placeMove(char [][] board , String position , char ch){

        // methode to write letters in place of the position
           switch (position)
        {

            case "1" :
            {
                board[0][0]=ch;

                break;

            }
            case "2" :
            {
               board[0][1]=ch;
               break;

            }
            case "3" :
            {
                board[0][2]=ch;
                break;

            }
            case "4" :
            {
                board[1][0]=ch;
                break;

            }

            case "5" :
            {
                board[1][1]=ch;
                break;

            }
            case "6" :
            {
                board[1][2]=ch;
                break;

            }
            case "7" :
            {
                board[2][0]=ch;
                break;

            }
            case"8" :
            {
                board[2][1]=ch;
                break;

            }
            case "9" :
            {
                board[2][2]=ch;
                break;

            }
            default :
                System.out.println("Please Enter Correct number between (1-9) !!! ");
        }


    }
    public static void userTurn(Scanner input, char[][] board) {
        //methode to user turn
        System.out.println("Your Turn");
        while (true) {
            //take position from user
            System.out.print("Where do you want to play? Choose a number (1-9): ");
            String userinput = input.nextLine();
            try {
                int pos = Integer.parseInt(userinput);
                //check is the input is number from 1 to 9 and check if the position is empty
                if (pos >= 1 && pos <= 9 && isValidMove(board, pos)) {
                    //Write the letter where the user choose
                    placeMove(board, userinput, 'X');
                    break;
                } else {
                    System.out.println("Invalid or unavailable position. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
            }
        }
    }

        public static boolean whoIsWon(char[][] board ,char symbol) {

        //methode To know the winning cases

            if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                    (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                    (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                    (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                    (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                    (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                    (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                    (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
                return true;


            }
            return false;


        }
    public static boolean isGameFinished(char [][] board)
    {
        //methode to know the user is wins or computer or is board full
       if (whoIsWon(board , 'X'))
       {
           printBord(board);
           System.out.println("You Wins !!!");
           return true;
       }

       if(whoIsWon(board,'O'))
       {
           printBord(board);
           System.out.println("The computer is win !");
           return true;
        }



        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == ' ') {
                    return false;


                }
            }
        }
        printBord(board);
        System.out.println(" No one Win! ");
         return true;
            }



        private static void printBord(char[][] bord) {
        //methode to print the board


        System.out.println(bord[0][0]+"|"+ bord[0][1]+"|"+ bord[0][2]);
        System.out.println("-+-+-");
        System.out.println(bord[1][0]+"|"+ bord[1][1]+"|"+ bord[1][2]);
        System.out.println("-+-+-");
        System.out.println(bord[2][0]+"|"+ bord[2][1]+"|"+ bord[2][2]);
    }
}
