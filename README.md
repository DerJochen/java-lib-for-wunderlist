# java-lib-for-wunderlist
This project is a Java library for the REST API of Wunderlist.

The project is still work-in-progress and not ready to be used!

## Features

### ListService

- retrieveAll(): Retrieves all lists
- retrieve(int): Retrieves one list, identified by ID

### PositionsService

- retrieveAllListPositions(): Retrieves all list positions objects for the user
- retrieveListPositions(int): Retrieves one list positions object
- retrieveAllTaskPositions(int): Retrieves all task positions objects for one list
- retrieveTaskPositions(int): Retrieves one task positions object
- updateTaskPositions(int, int[], int): Updates one task positions object

### TaskService

- retrieveAll(int): Retrieves all open tasks for a list
- retrieveAllCompleted(int): Retrieves all completed tasks for a list
- retrieve(int): Retrieves a specific task

### WebhookService

- retrieveAll(int): Retrieves all webhooks for a list, identified by ID
- create(CreateWebhookRequest): Creates a new webhook
- delete(int): Deletes a webhook permanently

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
