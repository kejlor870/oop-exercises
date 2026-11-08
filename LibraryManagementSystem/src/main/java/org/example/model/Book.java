package org.example.model;

import java.util.UUID;

public class Book {
    private final String uniqueId;
    private final String title;
    private final String author;
    private final String isbn;

    public Book(String title, String author, String isbn){
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title can not be null or empty");
        }

        this.uniqueId = UUID.randomUUID().toString(); // ex. f81d4fae-7dec-11d0-a765-00a0c91e6bf6
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getUniqueId() {
        return uniqueId;
    }
}
