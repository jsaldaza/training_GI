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
        config/         <- Configuración por entorno
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

## 8) CI/CD con GitHub Actions (moderno y escalable)

Este proyecto ya incluye CI en GitHub Actions.

### 8.1 Qué hace el pipeline
- Ejecuta tests en cada `push` y `pull_request` a `main`.
- Corre UI tests en Selenium Grid dentro de un contenedor.
- Sube reportes como artifacts (Serenity y Gradle).

### 8.2 Dónde ver resultados
1. GitHub -> pestaña **Actions**.
2. Workflow **CI** -> run más reciente.
3. En **Artifacts** descarga:
   - `serenity-report`
   - `gradle-test-report`

### 8.2.1 Reporte en GitHub Pages (Serenity)
El pipeline publica automáticamente el reporte Serenity en GitHub Pages (solo en `main`).

Pasos para habilitarlo por primera vez:
1. Repo -> **Settings** -> **Pages**
2. Source: **GitHub Actions**
3. Guarda y vuelve a ejecutar el workflow.

La URL pública quedará en el job **Deploy Serenity Report** del run.

### 8.3 Ejecutar manualmente
Actions -> Workflow **CI** -> **Run workflow** -> seleccionar `main`.

### 8.4 Archivos clave
- Workflow: `.github/workflows/ci.yml`
- Config remoto: `src/test/resources/serenity.conf`
- Forzado remoto en CI: `build.gradle` (bloque `test { ... }`)

### 8.5 Si el CI falla
- Revisa el XML: `build/test-results/test/TEST-*.xml`
- El workflow imprime ese XML automáticamente si hay fallos.

### 8.6 Playbook interno
Guía reutilizable del CI:
- `docs/CI_PLAYBOOK.md`

## 9) Problemas comunes

**Error: `JAVA_HOME` no configurado**
- Define `JAVA_HOME` apuntando al JDK 17 y reinicia la terminal.

**Falla de selector en UI**
- Revisa `src/test/java/co/com/training_GI/ui` y valida los selectores.

**Chromedriver / Selenium**
- Si hay errores con Chrome/driver, asegúrate de tener Chrome actualizado.

## 10) Git Flow (modelo de ramificación)

Este repo usa Git Flow clásico:
- `main`: releases en producción
- `develop`: integración de features
- `feature/*`: trabajo incremental
- `release/*`: preparación de releases
- `hotfix/*`: correcciones urgentes

---

Si necesitas extender el proyecto (tags, paralelismo, ejecución en CI/CD), puedo ayudarte a dejarlo listo para producción.
