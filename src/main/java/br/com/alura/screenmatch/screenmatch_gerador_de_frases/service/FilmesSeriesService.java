package br.com.alura.screenmatch.screenmatch_gerador_de_frases.service;

import br.com.alura.screenmatch.screenmatch_gerador_de_frases.dto.FilmesSeriesDTO;
import br.com.alura.screenmatch.screenmatch_gerador_de_frases.model.FilmesSeries;
import br.com.alura.screenmatch.screenmatch_gerador_de_frases.repository.FilmesSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FilmesSeriesService {
    @Autowired
    private FilmesSeriesRepository repositorio;
    private Random random = new Random();

    public Optional<FilmesSeriesDTO> obterAleatorio() {
        List<FilmesSeries> filmesSeries = repositorio.findAll();

        FilmesSeries f = filmesSeries.get(obterNumeroAleatorio());

        Optional<FilmesSeriesDTO> teste = Optional.of(new FilmesSeriesDTO(f.getId(), f.getTitulo(), f.getFrase(), f.getPersonagem(), f.getPoster()));

        return teste;
    }

    private Integer obterNumeroAleatorio() {
        return  random.nextInt(6 - 0);
    }

}
