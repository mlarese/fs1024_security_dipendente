package it.epicode.fs1024_security.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private int eta;
    private String indirizzo;
    private String telefono;
}
