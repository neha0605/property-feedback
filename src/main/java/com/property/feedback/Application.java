package com.property.feedback;

import com.property.feedback.repository.PropertyRepo;
import com.property.feedback.repository.models.Property;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by nehaojha on 07/11/16.
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        PropertyRepo propertyRepo = context.getBean(PropertyRepo.class);
        List<Property> properties = propertyRepo.findNearByProperties(28.512783, 77.036893);

        for (Property property : properties) {
            System.out.println(property);
        }
    }
}
