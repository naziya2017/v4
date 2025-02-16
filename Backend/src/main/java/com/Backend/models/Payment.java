package com.Backend.models;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Document(collection = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    private ObjectId _id;
    private ObjectId booking_id;
    private String user_id;
    private double amount;
    private List<String> paymentMethod;
    private String transaction_id;
    private List<String> paymentStatus;
    private Timestamp created_at = new Timestamp(System.currentTimeMillis());
}
