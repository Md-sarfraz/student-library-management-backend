package com.demo.example.student_library_management.requestDto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
@Data

public class TransactionRequestDto {
    private String transactionStatus;
    private String dueDate;
    private double fine;
    private String issueOrReturn;
    private int BookId;
    private int CardId;
}
