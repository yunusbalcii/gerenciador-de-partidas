package com.bristotartur.gerenciadordepartidas.services;

import com.bristotartur.gerenciadordepartidas.domain.match.structure.Match;
import com.bristotartur.gerenciadordepartidas.domain.match.structure.VolleyballMatch;
import com.bristotartur.gerenciadordepartidas.enums.ExceptionMessages;
import com.bristotartur.gerenciadordepartidas.exceptions.NotFoundException;
import com.bristotartur.gerenciadordepartidas.repositories.MatchRepository;
import com.bristotartur.gerenciadordepartidas.repositories.VolleyballMatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável por gerenciar operações relacionadas a partidas de vôlei ({@link VolleyballMatch}).
 * Esta classe implementa a estratégia {@link MatchStrategy} para fornecer comportamentos padronizados
 * relacionados à especialização de {@link VolleyballMatch}.
 *
 * @see VolleyballMatchRepository
 * @see MatchSportServiceFactory
 * @see GeneralMatchSportService
 */
@Service
@AllArgsConstructor
public class VolleyballMatchService implements MatchStrategy<VolleyballMatch> {

    private final MatchRepository matchRepository;

    /**
     * Busca uma partida de vôlei pelo seu ID.
     *
     * @param id Identificador único da partida de vôlei.
     * @return Uma instância de {@link Match} correspondente ao ID fornecido.
     * @throws NotFoundException Se nenhuma partida de vôlei correspondente ao ID for encontrada.
     */
    @Override
    public Match findMatchById(Long id) {

        return matchRepository.findMatchByType(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.VOLLEYBALL_MATCH_NOT_FOUND.message));
    }

    /**
     * Cria uma nova instância de {@link Match} e a persiste no banco de dados.
     *
     * @return Uma nova instância de {@link Match} criada e salva no banco de dados.
     */
    @Override
    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

}
