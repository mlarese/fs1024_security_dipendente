package it.epicode.fs1024_security.dipendente;

import it.epicode.fs1024_security.auth.AppUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Dipendente")

public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(cascade={CascadeType.REMOVE, CascadeType.PERSIST})
    private AppUser appUser;

    private String nome;
    private String cognome;
    private int eta;
    private String indirizzo;
    private String telefono;


}
