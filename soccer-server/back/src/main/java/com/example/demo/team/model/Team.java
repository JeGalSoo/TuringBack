package com.turing.api.team.model;

import jakarta.persistence.Entity;

@Entity()
public class Team {
private Long id;
private String regionName;
private String teamName;
public String eTeamName;
public String origYYYY;
public String zipCode1;
public String zipCode2;
public String address;
public String ddd;
public String tel;
public String fax;
public String homepage;
public String owner;
}
