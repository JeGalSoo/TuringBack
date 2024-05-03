package com.turing.api.team.service;

import com.turing.api.stadium.model.Stadium;
import com.turing.api.team.model.Team;
import com.turing.api.team.model.TeamDto;
import java.util.List;

public interface TeamService {

    default Team dtoToEntity(TeamDto dto,Stadium stadium){
        return Team.builder()
        .teamId(dto.getTeamId())
        .regionName(dto.getRegionName())
        .teamName(dto.getTeamName())
        .eTeamName(dto.getETeamName())
        .origYyyy(dto.getOrigYyyy())
        .zipCode1(dto.getZipCode1())
        .zipCode2(dto.getZipCode2())
        .address(dto.getAddress())
        .ddd(dto.getDdd())
        .tel(dto.getTel())
        .fax(dto.getFax())
        .homepage(dto.getHomepage())
        .owner(dto.getOwner())
        .stadiumId(stadium)
        .build();
    }
    
    default TeamDto entityToDto(Team ent){
        return TeamDto.builder()
        .id(ent.getId())
        .teamId(ent.getTeamId())
        .regionName(ent.getRegionName())
        .teamName(ent.getTeamName())
        .eTeamName(ent.getETeamName())
        .origYyyy(ent.getOrigYyyy())
        .zipCode1(ent.getZipCode1())
        .zipCode2(ent.getZipCode2())
        .address(ent.getAddress())
        .ddd(ent.getDdd())
        .tel(ent.getTel())
        .fax(ent.getFax())
        .homepage(ent.getHomepage())
        .owner(ent.getOwner())
        .modDate(String.valueOf(ent.getModDate()))
        .regDate(String.valueOf(ent.getRegDate()))
        .build();
    }
    
    // List<TeamDto> findAllTeam();
    // List<TeamDto> findTeamByPosionAndRegionName();
    // List<TeamDto> findTeamByPlayerHeightAndRegionName();
    // List<TeamDto> findAllTeamByPositionNull();
    // List<TeamDto> findTeamAngHeightByRegionName();
    // List<TeamDto> findTeamByPosition();
}
