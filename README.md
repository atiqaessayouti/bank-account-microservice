# Bank Account Service — TP 11 étapes

Microservice bancaire Spring Boot 3.5.7 / Java 17+, ajouté au dépôt e-commerce original. **Il démarre indépendamment des autres services.**

## Démarrer

Ouvrir le dossier `bank-account-service` dans IntelliJ ou VS Code, activer Lombok/annotation processing, puis dans ce dossier :

```bash
mvn clean test
mvn spring-boot:run
```

Port 8085. La base H2 est **en mémoire**, réinitialisée à chaque redémarrage. Deux comptes de démonstration sont insérés.

## Correspondance exacte avec l'énoncé

1. Spring Boot + Web/JPA/H2/Lombok : `pom.xml`
2. Entité JPA Compte : `entities/Compte.java` et `TypeCompte.java`
3. DAO : `repositories/CompteRepository.java`
4. Test DAO : `src/test/.../CompteRepositoryTest.java` et données au démarrage
5. API REST CRUD : `web/CompteRestController.java`
6. Postman : collection `postman/Bank-Account-Service.postman_collection.json`
7. Swagger : http://localhost:8085/swagger-ui.html ; OpenAPI : http://localhost:8085/v3/api-docs
8. Spring Data REST + projection : http://localhost:8085/data-rest/comptes?projection=solde
9. DTOs/Mapper : `dtos/` et `mappers/`
10. Service métier : `services/` ; le contrôleur REST utilise le service
11. GraphQL : `graphql/schema.graphqls` et `web/CompteGraphQLController.java` ; http://localhost:8085/graphiql

## REST (Postman ou curl)

- `GET http://localhost:8085/api/comptes`
- `GET http://localhost:8085/api/comptes/{id}`
- `POST http://localhost:8085/api/comptes` JSON : `{"solde":15000,"type":"COURANT"}`
- `PUT http://localhost:8085/api/comptes/{id}` JSON : `{"solde":17000,"type":"EPARGNE"}`
- `DELETE http://localhost:8085/api/comptes/{id}`

## GraphQL

`POST http://localhost:8085/graphql`, body JSON `{"query":"{ allComptes { id solde type dateCreation } }"}`

Ou dans GraphiQL :

```graphql
query { allComptes { id solde type dateCreation } }
mutation { addCompte(compte: {solde: 1500, type: COURANT}) { id solde type } }
```

## H2 Console

http://localhost:8085/h2-console ; JDBC URL `jdbc:h2:mem:bankdb`, username `sa`, password vide.

## Notes

- REST métier et Spring Data REST exposent deux voies d'accès aux comptes pour démontrer les techniques du TP.
- `BigDecimal` est utilisé en Java pour les soldes ; le schéma GraphQL pédagogique utilise `Float` (une vraie API financière nécessiterait un scalaire Decimal).
- Projet académique, sans authentification ni gestion de transactions bancaires réelles.
- Les commandes Maven et tests doivent être exécutés sur un poste disposant de Maven et d'un accès aux dépendances.
