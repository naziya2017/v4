package com.Backend.service;

import com.Backend.models.ServiceProvider;
import com.Backend.repository.ServiceProviderRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceProviderServiceImpl {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderRepository.findByVerifiedTrueAndIsActiveTrue();
    }

    public Optional<ServiceProvider> getServiceProviderById(ObjectId id) {
        return serviceProviderRepository.findById(id);
    }

    public List<ServiceProvider> getServiceProvidersByService(String serviceId) {
        return serviceProviderRepository.findByServiceIdsAndIsActive(new ObjectId(serviceId));
    }

    public List<ServiceProvider> searchServiceProviders(String query) {
        return serviceProviderRepository.findByFullNameContainingAndIsActive(query);
    }

    public List<ServiceProvider> getServiceProvidersByLocation(String location) {
        return serviceProviderRepository.findByAddressContainingAndIsActive(location);
    }

    public List<ServiceProvider> getTopRatedProvidersByService(String serviceId, double minRating) {
        return serviceProviderRepository.findByServiceAndMinimumRating(serviceId, minRating);
    }

    public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider) {
        // Using standard getId() method
        if (serviceProvider.getId() == null) {
            serviceProvider.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        }
        serviceProvider.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return serviceProviderRepository.save(serviceProvider);
    }

    public void deleteServiceProvider(ObjectId id) {
        serviceProviderRepository.deleteById(id);
    }
}