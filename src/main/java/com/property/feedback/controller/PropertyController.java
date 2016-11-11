package com.property.feedback.controller;

import com.property.feedback.repository.models.Property;
import com.property.feedback.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nehaojha on 11/11/16.
 */
@RestController
@RequestMapping(value = "/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(value = "/nearby", method = RequestMethod.GET)
    public Property getPropertyByLatitudeAndLongitude(@RequestParam double latitude,
                                                      @RequestParam double longitude) {
        return propertyService.findByLatitudeAndLongitude(latitude, longitude);
    }
}
