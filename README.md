# Movable Type Data API SDK for Java

## Requirements
Java 5.0 or later

## Usage Example
```java
// Initialize API client.
String username = "melody";
String password = "nelson";
String clientId = "JavaClient";
String endpoint = "http://localhost/mt/mt-data-api.cgi";
MovableTypeApiClient client = MovableTypeClientFactory.createDataApiClient(username, password, clientId, endpoint);

// Call createEntry endpoint.
int siteId = 1;
Entry entry = new Entry();
entry.setTitle("Title");
entry.setBody("Body");
entry.setStatus("Publish");
Entry postEntry = client.postEntry(siteId, entry);
```

## License
[The MIT License (MIT)](./LICENSE.txt)

## Copyright
The following copyright notice applies to all the files provided in this distribution, including binary files, unless explicitly noted otherwise.

Copyright 2017 Six Apart, Ltd.
