# Est-core-repository
Test repository for Est-Core to be used by DOP

# Installation

Check out the project and build the application using **maven** and run the dop.jar at **/target** folder.

	mvn clean package

# Start application

By default, application will run at port 8080. The rest API is available under context path **rest/**. After starting application you can access it at:

	http://localhost:8080/rest/path/to/resource

## Default configuration

	java -jar dop.jar
	
## Custom configuration

The custom configuration file can be placed anywhere visible to the application and may have any name.

	java -jar -Dconfig="/path/to/custom.properties" dop.jar

# Stop application

To stop the application just run the command:

	java -jar dop.jar stop
	
If you started the application using a **custom configuration** file, use the same configuration to stop the application.

	java -jar -Dconfig="/path/to/custom.properties" dop.jar stop


### Database

DOP uses **MariaDB** database. Click [here](https://mariadb.com/kb/en/mariadb/getting-installing-and-upgrading-mariadb/) for how to install it.
In my.ini or my.cnf under [mysqld] add: character-set-server=utf8

* **db.url** - the database url
* **db.username** - the database username
* **db.password** - the database password for given username

### Server

* **server.port** - the port that server starts.
* **command.listener.port** - the port used to listening for commands to be executed on server. Currently only shutdown command is available.

### Keystore
To import the Ekoolikott public key cert:

	keytool -import -alias eKoolikott -file eKoolikottPublicKeyCert.cer -keystore eKoolikott.keystore
	
You will be prompted for a password (examplePassword) and to trust the certificate.

Add all keystore configurations to **custom.properties**. From the example keytool command the configuration would be: 
```
	keystore.filename=eKoolikott.keystore
	keystore.password=exampleStorePass
	keystore.signingEntityID=examplePassword
```
