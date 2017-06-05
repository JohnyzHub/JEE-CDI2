
Build:
    
    mvn clean package -up -q

Deploy:

    java -jar target/RestWithProduce-swarm.jar -Dswarm.port.offset=100 -Dswarm.context.path=/restwithcdi

For system level properties refer:
  
  https://wildfly-swarm.gitbooks.io/wildfly-swarm-users-guide/content/configuration_properties.html 

For different configuration methods refer:

   https://reference.wildfly-swarm.io/configuration.html 

Rest End Points:

    localhost:<port>/restwithcdi 
    localhost:<port>/restwithcdi/rest/book 
    localhost:<port>/restwithcdi/rest/book/FICTION 
    localhost:<port>/restwithcdi/rest/book/SUSPENSE 
