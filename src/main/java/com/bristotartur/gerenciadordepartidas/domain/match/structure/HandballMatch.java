package com.bristotartur.gerenciadordepartidas.domain.match.structure;

import com.bristotartur.gerenciadordepartidas.domain.match.specifications.Goal;
import com.bristotartur.gerenciadordepartidas.domain.match.specifications.PenaltyCard;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "HANDBALL_MATCH")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HandballMatch extends MatchSport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "matchSport", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Match> matches;

    @JsonManagedReference
    @OneToMany(mappedBy = "matchSport", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Goal> goals;

    @JsonManagedReference
    @OneToMany(mappedBy = "matchSport", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PenaltyCard> penaltyCards;

}
