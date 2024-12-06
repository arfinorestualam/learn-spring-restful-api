# Address API Spec

## Create Address

Endpoint : POST /api/contacts/{idContact}/addresses

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :
```json
{
  "street" : "ya jalan",
  "city" : "kota",
  "province" : "provinsi",
  "country" : "negara",
  "postalCode" : "12121"
}
```

Response Body (Success) :
```json
{
  "data" : {
    "id" : "random-string",
    "street" : "ya jalan",
    "city" : "kota",
    "province" : "provinsi",
    "country" : "negara",
    "postalCode" : "12121"
  }
}
```

Response Body (Failed) :
```json
{
  "errors" : "yo nda tau ko tanya saya"
}
```

## Update Address

Endpoint : PUT /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :
```json
{
  "street" : "ya jalan",
  "city" : "kota",
  "province" : "provinsi",
  "country" : "negara",
  "postalCode" : "12121"
}
```

Response Body (Success) :
```json
{
  "data" : {
    "id" : "random-string",
    "street" : "ya jalan",
    "city" : "kota",
    "province" : "provinsi",
    "country" : "negara",
    "postalCode" : "12121"
  }
}
```

Response Body (Failed) :
```json
{
  "errors" : "yo nda tau ko tanya saya"
}
```

## Get Address

Endpoint : GET /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :
```json
{
  "data" : {
    "id" : "random-string",
    "street" : "ya jalan",
    "city" : "kota",
    "province" : "provinsi",
    "country" : "negara",
    "postalCode" : "12121"
  }
}
```

Response Body (Failed) :
```json
{
  "errors" : "yo nda tau ko tanya saya"
}
```

## Remove Address

Endpoint : DELETE /api/contacts/{idContact}/addresses/{idAddress}

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

## List Address

Endpoint : GET /api/contacts/{idContacts}/addresses

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :
```json
{
  "data" : [
    {
      "id" : "random-string",
      "street" : "ya jalan",
      "city" : "kota",
      "province" : "provinsi",
      "country" : "negara",
      "postalCode" : "12121"
    }
  ]
}
```

Response Body (Failed) :
```json
{
  "errors" : "yo nda tau ko tanya saya"
}
```