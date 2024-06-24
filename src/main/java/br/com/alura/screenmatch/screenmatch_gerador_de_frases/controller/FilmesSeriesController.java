package br.com.alura.screenmatch.screenmatch_gerador_de_frases.controller;

import br.com.alura.screenmatch.screenmatch_gerador_de_frases.dto.FilmesSeriesDTO;
import br.com.alura.screenmatch.screenmatch_gerador_de_frases.service.FilmesSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/series")
public class FilmesSeriesController {

    @Autowired
    private FilmesSeriesService servico;

    @GetMapping("/frases")
    public Optional<FilmesSeriesDTO> obterFilmesSeries() {
        return servico.obterAleatorio();
    }
}
