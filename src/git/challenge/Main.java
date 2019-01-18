package git.challenge;
import java.util.Scanner;

public class Main {

    private static int op;
    private static Scanner in = new Scanner(System.in);
    private static Book nBook = new Book();

    public static void main(String[] args) {



    }

    public void mainMenu() {
        while(op != 5){
            System.out.println("********Endava Library********");
            System.out.println("1. Add a new book.");
            System.out.println("3. Update a book.");
            System.out.println("4. Delete a book.");
            System.out.println("5. Exit.");

            System.out.println();

            op = in.nextInt();

            switch(op) {
                case 1: //Create feature

                    break;
                case 2: //Read feature

                    break;
                case 3: //Update feature

                    break;
                case 4: //Delete feature

                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

}

