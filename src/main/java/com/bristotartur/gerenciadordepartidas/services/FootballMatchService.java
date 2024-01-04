package com.bristotartur.gerenciadordepartidas.services;

import com.bristotartur.gerenciadordepartidas.domain.match.structure.FootballMatch;
import com.bristotartur.gerenciadordepartidas.enums.ExceptionMessages;
import com.bristotartur.gerenciadordepartidas.exceptions.NotFoundException;
import com.bristotartur.gerenciadordepartidas.repositories.FootballMatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável por gerenciar operações relacionadas a partidas de futebol (FootballMatch).
 * Esta classe implementa a estratégia MatchSportStrategy para fornecer comportamentos padronizados
 * relacionados à especialização de FootballMatch.
 */
@Service
@AllArgsConstructor
public class FootballMatchService implements MatchSportStrategy<FootballMatch> {

    private final FootballMatchRepository footballMatchRepository;

    /**
     * Busca uma partida de futebol pelo seu ID.
     *
     * @param id Identificador único da partida de futebol.
     * @return Uma instância de FootballMatch correspondente ao ID fornecido.
     * @throws NotFoundException Se nenhuma partida de futebol correspondente ao ID for encontrada.
     */
    @Override
    public FootballMatch findMatchSportById(Long id) {

        return footballMatchRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.FOOTBALL_MATCH_NOT_FOUND.message));
    }

    /**
     * Cria uma nova instância de FootballMatch e a persiste no banco de dados.
     *
     * @return Uma nova instância de FootballMatch criada e salva no banco de dados.
     */
    @Override
    public FootballMatch createNewMatchSport() {
        return footballMatchRepository.save(new FootballMatch());
    }

}
