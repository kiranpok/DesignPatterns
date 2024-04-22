package org.example;



public class Book {

    private String author;
    private String title;
    private String genre;
    private int publicationYear;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book(String author, String title, String genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    // Implement deep cloning using a copy constructor
    public Book(Book book) {
        this.author = new String(book.author);  // Deep copy for String
        this.title = new String(book.title);
        this.genre = book.genre != null ? new String(book.genre) : null;  // Optional deep copy for genre
        this.publicationYear = book.publicationYear;
    }

    @Override
    public String toString() {
        return author + " - " + title + (genre != null ? " (" + genre + ")" : "");
    }
}

