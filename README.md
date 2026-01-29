# Proyecto de Automatización - Serenity BDD + Cucumber (Java)

Este proyecto es una base de pruebas automatizadas con Serenity BDD y Cucumber.  
Está pensado para que alguien sin experiencia pueda levantarlo desde cero y ejecutar los tests de forma local.

## 1) Requisitos previos

Instala lo siguiente en tu computadora:

- **Java 17 (JDK)**  
  Verifica con:
  ```powershell
  java -version
  ```
  Debe mostrar `17.x`.

- **Git** (opcional, solo si vas a clonar el repositorio).

- **Google Chrome** instalado (el proyecto usa Chrome por defecto).

> El proyecto usa **Gradle Wrapper**, por lo que no necesitas instalar Gradle.

## 2) Obtener el proyecto

Si ya tienes la carpeta, omite este paso.  
Si vas a clonar:
```powershell
git clone <URL_DEL_REPOSITORIO>
cd training_GI
```

## 3) Estructura básica

```
src/
  test/
    java/
      co/com/training_GI/
        runners/        <- Runner de Cucumber (JUnit 5 Suite)
        stepDefinitions <- Steps de Cucumber
        tasks/          <- Acciones del actor (Screenplay)
        ui/             <- Selectores y páginas
    resources/
      features/         <- Features de Cucumber
```

Reportes:
- `target/site/serenity/index.html` (Serenity Report)
- `build/reports/tests/test/index.html` (Reporte de tests Gradle)

## 4) Ejecutar los tests

Desde la raíz del proyecto:

```powershell
.\gradlew clean test
```

Si todo está bien, verás:
```
BUILD SUCCESSFUL
```

## 5) Ver los reportes

Abrir en el navegador:

- Serenity: `target/site/serenity/index.html`
- Gradle: `build/reports/tests/test/index.html`

## 6) Configuración principal

Archivo: `build.gradle`

Dependencias clave:
- Serenity BDD 5
- Cucumber 7
- JUnit Platform (JUnit 5 Suite)

Archivo de configuración Serenity:
- `src/test/resources/serenity.conf`

## 7) Cómo ejecutar desde IntelliJ IDEA

1. Abrir el proyecto.
2. Esperar a que Gradle indexe.
3. Ir a **Run → Edit Configurations**.
4. Crear una configuración de tipo **JUnit**:
   - Test kind: **All tests**
   - JUnit platform: **JUnit 5**
5. Guardar y ejecutar.

También puedes ejecutar desde los archivos `.feature` con el botón de Run.

## 8) Problemas comunes

**Error: `JAVA_HOME` no configurado**
- Define `JAVA_HOME` apuntando al JDK 17 y reinicia la terminal.

**Falla de selector en UI**
- Revisa `src/test/java/co/com/training_GI/ui` y valida los selectores.

**Chromedriver / Selenium**
- Si hay errores con Chrome/driver, asegúrate de tener Chrome actualizado.

---

Si necesitas extender el proyecto (tags, paralelismo, ejecución en CI/CD), puedo ayudarte a dejarlo listo para producción.
