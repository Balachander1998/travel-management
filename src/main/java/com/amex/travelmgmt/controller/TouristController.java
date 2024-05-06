package com.amex.travelmgmt.controller;

import com.amex.travelmgmt.dto.Response;
import com.amex.travelmgmt.dto.TouristDTO;
import com.amex.travelmgmt.model.Tourist;
import com.amex.travelmgmt.service.TouristService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class TouristController {

    @Autowired
    private TouristService touristService;

    private static final Logger logger = LoggerFactory.getLogger(TouristController.class);

    //  1 Creates a tourist entry on the MySQL DB
    @PostMapping("/tourist/create")
    public Response createTourist(@RequestBody TouristDTO touristDTO) {
        logger.info("Tourist DTO...{}", touristDTO);
        return touristService.createTourist(touristDTO);
    }

    @GetMapping("/tourist/all")
    public List<Tourist> getAllTourist(){
        return touristService.getAllTourists();
    }

    @PutMapping("/tourist/update")
    public Response updateTouristDetails(@RequestParam Integer touristId, @RequestBody TouristDTO touristDTO){
        return touristService.updateTouristDetails(touristId, touristDTO);
    }

    @DeleteMapping("/tourist/delete/{touristId}")
    public void deleteTouristDetails(@PathVariable Integer touristId){
        touristService.deleteTouristDetails(touristId);
    }

}
