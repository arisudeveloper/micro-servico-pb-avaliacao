package br.edu.infnet.ms_avaliacao.controller;

import br.edu.infnet.ms_avaliacao.model.Avaliacao;
import br.edu.infnet.ms_avaliacao.repository.AvaliacaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
@CrossOrigin(origins = "*")
public class AvaliacaoController {

    private final AvaliacaoRepository repository;

    public AvaliacaoController(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Avaliacao criar(@RequestBody Avaliacao avaliacao) {
        return repository.save(avaliacao);
    }

    @GetMapping("/restaurante/{restauranteId}")
    public List<Avaliacao> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return repository.findByRestauranteId(restauranteId);
    }
}