# User API Spec

## Register User

Endpoint : POST /api/users

Request Body :
```json
{
  "username" : "fin",
  "password" : "112233",
  "name" : "finofin hulu"
}
```

Response Body (Success) :
```json
{
  "data" : "OK"
}
```

Response Body (Failed) :
```json
{
  "errors" : "Username is blank, ???"
}
```

## Login User

Endpoint : POST /api/auth/login

Request Body :
```json
{
  "username" : "fin",
  "password" : "112233"
}
```

Response Body (Success) :
```json
{
  "data" : {
    "token" : "TOK",
    "expiredAt" : 2323232232 //millisecond
  }
}
```

Response Body (Failed, 401) :
```json
{
  "errors" : "Username or Password wrong"
}
```

## Get User
Endpoint : GET /api/users/current

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :
```json
{
  "data" : {
    "username" : "fin",
    "name" : "finofin hulu"
  }
}
```

Response Body (Failed, 401) :
```json
{
  "errors" : "Unauthorized"
}
```

## Update User

Endpoint : PATCH /api/users/current

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :
```json
{
  "name" : "gin", //put if only want to update name
  "password" : "didi123" //put if only want to update password
}
```

Response Body (Success) :
```json
{
  "data" : {
    "token" : "TOK",
    "expiredAt" : 2323232232 //millisecond
  }
}
```

Response Body (Failed, 401) :
```json
{
  "errors" : "Username or Password wrong"
}
```

## Logout User

Endpoint : DELETE /api/auth/logout

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :
```json
{
  "data" : "OK"
}
```