package it.epicode.progettoW5.services;

import it.epicode.progettoW5.entities.Utente;
import it.epicode.progettoW5.repositories.UtenteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public void salvaUtente(Utente utente) {
        utenteRepository.save(utente);
    }
    public void aggiornaUtente(Utente utente) {
        Optional<Utente> optionalUtente = utenteRepository.findById(utente.getId());
        if (optionalUtente.isPresent()) {
            Utente existingUtente = optionalUtente.get();
            existingUtente.setNomeCompleto(utente.getNomeCompleto());
            existingUtente.setEmail(utente.getEmail());

            utenteRepository.save(existingUtente);
        }
    }

    public Optional<Utente> cercaUtentePerId(Long id) {
        return utenteRepository.findById(id);
    }

    public void cancellaUtentePerId(Long id) {
        utenteRepository.deleteById(id);
    }
}
