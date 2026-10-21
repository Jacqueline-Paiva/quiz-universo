package br.com.feira.universo.config;

import br.com.feira.universo.model.Pergunta;
import br.com.feira.universo.repository.PerguntaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

@Configuration
public class DadosIniciais {
    @Bean
    CommandLineRunner inserir(PerguntaRepository repo) {
        return args -> {
            if (repo.count() > 0)
                return;
            String[][] dados = {
                    { "Qual é a idade aproximada do Universo?", "4,6 bilhões de anos", "13,8 bilhões de anos",
                            "100 milhões de anos", "50 bilhões de anos", "B" },
                    { "Qual é a estrela mais próxima da Terra?", "Sirius", "Proxima Centauri", "Sol", "Betelgeuse",
                            "C" },
                    { "O que é uma galáxia?", "Um planeta gigante",
                            "Conjunto de estrelas, gás, poeira e matéria escura", "Uma lua", "Um cometa", "B" },
                    { "Como se chama nossa galáxia?", "Andrômeda", "Via Láctea", "Triângulo", "Sombrero", "B" },
                    { "O que é um ano-luz?", "Uma unidade de tempo", "A velocidade de um planeta",
                            "A distância percorrida pela luz em um ano", "O brilho de uma estrela", "C" },
                    { "Qual planeta é conhecido como planeta vermelho?", "Vênus", "Júpiter", "Marte", "Netuno", "C" },
                    { "O que é o Universo observável?", "Tudo o que existe necessariamente",
                            "A região da qual a luz teve tempo de chegar até nós", "Só o Sistema Solar",
                            "Apenas a Via Láctea", "B" },
                    { "O que causa as fases da Lua?", "A sombra da Terra sempre", "Mudança na forma da Lua",
                            "A porção iluminada visível da Terra", "As nuvens", "C" },
                    { "Qual é o maior planeta do Sistema Solar?", "Terra", "Saturno", "Júpiter", "Urano", "C" },
                    { "O que é uma nebulosa?", "Nuvem de gás e poeira no espaço", "Um buraco negro",
                            "Uma lua congelada", "Um tipo de foguete", "A" },
                    { "Qual telescópio espacial foi lançado em 2021?", "Hubble", "James Webb", "Kepler", "Galileu",
                            "B" },
                    { "O que mantém os planetas em órbita do Sol?", "Magnetismo terrestre", "Vento solar", "Gravidade",
                            "Luz das estrelas", "C" },
                    { "O que é um buraco negro?", "Uma região onde a gravidade impede a luz de escapar",
                            "Um planeta apagado", "Um vazio sem matéria", "Uma estrela fria", "A" },
                    { "Qual galáxia grande é vizinha da Via Láctea?", "Andrômeda", "Centauro A", "Messier 87",
                            "Pequena Nuvem de Magalhães", "A" },
                    { "O Sol é classificado como o quê?", "Planeta", "Satélite", "Estrela", "Galáxia", "C" },
                    { "O que é a radiação cósmica de fundo?", "Luz refletida pela Lua",
                            "Radiação remanescente do Universo primordial", "Calor do Sol", "Sinal de rádio terrestre",
                            "B" },
                    { "Qual planeta tem anéis especialmente visíveis?", "Mercúrio", "Marte", "Saturno", "Vênus", "C" },
                    { "Qual é o satélite natural da Terra?", "Europa", "Titã", "Lua", "Fobos", "C" },
                    { "O que é uma supernova?", "Explosão estelar muito energética", "Nascimento de um planeta",
                            "Um eclipse", "Uma chuva de meteoros", "A" },
                    { "Por que vemos estrelas no passado?", "Porque a luz leva tempo para viajar",
                            "Porque elas não existem mais", "Porque a Terra gira ao contrário",
                            "Porque telescópios atrasam imagens", "A" }
            };
            for (String[] d : dados)
                repo.save(new Pergunta(d[0], d[1], d[2], d[3], d[4], d[5]));
        };
    }
}
