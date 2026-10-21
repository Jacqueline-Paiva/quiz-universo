package br.com.feira.universo.model;

import jakarta.persistence.*;

@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false, length = 500)
    public String enunciado;
    public String a, b, c, d;
    @Column(nullable = false)
    public String correta;

    protected Pergunta() {
    }

    public Pergunta(String e, String a, String b, String c, String d, String correta) {
        this.enunciado = e;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.correta = correta;
    }
}
