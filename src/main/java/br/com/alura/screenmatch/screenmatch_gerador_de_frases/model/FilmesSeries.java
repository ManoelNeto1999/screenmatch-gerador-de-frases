package br.com.alura.screenmatch.screenmatch_gerador_de_frases.model;

import jakarta.persistence.*;

@Entity
@Table(name = "series_filmes")
public class FilmesSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String frase;
    private String personagem;
    private String poster;

    public FilmesSeries() {}

    public FilmesSeries(DadosFilmesSeries dadosFilmesSeries, String nome, String frase) {
        this.titulo = dadosFilmesSeries.titulo();
        this.poster = dadosFilmesSeries.banner();
        this.personagem = nome.trim();
        this.frase = frase.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getPersonagem() {
        return personagem;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return
                "titulo='" + titulo + '\'' +
                ", frase='" + frase + '\'' +
                ", personagem='" + personagem + '\'' +
                ", poster='" + poster;
    }
}
