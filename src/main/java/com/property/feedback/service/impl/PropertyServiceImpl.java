package com.property.feedback.service.impl;

import com.property.feedback.repository.PropertyRepo;
import com.property.feedback.repository.models.Property;
import com.property.feedback.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nehaojha on 11/11/16.
 */
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;

    @Override
    public List<Property> findReviewsNearLocation(Double latitude, Double longitude) {
        return propertyRepo.findNearByProperties(latitude, longitude);
    }

    @Override
    public Property findByLatitudeAndLongitude(double latitude, double longitude) {
        return propertyRepo.findByLatitudeAndLongitude(latitude, longitude);
    }
}
