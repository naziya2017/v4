package com.Backend.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.sql.Timestamp;
import java.util.List;

@Document(collection = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    private ObjectId _id;
    private String service_name;
    private String description;
    private String image_url;  // Path to service image
    private double avg_rate_per_hr;
    private String service_type;  // Category of service
    private List<String> availability;  // Days or time slots when service is available
    private List<ServicePackage> packages;  // Different service packages
    private List<String> tags;  // For search and categorization
    private boolean is_active;  // Flag to enable/disable service
    private Timestamp created_at = new Timestamp(System.currentTimeMillis());
    private Timestamp updated_at = new Timestamp(System.currentTimeMillis());

    // Nested class for service packages
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ServicePackage {
        private String package_id;  // Unique identifier for package
        private String name;  // Package name (e.g., "Basic", "Premium")
        private String description;  // Package details
        private double price;  // Package price
        private int duration_minutes;  // Expected duration of service
        private List<String> included_items;  // What's included in the package
    }
}