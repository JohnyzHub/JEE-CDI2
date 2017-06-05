Notes:

perform: mvn package
Deploy: 
java -jar target/RestWithProduce-swarm.jar -Dswarm.port.offset=100 -Dswarm.context.path=/restwithcdi

refer https://wildfly-swarm.gitbooks.io/wildfly-swarm-users-guide/content/configuration_properties.html for system level properties.
refer https://reference.wildfly-swarm.io/configuration.html for different configuration methods.

End Points: 
localhost:<port>/restwithcdi
localhost:<port>/restwithcdi/rest/book
localhost:<port>/restwithcdi/rest/book/FICTION
localhost:<port>/restwithcdi/rest/book/SUSPENSE