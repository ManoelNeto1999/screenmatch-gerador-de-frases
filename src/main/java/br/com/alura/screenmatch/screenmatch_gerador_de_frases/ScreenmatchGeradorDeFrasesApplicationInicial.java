//package br.com.alura.screenmatch.screenmatch_gerador_de_frases;
//
//import br.com.alura.screenmatch.screenmatch_gerador_de_frases.principal.Principal;
//import br.com.alura.screenmatch.screenmatch_gerador_de_frases.repository.FilmesSeriesRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class ScreenmatchGeradorDeFrasesApplicationInicial implements CommandLineRunner {
//	@Autowired
//	private FilmesSeriesRepository repositorio;
//
//	public static void main(String[] args) {
//		SpringApplication.run(ScreenmatchGeradorDeFrasesApplicationInicial.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		Principal principal = new Principal(repositorio);
//		principal.menuInicial();
//	}
//}
