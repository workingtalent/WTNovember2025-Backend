# Boekleen app

Voor de Bootcamp specializatie een Fullstack boek leen app.

## Features

## Must haves

- Overzicht boeken (voorraad status)
- Detailpagina boek (boek id, exemplaar id, sticker)
- Boek plaatjes (open api)
- Boek toevoegen, bewerken, verwijderen als trainer
- Boeken uitlenen
- Boek inleveren
- Boek reserveren
- Reservering annuleren
- Reservering naar lening als trainer
- Boek toewijzen aan trainee
- Overzicht van jouw geleende/reservingen boeken
- Overzicht wie welk boek geleend/reservingen heeft als trainer
- Inloggen als trainer of trainee
- Users beheren
- WT huisstijl

## Should have

- Conditie boek bijhouden
- Limiet aantal boeken te leen
- Email/Bericht herinnering verlengen
- Boek verlengen
- Boek reviews (alleen sterren)
- Boek aanbevelingen
- Profielpagina

## Stack

- Backend: Spring Boot
- Frontend: Angular / Bulma
- Database: Postgres
- UML: Draw.io / Excalidraw
- Wireframes: Figma
- CI/CD: Docker (Postgres), Azure (Github Actions)

## Backend development

- Installeer Postgres (EDB installer komt met pgAdmin4)
- Maak een project-laas database
- Draai het script in de 'sql' folder
- Start de applicatie

## Request examples

- http://localhost:8080/project-laas/show/books
- http://localhost:8080/project-laas/show/copies/bookid/1
- http://localhost:8080/project-laas/show/loans
- http://localhost:8080/project-laas/show/reservations

## Security

Add new user: http://localhost:8080/project-laas/auth/addNewUser

```
{
    "username": "kees",
    "password": "geheim123",
    "email": "kees@workingtalent.nl",
    "roles": "TRAINEE"
}
```

Request token: http://localhost:8080/project-laas/auth/generateToken

```
{
    "username": "kees",
    "password": "geheim123"
}
```

Do a request with auth token: http://localhost:8080/project-laas/auth/user/trainee