package com.bristotartur.gerenciadordepartidas.dtos;

import com.bristotartur.gerenciadordepartidas.domain.team.Team;
import com.bristotartur.gerenciadordepartidas.enums.PenaltyCardColor;
import com.bristotartur.gerenciadordepartidas.enums.Sports;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record PenaltyCardDto(@NotNull PenaltyCardColor color,
                             @NotNull @JsonProperty("team_id") Long teamId,
                             @NotNull @JsonProperty("match_sport_id") Long matchSportId,
                             @NotNull Sports sport) {
}
