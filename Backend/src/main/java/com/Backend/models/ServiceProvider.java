package com.Backend.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Document(collection = "service_providers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvider {
    @Id
    private ObjectId id;  // Changed to camelCase

    @Field("full_name")
    private String fullName;  // Changed to camelCase

    private String phone;
    private String email;

    @Field("service_ids")
    private List<ObjectId> serviceIds;  // Changed to camelCase

    @Field("service_specialties")
    private Map<String, Boolean> serviceSpecialties;  // Changed to camelCase

    private int experience;

    @Field("profile_picture")
    private String profilePicture;  // Changed to camelCase

    @Field("availability_slots")
    private List<AvailabilitySlot> availabilitySlots;  // Changed to camelCase

    private String address;

    @Field("hourly_rate")
    private double hourlyRate;  // Changed to camelCase

    private double ratings;

    @Field("total_reviews")
    private int totalReviews;  // Changed to camelCase

    private boolean verified;

    @Field("is_active")
    private boolean isActive;  // Changed to camelCase

    private String bio;
    private List<String> languages;
    private List<String> certifications;

    @Field("service_areas")
    private List<String> serviceAreas;  // Changed to camelCase

    @Field("created_at")
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());  // Changed to camelCase

    @Field("updated_at")
    private Timestamp updatedAt = new Timestamp(System.currentTimeMillis());  // Changed to camelCase

    // Nested class for structured availability
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AvailabilitySlot {
        private String day;

        @Field("start_time")
        private String startTime;  // Changed to camelCase

        @Field("end_time")
        private String endTime;  // Changed to camelCase
    }
}