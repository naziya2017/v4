package com.Backend.repository;

import com.Backend.models.ServiceProvider;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ServiceProviderRepository extends MongoRepository<ServiceProvider, ObjectId> {

    @Query("{'service_ids': ?0, 'is_active': true}")
    List<ServiceProvider> findByServiceIdsAndIsActive(ObjectId serviceId);

    @Query("{'verified': true, 'is_active': true}")
    List<ServiceProvider> findByVerifiedTrueAndIsActiveTrue();

    @Query("{'full_name': {$regex: ?0, $options: 'i'}, 'is_active': true}")
    List<ServiceProvider> findByFullNameContainingAndIsActive(String name);

    @Query("{'service_ids': ?0, 'ratings': {$gte: ?1}, 'is_active': true}")
    List<ServiceProvider> findByServiceAndMinimumRating(String serviceId, double minRating);

    @Query("{'address': {$regex: ?0, $options: 'i'}, 'is_active': true}")
    List<ServiceProvider> findByAddressContainingAndIsActive(String location);
}