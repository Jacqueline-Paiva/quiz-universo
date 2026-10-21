package br.com.feira.universo.service;

import br.com.feira.universo.model.Participante;
import br.com.feira.universo.model.Pergunta;
import br.com.feira.universo.model.Resultado;
import br.com.feira.universo.repository.ParticipanteRepository;
import br.com.feira.universo.repository.PerguntaRepository;
import br.com.feira.universo.repository.ResultadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class QuizServiceTest {

    @Test
    void entrar_deveAceitarNicknameExistenteComCodigoCorreto() {
        ParticipanteRepository participantes = mock(ParticipanteRepository.class);
        PerguntaRepository perguntas = mock(PerguntaRepository.class);
        ResultadoRepository resultados = mock(ResultadoRepository.class);
        QuizService service = new QuizService(participantes, perguntas, resultados);

        Participante existente = new Participante("Astro", new BCryptPasswordEncoder().encode("1234"));
        existente.id = 9L;
        when(participantes.findByApelidoIgnoreCase("astro")).thenReturn(Optional.of(existente));

        Participante retorno = service.entrar("  astro  ", "1234");

        assertSame(existente, retorno);
    }

    @Test
    void entrar_deveRejeitarNicknameNulo() {
        ParticipanteRepository participantes = mock(ParticipanteRepository.class);
        PerguntaRepository perguntas = mock(PerguntaRepository.class);
        ResultadoRepository resultados = mock(ResultadoRepository.class);
        QuizService service = new QuizService(participantes, perguntas, resultados);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.entrar(null, "1234"));

        assertEquals("Apelido: use 3 a 30 caracteres (letras, números, espaço, _ ou -).", ex.getMessage());
    }

    @Test
    void corrigir_deveSalvarResultadoComParticipantePersistido() {
        ParticipanteRepository participantes = mock(ParticipanteRepository.class);
        PerguntaRepository perguntas = mock(PerguntaRepository.class);
        ResultadoRepository resultados = mock(ResultadoRepository.class);
        QuizService service = new QuizService(participantes, perguntas, resultados);

        Participante participante = new Participante("Astro", "hash");
        participante.id = 42L;
        when(participantes.findById(42L)).thenReturn(Optional.of(participante));

        Pergunta pergunta = new Pergunta("Qual é a capital do Brasil?", "Lisboa", "Rio", "Brasília", "Buenos Aires", "C");
        pergunta.id = 7L;
        when(perguntas.findById(7L)).thenReturn(Optional.of(pergunta));

        Participante tentativa = new Participante("Astro", "hash");
        tentativa.id = 42L;
        int pontos = service.corrigir(tentativa, List.of(7L), Map.of("q7", "C"));

        assertEquals(1, pontos);
        verify(resultados).save(argThat((Resultado resultado) ->
                resultado.participante != null
                        && resultado.participante.id.equals(42L)
                        && resultado.pontos == 1));
    }
}
