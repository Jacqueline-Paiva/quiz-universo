package br.com.feira.universo.config;

import br.com.feira.universo.model.Pergunta;
import br.com.feira.universo.repository.PerguntaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DadosIniciais {

    @Bean
    CommandLineRunner inserir(PerguntaRepository repo) {
        return args -> {

            // Insere as perguntas somente quando o banco está vazio.
            if (repo.count() > 0) {
                return;
            }

            String[][] dados = {

                // UNIVERSO E COSMOLOGIA
                {"Qual é a idade aproximada do Universo?",
                 "4,6 bilhões de anos", "13,8 bilhões de anos",
                 "100 milhões de anos", "50 bilhões de anos", "B"},

                {"O que é o Universo observável?",
                 "Tudo o que existe necessariamente",
                 "A região da qual a luz teve tempo de chegar até nós",
                 "Só o Sistema Solar", "Apenas a Via Láctea", "B"},

                {"O que é um ano-luz?",
                 "Uma unidade de tempo", "A velocidade de um planeta",
                 "A distância percorrida pela luz em um ano",
                 "O brilho de uma estrela", "C"},

                {"O que é a radiação cósmica de fundo?",
                 "Luz refletida pela Lua",
                 "Radiação remanescente do Universo primordial",
                 "Calor do Sol", "Sinal de rádio terrestre", "B"},

                {"Por que vemos estrelas no passado?",
                 "Porque a luz leva tempo para viajar",
                 "Porque elas não existem mais",
                 "Porque a Terra gira ao contrário",
                 "Porque telescópios atrasam imagens", "A"},

                {"O que descreve a teoria do Big Bang?",
                 "Uma explosão de uma estrela",
                 "A expansão do Universo a partir de um estado quente e denso",
                 "A formação da Lua", "A colisão entre galáxias", "B"},

                {"O que significa dizer que o Universo está se expandindo?",
                 "Que os planetas estão aumentando de tamanho",
                 "Que todas as estrelas estão explodindo",
                 "Que as distâncias entre galáxias distantes tendem a aumentar",
                 "Que a Terra está se afastando do Sol", "C"},

                {"Qual é a velocidade aproximada da luz no vácuo?",
                 "30 mil km/s", "300 mil km/s",
                 "3 mil km/s", "3 milhões de km/s", "B"},

                {"O que é matéria escura?",
                 "Matéria que não emite luz e é detectada por seus efeitos gravitacionais",
                 "Poeira preta encontrada na Lua",
                 "Matéria que existe somente em buracos negros",
                 "Um tipo de planeta sem atmosfera", "A"},

                {"O que é energia escura?",
                 "Energia produzida pelo Sol",
                 "Energia liberada pelos buracos negros",
                 "Nome dado ao fenômeno associado à expansão acelerada do Universo",
                 "Eletricidade presente nas estrelas", "C"},

                // GALÁXIAS
                {"O que é uma galáxia?",
                 "Um planeta gigante",
                 "Conjunto de estrelas, gás, poeira e matéria escura",
                 "Uma lua", "Um cometa", "B"},

                {"Como se chama nossa galáxia?",
                 "Andrômeda", "Via Láctea",
                 "Triângulo", "Sombrero", "B"},

                {"Qual galáxia grande é vizinha da Via Láctea?",
                 "Andrômeda", "Centauro A",
                 "Messier 87", "Pequena Nuvem de Magalhães", "A"},

                {"Qual é o formato geral da Via Láctea?",
                 "Elíptico", "Espiral barrada",
                 "Esférico perfeito", "Irregular", "B"},

                {"O que existe no centro da Via Láctea?",
                 "Um planeta gigante",
                 "Uma estrela azul",
                 "Um buraco negro supermassivo",
                 "Uma segunda Lua", "C"},

                {"Como se chama o buraco negro supermassivo no centro da Via Láctea?",
                 "Sagittarius A*", "Andrômeda X",
                 "Centauri B", "Kepler 22", "A"},

                {"O que são galáxias elípticas?",
                 "Galáxias com formato aproximadamente oval",
                 "Galáxias feitas somente de gás",
                 "Galáxias sem estrelas",
                 "Galáxias que orbitam planetas", "A"},

                {"Qual é o nome da galáxia que deverá interagir e se fundir com a Via Láctea no futuro distante?",
                 "Sombrero", "Andrômeda",
                 "Triângulo", "Centauro A", "B"},

                // ESTRELAS E FENÔMENOS
                {"Qual é a estrela mais próxima da Terra?",
                 "Sirius", "Proxima Centauri",
                 "Sol", "Betelgeuse", "C"},

                {"O Sol é classificado como o quê?",
                 "Planeta", "Satélite",
                 "Estrela", "Galáxia", "C"},

                {"O que é uma nebulosa?",
                 "Nuvem de gás e poeira no espaço",
                 "Um buraco negro", "Uma lua congelada",
                 "Um tipo de foguete", "A"},

                {"O que é uma supernova?",
                 "Explosão estelar muito energética",
                 "Nascimento de um planeta",
                 "Um eclipse", "Uma chuva de meteoros", "A"},

                {"O que é um buraco negro?",
                 "Uma região onde a gravidade impede a luz de escapar",
                 "Um planeta apagado",
                 "Um vazio sem matéria",
                 "Uma estrela fria", "A"},

                {"Qual processo produz a maior parte da energia do Sol?",
                 "Combustão de oxigênio",
                 "Fusão nuclear",
                 "Atrito entre planetas",
                 "Eletricidade atmosférica", "B"},

                {"Qual é a principal composição do Sol?",
                 "Oxigênio e carbono",
                 "Ferro e níquel",
                 "Hidrogênio e hélio",
                 "Nitrogênio e oxigênio", "C"},

                {"O que é uma estrela de nêutrons?",
                 "Uma estrela feita de gelo",
                 "Um remanescente estelar extremamente denso",
                 "Um planeta sem atmosfera",
                 "Uma estrela que não possui gravidade", "B"},

                {"Qual característica influencia fortemente a cor de uma estrela?",
                 "Sua temperatura superficial",
                 "A quantidade de planetas",
                 "Sua distância da Terra",
                 "A quantidade de luas", "A"},

                {"Em geral, qual estrela possui maior temperatura superficial?",
                 "Vermelha", "Amarela",
                 "Azul", "Laranja", "C"},

                {"O que é uma constelação?",
                 "Um grupo de estrelas necessariamente próximas entre si",
                 "Uma região do céu com um padrão aparente de estrelas",
                 "Uma galáxia pequena",
                 "Um conjunto de planetas", "B"},

                {"O que é um pulsar?",
                 "Um planeta que gira rapidamente",
                 "Uma estrela de nêutrons que emite feixes de radiação",
                 "Um tipo de cometa",
                 "Uma galáxia em formação", "B"},

                // SISTEMA SOLAR
                {"Qual planeta é conhecido como planeta vermelho?",
                 "Vênus", "Júpiter",
                 "Marte", "Netuno", "C"},

                {"Qual é o maior planeta do Sistema Solar?",
                 "Terra", "Saturno",
                 "Júpiter", "Urano", "C"},

                {"Qual planeta tem anéis especialmente visíveis?",
                 "Mercúrio", "Marte",
                 "Saturno", "Vênus", "C"},

                {"Qual é o satélite natural da Terra?",
                 "Europa", "Titã",
                 "Lua", "Fobos", "C"},

                {"O que causa as fases da Lua?",
                 "A sombra da Terra sempre",
                 "Mudança na forma da Lua",
                 "A porção iluminada visível da Terra",
                 "As nuvens", "C"},

                {"O que mantém os planetas em órbita do Sol?",
                 "Magnetismo terrestre",
                 "Vento solar",
                 "Gravidade",
                 "Luz das estrelas", "C"},

                {"Qual é o planeta mais próximo do Sol?",
                 "Vênus", "Mercúrio",
                 "Terra", "Marte", "B"},

                {"Qual é o planeta mais distante do Sol entre os oito planetas?",
                 "Saturno", "Urano",
                 "Netuno", "Júpiter", "C"},

                {"Qual planeta possui a maior temperatura média na superfície?",
                 "Mercúrio", "Vênus",
                 "Marte", "Júpiter", "B"},

                {"O que é um eclipse solar?",
                 "Quando a Terra fica entre o Sol e a Lua",
                 "Quando a Lua passa entre a Terra e o Sol",
                 "Quando o Sol desaparece definitivamente",
                 "Quando Marte bloqueia a luz do Sol", "B"},

                {"O que é um eclipse lunar?",
                 "Quando a Lua entra na sombra da Terra",
                 "Quando o Sol entra na sombra da Lua",
                 "Quando a Lua deixa de refletir luz para sempre",
                 "Quando Vênus passa atrás do Sol", "A"},

                {"Qual planeta é conhecido por girar com seu eixo muito inclinado?",
                 "Marte", "Mercúrio",
                 "Urano", "Júpiter", "C"},

                {"O que é um cometa?",
                 "Um corpo formado principalmente por gelo, poeira e rochas",
                 "Uma estrela pequena",
                 "Um planeta que perdeu a atmosfera",
                 "Um satélite artificial", "A"},

                {"Onde fica o cinturão principal de asteroides?",
                 "Entre Terra e Marte",
                 "Entre Marte e Júpiter",
                 "Entre Saturno e Urano",
                 "Além de Netuno", "B"},

                {"Por que Plutão é classificado como planeta anão?",
                 "Porque não possui gravidade",
                 "Porque não orbita o Sol",
                 "Porque não limpou a vizinhança de sua órbita",
                 "Porque não possui luas", "C"},

                // EXPLORAÇÃO ESPACIAL
                {"Qual telescópio espacial foi lançado em 2021?",
                 "Hubble", "James Webb",
                 "Kepler", "Galileu", "B"},

                {"Quem foi o primeiro ser humano a viajar ao espaço?",
                 "Neil Armstrong", "Yuri Gagarin",
                 "Buzz Aldrin", "Alan Shepard", "B"},

                {"Em que ano o ser humano pisou na Lua pela primeira vez?",
                 "1957", "1961",
                 "1969", "1981", "C"},

                {"Qual missão levou os primeiros seres humanos à superfície da Lua?",
                 "Apollo 11", "Apollo 13",
                 "Voyager 1", "Artemis I", "A"},

                {"Qual é o principal objetivo científico do telescópio James Webb?",
                 "Transportar astronautas",
                 "Observar o Universo em infravermelho",
                 "Explorar o interior da Terra",
                 "Coletar rochas de Marte", "B"}
            };

            for (String[] d : dados) {
                repo.save(new Pergunta(
                    d[0], d[1], d[2], d[3], d[4], d[5]
                ));
            }

            System.out.println("Quiz do Universo: "
                    + repo.count() + " perguntas cadastradas!");
        };
    }
}