package com.amex.travelmgmt.service;

import com.amex.travelmgmt.dto.Response;
import com.amex.travelmgmt.dto.TouristDTO;
import com.amex.travelmgmt.model.Tourist;

import java.util.List;

public interface TouristService {

    public Response createTourist(TouristDTO touristDTO);

    public List<Tourist> getAllTourists();

    public Response updateTouristDetails(Integer touristId, TouristDTO touristDTO);

    public void deleteTouristDetails(Integer touristId);
}
