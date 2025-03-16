package com.Backend.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@Document(collection = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    private ObjectId _id;
    private ObjectId user_id;
    private ObjectId provider_id;
    private ObjectId service_id;
    private ObjectId booking_id;  // Reference to the booking
    private double rating;  // Overall rating
    private HashMap<String, Double> rating_categories;  // Categories like timeliness, professionalism, etc.
    private String comment;
    private List<String> images;  // URLs to review images if any
    private boolean is_verified;  // Verified if it comes after a completed booking
    private String provider_response;  // Provider's response to the review
    private Timestamp provider_response_at;  // When the provider responded
    private boolean is_anonymous;  // If user chose to remain anonymous
    private boolean is_published;  // Flag to control review visibility
    private Timestamp created_at = new Timestamp(System.currentTimeMillis());
    private Timestamp updated_at = new Timestamp(System.currentTimeMillis());
}