package org.example.model;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    private final String uniqueId;
    private final Book loanedBook;
    private final Member borrower;
    private final LocalDate loanDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;

    public Loan(Book loanedBook, Member borrower, LocalDate loanDate, LocalDate dueDate){
        if(loanedBook == null){
            throw new IllegalArgumentException("Loaned book can not be null.");
        }
        if(borrower == null){
            throw new IllegalArgumentException("Borrower can not be null.");
        }
        if(loanDate == null || dueDate == null){
            throw new IllegalArgumentException("Loan and due date can not be null.");
        }
        if(loanDate.isAfter(dueDate)){
            throw new IllegalArgumentException("Loan date can not be after due date.");
        }


        this.uniqueId = UUID.randomUUID().toString();
        this.loanedBook = loanedBook;
        this.borrower = borrower;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
    }

    public String getUniqueId() {
        return uniqueId;
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

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void returnBook(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned(){
        return this.returnDate != null;
    }
}
