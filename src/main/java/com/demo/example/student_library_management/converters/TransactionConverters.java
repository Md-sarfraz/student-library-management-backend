package com.demo.example.student_library_management.converters;

import com.demo.example.student_library_management.model.Transaction;
import com.demo.example.student_library_management.requestDto.TransactionRequestDto;

public class TransactionConverters {
    public static Transaction convertTransactionRequestDtoToTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction =new Transaction();
        transaction.setTransactionStatus(transactionRequestDto.getTransactionStatus());
        transaction.setDueDate(transactionRequestDto.getDueDate());
        transaction.setFine(transactionRequestDto.getFine());
        transaction.setIssueOrReturn(transactionRequestDto.getIssueOrReturn());
        return transaction;
    }
}
