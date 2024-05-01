package com.turing.api.team.service;

import org.springframework.stereotype.Service;

import com.turing.api.team.model.TeamDto;
import com.turing.api.team.repository.TeamRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

  private final TeamRepository repository;

  // @Override
  // public List<TeamDto> findAllTeam() {
  //   List<TeamDto> list = repository.findAllTeam().stream()
  //       .map(i->entityToDto(i))
  //       .collect(Collectors.toList());
  //   return list;
  // }

  // @Override
  // public List<TeamDto> findTeamByPosionAndRegionName() {
  //   String position = "GK";
  //   String regionName1 = "수원";
  //   String regionName2 = "대전";
  //   List<TeamDto> list = repository.findTeamByPosionAndRegionName(position, regionName1, regionName2).stream()
  //       .map(i -> entityToDto(i))
  //       .collect(Collectors.toList());
  //   return list;
  // }

  // @Override
  // public List<TeamDto> findTeamByPlayerHeightAndRegionName() {
  //   String regionName1 = "수원";
  //   String regionName2 = "대전";
  //   List<TeamDto> list = repository.findTeamByPlayerHeightAndRegionName(regionName1, regionName2).stream()
  //       .map(i -> entityToDto(i))
  //       .collect(Collectors.toList());
  //   return list;
  // }

  // @Override
  // public List<TeamDto> findAllTeamByPositionNull() {
  //   List<TeamDto> list = repository.findAllTeamByPositionNull().stream()
  //       .map(i -> entityToDto(i))
  //       .collect(Collectors.toList());
  //   return list;
  // }

  // public List<TeamDto> findTeamAngHeightByRegionName() {
  //   String regionName = "인천";
  //   List<TeamDto> list = repository.findTeamAngHeightByRegionName(regionName).stream()
  //       .map(i -> entityToDto(i))
  //       .collect(Collectors.toList());
  //   return list;
  // }

  // @Override
  // public List<TeamDto> findTeamByPosition() {
  //   String position = "MF";
  //   List<TeamDto> list = repository.findTeamByPosition(position).stream()
  //       .map(i -> entityToDto(i))
  //       .collect(Collectors.toList());
  //   return list;
  // }

  // @Override
  // public List<TeamDto> find5PlayerByHeight() {
  //   List<TeamDto> list = repository.find5PlayerByHeight().stream()
  //       .map(i -> entityToDto(i))
  //       .collect(Collectors.toList());
  //   return list;
  // }

}
