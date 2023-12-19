# Todo App

## Beschreibung
Dieses Projekt ist eine Todo App, welches Benutzern mit den erforderlichen Berechtigungen, Todo's "Aufgaben" zu erstellen. Die Todo's haben eine Id, eine Message und einen Status, welche man setzen kann, je nach Standpunkt des Todo's.

## Inhaltsverzeichnis
- [Todo App](#todo-app)
  - [Beschreibung](#beschreibung)
  - [Inhaltsverzeichnis](#inhaltsverzeichnis)
  - [Installationen](#installationen)
    - [MySQL](#mysql)
    - [Frontend (React)](#frontend-react)
    - [Backend (Spring Boot)](#backend-spring-boot)
  - [Verwendete Technologien](#verwendete-technologien)
  - [Akzeptanzkriterien](#akzeptanzkriterien)
  - [Dokumentation](#dokumentation)
    - [Datenbank](#datenbank)
    - [RBAC](#rbac)
    - [REST API](#rest-api)
    - [Frontend](#frontend-1)
    - [Backend](#backend-1)
  - [Tests](#tests)
    - [Frontend](#frontend-2)
    - [Backend](#backend-2)
  - [Sicherheit](#sicherheit)
    - [Spring Security](#spring-security)
    - [JWT](#jwt)
    - [BCrypt](#bcrypt)
    - [CORS](#cors)
  - [Hilfestellungen](#hilfestellungen)
    - [MySQL](#mysql-1)
    - [Frontend (React)](#frontend-react-1)
    - [Backend (Spring Boot)](#backend-spring-boot-1)


## Installationen

### MySQL
1. Installieren Sie [MySQL](https://dev.mysql.com/downloads/installer/)
2. (in Windows) Starten Sie den MySQL Dienst, falls dieser noch nicht gestartet ist. <br/> (in Linux) Starten Sie den mysql-Daemon mit `sudo systemctl start mysql` oder `sudo systemctl start mysql.service`
3. (in Windows) Öffnen Sie die mysql "Commandline" und loggen Sie sich ein.<br/> (in Linux) Loggen Sie sich in der Kommandozeile in mysql ein. `sudo mysql -u root -p`
3. Erstellen Sie einen neuen Benutzer
```sql
CREATE USER 'username'@'%' IDENTIFIED BY 'password';
```
4. Erstellen Sie eine neue Datenbank
```sql
CREATE DATABASE todo;
```
5. Geben Sie dem Benutzer alle Rechte auf die Datenbank
```sql
GRANT ALL PRIVILEGES ON todo.* TO 'username'@'%';
```


### Frontend (React)
1. Installieren Sie [Node.js](https://nodejs.org/en/download/)
2. Installieren Sie [NPM](https://www.npmjs.com/get-npm)
3. Klonen Sie das Repository
```bash	
git clone https://github.com/jasontermine/TodoApp.git
```
4. Navigieren Sie in den Ordner "/frontend"
```bash
cd TodoApp/frontend
```
5. Installieren Sie die benötigten Pakete
```bash
npm install
```
6. Starten Sie das Frontend
```bash
npm run dev
```
7. Öffnen Sie [http://localhost:5173](http://localhost:5173) um die App im Browser zu sehen.

### Backend (Spring Boot)
1. Installieren Sie [Java](https://www.java.com/de/download/)
2. Klonen Sie das Repository
```bash
git clone https://github.com/jasontermine/TodoApp.git
```
3. Navigieren Sie in den Ordner "M223/backend"
```bash
cd TodoApp/backend
```
5. Fügen Sie Ihre MySQL Daten in die Datei "application.properties" ein
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo
spring.datasource.username=username
spring.datasource.password=password
```

6. Starten Sie das Backend
```bash
./mvnw spring-boot:run
```
7. Öffnen Sie [http://localhost:8080](http://localhost:8080) um die App im Browser zu sehen.

## Verwendete Technologien
- [React](https://reactjs.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL 8.0](https://www.mysql.com/)
- [MDBootstrap](https://mdbootstrap.com/)
- [JWT](https://jwt.io/)
- [Maven](https://maven.apache.org/)
- [NPM](https://www.npmjs.com/)
- [Git](https://git-scm.com/)
- [Visual Studio Code](https://code.visualstudio.com/)
- [Postman](https://www.postman.com/)

## Akzeptanzkriterien

| Wer                     | Was                           |  Warum                          |    Akzeptanzkriterien                    |
| ------------------------|-------------------------------|---------------------------------|------------------------------------------|
| Admin / CEO             | Einloggen                     | Um seine TODOs zu verwalten     | Admin kann sich einloggen                |
| Mitarbeiter / Employee  | Einloggen                     | Um seine/Ihre TODOs einzusehen  | Employee kann sich einloggen             |
| Admin / CEO             | TODOs erstellen               | Um Arbeiten zu delegieren       | Admin kann TODOS erstellen               |
| Admin / CEO             | Stati der TODO setzen         | Um die Arbeiten zu verfolgen    | Admin sieht ein, welche TODOs offen sind |       


## Dokumentation

### Datenbank
Die Datenbank besteht aus 5 Tabellen. Die Tabelle "user" enthält alle Benutzer. Die Tabelle "role" enthält alle Rollen. Die Tabelle "todo" enthält alle Todo's. Die Tabelle "status" enthält alle Stati, in Relation zu den Todo's. Die Tabelle "user_role" enthält die Rollen, in Relation zu den Benutzern.

![Datenbank Diagramm](resources/ERD.png)

### RBAC
![RBAC Diagram](resources/RBAC_diagram.png)

### REST API
| Methode | URL | Beschreibung | Authentifizierung | Parameter |
| --- | --- | --- | --- | --- |
| POST | /api/auth/signup | Registriert einen neuen Benutzer | Nein | username, email, password |
| POST | /api/auth/signin | Loggt einen Benutzer ein | Nein | username, password |
| GET | /admin/todos | Gibt alle Todo's zurück | Ja | |
| POST | /admin/todos/create | Erstellt ein neues Todo | Ja | (Optional => id : int) name : String, message : String, status : int |
| DELETE | /admin/todos/delete/{id} | Löscht ein todo | Ja | id : int |

### Frontend

Die verschiedenen Seiten der Webanwendung sind in der folgenden Tabelle aufgelistet.

| URL | Beschreibung | Authentifizierung |
| --- | --- | --- |
| / | Login Seite | Nein |
| /private | Liste aller Todo's | Ja |
| /admin | Zwei buttons zur Auswahl, ob man ein Todo erstellen möchte oder eins löschen | Ja |

Die Seiten wurden aus zeitlichen Gründe einfach gestaltet und erfüllen somit den Zweck der Endpoints und des Projekts. Die Seite "/admin" verfügt über zwei Buttons "Todo erstellen" und "Todo löschen". Diese Buttons rufen verschiedene "Modals" / Formulare auf.  Diese Formulare können nach Zweck ausgefüllt werden und absenden. Nach dem Erstellen oder Löschen eines Todo's, wird der Benutzer zur "/private" Seite geschickt. Die Seite "/private" listet die Todos nur auf.

### Backend

Das Backend ist in 5 Schichten aufgeteilt. Die Schichten sind in der folgenden Tabelle aufgelistet.

| Schicht | Beschreibung |
| --- | --- |
| controller | REST Controller |
| helper | Hilfsklasse für JWT |
| model | Datenbank Modelle |
| repository | Spring Data Repositories |
| security | Spring Security |

## Tests

### Frontend
Die Tests sind im Ordner "TodoApp/frontend/src/\__tests\_\_" zu finden. Die Tests sind mit dem Framework [Vitest](https://vitest.dev/) geschrieben. Die Tests können wie folgt ausgeführt werden.
```bash
cd TodoApp/frontend
npm test
```

#### Vorhandene Tests
- state.test.js 

##### auth.service.test.js
Dieser Test überprüft, ob die States funktional sind.

### Backend
Die Tests sind im Ordner "backend/src/test/java/com/wiss/m223" zu finden.
Die Tests sind mit dem Framework [JUnit](https://junit.org/junit5/) und [Mockito](https://site.mockito.org/) geschrieben. Die Tests können wie folgt ausgeführt werden.
```bash
cd TodoApp/backend
./mvnw test
```

#### Vorhandene Tests
Für Die folgenden Schichten, wurden Tests geschrieben:
- AdminController

Diese Schicht enthält zwei Tests.
Genaurere Informationen zu den Tests dieser Klasse ist im Klassenkommentar zu finden.

## Sicherheit
Sie Sicherheit der Webanwendung wird mit folgenden Technologien gewährleistet.

### Spring Security
Spring Security ist ein Framework, das dazu dient, die Sicherheit einer Webanwendung sicherzustellen. Es bietet verschiedene Mittel, um dies zu erreichen. In diesem Projekt wird Spring Security verwendet, um sowohl die Authentifizierung als auch die Autorisierung zu handhaben.

### JWT
JWT (JSON Web Token) ist ein offener Standard, der in diesem Projekt für sichere Authentifizierung sorgt. Nach dem Login erhält der Benutzer einen verschlüsselten JWT mit Benutzer-ID und -namen, den er bei jeder Anfrage mitsendet, um die Integrität zu gewährleisten.

### BCrypt
In diesem Projekt wird der BCrypt-Algorithmus verwendet, um die Passwörter der Benutzer sicher zu verschlüsseln. BCrypt ermöglicht eine effektive Hashing-Methode, die die Sicherheit der Passwortverwaltung verbessert.

### CORS
In diesem Projekt ermöglicht der CORS-Mechanismus die nahtlose Kommunikation zwischen Frontend und Backend, indem er der Webanwendung erlaubt, sicher auf Ressourcen von einem anderen Server zuzugreifen.

## Hilfestellungen

### MySQL
Da die Datenbank durch Spring Boot generiert wurde, kam zur Entwicklung nur [MySQL](https://www.mysql.com/) zum Einsatz.

### Frontend (React)
Da ich in meinem Betrieb bereits Erfahrung habe mit Vue.js, war das entwickeln vom Frontend mit React nicht so ein Problem. Vorallem die handhabung mit den REST, States und die Logik hinter der Komponentenbaserte Webentwicklung. Trotzdem benötigte ich für gewisse sachen Hilfe von der [React Dokumentation](https://reactjs.org/docs/getting-started.html).

Aufgrund der sehr begrenzter Zeit für dieses Projekt, habe ich teilweise [ChatGPT](https://chat.openai.com/) und [GitHUb Copilot](https://copilot.github.com/) zurückgegriffen.

Hilfe wurde von folgenden Mitschülern und Dozenten erhalten:
- Christoph Knuchel

Hilfe wurde von folgenden Lehrern erhalten:
- Sven Schirmer

### Backend (Spring Boot)
Da ich bereits Erfahrungen gesammelt habe im Modul 320 (Objektorientiert Programmieren) und Modul 295 (Backend für Applikationen realisieren), welche auch Springboot und Maven enthielten, war das realisieren des Backends für dieses Projekt nicht so Kompliziert. Jedoch habe ich von der [Spring Boot Dokumentation](https://spring.io/projects/spring-boot) hilfe bezogen.

Aufgrund der sehr begrenzter Zeit für dieses Projekt, habe ich teilweise [ChatGPT](https://chat.openai.com/) und [GitHUb Copilot](https://copilot.github.com/) zurückgegriffen.

Hilfe wurde von folgenden Mitschülern erhalten (Gott sei Dank):
- Christop Knuchel

Hilfe wurde von folgenden Lehrern erhalten:
- Sven Schirmer
