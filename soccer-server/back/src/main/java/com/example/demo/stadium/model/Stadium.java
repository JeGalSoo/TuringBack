package com.example.demo.stadium.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity(name="stadiums")
public class Stadium {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String stadiumId;
    private String name;
    private Integer seatCount;
    private String address;
    private String ddd;
    private String tel;

}
