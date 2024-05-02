package com.turing.api.team.model;

import com.turing.api.common.BaseEntity;
import com.turing.api.player.model.Player;
import com.turing.api.stadium.model.Stadium;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "teams")
@Data
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team extends BaseEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="team_id")
    private String teamId;
    @Column(name = "region_name")
    private String regionName;
    @Column(name = "team_name")
    private String teamName;
    @Column(name = "e_team_name")
    private String eTeamName;
    @Column(name = "orig_yyyy")
    private String origYyyy;
    @Column(name = "zip_code1")
    private String zipCode1;
    @Column(name = "zip_code2")
    private String zipCode2;
    private String address;
    private String ddd;
    private String tel;
    private String fax;
    private String homepage;
    private String owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id", nullable = true, referencedColumnName = "stadium_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Stadium stadiumId;

    @OneToMany(mappedBy = "teamId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Player> players;

}