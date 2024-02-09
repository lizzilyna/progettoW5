package it.epicode.progettoW5;

import it.epicode.progettoW5.entities.Edificio;
import it.epicode.progettoW5.entities.Postazione;
import it.epicode.progettoW5.entities.TipoPostazione;
import it.epicode.progettoW5.entities.Utente;
import it.epicode.progettoW5.services.EdificioService;
import it.epicode.progettoW5.services.PostazioneService;
import it.epicode.progettoW5.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
@Order(1)
public class GestionePrenotazioniRunner implements CommandLineRunner{

    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private EdificioService edificioService;
    private Logger logger = LoggerFactory.getLogger("progettoW5");
    public void run (String... args) throws Exception{
        logger.info("Runner per la gestione delle prenotazioni");

        Postazione postazione = new Postazione();
        postazione.setCodice("P1");
        postazione.setDescrizione("Postazione di lavoro");
        postazione.setTipoPostazione(TipoPostazione.PRIVATO);
        postazione.setNumeroMassimoOccupanti(1);
        postazioneService.salvaPostazione(postazione);

        Utente utente = new Utente();
        utente.setUsername("utente1");
        utente.setNomeCompleto("Nome Utente 1");
        utente.setEmail("utente1@example.com");
        utenteService.salvaUtente(utente);

        Edificio edificio = new Edificio();
        edificio.setNome("Edificio A");
        edificio.setIndirizzo("Via Edificio A, 123");
        edificio.setCitta("Città A");
        edificioService.salvaEdificio(edificio);
    }
}




