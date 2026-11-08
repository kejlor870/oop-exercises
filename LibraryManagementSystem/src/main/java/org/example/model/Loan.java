package org.example.model;

import java.time.LocalDate;

public class Loan {
    private Book loanedBook;
    private Member borrower;
    private LocalDate loanDate;
    private LocalDate dueDate;

    public Loan(Book loanedBook, Member borrower, LocalDate loanDate, LocalDate dueDate){
        if(loanedBook == null || borrower == null){
            throw new IllegalArgumentException("Loaned book and borrower can not be null");
        }

        this.loanedBook = loanedBook;
        this.borrower = borrower;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
    }

    public Book getLoanedBook() {
        return loanedBook;
    }

    public Member getBorrower() {
        return borrower;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }
}
