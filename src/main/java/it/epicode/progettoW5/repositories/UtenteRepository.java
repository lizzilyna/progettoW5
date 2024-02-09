package it.epicode.progettoW5.repositories;

import it.epicode.progettoW5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
