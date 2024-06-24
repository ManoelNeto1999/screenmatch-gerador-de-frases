package br.com.alura.screenmatch.screenmatch_gerador_de_frases.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosFilmesSeries(@JsonAlias("Title") String titulo,
                                @JsonAlias("Poster") String banner) {
}
