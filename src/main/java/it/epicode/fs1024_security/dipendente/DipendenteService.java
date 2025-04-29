package it.epicode.fs1024_security.dipendente;

import it.epicode.fs1024_security.auth.AppUser;
import it.epicode.fs1024_security.auth.Role;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class DipendenteService {

    private final DipendenteRepository dipendenteRepository;

   public List<Dipendente> findAll() {
        return dipendenteRepository.findAll();
    }

    public void deleteById(Long id) {
        dipendenteRepository.deleteById(id);
    }

    public Dipendente findById(Long id) {
        return dipendenteRepository.findById(id).orElse(null);
    }

    public Dipendente update(Long id,  DipendenteRequest request, AppUser utenteLoggato) {
       Dipendente dipendente = dipendenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato con id: " + id));

       // se volessi abilitare anche l'utente amministrare a modificare qualsiasi profilo posso
       // controllare il ruolo dell'utente loggato per verificare che sia un admin

       boolean isAdmin = utenteLoggato.getRoles().contains(Role.ROLE_ADMIN);

       if(dipendente.getAppUser().getId() == utenteLoggato.getId() || isAdmin) {
           BeanUtils.copyProperties(request, dipendente);
       } else {
           throw new IllegalArgumentException("Non sei autorizzato a modificare questo dipendente");
       }

       return dipendenteRepository.save(dipendente);


    }

}
