package com.bristotartur.gerenciadordepartidas.domain.match.structure;

import com.bristotartur.gerenciadordepartidas.domain.match.specifications.Goal;
import com.bristotartur.gerenciadordepartidas.domain.match.specifications.PenaltyCard;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@DiscriminatorValue("FUTSAL")
@Data
@RequiredArgsConstructor
public class FutsalMatch extends Match {

    @JsonManagedReference
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Goal> goals;

    @JsonManagedReference
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PenaltyCard> penaltyCards;

}
