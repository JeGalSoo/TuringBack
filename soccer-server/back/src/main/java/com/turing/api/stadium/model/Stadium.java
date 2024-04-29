package com.turing.api.stadium.model;

import com.turing.api.player.model.Player;
import com.turing.api.schedule.model.Schedule;
import com.turing.api.team.model.Team;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity(name="stadiums")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="stadium_id")
    private String stadiumId;
    private String stadiumName;
    private String hometeamId;
    private Integer seatCount;
    private String address;
    private String ddd;
    private String tel;

    @OneToMany(mappedBy = "stadiumId",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "stadiumId",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Team> teams;

}
