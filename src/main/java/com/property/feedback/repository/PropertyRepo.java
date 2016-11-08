package com.property.feedback.repository;

import com.property.feedback.repository.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by nehaojha on 07/11/16.
 */
public interface PropertyRepo extends JpaRepository<Property, Integer> {

    List<Property> findByLatitudeAndLongitude(double latitude, double longitude);

    @Query(value = "SELECT *," +
            "    ( 6371 * acos( cos( radians(?1) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - " +
            "    radians(?2) ) + sin( radians(?1) ) * sin( radians( latitude ) ) ) ) AS distance" +
            "     FROM properties" +
            "     HAVING distance < 20" +
            "     ORDER BY distance" +
            "     LIMIT 0 , 30", nativeQuery = true)
    List<Property> findNearByProperties(double latitude, double longitude);
}
