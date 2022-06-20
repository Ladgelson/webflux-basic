# webflux-basic
A simple API using Spring Webflux to manage data about Github profiles. 

## Endpoints

### Create Github Profile:

**URL** : `/api/profiles/`

**Method** : `POST`

**Auth required** : NO

**Permissions required** : None

##### Request Body Example

```json
{
    "name": "Ladgelson",
    "repositories": [
         {
           "name": "java-api",
           "description": "A simple Spring Boot API",
           "languages": ["Java"]
         },
         {
           "name": "java-interview-questions",
           "description": "A list of answers of interview questions",
           "languages": ["Java"]
         }
    ]
}
```

##### Success Response

**Code** : `201 CREATED`

**Content examples**

```json
{
    "id": "23hcsd30-sds5456-asd3-543547"
    "name": "Ladgelson",
    "repositories": [
         {
           "name": "java-api",
           "description": "A simple Spring Boot API",
           "languages": ["Java"]
         },
         {
           "name": "java-interview-questions",
           "description": "A list of answers of interview questions",
           "languages": ["Java"]
         }
    ]
}
```
### Find Github Profiles:

**URL** : `/api/profiles/`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

##### Success Response

**Code** : `200 OK`

**Content examples**

```json
[
  {
      "id": "23hcsd30-sds5456-asd3-543547"
      "name": "Ladgelson",
      "repositories": [
           {
             "name": "java-api",
             "description": "A simple Spring Boot API",
             "languages": ["Java"]
           },
           {
             "name": "java-interview-questions",
             "description": "A list of answers of interview questions",
             "languages": ["Java"]
           }
      ]
  }
]
```
### Find Github Profile by id:

**URL** : `/api/profiles/{id}`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

##### Success Response

**Code** : `200 OK`

**Content examples**

```json
{
    "id": "23hcsd30-sds5456-asd3-543547"
    "name": "Ladgelson",
    "repositories": [
         {
           "name": "java-api",
           "description": "A simple Spring Boot API",
           "languages": ["Java"]
         },
         {
           "name": "java-interview-questions",
           "description": "A list of answers of interview questions",
           "languages": ["Java"]
         }
    ]
}
```
### Delete Github Profile by id:

**URL** : `/api/profiles/{}`

**Method** : `DELETE`

**Auth required** : NO

**Permissions required** : None

##### Success Response

**Code** : `204 NO_CONTENT`

## Notes

* This is a simple API using Webflux and Jetty, and it is not used to be a complete API. This is a simple reference of how to do use Spring WebFlux in a simple project.
