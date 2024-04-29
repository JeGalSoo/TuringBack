package com.turing.api.schedule.model;

import com.turing.api.stadium.model.Stadium;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class ScheduleDto {

    private Long id;
    private String scheDate;
    private String gubun;
    private String hometeamId;
    private String awayteamId;
    private Integer homeScore;
    private Integer awayScore;


    private Long stadiumId;

}
