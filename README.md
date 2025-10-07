# Sistema de Registro de Participación en Eventos Académicos ## Cómo ejecutar - Añadir dependencias de Spring Boot (starter-web) en pom/gradle. - `mvn spring-boot:run` o ejecutar clase EventosApplication. 
## Aplicación de los pilares de la POO
### 1. Encapsulamiento Los atributos de `Event` y `Student` son `private` y se acceden por getters/setters para controlar modificaciones. 
### 2. Abstracción `EventService` y `StudentService` encapsulan la lógica de negocio (registro, inscripción) y ocultan la persistencia en memoria a los controladores.
### 3. Herencia Podríamos extender `Event` con subclases como `CertifiedEvent` agregando atributos de certificación y reutilizando lógica común.
### 4. Polimorfismo Si existieran distintos tipos de estudiantes (p.ej. `UndergradStudent` y `GradStudent`) que implementen la misma interfaz, podríamos tratarlos uniformemente en los servicios.
