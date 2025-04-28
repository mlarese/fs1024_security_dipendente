package it.epicode.fs1024_security.dipendente;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dipendente")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class DipendenteController {
    private final DipendenteService dipendenteService;

    @GetMapping("/{id}")
    public Dipendente findById(Long id) {
        return dipendenteService.findById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<Dipendente> findAll() {
        return dipendenteService.findAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(Long id) {
        dipendenteService.deleteById(id);
    }
}
