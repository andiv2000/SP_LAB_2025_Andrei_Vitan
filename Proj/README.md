# Product Management RESTful API

O aplicație Spring Boot pentru gestionarea produselor într-un magazin.

## Tehnologii Utilizate

- **Spring Boot 3.5.6** - Framework pentru construirea aplicațiilor Java
- **Spring Data JPA** - Accesul la baza de date
- **H2 Database** - Baza de date în memorie
- **Lombok** - Reducerea codului boilerplate
- **Java 17** - Versiune de Java

## Funcționalități

API-ul RESTful oferă următoarele operații CRUD pentru gestionarea produselor:

### Endpoints

#### 1. GET toate produsele
```
GET /api/products
```
Răspuns: Lista cu toate produsele din baza de date

#### 2. GET produs după ID
```
GET /api/products/{id}
```
Răspuns: Produsul cu ID-ul specificat

#### 3. POST - Adăugare produs nou
```
POST /api/products
Content-Type: application/json

{
  "name": "Laptop",
  "description": "Laptop de gaming",
  "price": 1500.50,
  "quantity": 10,
  "category": "Electronics"
}
```

#### 4. PUT - Editare produs existent
```
PUT /api/products/{id}
Content-Type: application/json

{
  "name": "Laptop Updated",
  "description": "Laptop de gaming actualizat",
  "price": 1600.50,
  "quantity": 8,
  "category": "Electronics"
}
```

#### 5. DELETE - Ștergere produs
```
DELETE /api/products/{id}
```

## Structura Proiectului

```
Proj/
├── src/
│   ├── main/
│   │   ├── java/ro/uvt/info/desingpatternslab2025/
│   │   │   ├── entity/
│   │   │   │   └── Product.java          # Entitatea Product
│   │   │   ├── repository/
│   │   │   │   └── ProductRepository.java # Repository pentru acces la date
│   │   │   ├── service/
│   │   │   │   └── ProductService.java    # Logica de business
│   │   │   ├── controller/
│   │   │   │   ├── ProductController.java # REST endpoints
│   │   │   │   └── HomeController.java    # Endpoints de bază
│   │   │   └── ProductManagementApplication.java
│   │   └── resources/
│   │       └── application.properties    # Configurarea aplicației
│   └── test/
│       └── java/...                       # Teste unitare
├── build.gradle
├── settings.gradle
├── gradle/
│   └── wrapper/
├── gradlew
├── gradlew.bat
└── README.md
```

## Proprietatea Model

Clasa `Product` conține următoarele proprietăți:
- `id` - Identificator unic (generat automat)
- `name` - Numele produsului
- `description` - Descrierea produsului
- `price` - Prețul produsului
- `quantity` - Cantitatea disponibilă
- `category` - Categoria produsului

## Rulare Aplicației

### Prerequisite
- Java 17+
- Gradle

### Pași de rulare

1. **Accesați directorul proiectului:**
```bash
cd Proj
```

2. **Construiți și rulați aplicația:**
```bash
./gradlew bootRun
```

Pe Windows:
```bash
gradlew.bat bootRun
```

3. **Accesați aplicația:**
- Home: http://localhost:8080/
- Health check: http://localhost:8080/health
- API Products: http://localhost:8080/api/products
- H2 Console: http://localhost:8080/h2-console (username: sa, password: empty)

## Testare API-ului

Puteți testa API-ul folosind **Postman** sau **curl**:

### Exemplu curl - Adăugare produs:
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Mouse",
    "description": "Wireless mouse",
    "price": 25.99,
    "quantity": 50,
    "category": "Accessories"
  }'
```

### Exemplu curl - Obținere toate produsele:
```bash
curl http://localhost:8080/api/products
```

### Exemplu curl - Actualizare produs:
```bash
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Mouse Updated",
    "description": "Wireless mouse updated",
    "price": 29.99,
    "quantity": 45,
    "category": "Accessories"
  }'
```

### Exemplu curl - Ștergere produs:
```bash
curl -X DELETE http://localhost:8080/api/products/1
```

## Configurație Bază de Date

Aplicația folosește **H2 Database** - o bază de date în memorie care nu necesită instalare. 

Configurări în `application.properties`:
- URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (gol)
- H2 Console accesibilă la: `http://localhost:8080/h2-console`

## Status HTTP

- `200 OK` - Cererea a reușit
- `201 CREATED` - Resursa a fost creată
- `204 NO_CONTENT` - Ștergerea a reușit (fără conținut)
- `400 BAD_REQUEST` - Cerere invalidă
- `404 NOT_FOUND` - Resursa nu a fost găsită

## Compilare și Build

```bash
# Compilare
./gradlew clean compile

# Build JAR
./gradlew clean build

# Build fără teste
./gradlew clean build -x test
```

## Autor

Andrei Vitan
