package br.com.alura.screenmatch.screenmatch_gerador_de_frases.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterPersonagem(String texto) {
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_APIKEY"));

        CompletionRequest request = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("me retorne somente um nome de algum personagem de "
                        + texto + "somente o nome por favor")
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(request);
        return resposta.getChoices().get(0).getText();
    }

    public static String obterFrase(String nome, String titulo) {
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_APIKEY"));

        CompletionRequest request = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("me retorne somente um frase em português entre aspas desse personagem "
                        + nome + "da serie " + titulo
                        +" quero somente a frase sem mais nenhuma informação")
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(request);
        return resposta.getChoices().get(0).getText();
    }
}
