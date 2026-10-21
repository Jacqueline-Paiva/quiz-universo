package br.com.feira.universo.repository;

import br.com.feira.universo.model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
    @org.springframework.data.jpa.repository.Query("select r.participante.apelido, max(r.pontos) from Resultado r group by r.participante.id, r.participante.apelido order by max(r.pontos) desc, r.participante.apelido asc")
    java.util.List<Object[]> ranking();
}
