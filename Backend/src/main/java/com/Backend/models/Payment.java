package com.Backend.models;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document(collection = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    private ObjectId _id;
    private ObjectId booking_id;
    private ObjectId user_id;  // Changed to ObjectId for consistency
    private double amount;
    private String payment_method;  // Single payment method (CREDIT_CARD, DEBIT_CARD, UPI, WALLET, etc.)
    private String transaction_id;
    private String payment_status;  // Single status (PENDING, PROCESSING, COMPLETED, FAILED, REFUNDED)
    private String failure_reason;  // Reason if payment failed
    private String payment_gateway;  // Gateway used for transaction
    private String refund_id;  // ID for refund if applicable
    private Timestamp payment_date = new Timestamp(System.currentTimeMillis());
    private Timestamp created_at = new Timestamp(System.currentTimeMillis());
    private Timestamp updated_at = new Timestamp(System.currentTimeMillis());
}