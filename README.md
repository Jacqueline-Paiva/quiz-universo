# Desafio do Universo — Feira de Ciências 9º ano

Aplicação Java 21 / Spring Boot MVC / Thymeleaf / MySQL com 20 perguntas iniciais e sorteio de 10 por tentativa.

## Rodar no VS Code
1. Instale Java 21, Maven, MySQL, VS Code e extensões **Extension Pack for Java** e **Spring Boot Extension Pack**.
2. Execute no MySQL: `CREATE DATABASE quiz_universo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;`
3. Configure `DB_USER` e `DB_PASSWORD` nas variáveis de ambiente, ou ajuste `src/main/resources/application.properties` apenas localmente. Nunca publique senhas no Git.
4. Abra a pasta `quiz-universo` no VS Code e execute `mvn spring-boot:run` no terminal.
5. Acesse `http://localhost:8080`.

## Regras
- Apelido único (ignora maiúsculas/minúsculas), com código secreto para novas tentativas.
- Uma melhor pontuação por apelido no ranking; até 50 participantes.
- Cada tentativa sorteia 10 perguntas e registra resultado no banco.
- O gabarito fica no servidor e nunca é enviado ao HTML.
- O ranking se atualiza a cada 30 segundos.

## Publicação e QR Code
Para visitantes acessarem via celular, publique o serviço Java em hospedagem com suporte a Java e MySQL persistente, configure `DB_URL`, `DB_USER`, `DB_PASSWORD`, `PORT` e HTTPS. Gere um QR Code apontando para a URL pública após a publicação. `localhost` não funciona em outros celulares.

## Observações
Protótipo educacional: antes de expor publicamente, adicionar proteção contra envio automatizado/rate limiting, monitoramento, backup do banco e testes automatizados. Para feira com rede instável, teste a conectividade e a capacidade do provedor antes do evento.
