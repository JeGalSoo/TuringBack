package com.turing.api.player.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@SuppressWarnings("hiding")
@Repository
public interface PlayerJpqlRepository<Player> {

    @Query("select distinct new map(p.position) from players p")
    List<Map<String, String>> getAllPosition();   //2

    @Query("select distinct new map(IFNULL(nullif(p.position,''),'newone'))from players p")
    List<Map<String, Object>> getAllPositionincludeNull();  //3

    @Query("SELECT new map(p.playerName) FROM players p WHERE p.position = 'GK' AND p.teamId.teamId = 'K02'")
    List<Map<String, Object>> getAllByPositionAndTeamId();  //4


    @Query("SELECT new map(p.playerName) FROM players p WHERE p.playerName LIKE '고%' AND p.height >= '170' AND" +
            " p.teamId =(SELECT t FROM teams t WHERE t.regionName = '수원')")
    List<Map<String, Object>> getAllByPlayerNameAndHeightAndRegion();  //5-1

    @Query("""
            SELECT new map(p.playerName)
            FROM players p
            WHERE p.playerName LIKE '고%' AND p.height >= '170' AND p.teamId.teamId ='K02'""")
    List<Map<String, Object>> getAllByPlayerNameAndHeightAndTeamId(); //5

    @Query("""
            SELECT new map(p.playerName)
            FROM players p
            WHERE p.position = 'MF'
            AND p.height >= '170'
            AND p.height <= '180'
            AND p.teamId.teamId in (SELECT t.teamId
            FROM teams t
            WHERE t.teamName = '삼성블루윙즈'OR t.teamName='드래곤즈')""")
    List<Map<String, Object>> getAllByPlayerNameAndHeightAndTeamName(); //6

    @Query("""
            SELECT p.playerName
            FROM players p
            WHERE p.position = 'GK' AND p.teamId.teamId =(SELECT t.teamId
            												FROM teams t
            												WHERE t.regionName = '수원')""")
    List<Map<String, Object>> getAllByPositionAndRegion(); //7



    @Query("""
SELECT new map(p.playerName , case when p.height=' ' then '0' else p.height end ,case when p.weight=' ' then '0' else p.weight end)
FROM players p
WHERE p.teamId.teamId = (SELECT t.teamId
FROM teams t
WHERE t.regionName = '서울')
ORDER BY p.height DESC, p.weight DESC""")
    List<Map<String, Object>> getPlayerNameAndHeigtAndWeightByRegion(); //8

    @Query("""
SELECT p.playerName, p.position,
case when p.height=' ' then '0' else concat(p.height,'cm') end,
case when p.weight=' ' then '0' else concat(p.weight,'kg') end,
case when round(cast(p.weight as int)/(cast( p.height as int)/100*cast(p.height as int)/100),0) =null then 'NONE'
    else  round(cast(p.weight as int)/(cast(p.height as int)/100*cast(p.height as int) /100),0) end AS BMI
FROM players p
WHERE p.teamId.teamId =  (SELECT t.teamId
						FROM teams t
						WHERE t.regionName = '서울')
ORDER BY p.playerName DESC""")
    List<Map<String, Object>> getPlayerNameAndHeigtAndWeightAndBMIByRegion(); //9



}
