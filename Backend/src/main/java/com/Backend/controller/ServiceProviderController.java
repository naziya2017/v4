package com.Backend.controller;

import com.Backend.models.ServiceProvider;
import com.Backend.service.ServiceProviderServiceImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/providers")
@CrossOrigin(origins = "*") // For development - restrict in production
public class ServiceProviderController {

    @Autowired
    private ServiceProviderServiceImpl serviceProviderService;

    @GetMapping
    public ResponseEntity<List<ServiceProvider>> getAllServiceProviders() {
        List<ServiceProvider> providers = serviceProviderService.getAllServiceProviders();
        return new ResponseEntity<>(providers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProvider> getServiceProviderById(@PathVariable String id) {
        Optional<ServiceProvider> provider = serviceProviderService.getServiceProviderById(new ObjectId(id));
        return provider.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/service/{serviceId}")
    public ResponseEntity<List<ServiceProvider>> getServiceProvidersByService(@PathVariable String serviceId) {
        List<ServiceProvider> providers = serviceProviderService.getServiceProvidersByService(serviceId);
        return new ResponseEntity<>(providers, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ServiceProvider>> searchServiceProviders(@RequestParam String query) {
        List<ServiceProvider> providers = serviceProviderService.searchServiceProviders(query);
        return new ResponseEntity<>(providers, HttpStatus.OK);
    }

    @GetMapping("/location")
    public ResponseEntity<List<ServiceProvider>> getServiceProvidersByLocation(@RequestParam String location) {
        List<ServiceProvider> providers = serviceProviderService.getServiceProvidersByLocation(location);
        return new ResponseEntity<>(providers, HttpStatus.OK);
    }

    @GetMapping("/top-rated")
    public ResponseEntity<List<ServiceProvider>> getTopRatedProviders(
            @RequestParam String serviceId,
            @RequestParam(defaultValue = "4.0") double minRating) {
        List<ServiceProvider> providers = serviceProviderService.getTopRatedProvidersByService(serviceId, minRating);
        return new ResponseEntity<>(providers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServiceProvider> createServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        ServiceProvider savedProvider = serviceProviderService.saveServiceProvider(serviceProvider);
        return new ResponseEntity<>(savedProvider, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceProvider> updateServiceProvider(
            @PathVariable String id,
            @RequestBody ServiceProvider serviceProvider) {
        Optional<ServiceProvider> existingProvider = serviceProviderService.getServiceProviderById(new ObjectId(id));

        if (existingProvider.isPresent()) {
            serviceProvider.setId(new ObjectId(id));
            ServiceProvider updatedProvider = serviceProviderService.saveServiceProvider(serviceProvider);
            return new ResponseEntity<>(updatedProvider, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceProvider(@PathVariable String id) {
        Optional<ServiceProvider> existingProvider = serviceProviderService.getServiceProviderById(new ObjectId(id));

        if (existingProvider.isPresent()) {
            serviceProviderService.deleteServiceProvider(new ObjectId(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}