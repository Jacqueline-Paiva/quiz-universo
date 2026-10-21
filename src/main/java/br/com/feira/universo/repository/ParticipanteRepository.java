package br.com.feira.universo.repository;

import br.com.feira.universo.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    java.util.Optional<Participante> findByApelidoIgnoreCase(String apelido);
}
