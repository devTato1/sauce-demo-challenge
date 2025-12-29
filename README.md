
# 🛒 SauceDemo Automation Challenge - E2E

Este repositorio contiene la solución automatizada para el flujo de compra End-to-End (E2E) en la tienda virtual **SauceDemo**. El proyecto ha sido implementado utilizando el patrón de diseño **Screenplay** con **Serenity BDD**, **Cucumber** y **Gradle**.

## 🛠️ Tech Stack

* **Lenguaje:** Java 17 (Oracle OpenJDK)
* **Framework:** Serenity BDD (Screenplay Pattern)
* **BDD:** Cucumber (Gherkin)
* **Build Tool:** Gradle 7.6
* **Driver Management:** WebDriverManager (Bonigarcia) - *Gestión automática de drivers*
* **IDE:** IntelliJ IDEA Community/Ultimate

## 📋 Prerrequisitos

Para ejecutar este proyecto localmente, asegúrate de cumplir con los siguientes requisitos:

1.  **Sistema Operativo:** Windows 10/11, macOS o Linux.
2.  **Java JDK 17:** Debe estar instalado y configurado en las variables de entorno (`JAVA_HOME`).
3.  **Navegador:** **Mozilla Firefox** (Debe estar instalado).

## 🚀 Instalación

1.  **Clonar el repositorio:**
    ```bash
    git clone <URL_DE_TU_REPOSITORIO>
    ```

2.  **Acceder al directorio:**
    ```bash
    cd SauceDemoAutomation
    ```

3.  **Descargar dependencias:**
    Ejecuta el comando de Gradle para bajar las librerías necesarias.
    * **Windows:**
        ```bash
        gradlew clean build
        ```
    * **Mac/Linux:**
        ```bash
        ./gradlew clean build
        ```

## ⚙️ Ejecución de las Pruebas

El proyecto está configurado para ejecutarse en **Firefox** y gestionar automáticamente el `geckodriver`.

Para ejecutar los escenarios de prueba y generar los reportes, corre el siguiente comando en la terminal:

```bash
gradlew clean test aggregate

```

### ¿Qué hace este comando?

1. **`clean`**: Elimina reportes y binarios de ejecuciones anteriores para asegurar una prueba limpia.
2. **`test`**: Ejecuta los escenarios definidos en `src/test/resources/features`.
3. **`aggregate`**: Recopila los resultados y genera el reporte HTML de Serenity.

## 📊 Reportes Generados

Al finalizar la ejecución, Serenity BDD genera un reporte detallado con capturas de pantalla de cada paso.

* **Ubicación:** `target/site/serenity/index.html`
* **Cómo verlo:** Ve a la carpeta del proyecto, navega a la ruta indicada y abre el archivo `index.html` en tu navegador.

## 📂 Estructura del Proyecto (Screenplay)

El código sigue estrictamente la arquitectura Screenplay:

```text
src/
├── main/java/com/nttdata/
│   ├── tasks/              # Responsabilidades del actor (Login, AddProduct, etc.)
│   └── userinterfaces/     # Mapeo de elementos Web (Page Objects / Targets)
└── test/
    ├── java/com/nttdata/
    │   ├── runners/        # Clase ejecutora (CucumberShop.java)
    │   └── glue/           # Step Definitions (Conexión Gherkin <-> Java)
    └── resources/
        ├── features/       # Escenarios de prueba (.feature)
        └── serenity.conf   # Configuración del navegador (Firefox) y ambiente

```

## 📝 Notas Adicionales

* **Gestión de Drivers:** No es necesario descargar manualmente el `geckodriver`. El proyecto utiliza la librería `WebDriverManager` invocada en el `BeforeClass` del Runner para garantizar la compatibilidad con Firefox.
* **Datos de Prueba:** Los datos (usuarios, productos) están parametrizados utilizando **Scenario Outlines** en los archivos `.feature`.

---

**Autor:** Leonardo Reascos

