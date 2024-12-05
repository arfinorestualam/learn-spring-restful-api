# Contact API Spec

## Create Contact

Endpoint : POST /api/contacts

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :
```json
{
  "firstName" : "fifin",
  "lastName" : "hulu",
  "email" : "fifin@example.com",
  "phone" : "12345"
}
```

Response Body (Success) :
```json
{ "data" : {
      "id" : "random-String",
      "firstName" : "fifin",
      "lastName" : "hulu",
      "email" : "fifin@example.com",
      "phone" : "12345"
  }
}
```

Response Body (Failed) :
```json
{
  "errors" : "yo nda tau ko tanya saya"
}
```

## Update Contact

Endpoint : PUT /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :
```json
{
  "firstName" : "fifin",
  "lastName" : "hulu",
  "email" : "fifin@example.com",
  "phone" : "12345"
}
```

Response Body (Success) :
```json
{ "data" : {
      "id" : "random-String",
      "firstName" : "fifin",
      "lastName" : "hulu",
      "email" : "fifin@example.com",
      "phone" : "12345"
  }
}
```

Response Body (Failed) :
```json
{
  "errors" : "yo nda tau ko tanya saya"
}
```


## Get Contact

Endpoint : GET /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :
```json
{ "data" : {
      "id" : "random-String",
      "firstName" : "fifin",
      "lastName" : "hulu",
      "email" : "fifin@example.com",
      "phone" : "12345"
  }
}
```

Response Body (Failed, 404) :
```json
{
  "errors" : "yo nda tau ko tanya saya"
}
```

## Search Contact

Endpoint : GET /api/contacts

Query Param :

- name : String, contact first name or last name, using like query, optional
- phone : String, contact phone, using like query, optional
- email : String, contact email, using like query, optional
- page : Integer, start from 0, default 0
- size : Integer, default 10

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :
```json
{
  "data" : [
    {
      "id" : "random-String",
      "firstName" : "fifin",
      "lastName" : "hulu",
      "email" : "fifin@example.com",
      "phone" : "12345"
    }
  ],
  "paging" : {
    "currentPage" : 0,
    "totalPage" : 10,
    "size" : 10
  }
}
```

Response Body (Failed) :
```json
{
  "errors" : "yo nda tau ko tanya saya"
}
```

## Remove Contact

Endpoint : DELETE /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :
```json
{
  "data" : "OK"
}
```

Response Body (Failed) :
```json
{
  "errors" : "yo nda tau ko tanya saya"
}
```
