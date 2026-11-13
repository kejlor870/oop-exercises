package org.example;

import org.example.model.Book;
import org.example.model.Loan;
import org.example.model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanTest {
    Book book;
    Member member;

    @BeforeEach
    void setUp(){
        book = new Book("Animal Farm", "George Orwell", "9788366949195");
        member = new Member("Jan");
    }

    @Test
    void testLoanCreate(){
        LocalDate todayDate = LocalDate.now();
        LocalDate todayPlus7Date = LocalDate.now().plusDays(7);

        Loan newLoan = new Loan(book, member, todayDate, todayPlus7Date);

        assertEquals(book, newLoan.getLoanedBook());
        assertEquals(member, newLoan.getBorrower());
        assertEquals(todayDate, newLoan.getLoanDate());
        assertEquals(todayPlus7Date, newLoan.getDueDate());
        assertFalse(newLoan.isReturned());
    }

    @Test
    void testNewLoanReturnDate(){
        LocalDate todayDate = LocalDate.now();
        LocalDate todayPlus7Date = LocalDate.now().plusDays(7);

        Loan newLoan = new Loan(book, member, todayDate, todayPlus7Date);

        assertFalse(newLoan.isReturned());
        assertNull(newLoan.getReturnDate());
    }

    @Test
    void testLoanReturnCorrect(){
        LocalDate todayDate = LocalDate.now();
        LocalDate todayPlus7Date = LocalDate.now().plusDays(7);
        Loan newLoan = new Loan(book, member, todayDate, todayPlus7Date);
        LocalDate returnDate = LocalDate.now().plusDays(3);

        newLoan.returnBook(returnDate);

        assertEquals(returnDate, newLoan.getReturnDate());
        assertTrue(newLoan.isReturned());
    }

    @Test
    void testReturnBeforeLoanDate(){
        LocalDate todayDate = LocalDate.now();
        LocalDate todayPlus7Date = LocalDate.now().plusDays(7);
        Loan newLoan = new Loan(book, member, todayDate, todayPlus7Date);

        LocalDate returnDateBefore = LocalDate.now().minusDays(10);

        assertThrows(IllegalArgumentException.class, () -> {
            newLoan.returnBook(returnDateBefore);
        });
    }

    @Test
    void testDoubleReturn(){
        LocalDate todayDate = LocalDate.now();
        LocalDate todayPlus7Date = LocalDate.now().plusDays(7);
        Loan newLoan = new Loan(book, member, todayDate, todayPlus7Date);
        LocalDate firstReturnDate = LocalDate.now().plusDays(3);
        LocalDate secondReturnDate = LocalDate.now().plusDays(8);

        newLoan.returnBook(firstReturnDate);

        assertThrows(IllegalStateException.class, () -> {
           newLoan.returnBook(secondReturnDate);
        });
        assertEquals(firstReturnDate, newLoan.getReturnDate());
    }

    @Test
    void testNullReturnDate(){
        LocalDate todayDate = LocalDate.now();
        LocalDate todayPlus7Date = LocalDate.now().plusDays(7);
        Loan newLoan = new Loan(book, member, todayDate, todayPlus7Date);
        LocalDate returnDate = null;

        assertThrows(IllegalArgumentException.class, () -> {
            newLoan.returnBook(returnDate);
        });
    }
}
