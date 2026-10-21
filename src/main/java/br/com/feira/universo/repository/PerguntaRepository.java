package br.com.feira.universo.repository;

import br.com.feira.universo.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
}
