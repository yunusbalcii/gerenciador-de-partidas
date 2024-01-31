package com.bristotartur.gerenciadordepartidas.mappers;

import com.bristotartur.gerenciadordepartidas.enums.Sports;
import com.bristotartur.gerenciadordepartidas.enums.TeamName;
import com.bristotartur.gerenciadordepartidas.utils.MatchTestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static com.bristotartur.gerenciadordepartidas.utils.RandomIdUtil.getRandomLongId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class MatchMapperTest {

    @Autowired
    private MatchMapper matchMapper;

    @Test
    @DisplayName("Should convert scores fields to zero when mapped to new Match")
    void Should_ConvertScoresToZero_When_MappedToNewMatch() {

        var matchDto = MatchTestUtil.createNewMatchDto(Sports.CHESS, any(), any(), any());
        var result = matchMapper.toNewMatch(matchDto, any());

        assertEquals(result.getTeamScoreA(), 0);
        assertEquals(result.getTeamScoreB(), 0);
    }

    @Test
    @DisplayName("Should map entities to their referent fields in Match when they are passed to new Match")
    void Should_MapEntitiesToTheirReferentFieldsInMatch_When_TheyArePassedToNewMatch() {

        var teamA = TeamName.MESTRES_DE_OBRAS;
        var teamB = TeamName.ATOMICA;
        var matchDto = MatchTestUtil.createNewMatchDto(Sports.VOLLEYBALL, teamA, teamB, any());

        var result = matchMapper.toNewMatch(matchDto, any());

        assertEquals(result.getTeamA(), teamA);
        assertEquals(result.getTeamB(), teamB);
    }

    @Test
    @DisplayName("Should update Match when new values are passed")
    void Should_UpdateMatch_When_NewValuesArePassed() {

        var sport = Sports.HANDBALL;
        var teamA = TeamName.PAPA_LEGUAS;
        var teamB = TeamName.TWISTER;
        var teamC = TeamName.UNICONTTI;

        var match = MatchTestUtil.createNewMatch(teamA, teamB, any());
        var matchDto = MatchTestUtil.createNewMatchDto(Sports.HANDBALL, teamA, teamC, any());

        var result = matchMapper.toExistingMatch(getRandomLongId(), matchDto, any());

        assertNotEquals(result, match);
    }

    @Test
    @DisplayName("Should map Match fields to their equivalent fields in ExposingMatchDto when Match passed to map")
    void Should_MapMatchFieldsToTheirEquivalentFieldsInExposingMatchDto_When_MatchIsPassedToMap() {

        var teamA = TeamName.ATOMICA;
        var teamB = TeamName.MESTRES_DE_OBRAS;
        var match = MatchTestUtil.createNewMatch(teamA, teamB, any());

        var sport = Sports.FUTSAL;
        var result = matchMapper.toNewExposingMatchDto(match, sport);

        assertEquals(result.getTeamA(), teamA);
        assertEquals(result.getTeamB(), teamB);
        assertEquals(result.getSport(), sport);
    }

}