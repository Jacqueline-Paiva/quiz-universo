package br.com.feira.universo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne(optional = false)
    public Participante participante;
    public int pontos;
    public LocalDateTime criadoEm = LocalDateTime.now();

    protected Resultado() {
    }

    public Resultado(Participante p, int n) {
        participante = p;
        pontos = n;
    }
}
