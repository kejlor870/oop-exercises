package org.example.service;

import org.example.model.Book;
import org.example.model.Loan;
import org.example.model.Member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private final List<Book> bookList = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<Loan> loanList = new ArrayList<>();

    public boolean addBook(Book book){
        if(book == null){
            throw new IllegalArgumentException("Can not add book which is null.");
        }

        bookList.add(book);

        return true;
    }

    public boolean registerMember(Member member){
        if(member == null){
            throw new IllegalArgumentException("Can not register member which is null.");
        }

        members.add(member);

        return true;
    }

    public Loan borrowBook(Book book, Member member, LocalDate dueDate){
        if(!bookList.contains(book)){
            throw new IllegalArgumentException("Can not borrow book which is not added.");
        }
        if(!members.contains(member)){
            throw new IllegalArgumentException("Can not borrow to the member which is not registered.");
        }

        // Checking in loanList if there is any loan which have provided book and have don't have returned date
        boolean isBookAvailable = loanList.stream().anyMatch(loan ->
                loan.getLoanedBook().equals(book) && !loan.isReturned()
        );

        if(!isBookAvailable){
            throw new IllegalStateException("The book is already borrowed.");
        }

        // Checking member active loans
        long memberActiveLoans = loanList.stream()
                .filter(loan -> loan.getBorrower().equals(member) && !loan.isReturned())
                .count()
                ;

        if(memberActiveLoans >= 3){
            throw new IllegalStateException("The member have max active loans.");
        }

        // Creating new loan
        Loan newLoan = new Loan(book, member, LocalDate.now(), dueDate);

        // Adding loan to the list
        loanList.add(newLoan);

        return newLoan;
    }


}
