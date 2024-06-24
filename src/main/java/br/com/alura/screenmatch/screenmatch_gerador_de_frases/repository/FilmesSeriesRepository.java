package br.com.alura.screenmatch.screenmatch_gerador_de_frases.repository;

import br.com.alura.screenmatch.screenmatch_gerador_de_frases.model.FilmesSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FilmesSeriesRepository extends JpaRepository<FilmesSeries, Long> {

}
