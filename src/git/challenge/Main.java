package git.challenge;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static Scanner op = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        mainMenu();

    }

    public static void mainMenu() throws IOException, ClassNotFoundException {
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
        Book newBook2 = new Book(); //del
        Book newBook3 = new Book(); //del

        //Asks the user for the new book's info
        /*System.out.print("Type the name of the new book you want to add: ");
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
        System.out.println("");*/

        newBook.setName("Cien Años de Soledad");
        newBook.setAuthor("Gabriel García Marquez");
        newBook.setIsbn("1234");
        newBook.setPublishedDate("16/04/1998");
        newBook.setLanguage("Spanish");
        newBook.setPublisher("Norma");

        newBook2.setName("Delirio");
        newBook2.setAuthor("Laura Restrepo");
        newBook2.setIsbn("5678");
        newBook2.setPublishedDate("16/04/1998");
        newBook2.setLanguage("Spanish");
        newBook2.setPublisher("DeBolsillo");

        newBook3.setName("La Tregua");
        newBook3.setAuthor("Mario Benedetti");
        newBook3.setIsbn("2331");
        newBook3.setPublishedDate("16/04/1998");
        newBook3.setLanguage("Spanish");
        newBook3.setPublisher("Penguin");

        //Stores the object with the info provided by the user in a file called 'endava_library.txt'
        try {
            FileOutputStream fos = new FileOutputStream(new File("endava_library.txt"), true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(newBook);
            oos.writeObject(newBook2);
            oos.writeObject(newBook3);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found or does not exists!");
        } catch (IOException e) {
            System.out.println("Error initializing stream!");
        }

        System.out.println("Book successfully added!");
        System.out.println();
    }

    public static void readBookInfo() {
        //Book[] bookArray = new Book[5];
        Scanner input = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<Book>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("endava_library.txt"));
            FileInputStream fis = new FileInputStream(new File("endava_library.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            //books = (ArrayList<Book>) ois.readObject();
            /*Book b1 = (Book) ois.readObject();
            Book b2 = (Book) ois.readObject();
            Book b3 = (Book) ois.readObject();
            System.out.println(b1.getName());
            System.out.println(b2.getName());
            System.out.println(b3.getName());*/
            String line;
            //Book tmp = new Book();
            Boolean flag = true;
            Book tmp = null;
            //System.out.println("Bytes available: " + ois.available());
            while (flag) {
                if (fis.available() != 0) {
                    tmp = (Book) ois.readObject();
                    books.add(tmp);
                } else {
                    flag = false;
                }
                /*for (int i = 0; i < books.size(); i++) {
                    books.get(i).getName();
                }*/
                /*Book tmp = null;
                try {
                    tmp = (Book) ois.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (tmp != null) {
                    books.add(tmp);
                } else {
                    flag = false;
                }*/
            }
            /*Iterator<Book> itr = books.iterator();
            while(itr.hasNext()) {
                Book tmpBook = itr.next();
                System.out.println(tmpBook.getName());
            }
            System.out.println("tesssssssssssssssssssssssst");*/
            /*Book[] a = books.toArray(new Book[books.size()]);
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i].getName());
            }*/
            System.out.println(books.size());
            System.out.println("Please type the book's name: ");
            String bName = input.nextLine();
            Iterator<Book> itr = books.iterator();
            while(itr.hasNext()) {
                Book tmpBook = itr.next();
                if (tmpBook.getName().equals(bName)) {
                    System.out.println(tmpBook.getAuthor());
                    System.out.println(tmpBook.getIsbn());
                    System.out.println(tmpBook.getPublishedDate());
                    System.out.println(tmpBook.getLanguage());
                    System.out.println(tmpBook.getPublisher());
                    break;
                } else {
                    //System.out.println("The book does not exists!");
                }
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Asks the user for the name of the book they want info about
    }

    public static void updateBookInfo() {

    }

    public static void deleteBook() {

    }

    public static void readFile() {

    }

    public static void writeFile() {

    }

}

