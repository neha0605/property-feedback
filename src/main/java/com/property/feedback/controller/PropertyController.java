package com.property.feedback.controller;

import com.property.feedback.repository.models.Property;
import com.property.feedback.repository.models.Review;
import com.property.feedback.repository.models.view.PropertyViewModel;
import com.property.feedback.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nehaojha on 11/11/16.
 */
@RestController
@RequestMapping(value = "/properties")
public class PropertyController extends BaseController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(value = "/nearby", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public PropertyViewModel getPropertyByLatitudeAndLongitude(@RequestParam double latitude,
                                                               @RequestParam double longitude) {
        Property property = propertyService.findByLatitudeAndLongitude(latitude, longitude);
        PropertyViewModel viewModel = new PropertyViewModel(property);
        return viewModel;

    }

    @RequestMapping(value = "/published/{propertyId}", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public List<Review> getPublishedReviewsByPropertyId(@PathVariable Integer propertyId) {
        return propertyService.findReviewByPropertyIdAndPublishedTrue(propertyId);
    }

    @RequestMapping(value = "/property/all", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public ResponseEntity<List<PropertyViewModel>> getAllProperties() {
        List<PropertyViewModel> propertyViewModels = propertyService.findAllProperties().stream().map(PropertyViewModel::new).collect(Collectors.toList());
        return new ResponseEntity<>(propertyViewModels, HttpStatus.OK);
    }
}
