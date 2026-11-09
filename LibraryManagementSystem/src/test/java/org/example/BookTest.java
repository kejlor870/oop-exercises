package org.example;

import org.example.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    void testBookCreateNewBook(){
        // Arange
        String title = "Animal Farm";
        String author = "George Orwell";
        String isbn = "9788366949195";
        Book newBook = new Book(title, author, isbn);

        // Act
        String bookTitle = newBook.getTitle();
        String bookAuthor = newBook.getAuthor();
        String bookIsbn = newBook.getIsbn();

        // Assert
        assertEquals(title, bookTitle);
        assertEquals(author, bookAuthor);
        assertEquals(isbn, bookIsbn);
    }

    @Test
    void testBookNullTitleCreate(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Book(null, "George Orwell", "9788366949195");
        });
    }

    @Test
    void testBookBooksHaveUniqueId(){
        Book book1 = new Book("Animal Farm", "George Orwell", "9788366949195");
        Book book2 = new Book("Book number 2", "Author 2", "3667895819949");

        String idBook1 = book1.getUniqueId();
        String idBook2 = book2.getUniqueId();

        assertNotEquals(idBook1, idBook2);
    }

}
