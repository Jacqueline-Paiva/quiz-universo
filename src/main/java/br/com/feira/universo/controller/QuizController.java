package br.com.feira.universo.controller;

import br.com.feira.universo.model.*;
import br.com.feira.universo.service.QuizService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class QuizController {
    private final QuizService service;

    public QuizController(QuizService s) {
        service = s;
    }

    @GetMapping("/")
    public String inicio() {
        return "inicio";
    }

    @PostMapping("/entrar")
    public String entrar(@RequestParam String apelido, @RequestParam String codigo, HttpSession sess, Model m) {
        try {
            Participante p = service.entrar(apelido, codigo);
            sess.setAttribute("participanteId", p.id);
            sess.setAttribute("apelido", p.apelido);
            return "redirect:/quiz";
        } catch (IllegalArgumentException ex) {
            m.addAttribute("erro", ex.getMessage());
            return "inicio";
        }
    }

    @GetMapping("/quiz")
    public String quiz(HttpSession sess, Model m) {
        if (sess.getAttribute("participanteId") == null)
            return "redirect:/";
        List<Pergunta> qs = service.sortear();

        sess.setAttribute("perguntas", qs.stream().map(q -> q.id).toList());
        m.addAttribute("perguntas", qs);
        m.addAttribute("apelido",
                sess.getAttribute("apelido"));
        return "quiz";
    }

    @PostMapping("/finalizar")
    public String finalizar(@RequestParam Map<String, String> respostas, HttpSession sess, Model m) {
        Object id = sess.getAttribute("participanteId");
        Object questoes = sess.getAttribute("perguntas");
        if (!(id instanceof Long) || !(questoes instanceof List<?>))
            return "redirect:/";

        @SuppressWarnings("unchecked")
        List<Long> ids = (List<Long>) questoes;
        sess.removeAttribute("perguntas");
        Participante p = new Participante();
        p.id = (Long) id;
        int pontos = service.corrigir(p, ids, respostas);
        m.addAttribute("pontos", pontos);
        m.addAttribute("mensagem",
                pontos == 10 ? "Missão perfeita! Você é uma estrela!"
                        : pontos >= 7 ? "Excelente, explorador do cosmos!"
                                : pontos >= 4 ? "Boa viagem! Continue explorando."
                                        : "Todo astronauta começa aprendendo. Tente de novo!");
        return "resultado";
    }

    @GetMapping("/ranking")
    public String ranking(Model m) {
        m.addAttribute("ranking", service.ranking());
        return "ranking";
    }
}
