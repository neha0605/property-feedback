package com.property.feedback.repository;

import com.property.feedback.repository.models.Property;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nehaojha on 08/11/16.
 */
public class PropertyRepoTest {

    private PropertyRepo propertyRepo;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        propertyRepo = context.getBean(PropertyRepo.class);
    }

    @Test
    public void findNearByProperties() throws Exception {
        Property property = new Property();
        property.setAddress("colambia asia palam vihar gurgaon");
        property.setLatitude(28.512783);
        property.setLongitude(77.036893);
        List<Property> nearByProperties = propertyRepo.findNearByProperties(28.512783, 77.036893);
        Assert.assertNotNull(nearByProperties);
        Assert.assertTrue(!nearByProperties.isEmpty());
        for (Property properties : nearByProperties) {
            System.out.println(properties);
        }
    }

}