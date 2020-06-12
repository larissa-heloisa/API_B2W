# API_B2W Desafio Desenvolvedoras
Olá desenvolvedoras!! 

O projeto é uma API rest, onde você poderá inserir os planetas do filme Star Wars, colocando seu nome, clima e terreno. E a API Rest,
irá te retornar o ID do planeta, nome, clima, Terreno e também a quantidade aparições nos filmes. Para isso, foi preciso consumir
a API publica do Star Wars -> https://swapi.dev/.

Foram utilizada as seguintes tecnologias:

-Linguagem Java versão 1.8
-Framework Spring Boot versão 2.3.0 RELEASE
-MongoDB
-Swagger para documentar a API.

Observações: Para testarem a API no ambiente de vocês, é necessário fazer a configuração do servidor MongoDB. 
A configuração do projeto tá no arquivo application.properties.

Funcionalidades Criadas:

1. Listar Planetas (GET - http://localhost:9090/planets/);
2. Buscar por nome (GET - http://localhost:9090/planets/planet/{name});
3. Buscar por Id (GET - http://localhost:9090/planets/{id});
4. Adicionar planeta (POST - http://localhost:9090/planets/);
5. Remover planeta (DEL - http://localhost:9090/planets/{id});

Para melhor visualização dos end-points, achei melhor documentar no Swagger. A URL para visualizar é: localhost:9090/swagger-ui.html

Foi bem legal fazer essa API, espero que gostem!!!
