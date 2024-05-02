package com.turing.api.team.service;

import org.springframework.stereotype.Service;

import com.turing.api.team.model.TeamDto;
import com.turing.api.team.repository.TeamRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

  private final TeamRepository repository;

  @Override
  public List<Map<String,Object>> sql1() {
    return repository.aaa();
    // return null;
  }

  @Override
  public List<TeamDto> sql10() {
    String position = "GK";
    String regionName1 = "수원";
    String regionName2 = "대전";
    // List<TeamDto> list = repository.sql10(position, regionName1, regionName2).stream()
    //     .map(i -> entityToDto(i))
    //     .collect(Collectors.toList());
    // return list;
    return null;
  }

  @Override
  public List<TeamDto> sql12() {
    String regionName1 = "수원";
    String regionName2 = "대전";
    // List<TeamDto> list = repository.sql12(regionName1, regionName2).stream()
    //     .map(i -> entityToDto(i))
    //     .collect(Collectors.toList());
    // return list;
    return null;
  }

  @Override
  public List<TeamDto> sql13() {
    // List<TeamDto> list = repository.sql13().stream()
    //     .map(i -> entityToDto(i))
    //     .collect(Collectors.toList());
    // return list;
    return null;
  }

  public List<TeamDto> sql19() {
    String regionName = "인천";
    // List<TeamDto> list = repository.sql19(regionName).stream()
    //     .map(i -> entityToDto(i))
    //     .collect(Collectors.toList());
    // return list;
    return null;
  }

  @Override
  public List<TeamDto> sql20() {
    // String position = "MF";
    // List<TeamDto> list = repository.sql19(position).stream()
    //     .map(i -> entityToDto(i))
    //     .collect(Collectors.toList());
    // return list;
    return null;
  }

  @Override
  public List<TeamDto> sql21() {
    String position = "MF";
    // List<TeamDto> list = repository.sql19(position).stream()
    //     .map(i -> entityToDto(i))
    //     .collect(Collectors.toList());
    // return list;
    return null;
  }

}
