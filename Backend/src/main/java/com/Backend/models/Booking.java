package com.Backend.models;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Document(collection = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    private ObjectId _id;
    private ObjectId user_id;
    private ObjectId provider_id;
    private ObjectId service_id;
    private Date booking_date;
    private List<String> status;
    private double price;
    private List<String> duration; // Duration in hours
    private List<String> paymentStatus;
    private Timestamp created_at = new Timestamp(System.currentTimeMillis());
    private Timestamp updated_at = new Timestamp(System.currentTimeMillis());
}
