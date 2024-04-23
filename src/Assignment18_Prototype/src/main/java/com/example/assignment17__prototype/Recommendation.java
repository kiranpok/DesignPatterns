package com.example.assignment17__prototype;

import java.util.ArrayList;
import java.util.List;


public class Recommendation implements Cloneable {

    private String targetAudience;
    List<Book> books;

    public Recommendation(String targetAudience, List<Book> books) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>(books); // Deep copy of book list
    }

    @Override
    public Recommendation clone() throws CloneNotSupportedException {
        Recommendation clone = (Recommendation) super.clone();
        clone.books = new ArrayList<>(books);  // Deep copy books again after cloning
        return clone;
    }

    public void addBook(Book book) {
        books.add(new Book(book));  // Deep copy of book before adding
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void changeTargetAudience(String newAudience) {
        this.targetAudience = newAudience;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recommendation for: ").append(targetAudience).append("\nBooks:\n");
        for (Book book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }

    public String getTargetAudience() {
        return targetAudience;

    }
}

