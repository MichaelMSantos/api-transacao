
# Transação API

Este projeto é uma API REST desenvolvida para gerenciar transações e calcular estatísticas com base nas transações realizadas nos últimos 60 segundos (ou mais, dependendo da configuração do usuário).
Trata-se de uma solução para o <a href="https://github.com/rafaellins-itau/desafio-itau-vaga-99-junior" target="_blank">desafio proposto pelo Itaú<a/>, que decidi implementar como forma de colocar meus conhecimentos em prática.

## Requisitos

Java: JDK 21 ou superior.
Maven: Versão 3.8.1 ou superior.
Docker (opcional).

##  Configuração do projeto

```bash
 mvn clean install # Compilação do projeto
```
```bash
mvn spring-boot:run # Executar o projeto
```

### Docker (Opcional)

```bash
docker build -t api-transacoes 
docker run -p 8080:8080 api-transacoes
```

## Documentação da API
A documentação da API pode ser acessada através da seguinte URL:
http://localhost:8080/swagger-ui/index.html,
desde que o projeto esteja em execução localmente.