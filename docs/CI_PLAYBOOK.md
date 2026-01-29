# CI/CD Playbook (GitHub Actions + Serenity)

Este documento resume la configuracion final del CI y las lecciones clave para reutilizar en futuros proyectos.

## 1) Arquitectura del pipeline

- Workflow: `.github/workflows/ci.yml`
- Job principal: `test`
- Job de despliegue: `deploy-pages` (GitHub Pages)
- Selenium: contenedor `selenium/standalone-chrome`

## 2) Puntos claves (lo que hizo que funcione)

1) **Selenium en contenedor, no local**
   - Evita problemas de Chrome/Driver en runners Linux.
   - Usamos Grid local en `localhost:4444`.

2) **URL correcta para Selenium 4**
   - Remote URL: `http://localhost:4444/` (no `/wd/hub`).

3) **Forzar remoto desde Gradle en CI**
   - En `build.gradle` se fuerza:
     - `webdriver.driver=remote`
     - `webdriver.remote.url=http://localhost:4444/`
     - `webdriver.remote.driver=chrome`
   - Esto evita que Serenity intente crear `ChromeDriver` local.

4) **Logs automaticos de fallos**
   - El workflow imprime `build/test-results/test/TEST-*.xml` si falla.

5) **GitHub Pages**
   - Source: **GitHub Actions**
   - Se publica el reporte Serenity en Pages con `actions/deploy-pages@v4`.

## 3) Checklist para nuevos proyectos

- [ ] Activar Pages: Settings -> Pages -> Source = GitHub Actions
- [ ] Verificar que el workflow use Selenium container
- [ ] Forzar remote driver en CI (Gradle)
- [ ] Subir artifacts de reportes
- [ ] Habilitar concurrency y cache Gradle

## 4) Archivos relevantes

- `.github/workflows/ci.yml`
- `build.gradle` (bloque `test { ... }` con propiedades CI)
- `src/test/resources/serenity.conf`

## 5) Troubleshooting rapido

- **SessionNotCreatedException**:
  - Casi siempre es ChromeDriver local. Asegurar remoto.
- **Pages deploy 404**:
  - Pages no habilitado o Source incorrecto.
- **Grid no ready**:
  - Revisar `/status` y logs del contenedor.
