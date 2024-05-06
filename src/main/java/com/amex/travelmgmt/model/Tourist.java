package com.amex.travelmgmt.model;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tourist_id", nullable = false)
    private Long touristId;


    @Column(name = "tourist_name")
    private String touristName;

    @Column(name = "boarded_location")
    private String boardedLocation;

    @Column(name = "destination_location")
    private String destinationLocation;

    @Column(name = "mode_of_travel")
    private String modeOfTravel;

    @Column(name = "paid_full_amount")
    private Boolean isPaidFullAmount;
}
