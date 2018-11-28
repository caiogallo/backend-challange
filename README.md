# Invillia recruitment challenge

Este projeto é um desafio de programação.

## Pré-requisitos

Esta aplicação necessita dos seguintes requisitos abaixo para execução:

- docker
- docker-compose
- java 1.8
- maven
- mongodb

## Iniciando a aplicação

Este aplicativo pode ser compilado e executado através do maven ou utilizando o docker-compose. Para a opção com o maven
é necessário que uma instância do mongodb server esteja executando no host local ou será preciso customizar as configurações
de acesso ao banco.

Para executar com o mongodb local, rode o comando:

```shell
mvn clean install -DskipTests springboot:run
```

Caso deseja executar utilizando docker-compose, execute o comando abaixo:

```
docker-compose up
```

Com o compose, não é preciso baixar e executar o mongodb. A imagem do docker para ele será baixada e executada junto a
aplicação.

## Rodando os testes unitários

A aplicação possuí uma suite de testes unitários feita com JUnit que pode ser executada através do comando

```
mvn clean test
```

## Recursos disponível

### Autenticação

Está aplicação está protegida com autenticação basic, as credênciais de acesso padrão são

**username:** admin
**password:** 123

### API Rest

A API rest pode ser verificada a partir da url do swagger

http://localhost:8080/api/swagger-ui.html
