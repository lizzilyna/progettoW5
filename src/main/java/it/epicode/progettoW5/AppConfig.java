package it.epicode.progettoW5;

import it.epicode.progettoW5.entities.Edificio;
import it.epicode.progettoW5.entities.Postazione;
import it.epicode.progettoW5.entities.TipoPostazione;
import it.epicode.progettoW5.entities.Utente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.List;
import java.util.ArrayList;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean("postazione1")
            public Postazione postazione1(){
    Postazione postazione=new Postazione();
    postazione.setCodice("P1");
    postazione.setDescrizione("scrivania");
    postazione.setTipoPostazione(TipoPostazione.PRIVATO);
    postazione.setNumeroMassimoOccupanti(1);
    return postazione;

}
    @Bean("utente1")
    public Utente utente1() {
        Utente utente = new Utente();
        utente.setUsername("utente1");
        utente.setNomeCompleto("Nome Utente 1");
        utente.setEmail("utente1@example.com");

        return utente;
    }

    @Bean("edificio1")
    public Edificio edificio1() {
        Edificio edificio = new Edificio();
        edificio.setNome("Edificio A");
        edificio.setIndirizzo("Via Dante, 123");
        edificio.setCitta("Roma");

        return edificio;
    }

    @Bean("listaPostazioni")
    public List<Postazione> listaPostazioni() {
        List<Postazione> postazioni = new ArrayList<>();
        postazioni.add(postazione1());
        // Aggiungi altre postazioni alla lista se necessario
        return postazioni;
    }
}
