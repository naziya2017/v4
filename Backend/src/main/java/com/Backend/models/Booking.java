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
    private String package_id;  // Reference to specific service package if applicable
    private Date booking_date;  // Date of service
    private String start_time;  // Start time in HH:MM format
    private String end_time;  // End time in HH:MM format
    private String status;  // Single status field (PENDING, CONFIRMED, IN_PROGRESS, COMPLETED, CANCELLED)
    private String cancellation_reason;  // Reason if booking was cancelled
    private double price;  // Total price
    private int duration_minutes;  // Duration in minutes
    private String payment_status;  // Single payment status (PENDING, PAID, REFUNDED)
    private String address;  // Service address
    private String special_instructions;  // Any special requirements
    private boolean is_rescheduled;  // Flag for rescheduled bookings
    private ObjectId previous_booking_id;  // Reference to previous booking if rescheduled
    private Timestamp created_at = new Timestamp(System.currentTimeMillis());
    private Timestamp updated_at = new Timestamp(System.currentTimeMillis());
}