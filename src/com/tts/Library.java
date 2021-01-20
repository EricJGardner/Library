package com.tts;
import java.util.*;

public class Library {

    //    Library firstLibrary = new Library("10 Main St.");
//    Library secondLibrary = new Library("228 Liberty St.");
//
    //library address
    String libraryAddress;
    //book array
    ArrayList<Book> books;

    //method to add address and books
    public Library(String address) {
        libraryAddress = address;
        books = new ArrayList<Book>();
    }

    //method to add book to books
    public void addBook(Book book) {
        books.add(book);
    }

    //printAddress method
    public void printAddress() {
        System.out.println(libraryAddress);
    }

    //method for borrowing book in library
    public String borrowBook(String bookTitle) {
        Book libraryBook;
        String libraryBookTitle;

        for (int i = 0; i < books.size(); i += 1) {
            libraryBook = books.get(i);
            libraryBookTitle = libraryBook.getTitle();

            if(libraryBookTitle.equals(bookTitle)) {

                if(!(libraryBook.isBorrowed()))
                {
                    libraryBook.borrowed();
                    System.out.println("You have borrowed " + libraryBookTitle);
                    return null;
                } else {
                    System.out.println("Sorry, this book is checked out.");
                    return null;
                }
            }
        }//end for loop
        System.out.println("Sorry, this book is not in our catalog.");
        return null;
    }//end borrowBook method

    //method for available books in library
    public void printAvailableBooks() {
        Book libraryBook;
        boolean libraryIsEmpty = true;

        for(int i = 0; i < books.size(); i+=1) {
            libraryBook = books.get(i);

            if (!(libraryBook.isBorrowed())) {
                System.out.println(libraryBook.getTitle());
                libraryIsEmpty = false;
            }
        }
        if(libraryIsEmpty)
        {
            System.out.println("No books in catalog.");
        }

}// end printAvailableBooks

    //method to return books
    public void returnBook(String bookTitle) {
        Book libraryBook;
        String libraryBookTitle;
        Boolean found = false;

        for(int i=0; i < books.size(); i+=1)
        {
            libraryBook = books.get(i);
            libraryBookTitle = libraryBook.getTitle();

            if(libraryBook.equals(bookTitle))
            {
                if(libraryBook.isBorrowed())
                {
                    libraryBook.returned();
                    System.out.println("You have successfully returned " + libraryBookTitle);
                    found = true;
                    break;
                }
            }
        }
        if(!found)
        {
            System.out.println("Your book was not found in the library catalog.");
        }//end for loop
    }//end returnBook

//print opening hours method
    public static void printOpeningHours(){
        System.out.println("Open daily from 9am-5pm");
    }
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("com.tts.Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("com.tts.Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }//end main
}//end class Library
