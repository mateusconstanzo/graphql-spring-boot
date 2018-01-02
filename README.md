# Graphql + Spring Boot

## Frameworks

- **Spring Boot**
- **Spring Data**
- **GraphQL**

## Setup

- Gradle
- Java 1.8
- MySQL
- Docker

### Gradle

```
gradle build
 
docker-compose up
 
http://localhost:8080/graphiql
```

## Query

Save Author

```
mutation {
  saveAuthor(firstName:"Mateus", lastName: "Constanzo") {
    id,
    name,
    firstName,
    lastName,
  }
}
```

Get all Author

```
{
  authors {
    id,
    name,
    firstName,
    # lastName
  }
}
```

Get all Author with Posts

```
{
  authors {
    id,
    name,
    # firstName,
    # lastName
    posts {
      id
    }
  }
}
```

Save Post

```
mutation {
  savePost(authorId:1, title: "Graphql + Spring Boot", text: "Example", category : "Spring Boot") {
    id,
    title,
    category
  }
}
```

Get all Posts

```
{
  posts {
    id,
    title,
    category
  }
}
```

Get all Posts with Author

```
{
  posts {
    id
    title
    category
    author {
      id
      name
    }
  }
}
```