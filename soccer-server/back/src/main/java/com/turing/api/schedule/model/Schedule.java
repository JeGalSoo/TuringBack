package com.turing.api.schedule.model;


import com.turing.api.stadium.model.Stadium;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="schedules")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String scheDate;
    private String gubun;
    private String hometeamId;
    private String awayteamId;
    private Integer homeScore;
    private Integer awayScore;

    @ManyToOne
    @JoinColumn(name = "Stadium_id")
    private Stadium stadiumId;
}
