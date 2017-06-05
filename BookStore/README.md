			mvn clean install
			-------------------------
			VisualEE related files will be generated in the project directory.
			Open the command prompt in the project directory and execute :: python -m http.server <port>
			Now open chrome browser, hit http://localhost:<port>/visualee/
			This shows up the dependency related information in a graphical view.
			Press ctrl+c to terminate the service.

			-------------------------
			To execute the project: 
			mvn clean compile exec:java
