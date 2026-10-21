package br.com.feira.universo.model;

import jakarta.persistence.*;

@Entity
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false, unique = true, length = 30)
    public String apelido;
    @Column(nullable = false)
    public String senhaHash;

    public Participante() {
    }

    public Participante(String a, String h) {
        apelido = a;
        senhaHash = h;
    }
}
