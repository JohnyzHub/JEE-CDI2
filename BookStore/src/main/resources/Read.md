mvn clean install
-------------------------
VisualEE related files will be generated in the project directory.
Open the command prompt in the project directory and execute - python -m http.server 8000
Now open chrome browser, hit http://localhost:8000/visualee/
This shows up the dependency related information in a graphical view.

-------------------------
To execute the project: 
mvn clean compile exec:java