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
        LocalDate todayDate = LocalDate.of(2026, 11, 13);
        LocalDate todayPlus7Date = LocalDate.of(2026, 11, 20);

        Loan newLoan = new Loan(book, member, todayDate, todayPlus7Date);

        assertEquals(book, newLoan.getLoanedBook());
        assertEquals(member, newLoan.getBorrower());
        assertEquals(todayDate, newLoan.getLoanDate());
        assertEquals(todayPlus7Date, newLoan.getDueDate());
        assertFalse(newLoan.isReturned());
    }

    @Test
    void testNewLoanReturnDate(){
        LocalDate todayDate = LocalDate.of(2026, 11, 13);
        LocalDate todayPlus7Date = LocalDate.of(2026, 11, 20);

        Loan newLoan = new Loan(book, member, todayDate, todayPlus7Date);

        assertFalse(newLoan.isReturned());
        assertNull(newLoan.getReturnDate());
    }

    @Test
    void testLoanReturnCorrect(){
        LocalDate todayDate = LocalDate.of(2026, 11, 13);
        LocalDate todayPlus7Date = LocalDate.of(2026, 11, 20);
        Loan newLoan = new Loan(book, member, todayDate, todayPlus7Date);
        LocalDate returnDate = LocalDate.of(2026, 11, 16);

        newLoan.returnBook(returnDate);

        assertEquals(returnDate, newLoan.getReturnDate());
        assertTrue(newLoan.isReturned());
    }

    @Test
    void testReturnBeforeLoanDate(){
        LocalDate todayDate = LocalDate.of(2026, 11, 13);
        LocalDate todayPlus7Date = LocalDate.of(2026, 11, 20);
        Loan newLoan = new Loan(book, member, todayDate, todayPlus7Date);

        LocalDate returnDateBefore = LocalDate.of(2026, 11, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            newLoan.returnBook(returnDateBefore);
        });
    }

    @Test
    void testDoubleReturn(){
        LocalDate todayDate = LocalDate.of(2026, 11, 13);
        LocalDate todayPlus7Date = LocalDate.of(2026, 11, 20);
        Loan newLoan = new Loan(book, member, todayDate, todayPlus7Date);
        LocalDate firstReturnDate = LocalDate.of(2026, 11, 16);
        LocalDate secondReturnDate = LocalDate.of(2026, 11, 21);

        newLoan.returnBook(firstReturnDate);

        assertThrows(IllegalStateException.class, () -> {
           newLoan.returnBook(secondReturnDate);
        });
        assertEquals(firstReturnDate, newLoan.getReturnDate());
    }

    @Test
    void testNullReturnDate(){
        LocalDate todayDate = LocalDate.of(2026, 11, 13);
        LocalDate todayPlus7Date = LocalDate.of(2026, 11, 20);
        Loan newLoan = new Loan(book, member, todayDate, todayPlus7Date);
        LocalDate returnDate = null;

        assertThrows(IllegalArgumentException.class, () -> {
            newLoan.returnBook(returnDate);
        });
    }
}
