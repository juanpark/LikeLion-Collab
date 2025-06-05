package com.sec01;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Travels")
@AllArgsConstructor
@NoArgsConstructor
public @Data class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String location;
    private String googleMapsUrl;

    private LocalDate startDate;
    private LocalDate endDate;

    private String description;
    private String imageUrl;
}