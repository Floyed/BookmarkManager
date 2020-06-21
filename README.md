# Bookmark Manager

`database` contains scripts to setup the database. The database of choice for this project is [PostgreSQL](https://www.postgresql.org) 12.

`backend` contains the backend web server. It is a Java 11 [Spring Boot](https://spring.io/projects/spring-boot) app that signs in users via their Microsoft account, serves the static web assets, and offers a [GraphQL](https://graphql.org) API. 

`frontend` contains the [React](https://reactjs.org) frontend. We use [material-ui](https://material-ui.com) as a component library for the project, and [Apollo](https://www.apollographql.com/docs/react/) as our GraphQL client.
