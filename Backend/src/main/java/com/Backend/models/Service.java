package com.Backend.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
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
    private double avg_rate_per_hr;
    private String service_type;
    private List<String> availability;
}
