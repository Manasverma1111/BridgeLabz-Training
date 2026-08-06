# My Greetings App (Spring MVC project)

A minimal Spring MVC app: a form where you type your name and get a
personalized greeting page back.

## How it maps to the topics

- **DispatcherServlet** — auto-configured by `@SpringBootApplication` in
  `GreetingsApplication.java`. It's the front controller that receives
  every request and hands it to the right controller method.
- **Controllers** — `GreetingController.java`, marked `@Controller`.
- **Views** — Thymeleaf templates in `src/main/resources/templates/`
  (`index.html`, `greeting.html`).
- **Request mapping and handling** — `@GetMapping("/")` and
  `@GetMapping("/greeting")`, with `@RequestParam` pulling the `name`
  query parameter out of the request.

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
├── pom.xml
├── src/main/java/com/example/greetings/
│   ├── GreetingsApplication.java   # entry point / DispatcherServlet setup
│   └── GreetingController.java     # request mapping + handling
└── src/main/resources/
    ├── application.properties
    ├── static/css/style.css
    └── templates/
        ├── index.html              # form (view)
        └── greeting.html           # result (view)
```
