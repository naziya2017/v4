package com.Backend.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Document(collection = "service_providers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvider {
    @Id
    private ObjectId _id;
    private String full_name;
    private Integer phone;
    private String email;
    private List<String> services;
    private int experience;
    private String profilePicture;
    private String availability;
    private String address;
    private double hourlyRate;
    private double ratings;
    private boolean verified;
    private Timestamp created_at = new Timestamp(System.currentTimeMillis());
    private Timestamp updates_at = new Timestamp(System.currentTimeMillis());
}
