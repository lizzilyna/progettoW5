package it.epicode.progettoW5.services;

import it.epicode.progettoW5.entities.Postazione;
import it.epicode.progettoW5.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public void salvaPostazione(Postazione postazione) {
        postazioneRepository.save(postazione);
    }
    public void aggiornaPostazione(Postazione postazione) {
        Optional<Postazione> optionalPostazione = postazioneRepository.findById(postazione.getId());
        if (optionalPostazione.isPresent()) {
            Postazione existingPostazione = optionalPostazione.get();
            existingPostazione.setDescrizione(postazione.getDescrizione());
            existingPostazione.setTipoPostazione(postazione.getTipoPostazione());

            postazioneRepository.save(existingPostazione);
        }
    }

    public Optional<Postazione> cercaPostazionePerId(Long id) {
        return postazioneRepository.findById(id);
    }

    public void cancellaPostazionePerId(Long id) {
        postazioneRepository.deleteById(id);
    }
}