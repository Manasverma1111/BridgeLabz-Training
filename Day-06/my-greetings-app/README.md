# My Greetings App (Spring MVC)

A minimal Spring MVC app for saving and managing greetings, with full
CRUD (Create, Read, Update, Delete) backed by an in-memory H2 database.

## How it maps to the topics

- **DispatcherServlet** — auto-configured by `@SpringBootApplication` in
  `GreetingsApplication.java`. It's the front controller that receives
  every request and hands it to the right controller method.
- **Controllers** — `GreetingController.java`, marked `@Controller`.
- **Views** — Thymeleaf templates in `src/main/resources/templates/`
  (`index.html`, `greeting.html`, `edit.html`).
- **Request mapping and handling** — `@GetMapping`/`@PostMapping` routes
  below, with `@RequestParam`/`@PathVariable` pulling data out of each
  request.

## CRUD operations

| Operation | Route                       | What it does                          |
|-----------|------------------------------|----------------------------------------|
| Create    | `POST /greetings`             | Saves a new greeting (name + message) |
| Read      | `GET /` and `GET /greetings/{id}` | Lists all greetings / views one   |
| Update    | `GET /greetings/{id}/edit`, `POST /greetings/{id}` | Edit form + save changes |
| Delete    | `POST /greetings/{id}/delete` | Removes a greeting                    |

`GreetingRepository` (a `JpaRepository<Greeting, Long>`) provides
`save()`, `findAll()`, `findById()`, and `deleteById()` — Spring Data
JPA implements these for us, no SQL written by hand.

## Run it

Requires Java 17+ and Maven.

```bash
cd my-greetings-app
mvn spring-boot:run
```

Then open http://localhost:8080 in your browser, type a name, and
submit.

## Project structure

```
my-greetings-app/
├── src/
│   ├── main/
│       ├── java/
│       │   ├── com/
│       │       ├── example/
│       │           ├── greetings/
│       │               ├── Greeting.java
│       │               ├── GreetingController.java
│       │               ├── GreetingRepository.java
│       │               └── GreetingsApplication.java
│       ├── resources/
│           ├── static/
│           │   ├── css/
│           │       └── style.css
│           ├── templates/
│           │   ├── edit.html
│           │   ├── greeting.html
│           │   └── index.html
│           └── application.properties
├── README.md
└── pom.xml

```
