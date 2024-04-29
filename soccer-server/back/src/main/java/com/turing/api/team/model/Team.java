package com.turing.api.team.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="teams")
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="team_id")
    private String teamId;

    @Column(name="region_name")
    private String regionName;

    @Column(name="team_name")
    private String teamName;

    @Column(name="e_team_name")
    private String eTeamName;

    @Column(name="orig_yyyy")
    private String origYYYY;

    @Column(name="zip_code1")
    private String zipCode1;

    @Column(name="zip_code2")
    private String zipCode2;

    private String address;
    private String ddd;
    private String tel;
    private String fax;
    private String homepage;
    private String owner;



}