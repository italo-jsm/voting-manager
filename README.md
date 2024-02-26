# Voting API


This project is a tool for managing voting for a cooperative.
### Running the application
This app can be used executing a docker-compose file. It will build the app, start a postgresql database and create
the tables.

`docker-compose up`

### Create an Agenda

Run this CURL to create an Agenda.

`curl --location 'localhost:8080/agenda/create' \
--header 'Content-Type: application/json' \
--data '{
"name": "Agenda Name",
"description": "Agenda Description"
}'`

Replace "Agenda Name" and "Agenda Description" with your own data.


### Open an Agenda for voting

Run this CURL to open an Agenda for voting.

`curl --location --request PUT 'localhost:8080/agenda/open' \
--header 'Content-Type: application/json' \
--data '{
"agendaId": "9f1ba464-9e9a-4c47-819c-d3b368c2f162",
"duration": 10
}'`
 "Agenda Id" is the id of the agenda to be opened and duration is the time in minutes that the agenda will remain opened. After
that time it will be closed.

### Vote on an Agenda
Run this CURL to vote on an Agenda.
`curl --location 'localhost:8080/vote' \
--header 'Content-Type: application/json' \
--data '{
"agendaId": "9bec11ed-13eb-4654-9eb0-6a02e6c82be7",
"authorId": "12312fsdfwtrf234t",
"vote": "SIM"
}'`

Agenda Id" is the id of the agenda and authorId is the id of the person who is voting. Votes must be only "SIM" ou "NAO" (case-sensitive).

### Get the voting result
Run this CURL to get the voting result.

`curl --location --request PUT 'localhost:8080/agenda/open' \
--header 'Content-Type: application/json' \
--data '{
"agendaId": "9f1ba464-9e9a-4c47-819c-d3b368c2f162",
"duration": 10
}'`

curl --location 'localhost:8080/vote/result?agendaId=11b79c2a-2ba0-4eee-a38e-a0696a8cfbd9'

Agenda Id" is the id of the agenda.

### Quality
This project has the resources to send quality information to a sonar qube instance. To do that you must have a sonar qube server instance running. You can do that 
with docker for an example. Just follow the steps in this article: https://www.baeldung.com/sonar-qube

The maven plugin described on step 4 is already included. 