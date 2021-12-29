package com.tot.backend.service;

import com.tot.backend.model.Property;
import com.tot.backend.payload.request.PropertyDto;
import com.tot.backend.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public Property addProperty(PropertyDto propertyDto) {
        UserDetailsImpl userDetails = (UserDetailsImpl)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Property property = new Property(userDetails.getId(),
                propertyDto.getName(), propertyDto.getAddress(),
                propertyDto.getSummary(), propertyDto.getLat(), propertyDto.getLang(), propertyDto.getType());

        return propertyRepository.save(property);
    }
}
