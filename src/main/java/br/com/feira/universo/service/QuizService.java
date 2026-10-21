package br.com.feira.universo.service;

import br.com.feira.universo.model.Participante;
import br.com.feira.universo.model.Pergunta;
import br.com.feira.universo.model.Resultado;
import br.com.feira.universo.repository.ParticipanteRepository;
import br.com.feira.universo.repository.PerguntaRepository;
import br.com.feira.universo.repository.ResultadoRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QuizService {
    private final ParticipanteRepository participantes;
    private final PerguntaRepository perguntas;
    private final ResultadoRepository resultados;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public QuizService(ParticipanteRepository p, PerguntaRepository q, ResultadoRepository r) {
        participantes = p;
        perguntas = q;
        resultados = r;
    }

    public Participante entrar(String apelido, String senha) {
        if (apelido == null) {
            throw new IllegalArgumentException("Apelido: use 3 a 30 caracteres (letras, números, espaço, _ ou -).");
        }

        apelido = apelido.trim();

        if (!apelido.matches("[\\p{L}0-9 _-]{3,30}")) {
            throw new IllegalArgumentException("Apelido: use 3 a 30 caracteres (letras, números, espaço, _ ou -).");
        }

        if (senha == null || senha.length() < 4 || senha.length() > 72) {
            throw new IllegalArgumentException("Código secreto deve ter entre 4 e 72 caracteres.");
        }

        Optional<Participante> existente = participantes.findByApelidoIgnoreCase(apelido);
        if (existente.isPresent()) {
            if (!encoder.matches(senha, existente.get().senhaHash)) {
                throw new IllegalArgumentException("Apelido já utilizado. Informe o código correto ou escolha outro apelido.");
            }
            return existente.get();
        }

        return participantes.save(new Participante(apelido, encoder.encode(senha)));
    }

    public List<Pergunta> sortear() {
        List<Pergunta> lista = new ArrayList<>(perguntas.findAll());
        if (lista.size() < 10) {
            throw new IllegalStateException("É necessário cadastrar pelo menos 10 perguntas.");
        }
        Collections.shuffle(lista);
        return new ArrayList<>(lista.subList(0, 10));
    }

    public int corrigir(Participante p, List<Long> ids, Map<String, String> respostas) {
        if (p == null || p.id == null) {
            throw new IllegalArgumentException("Participante não informado.");
        }

        Participante participante = participantes.findById(p.id)
                .orElseThrow(() -> new IllegalArgumentException("Participante não encontrado."));

        int pontos = 0;
        for (Long id : ids) {
            Pergunta q = perguntas.findById(id).orElseThrow();
            if (q.correta.equalsIgnoreCase(respostas.getOrDefault("q" + id, ""))) {
                pontos++;
            }
        }

        resultados.save(new Resultado(participante, pontos));
        return pontos;
    }

    public List<Object[]> ranking() {
        return resultados.ranking().stream().limit(50).toList();
    }
}
