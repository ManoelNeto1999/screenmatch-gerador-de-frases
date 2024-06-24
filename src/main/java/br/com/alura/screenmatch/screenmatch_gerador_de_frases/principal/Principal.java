package br.com.alura.screenmatch.screenmatch_gerador_de_frases.principal;

import br.com.alura.screenmatch.screenmatch_gerador_de_frases.model.DadosFilmesSeries;
import br.com.alura.screenmatch.screenmatch_gerador_de_frases.model.FilmesSeries;
import br.com.alura.screenmatch.screenmatch_gerador_de_frases.repository.FilmesSeriesRepository;
import br.com.alura.screenmatch.screenmatch_gerador_de_frases.service.ConsultaChatGPT;
import br.com.alura.screenmatch.screenmatch_gerador_de_frases.service.ConsumoApi;
import br.com.alura.screenmatch.screenmatch_gerador_de_frases.service.ConverteDados;

import java.util.Scanner;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";
    private FilmesSeriesRepository repositorio;

    public Principal(FilmesSeriesRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void menuInicial() {
        var escolha = -1;

        while(escolha != 0) {

            var menu = """
                    1 - Buscar série ou filme para cadrastar no banco.
                    
                    0 - Sair do sistema.
                    """;

            System.out.println(menu);
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    buscarSerieFilme();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }

    private void buscarSerieFilme() {
        DadosFilmesSeries dados = getDados();
        var nome = getNomePersonagem(dados);
        var frase = getFraseDoPersonagem(dados, nome);
        FilmesSeries filmesSeries = new FilmesSeries(dados, nome, frase);
        System.out.println(filmesSeries);
        repositorio.save(filmesSeries);
    }


    private DadosFilmesSeries getDados() {
        System.out.println("Digite o nome de uma série ou filme que deseja: ");
        var nome = sc.nextLine();
        var resposta = consumo.obterDados(ENDERECO + nome.replace(" ", "+") + API_KEY);
        DadosFilmesSeries dados = conversor.obterDados(resposta, DadosFilmesSeries.class);
        return dados;
    }

    private String getNomePersonagem(DadosFilmesSeries dadosFilmesSeries) {
        var nome = ConsultaChatGPT.obterPersonagem(dadosFilmesSeries.titulo());
        nome.trim();
        return nome;
    }

    private String getFraseDoPersonagem(DadosFilmesSeries dadosFilmesSeries, String nome) {
        var frase = ConsultaChatGPT.obterFrase(nome, dadosFilmesSeries.titulo());
        frase.trim();
        return frase;
    }
}
