# Movable Type Data API SDK for Java

## Requirements
Java 6 or later

## Some Examples

### Usage Example

```java
// Initialize API client.
String username = "melody";   // Your Sign-in Name
String password = "nelson";   // Your web service password
String clientId = "JavaClient";
String endpoint = "http://localhost/mt/mt-data-api.cgi";
MovableTypeApiClient client = MovableTypeClientFactory.createDataApiClient(username, password, clientId, endpoint);

// Call createEntry endpoint.
int siteId = 1;
Entry entry = new Entry();
entry.setTitle("Title");
entry.setBody("Body");
entry.setStatus(EntryStatus.PUBLISH);
Entry postEntry = client.postEntry(siteId, entry);
```

### Creating a API Client
```java
// Api Authentication

MovableTypeApiClient client
    = MovableTypeClientFactory.createDataApiClient(username,password,clientId,endpoint);

// Api Authentication + Basic Authentication
MovableTypeApiClient client
    = MovableTypeClientFactory.createDataApiClient(username,password,clientId,endpoint,basicAuthId,basicAuthPass);

// Not authentication
MovableTypeApiClient client
    = MovableTypeClientFactory.createDataApiClient(clientId,endpoint);
```

### Site

```java
// Create a new website.
Site site = new Site();
site.setName("WebSite");
site.setUrl("http://example.com/");
site.setSitePath("/data/file/static/example.com");
site = client.createWebsite(site);
System.out.println(site.getId());
System.out.println(site.getHost());

// Create a new blog under the site.
int site_id = 4;
Site site = new Site();
site.setName("My Blog");
site.setUrl("http://example.com/blog/");
site.setSitePath("/data/file/static/example.com/blog");
site = client.createBlog( site_id, site) ;
System.out.println(site.getId());
System.out.println(client.getResponseMessage());

// Retrieve a list of sites.
SiteSearchParam siteSearchParam = new SiteSearchParam();
siteSearchParam.setSearch("Blog");
SiteItems siteItems = client.searchSites(siteSearchParam);
siteItems.getItems();
for (Site site : siteItems.getItems()) {
   System.out.println(site.getId());
   System.out.println(site.getName());
}

// Retrieve a single website/blog by its ID.
int site_id = 4;
String fields = "id,name";  // All fields is null
Site site = client.getSite(site_id, fields);
System.out.println(site.getId());
System.out.println(site.getName());

// Update an existing site.
// - Create or search "Site" object.
int site_id = 4;
site.setName("WebSite2");
site = client.updateSite(site_id, site);
System.out.println(site.getName());

// Delete an existing site.
Site site = client.deleteSite(site_id);
System.out.println(client.getResponseMessage());
```

### Entry

```java
// Create a new entry.
int site_id = 2;
Entry entry = new Entry();
entry.setTitle("Title");
entry.setBody("Body");
entry.setStatus(EntryStatus.PUBLISH);
entry = client.postEntry(site_id, entry);
System.out.println(entry.getId());
System.out.println(entry.getCreatedDate());

// Searching the entries.
EntrySearchParam entrySearchParam = new EntrySearchParam();
entrySearchParam.setBlog_id(2);
entrySearchParam.setSearch("Title");
EntryItems entryItems = client.searchEntry(entrySearchParam);
for (Entry entry : entryItems.getItems()) {
    System.out.println(entry.getId());
    System.out.println(entry.getTitle());
}

// Retrieve a single entry by its ID.
int site_id = 2;
int entry_id = 10;
String fields = "title,body";  // All fields is null
Entry entry = client.getEntry(site_id, entry_id, fields);
System.out.println(entry.getId());
System.out.println(entry.getTitle());
System.out.println(entry.getBody());

// Retrieve list of entry in the specified site.
int site_id = 2;
EntryItems entryItems = client.getEntries(site_id);
for (Entry entry : entryItems.getItems()) {
    System.out.println(entry.getId());
    System.out.println(entry.getTitle());
}

// Update an existing category.
// - Create or search "Entry" object.
entry.setTitle("Update Title");
entry = client.updateEntry(site_id, entry_id, entry);
System.out.println(entry.getTitle());

// Delete an entry.
entry = client.deleteEntry(site_id, entry_id);
System.out.println(client.getResponseMessage());
```

### Asset

```java
// Upload a single file.
UploadParam uploadParam = new UploadParam();
uploadParam.setSite_id(1);
uploadParam.setUploadPath("/");
uploadParam.setAutoRenameIfExists(true);
uploadParam.setUploadLocalfile("/tmp/example.jpg");
Asset asset = client.uploadAsset(uploadParam);
System.out.println(asset.getFilename());
System.out.println(asset.getId());
System.out.println(client.getResponseMessage());

// Retrieve list of assets in the specified site.
int site_id = 1;
AssetSearchParam assetSearchParam = new AssetSearchParam();
assetSearchParam.setSearch("melody");
assetSearchParam.setSearchFields("label");
AssetItems assteItems = client.searchAsset(site_id, assetSearchParam);
for (Asset asset : assteItems.getItems()) {
    System.out.println(asset.getId());
    System.out.println(asset.getUrl());
}

// Retrieve a single asset by its ID.
int site_id = 1;
int asset_id = 10;
String fields = "label,url";  // All fields is null
Asset asset = client.getAsset(site_id, asset_id, fields);
System.out.println(asset.getLabel());
System.out.println(asset.getUrl());

// Delete an asset.
int site_id = 1;
int asset_id = 10;
Asset asset = client.deleteAsset(site_id, asset_id);
System.out.println(client.getResponseMessage());
```

### Category

```java
// Create a new category.
int site_id = 1;
Category category = new Category();
category.setBasename("news");
category.setLabel("News");
category.setClass_("category");
category = client.createCategory(site_id, category);
System.out.println(category.getId());

// Retrieve a list of categories.
int site_id = 1;
CategorySearchParam categorySearchParam = new CategorySearchParam();
categorySearchParam.setSearch("News");
categorySearchParam.setSearchFields("label");
CategoryItems categoryItems = client.searchCategory(site_id, categorySearchParam);
for (Category category : categoryItems.getItems()) {
    System.out.println(category.getLabel());
}

// Retrieve a single category by its ID.
int site_id = 1;
int category_id = 1;
String fields = "id,basename"  // All fields is null
Category category = client.getCategory(site_id, category_id, fields);
System.out.println(category.getLabel());
System.out.println(category.getBasename());
System.out.println(category.getId());

// Update an existing category.
// - Create or search "Category" object.
int site_id = 1;
category.setLabel("News2");
category = client.updateCategory(site_id, category_id, category);
System.out.println(category.getLabel());

// Delete an existing category.
int site_id = 1;
int category_id = 2;
Category category = client.deleteCategory(site_id, category_id);
System.out.println(client.getResponseMessage());
```

### User

```java
// Create a new user.
CreateUser createUser = new CreateUser();
createUser.setName("melody");
createUser.setPassword("nelsonnelson");
createUser.setDisplayName("Melody");
createUser.setEmail("melody@example.com");
User user = client.createUser(createUser);

// Retrieve a list of users.
UserSearchParam userSearchParam = new UserSearchParam();
userSearchParam.setSearch("melody");
userSearchParam.setSearchFields("email");
UserItems userItems = client.searchUser(userSearchParam);
for (User user : userItems.getItems()) {
    System.out.println(user.getId());
    System.out.println(user.getName());
    System.out.println(user.getEmail());
}

// Retrieve a single user by ID.
String user_id = "2";            // user_id or 'me'
String fields = "name,email";    // All fields is null
User user = client.getUser(user_id,fields);
System.out.println(user.getName());
System.out.println(user.getDisplayName());

// Update an existing user.
// - Create or search "User" object.
user.setDisplayName("melody2");
user = client.updateUser(user);
System.out.println(user.getDisplayName());

// Unlock user account.
int user_id = 2;
Status status = client.unlockUser(user_id);
System.out.println(status.getStatus());

// Delete an existing user.
User user = client.deleteUser(2);
System.out.println(client.getResponseMessage());
```

### API Response

```java
// HTTP status code.
int code = client.getResponseCode();

// API response message.
String message = client.getResponseMessage();

// API JSON Response.
String body = client.getResponseBody();
```

## License
[The MIT License (MIT)](./LICENSE.txt)

## Copyright
The following copyright notice applies to all the files provided in this distribution, including binary files, unless explicitly noted otherwise.

Copyright 2017 Six Apart, Ltd.
