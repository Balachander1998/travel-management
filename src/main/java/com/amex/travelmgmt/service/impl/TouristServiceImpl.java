package com.amex.travelmgmt.service.impl;

import com.amex.travelmgmt.TouristRepository;
import com.amex.travelmgmt.dto.Response;
import com.amex.travelmgmt.dto.TouristDTO;
import com.amex.travelmgmt.model.Tourist;
import com.amex.travelmgmt.service.TouristService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristServiceImpl implements TouristService {

    private static final Logger logger = LoggerFactory.getLogger(TouristServiceImpl.class);

    @Autowired
    private TouristRepository touristRepository;

    @Override
    public Response createTourist(TouristDTO touristDTO) {
        Tourist tourist = new Tourist();
        Response response = new Response();
        tourist.setTouristName(touristDTO.getTouristName());
        tourist.setBoardedLocation(touristDTO.getBoardedLocation());
        tourist.setDestinationLocation(touristDTO.getDestinationLocation());
        tourist.setModeOfTravel(touristDTO.getModeOfTravel());
        tourist.setIsPaidFullAmount(touristDTO.getIsPaidFullAmount());
        logger.info("Tourist Model...{}", tourist);
        tourist = touristRepository.save(tourist);
        if(tourist != null){
            response.setResponseCode(201);
            response.setResponseMessage("Tourist details saved successfully");
        }else{
            response.setResponseCode(000);
            response.setResponseMessage("Something went wrong...");
            logger.info("Tourist details....{}", tourist);
        }
        return response;
    }

    @Override
    public List<Tourist> getAllTourists() {
        return touristRepository.findAll();
    }

    @Override
    public Response updateTouristDetails(Integer touristId, TouristDTO touristDTO) {
        Response response = new Response();
        Optional<Tourist> touristDetailsOptional = touristRepository.findById(Long.valueOf(touristId));
        if(touristDetailsOptional.isPresent()){
            logger.info("Tourist details found....{}", touristDetailsOptional.get());
            Tourist tourist = touristDetailsOptional.get();
            tourist.setTouristName(touristDTO.getTouristName());
            tourist.setBoardedLocation(touristDTO.getBoardedLocation());
            tourist.setDestinationLocation(touristDTO.getDestinationLocation());
            tourist.setIsPaidFullAmount(touristDTO.getIsPaidFullAmount());
            tourist.setModeOfTravel(touristDTO.getModeOfTravel());
            tourist  = touristRepository.save(tourist);
            if(tourist != null){
                response.setResponseCode(201);
                response.setResponseMessage("Tourist details saved successfully");
            }else{
                response.setResponseCode(000);
                response.setResponseMessage("Something went wrong...");
                logger.info("Tourist details....{}", tourist);
            }
        }else{
            logger.error("Tourist Info not found for the id...{}", touristId);
            response.setResponseCode(404);
            response.setResponseMessage("No Tourist found for the ID..."+ String.valueOf(touristId));
        }

        return response;
    }

    @Override
    public void deleteTouristDetails(Integer touristId) {
        Response response = new Response();
        touristRepository.deleteById(Long.valueOf(touristId));
    }
}
