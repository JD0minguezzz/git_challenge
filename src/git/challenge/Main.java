package git.challenge;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static Scanner op = new Scanner(System.in);

    public static void main(String[] args) {

        mainMenu();

    }

    public static void mainMenu() {
        boolean flag = true;
        while(flag){
            System.out.println("********Endava Library********");
            System.out.println("1. Add a new book.");
            System.out.println("2. Search a book.");
            System.out.println("3. Update a book.");
            System.out.println("4. Delete a book.");
            System.out.println("5. Exit.");
            System.out.println();

            System.out.print("Select an option: ");
            int option = op.nextInt();
            System.out.println("");

            switch(option) {
                case 1: //Create feature
                    addBook();
                    break;
                case 2: //Read feature
                    readBookInfo();
                    break;
                case 3: //Update feature
                    updateBookInfo();
                    break;
                case 4: //Delete feature
                    deleteBook();
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }

    public static void addBook(){
        Scanner input = new Scanner(System.in);
        Book newBook = new Book();

        //Asks the user for the new book's info
        System.out.print("Type the name of the new book you want to add: ");
        newBook.setName(input.nextLine());
        System.out.print("Type the book's author: ");
        newBook.setAuthor(input.nextLine());
        System.out.print("Type the book's ISBN number: ");
        newBook.setIsbn(input.nextLine());
        System.out.print("Type the book's published date: ");
        newBook.setPublishedDate(input.nextLine());
        System.out.print("Type the book's language: ");
        newBook.setLanguage(input.nextLine());
        System.out.print("Type the book's publisher: ");
        newBook.setPublisher(input.nextLine());
        System.out.println("");

        //Stores the object with the info provided by the user in a file called 'endava_library.txt'
        try {
            FileOutputStream fos = new FileOutputStream(new File("endava_library.txt"), true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(newBook);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found or does not exists!");
        } catch (IOException e) {
            System.out.println("Error initializing stream!");
        }

        System.out.println("Book successfully added!");
        System.out.println();
    }

    public static void readBookInfo() {

    }

    public static void updateBookInfo() {

    }

    public static void deleteBook() {

    }

}

