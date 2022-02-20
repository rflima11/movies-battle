# Movie Battle
## _API Rest para teste técnico Let's Code - Rodolfo Ferreira de Lima_
[![N|Solid](https://pbs.twimg.com/profile_images/1453086096489959428/s915qXTs_200x200.jpg)](https://nodesource.com/products/nsolid)
## Filmes

Para inicializar a base de filmes, foi feito um webscraping do [IMDB](https://breakdance.github.io/breakdance/) de 50 filmes do gênero de ação.

## Swagger
O swagger-ui está em um subindo junto ao docker-compose, para acessá-lo basta seguir para:
```sh
http:localhost:8080
```

## OpenAPI 3.0 Collection

```bash

movie-battle
    |
    |doc
    |    |___openapi.json

```

## Docker

Foi disponibilizado um **docker-compose.yml na raiz do projeto** para que a aplicação seja facilmente testada. Basta executar:

```sh
docker-compose up
```
## Endpoints

Porta padrão: **5000**

| Host | Método | Endpoint | Objetivo |
 | ------ | ------ | ------ | ------ |
| http://localhost:5000 | POST | /movie-battle/v1/iniciar | Iniciar uma nova partida
| http://localhost:5000 | GET | /movie-battle/v1/iniciar-rodada | Iniciar uma nova rodada
| http://localhost:5000 | GET | /movie-battle/v1/escolher-opcao | Escolher uma opção entre filmes
| http://localhost:5000 | GET | movie-battle/v1/encerrar  | Encerrar o jogo
| http://localhost:5000 | GET | movie-battle/v1/ranking | Buscar o ranking dos melhores jogadores

craftbeer
|
|docs
|    |___craftbeer-spec

## Usuários

A seguir segue a lista de usuários criados que serão necessários para o jogo, o protocolo usado para autenticação foi o **Basic Authentication**

| Nome | Usuário | Senha |
| ------ | ------ | ------ |
| Rodolfo | rflima | 123
| Helena | usuario2 | 123
| Fabi | usuario3 | 123
| Ricardo | usuario4  | 123
| Carlos | usuario5 | 123
| David | usuario6 | 123
| Chico | usuario7 | 123
| Elias | usuario8 | 123
| Rafaela | usuario9 | 123
| Henrique | usuario10 | 123

## YouTube

Fiz um pequeno vídeo de explicação sobre o projeto:

```sh
https://www.youtube.com/watch?v=JyfRQYRpSeo
```

Muito obrigado, pela oportunidade.

