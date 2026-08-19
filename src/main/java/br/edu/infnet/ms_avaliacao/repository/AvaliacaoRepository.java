package br.edu.infnet.ms_avaliacao.repository;

import br.edu.infnet.ms_avaliacao.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    List<Avaliacao> findByRestauranteId(Long restauranteId);
}