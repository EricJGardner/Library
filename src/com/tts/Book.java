package com.tts;

public class Book {

    @Override
    public String toString() {
        return "Book [title:" + title + ", borrowed:" + borrowed + "]";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    String title;
    boolean borrowed;

    // Creates a new com.tts.Book
    public Book(String bookTitle) {
        title = bookTitle;
        borrowed = false;
    }

    // Marks the book as borrowed
    public void borrowed() {
        borrowed = true;
    }

    // Marks the book as not borrowed
    public void returned() {
        borrowed = false;
    }

    // Returns true if the book is borrowed, false otherwise
    public boolean isBorrowed() {
        if (borrowed) {
            return true;
        }
        return false;
    }

    // Returns the title of the book
    public String getTitle() {
        return title;
    }

    public static void main(String[] arguments) {
        // Small test of the com.tts.Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.borrowed();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }
}
