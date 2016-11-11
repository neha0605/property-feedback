package com.property.feedback.test.client;

import com.property.feedback.repository.PropertyRepo;
import com.property.feedback.repository.models.Property;
import com.property.feedback.repository.models.PropertyFeedback;
import com.property.feedback.service.PropertyService;
import com.property.feedback.service.ReviewService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by nehaojha on 07/11/16.
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//        PropertyService propertyService=context.getBean(PropertyService.class);
        ReviewService reviewService = context.getBean(ReviewService.class);

        PropertyFeedback propertyFeedback = createProperty("colambia asia palam vihar gurgaon", 28.512783, 77.036893, "service was ok", "8447884459", 3);
        reviewService.addReview(propertyFeedback);


    }

    private static PropertyFeedback createProperty(String add, Double lat, Double longtitude, String review, String number, int rating) {
        PropertyFeedback propertyFeedback = new PropertyFeedback(add, lat, longtitude, review, number, rating);
        return propertyFeedback;
    }
}

