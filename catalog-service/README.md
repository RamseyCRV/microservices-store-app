# Catalog-Service Microservices
**Import the next JSON in Postman. All requests for all controllers are here**
------------------------------------------------------------------------------

{
"info": {
"_postman_id": "b6319e88-fda7-42d0-a961-baa03a084303",
"name": "catalog-service",
"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
"_exporter_id": "13627849"
},
"item": [
{
"name": "Get Catalogs",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "http://localhost:8080/api/v1/catalog",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"catalog"
]
}
},
"response": []
},
{
"name": "Save Catalog",
"request": {
"method": "POST",
"header": [],
"body": {
"mode": "raw",
"raw": "{\n    \"name\": \"Laptops\",\n    \"description\" : \"One catalog for all laptops devices\"\n}",
"options": {
"raw": {
"language": "json"
}
}
},
"url": {
"raw": "http://localhost:8080/api/v1/catalog/new",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"catalog",
"new"
],
"query": [
{
"key": "name",
"value": "Laptops",
"disabled": true
},
{
"key": "description",
"value": "One catalog for all laptops devices",
"disabled": true
}
]
}
},
"response": []
},
{
"name": "Find Catalog By Id",
"request": {
"method": "GET",
"header": []
},
"response": []
},
{
"name": "Delete Catalog",
"request": {
"method": "DELETE",
"header": [],
"url": {
"raw": "http://localhost:8080/api/v1/catalog/delete",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"catalog",
"delete"
]
}
},
"response": []
},
{
"name": "Update catalog",
"request": {
"method": "PUT",
"header": [],
"url": {
"raw": "http://localhost:8080/api/v1/catalog/update",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"catalog",
"update"
]
}
},
"response": []
},
{
"name": "Get Categories",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "http://localhost:8080/api/v1/category",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"category"
]
}
},
"response": []
},
{
"name": "Save Category",
"request": {
"method": "POST",
"header": [],
"url": {
"raw": "http://localhost:8080/api/v1/category/new",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"category",
"new"
]
}
},
"response": []
},
{
"name": "Find Category By Id",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "http://localhost:8080/api/v1/category/find/2",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"category",
"find",
"2"
]
}
},
"response": []
},
{
"name": "Update Category",
"request": {
"method": "PUT",
"header": [],
"url": {
"raw": "http://localhost:8080/api/v1/category/update",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"category",
"update"
]
}
},
"response": []
},
{
"name": "Delete Category",
"request": {
"method": "DELETE",
"header": [],
"body": {
"mode": "raw",
"raw": "\"2\"",
"options": {
"raw": {
"language": "json"
}
}
},
"url": {
"raw": "http://localhost:8080/api/v1/category/delete",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"category",
"delete"
]
}
},
"response": []
},
{
"name": "Get Products",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "http://localhost:8080/api/v1/product",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"product"
]
}
},
"response": []
},
{
"name": "Save Product",
"request": {
"method": "POST",
"header": [],
"body": {
"mode": "raw",
"raw": "{\n    \"name\" : \"MacBook Pro\",\n    \"description\" : \"MacBook Pro 16 with 526GB SSD and M1 Pro proccessor\",\n    \"catalogId\" : 1,\n    \"categoryId\" : 1,\n    \"price\" : 11,\n    \"stock\" : 120\n}",
"options": {
"raw": {
"language": "json"
}
}
},
"url": {
"raw": "http://localhost:8080/api/v1/product/new",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"product",
"new"
]
}
},
"response": []
},
{
"name": "Find Product By Id",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "http://localhost:8080/api/v1/product/find/1",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"product",
"find",
"1"
]
}
},
"response": []
},
{
"name": "Update Product",
"request": {
"method": "PUT",
"header": [],
"body": {
"mode": "raw",
"raw": "{\n    \"name\" : \"MacBook Pro\",\n    \"description\" : \"MacBook Pro 16 with 526GB SSD and M1 Pro proccessor\",\n    \"catalogId\" : 1,\n    \"categoryId\" : 1,\n    \"price\" : 11,\n    \"stock\" : 120\n}",
"options": {
"raw": {
"language": "json"
}
}
},
"url": {
"raw": "http://localhost:8080/api/v1/product/update",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"product",
"update"
]
}
},
"response": []
},
{
"name": "Delete Product",
"request": {
"method": "DELETE",
"header": [],
"body": {
"mode": "raw",
"raw": "\"1\"",
"options": {
"raw": {
"language": "json"
}
}
},
"url": {
"raw": "http://localhost:8080/api/v1/product/delete",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"v1",
"product",
"delete"
]
}
},
"response": []
}
]
}