<h1 align="center">
  Kafka Email Service
</h1>


Projeto elaboradopara enviar emails utilizando Apache Kafka e Java Spring Boot.

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring for Apache Kafka](https://spring.io/projects/spring-kafka)
- [Docker Compose](https://docs.docker.com/compose/)
- [PostgreSQL](https://www.postgresql.org/)

## Como Executar

- Clonar repositório git:
```
git clone https://github.com/thalesmaiaa/kafka-email.git
```
- Executar o Kafka:
```
docker-compose up
```
- Executar a aplicação Spring Boot
- Acessar aplicação em `http://localhost:8000`.

## API

- http :8000/send-email
```
HTTP/1.1 200
Connection: keep-alive
Content-Type: application/json
Date: Tue, 05 Mar 2024 19:07:52 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "to": string,
    "subject": string,
    "body": string,
  
}
```

## Variaveis de Ambiente

- Preencher as variáveis de ambiente no arquivo application.properties para poder executar o sitema da maneira esperada.