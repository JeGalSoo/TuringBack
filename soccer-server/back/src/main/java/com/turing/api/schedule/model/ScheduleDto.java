package com.turing.api.schedule.model;

import com.querydsl.core.annotations.QueryProjection;
import com.turing.api.stadium.model.Stadium;
import lombok.Builder;
import lombok.Getter;


@Builder
public class ScheduleDto {

    private Long id;
    private String scheDate;
    private String gubun;
    private String hometeamId;
    private String awayteamId;
    private Integer homeScore;
    private Integer awayScore;
    private String stadiumId;

    @QueryProjection
    public ScheduleDto(Long id, String scheDate, String gubun, String hometeamId, String awayteamId, Integer homeScore, Integer awayScore, String stadiumId) {
        this.id = id;
        this.scheDate = scheDate;
        this.gubun = gubun;
        this.hometeamId = hometeamId;
        this.awayteamId = awayteamId;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.stadiumId = stadiumId;
    }
}
