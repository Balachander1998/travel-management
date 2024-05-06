package com.amex.travelmgmt.dto;

import lombok.Data;

@Data
public class TouristDTO {

    private Integer touristId;

    private String touristName;

    private String boardedLocation;

    private String destinationLocation;

    private String modeOfTravel;

    private Boolean isPaidFullAmount;
}
