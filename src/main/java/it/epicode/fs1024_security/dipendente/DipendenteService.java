package it.epicode.fs1024_security.dipendente;

import lombok.RequiredArgsConstructor;
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

}
