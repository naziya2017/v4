package com.Backend.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Date;

@Document(collection = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    private ObjectId _id;
    private ObjectId user_id;
    private ObjectId provider_id;
    private double rating;
    private String comment;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
}
