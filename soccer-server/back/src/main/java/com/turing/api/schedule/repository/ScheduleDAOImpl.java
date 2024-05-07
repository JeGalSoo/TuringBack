package com.turing.api.schedule.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.turing.api.schedule.model.QSchedule;
import com.turing.api.schedule.model.QScheduleDto;
import com.turing.api.schedule.model.ScheduleDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ScheduleDAOImpl implements ScheduleDAO{

    private final JPAQueryFactory queryFactory;
    private final QSchedule schedule = QSchedule.schedule;

    @Override
    public List<ScheduleDto> getAllSchedulesDSL() {
        return queryFactory.select(QSchedule.schedule.id,
                        QSchedule.schedule.scheDate,
                        QSchedule.schedule.awayScore,
                        QSchedule.schedule.awayteamId,
                        QSchedule.schedule.gubun,
                        QSchedule.schedule.homeScore,
                        QSchedule.schedule.hometeamId,
                        QSchedule.schedule.stadiumId.stadiumId)
                .from(QSchedule.schedule)
                .fetch()
                .stream()
                .map(tuple -> ScheduleDto.builder()
                        .scheDate(tuple.get(QSchedule.schedule.scheDate))
                        .hometeamId(tuple.get(QSchedule.schedule.hometeamId))
                        .gubun(tuple.get(QSchedule.schedule.gubun))
                        .awayScore(tuple.get(QSchedule.schedule.awayScore))
                        .awayteamId(tuple.get(QSchedule.schedule.awayteamId))
                        .homeScore(tuple.get(QSchedule.schedule.homeScore))
                        .hometeamId(tuple.get(QSchedule.schedule.hometeamId))
                        .stadiumId(tuple.get(QSchedule.schedule.stadiumId.stadiumId))
                        .build())
                .toList();
//        return queryFactory.select(
//                new QScheduleDto(
//                        schedule.id,
//                        schedule.scheDate,
//                        schedule.gubun,
//                        schedule.hometeamId,
//                        schedule.awayteamId,
//                        schedule.homeScore,
//                        schedule.awayScore))
//                .from(QSchedule.schedule)
//                .fetch();
    }
}
