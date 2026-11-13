package org.example;

import org.example.model.Book;
import org.example.model.Loan;
import org.example.model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

}
