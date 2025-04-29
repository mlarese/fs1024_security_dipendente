package it.epicode.fs1024_security.dipendente;


import it.epicode.fs1024_security.auth.AppUser;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DipendenteRequest {
    private String nome;
    private String cognome;
    private int eta;
    private String indirizzo;
    private String telefono;
}
