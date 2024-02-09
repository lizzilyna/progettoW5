package it.epicode.progettoW5.services;

import it.epicode.progettoW5.entities.Edificio;
import it.epicode.progettoW5.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;
    public void salvaEdificio (Edificio edificio){edificioRepository.save(edificio);
    }

    public void aggiornaEdificio (Edificio edificio) {
        Optional<Edificio>optionalEdificio=edificioRepository.findById(edificio.getId());
        if (optionalEdificio.isPresent()){
            Edificio existingEdificio=optionalEdificio.get();
            existingEdificio.setNome(edificio.getNome());
            existingEdificio.setIndirizzo(edificio.getIndirizzo());
            edificioRepository.save(existingEdificio);
        }
    }
    public Optional<Edificio>cercaEdificioPerId(Long id) {
        return edificioRepository.findById(id);
    }
    public void cancellaEdificioPerId(Long id) {
        edificioRepository.deleteById(id);
    }
}
