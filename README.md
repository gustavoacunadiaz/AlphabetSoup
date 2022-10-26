# AlphabetSoup

#BD:
Crear instancia de base de datos MySql con los siguientes datos:
datasource.url=jdbc:mysql://localhost:3306/sopadeletras?useSSL=false
username=root
password=123456
driver=com.mysql.cj.jdbc.Driver


#RUN
1-. Correr la instancia de BD creada anteriormente
2-. En la ruta ..\AlphabetSoup\Soup ejecutar mvn clean install package para crear el componente JAR
3-. Ejecutar mvn spring-boot:run para correr el aplicativo


#POSTMAN
1-.Crea Sopa de Letras -> Retornará un id en formato UUID (7fe946af-501d-4ac2-94b7-deb76b32f82f) el cual debe copiar para interactuar en los siguientes servicios REST
	http://localhost:9878/alphabetSoup/
2-. Lista de palabras -> Retorna las palabras escondidas en la sopa de letras
	http://localhost:9878/alphabetSoup/list/7fe946af-501d-4ac2-94b7-deb76b32f82f
3-. Valida Palabra -> Según el request, en incio_fila, inicio_columna, fin_fila y fin_columna, el servicio responderá si la palabra fue encontrada
	http://localhost:9878/alphabetSoup/7fe946af-501d-4ac2-94b7-deb76b32f82f
4-. Palabras Encontradas -> Retorna las palabras encontradas
	http://localhost:9878/alphabetSoup/view/7fe946af-501d-4ac2-94b7-deb76b32f82f
	