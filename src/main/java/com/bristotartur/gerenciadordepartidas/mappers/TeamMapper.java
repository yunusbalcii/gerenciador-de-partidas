package com.bristotartur.gerenciadordepartidas.mappers;

import com.bristotartur.gerenciadordepartidas.domain.match.Match;
import com.bristotartur.gerenciadordepartidas.domain.team.Team;
import com.bristotartur.gerenciadordepartidas.dtos.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeamMapper {

    public static final TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    /**
     * Realiza o mapeamento de um um objeto do tipo TeamDto para um novo objeto do tipo Team.
     * Os valores do campo points deste novo objeto Team será sempre 0, mesmo que o DTO possua
     * algum valor em seu campo correspondente.
     *
     * @param teamDto DTO a ser mapeado.
     * @return um novo objeto do tipo Team.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "teamDto.teamName.name")
    @Mapping(target = "points", constant = "0")
    @Mapping(target = "matchesAsTeamA", ignore = true)
    @Mapping(target = "matchesAsTeamB", ignore = true)
    @Mapping(target = "goals", ignore = true)
    Team toNewTeam(TeamDto teamDto);

    /**
     * Realiza o mapeamento de um objeto do tipo TeamDto para um objeto existente do tipo Team,
     * atualizando os valores de seus respectivos campos aos correspondentes do DTO.
     *
     * @param id identificador do objeto existente.
     * @param teamDto DTO a ser mapeado.
     * @return um objeto do tipo Team com seus valores atualizados.
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "teamDto.teamName.name")
    @Mapping(target = "matchesAsTeamA", ignore = true)
    @Mapping(target = "matchesAsTeamB", ignore = true)
    @Mapping(target = "goals", ignore = true)
    Team toExistingTeam(Long id, TeamDto teamDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "teamDto.teamName.name")
    @Mapping(target = "matchesAsTeamA", ignore = true)
    @Mapping(target = "matchesAsTeamB", ignore = true)
    @Mapping(target = "goals", ignore = true)
    Team toExistingTeam(Long id, TeamDto teamDto, List<Match> matches);
}
