package br.com.alura.screenmatch.screenmatch_gerador_de_frases.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
