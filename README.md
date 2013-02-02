JDBC Security with Glassfish 3.1 and Java EE 6
=========================================

Package as war and deploy to Glassfish
-------------------------

To package as war file with maven simply type the following on the command line:  

    mvn clean compile package
	
Now you can deploy the application by either using the Glassfish admin console or drop the war file into your {Glassfish}/domains/domain1/autodeploy directory.

Import as Eclipse Project
----------------------------
There is a project file included in the project folder, so you can import the project directly into eclipse as existing project.


