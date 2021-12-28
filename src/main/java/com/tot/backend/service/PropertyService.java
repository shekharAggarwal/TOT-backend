package com.tot.backend.service;

import com.tot.backend.payload.request.PropertyDto;
import com.tot.backend.model.Property;
import com.tot.backend.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public Property addProperty(PropertyDto propertyDto) {
        Property property = new Property();
        return propertyRepository.save(property);
    }
}
