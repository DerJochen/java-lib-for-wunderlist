# java-lib-for-wunderlist
This project is a Java library for the REST API of Wunderlist.

The project is still work-in-progress and not ready to be used!

## Features

### ListService

- retrieveAll(): Retrieves all lists
- retrieve(int): Retrieves one list, identified by ID

### PositionsService

- ~~retrieve(int)~~: Retrieves the positions for one list, identified by ID (not yet implemented)
- ~~update(int, int[], int)~~: Updates the positions for one list, identified by ID and revision (not yet implemented)

### TaskService

- ~~retrieveAll(int)~~: (not yet implemented)
- ~~retrieveAllCompleted(int)~~: (not yet implemented)
- ~~retrieve(int)~~: (not yet implemented)

### WebhookService

- ~~create(CreateWebhookRequest)~~: (not yet implemented)
- ~~delete(int)~~: (not yet implemented)
- ~~listWebhooks(int)~~: (not yet implemented)

## Maven

### Dependency Tag

```xml
<dependency>
	<groupId>de.jochor.wunderlist</groupId>
	<artifactId>java-lib-for-wunderlist</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```

### Repository Tag

#### Releases

```xml
<repository>
	<id>jochor-public-releases</id>
	<url>http://maven.jochor.de/content/repositories/public-releases/</url>
</repository>
```

#### Snapshots

```xml
<repository>
	<id>jochor-public-releases</id>
	<url>http://maven.jochor.de/content/repositories/public-snapshots/</url>
</repository>
```
