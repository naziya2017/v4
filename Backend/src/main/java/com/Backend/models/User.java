package com.Backend.models;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.sql.Timestamp;
import java.util.List;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private ObjectId _id;
    private String full_name;
    private String email;
    private String phone;  // Changed to String to handle country codes and leading zeros
    private String password_hash;  // Changed to String as password hashes are typically stored as strings
    private String profile_picture;
    private String address;
    private List<Address> saved_addresses;  // Multiple addresses for service locations
    private String profession;
    private boolean email_verified;
    private boolean phone_verified;
    private List<String> favorite_services;  // Store service IDs that user has favorited
    private List<String> favorite_providers;  // Store provider IDs that user has favorited
    private Timestamp created_at = new Timestamp(System.currentTimeMillis());
    private Timestamp updated_at = new Timestamp(System.currentTimeMillis());

    // Nested class for structured addresses
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address {
        private String type;  // Home, Work, Other
        private String full_address;
        private String landmark;
        private String city;
        private String state;
        private String pincode;
        private boolean is_default;
    }
}