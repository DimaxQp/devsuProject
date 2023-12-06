Devsu LLC Technical Assessment

Casos de prueba considerados:
- Validacion de carrito de compras seleccionando 01 telefono
- Validacion de carrito de compras seleccionando 02 telefonos diferentes
- Validacion de carrito de compras seleccionando 02 productos iguales

Implementación:
1) Clonar el proyecto con el comando: git clone https://github.com/DimaxQp/devsuProject.git
2) Instalar JDK 20 Oracle desde la URL: https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html
3) Importar JDK a Intellij IDEA:
	3.1. Click en File
	3.2. Click en Project Structure
	3.3. Seleccionar el JDK instalado en el campo SDK
4) Instalar y configurar Maven desde el siguiente enlace: https://maven.apache.org/download.cgi

Ejecución:
- Opción 1:
 Abrir terminal desde Intellij IDEA y ejecutar el comando: mvn clean test o mvn test -Dcucumber.filter.tags="@test"
- Opción 2:
 Ejecutar archivo ejecutarTests.cmd

Reporte de ejecución:
- Abrir el acceso directo cucumber2.html