## RetoJava

Contiene el desarrollo realizado para solucionar el reto de Java FullStack

La carpeta Back => contiene el proyecto del Back-end hecho en Spring boot framewok de Java con Gradle como administrador de dependencias.
Se crearon los paquetes con la estructura adecuada para la solución.
En el archivo aplication.properties se tiene la configuración adecuada para la conexión a la base de datos en la nube MySQL
La carpeta Front => contiene el proyecto del Front-end hecho en angular 9 con su estructura adecuada.

## Pre-requisitos

La solución del proyecto fue contruida con las siguientes herramientas y/o aplicativos, que son necesarios para el correcto funcionamiento del proyecto:

    *Windows 10
    *Gradle 6.4.1
    *Java 1.8.0_231
    *Spring boot 2.3.1
    *JDK (Java SE Development Kit)
    *IDE (Entorno de desarrollo integrado) para ejecutar la aplicación Java del Backend (Eclipse, IntelliJ IDEA, Netbeans)
    *Angular 9.1.9
    *Node.js 12.18.2
    *MySQL 8.0.17
    *Visual Studio Code

## Extracción del proyecto del repositorio

Para clonar el proyecto se debe situar dentro de una carpeta vacia, dar click derecho y ejecutar el aplicativo git `Git Batch Here` luego ejecutar el comando `git init` para inicializar el repositorio local, seguidamente ejecutar el comando `git clone https://github.com/EstebanV9/RetoJava.git` y se extraera el proyecto con todos sus complementos.

## Comandos para ejecutar los proyectos

Para la ejecución del Back-end se debe importar el proyecto Back/RetoFullStack en el IDE y luego situarse sobre la clase `RetoFullStack/src/main/java/RetoFullStackApplication.java` y presionar en "Ejecutar Java Application" y se iniciará el proyecto en Spring Boot v2.3.1

Para la ejecución del Front-end situarse dentro de la carpeta `Front/RetoJava/` allí se encuentra "src" que contiene la aplicación, entonces desde dentro de la carpeta `/RetoJava/` situarse sobre el buscador de windows y ejecutar el comando cmd y ejecutar el comando `ng serve -o`
Se iniciará automaticamente la aplicación en el navegador desde allí ya se podrá interactuar con la aplicación `http://localhost:4200/`

## Otros

Dentro del aplicativo Back y Front se encuentras sus especificos .gitignore y README.md