# SauceDemo Automation Challenge - E2E

Este repositorio contiene la automatización para el flujo de compra End-to-End (E2E) en la tienda virtual **SauceDemo**. 
El proyecto ha sido implementado utilizando el patrón de diseño **Screenplay** con **Serenity BDD**, **Cucumber** y **Gradle**.

## Stack Tecnológico 

* **Lenguaje:** Java 17 (Oracle OpenJDK)
* **Framework:** Serenity BDD (Screenplay Pattern)
* **BDD:** Cucumber (Gherkin)
* **Build Tool:** Gradle 7.6 (Wrapper)
* **Driver Management:** WebDriverManager - *Gestión automática de drivers*
* **IDE:** IntelliJ IDEA Community/Ultimate

## Prerrequisitos

Para ejecutar este proyecto localmente, asegúrate de cumplir con los siguientes requisitos:

1.  **Sistema Operativo:** Windows 10/11, macOS o Linux.
2.  **Java JDK 17:** Debe estar instalado y configurado en las variables de entorno (`JAVA_HOME`).
3.  **Navegador:** **Mozilla Firefox** (Debe estar instalado).

## Instalación

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/devTato1/sauce-demo-challenge.git
    ```

2.  **Acceder al directorio:**
    ```bash
    cd SauceDemoAutomation
    ```

3.  **Descargar dependencias:**
    Ejecuta el comando de Gradle para bajar las librerías necesarias.
    * **Windows:**
        ```bash
        .\gradlew dependencies
        ```
    * **Mac/Linux:**
        ```bash
        ./gradlew dependencies
        ```

## Ejecución de las Pruebas

El proyecto está configurado para ejecutarse en **Firefox** y gestionar automáticamente el `geckodriver`.

Para ejecutar los escenarios de prueba y generar los reportes, corre el siguiente comando en la terminal:

```bash
.\gradlew clean test 

```

## Reportes Generados

Al finalizar la ejecución, Serenity BDD genera un reporte detallado con capturas de pantalla de cada paso.

* **Ubicación:** `target/site/serenity/cucumber-reports.html`
* **Cómo verlo:** Ve a la carpeta del proyecto, navega a la ruta indicada y abre el archivo `cucumber-reports.html` en tu navegador, o desde intellij ir a la carpeta **target** click derecho en cucumber-reports.html abir en **Browser** (Elegir cualquier navegador disponible)
* **Opcional:** Se puede ver el reporte con capturas de pantalla dentro de la carpeta `target\site\serenity` y encontrar el reporte autogenerado con nombre similar a `96d5f43b43124b6a601dd78ed27f1b3c8c740132372df1528ef76440ce22cdc2`

##  Estructura del Proyecto (Screenplay)

El código sigue estrictamente la arquitectura Screenplay:

```text
src/
├── main/java/com/nttdata/
│   ├── tasks/              # Responsabilidades del actor (Login, AddProduct, CompleteCheckout.)
│   └── userinterfaces/     # Mapeo de elementos Web (Page Objects / Targets)
└── test/
    ├── java/com/nttdata/
    │   ├── runners/        # Clase ejecutora (CucumberShop.java)
    │   └── glue/           # Step Definitions (Conexión Gherkin <-> Java)
    └── resources/
        ├── features/       # Escenarios de prueba (.feature)
        └── serenity.conf   # Configuración del navegador (Firefox) y ambiente

```

##  Notas Adicionales

* **Gestión de Drivers:** No es necesario descargar manualmente el `geckodriver`. El proyecto utiliza la librería `WebDriverManager` invocada en el `BeforeClass` del Runner para garantizar la compatibilidad con Firefox.
* **Datos de Prueba:** Los datos (usuarios, productos) están parametrizados utilizando **Scenario Outlines** en el archivo `.feature`.

---

**Autor:** Leonardo Reascos

