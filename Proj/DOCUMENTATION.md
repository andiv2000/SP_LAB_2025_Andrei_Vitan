# Product Management API - Documentație Completă

## 📋 Cuprins
1. [Descrierea Proiectului](#descrierea-proiectului)
2. [Ce Face Aplicația](#ce-face-aplicația)
3. [Cazuri de Utilizare](#cazuri-de-utilizare)
4. [Arhitectura Tehnică](#arhitectura-tehnică)
5. [Ghid de Instalare](#ghid-de-instalare)
6. [API Reference](#api-reference)
7. [Exemple Practice](#exemple-practice)
8. [Baza de Date](#baza-de-date)
9. [Troubleshooting](#troubleshooting)

---

## 🎯 Descrierea Proiectului

**Product Management API** este o aplicație **RESTful** construită cu **Spring Boot** care oferă un sistem complet pentru gestionarea inventarului de produse într-un magazin. Aplicația implementează operații **CRUD** (Create, Read, Update, Delete) și expune endpoints HTTP pentru interacțiunea cu datele.

### Informații Tehnice Generale:
- **Limbaj**: Java 17
- **Framework**: Spring Boot 3.5.6
- **Arhitectură**: REST API
- **Bază de Date**: H2 (in-memory)
- **Dependency Management**: Gradle
- **Build Tool**: Gradle Wrapper
- **License**: Open Source

---

## 🚀 Ce Face Aplicația

### Funcționalități Principale:

#### 1. **Gestionarea Produselor**
Aplicația permite administratorilor și utilizatorii să gestioneze complete produsele din magazin:

- ✅ **Adăugare Produse** - Introducere de noi articole în catalog
- ✅ **Vizualizare Produse** - Afișarea listei complete sau a unui produs specific
- ✅ **Editare Produse** - Actualizarea detaliilor existente
- ✅ **Ștergere Produse** - Eliminarea articolelor din sistem

#### 2. **Stocare Persistentă a Datelor**
- Datele sunt stocate în baza de date H2
- Fiecare produs are proprietăți: id, nume, descriere, preț, cantitate, categorie
- Identificatori unici (ID) generați automat

#### 3. **API RESTful Standard**
- Endpoints HTTP standard (GET, POST, PUT, DELETE)
- HTTP Status codes corecte
- JSON pentru request/response
- CORS enabled pentru acces cross-origin

#### 4. **Validare și Erori**
- Validare de date de intrare
- Mesaje de eroare clare
- Status codes HTTP descriptive

---

## 💼 Cazuri de Utilizare

### Caz 1: Magazin Online
**Scenariu**: O platformă de comerț electronic trebuie să gestioneze inventarul de produse.

```
Flux:
1. Administrator adaugă noi produse la catalog
2. Sistem stochează datele în baza de date
3. Clienți vizualizează produsele disponibile
4. Administrator actualizează prețurile și cantitățile
5. Produsele epuizate sunt șterse din catalog
```

### Caz 2: Sistem de Inventar pentru Depozit
**Scenariu**: Un depozit de materiale necesită urmărire în timp real a stocului.

```
Flux:
1. La sosirea mărfii, se adaugă produsele în sistem
2. Responsabilul verifică disponibilitatea prin API
3. La ieșirea din depozit, se actualizează cantitățile
4. Rapoarte asupra stocului curent
```

### Caz 3: Integrare cu Sisteme de E-Commerce
**Scenariu**: Sincronizare inventar între mai multe canale de vânzare.

```
Flux:
1. Sistem central manageriază produsele
2. Alte aplicații se conectează la API
3. Actualizări în timp real ale disponibilității
4. Prevenirea overselling-ului
```

### Caz 4: Sistem de Management pentru Retail
**Scenariu**: Magazin fizic cu gestiune digitală a produselor.

```
Flux:
1. Casierul scanează produsul în sistem
2. Se actualizează stocul automat
3. Alertă când cantitatea scade sub prag
4. Raport zilnic de vânzări
```

---

## 🏗️ Arhitectura Tehnică

### Structura Straturilor

```
┌─────────────────────────────────────┐
│     REST API Layer (Controller)      │
│  ProductController, HomeController   │
└────────────────┬────────────────────┘
                 │
┌────────────────▼────────────────────┐
│      Service Layer (Business Logic)  │
│         ProductService               │
└────────────────┬────────────────────┘
                 │
┌────────────────▼────────────────────┐
│    Data Access Layer (Repository)    │
│       ProductRepository              │
└────────────────┬────────────────────┘
                 │
┌────────────────▼────────────────────┐
│      Database Layer (H2)             │
│    In-Memory Relational Database     │
└─────────────────────────────────────┘
```

### Descrierea Componentelor:

#### **1. Entity Layer (Model)**
```
Product Entity:
- id: Long (PK)
- name: String
- description: String
- price: Double
- quantity: Integer
- category: String
```

**Rol**: Reprezentarea datelor în baza de date
**Tehnologie**: JPA Annotations

#### **2. Repository Layer**
```
ProductRepository extends JpaRepository<Product, Long>
```

**Rol**: Acces la baza de date CRUD
**Metodă**: Spring Data JPA - generează SQL automat
**Operații**: save(), findAll(), findById(), delete()

#### **3. Service Layer**
```
ProductService:
- getAllProducts()
- getProductById(id)
- createProduct(product)
- updateProduct(id, details)
- deleteProduct(id)
```

**Rol**: Logica de business
**Responsabilități**: Validare, transformări date, apeluri repository

#### **4. Controller Layer**
```
@RestController
@RequestMapping("/api/products")
```

**Rol**: Expunere HTTP endpoints
**Protocol**: REST + JSON
**Responsabilități**: Mapare HTTP → Service

### Design Patterns Utilizate:

1. **Repository Pattern** - Abstracție acces date
2. **Service Layer Pattern** - Separare logică business
3. **Dependency Injection** - Spring @Autowired
4. **DAO Pattern** - Data Access Object

---

## 📦 Ghid de Instalare

### Prerequisite:
```
- Java JDK 17 sau mai nou
- Git (pentru clonare repository)
- Gradle (inclus - Gradle Wrapper)
```

### Pași de Instalare:

#### **1. Clonare Repository**
```bash
git clone https://github.com/andiv2000/SP_LAB_2025_Andrei_Vitan.git
cd SP_LAB_2025_Andrei_Vitan
cd Proj
```

#### **2. Verificare Java**
```bash
java -version
# Ar trebui să afișeze Java 17+
```

#### **3. Build Proiectul**
```bash
# Pe Windows
gradlew.bat clean build

# Pe Linux/Mac
./gradlew clean build
```

#### **4. Rulare Aplicația**
```bash
# Pe Windows
gradlew.bat bootRun

# Pe Linux/Mac
./gradlew bootRun
```

#### **5. Verificare Stare**
```
Ar trebui să vedeți:
"Started ProductManagementApplication in X seconds"
```

---

## 🔌 API Reference

### Base URL
```
http://localhost:8080
```

### 1. **GET /api/products**
**Descriere**: Obține lista cu toate produsele

**Request**:
```http
GET /api/products HTTP/1.1
Host: localhost:8080
```

**Response (200 OK)**:
```json
[
  {
    "id": 1,
    "name": "Laptop Dell XPS",
    "description": "High performance laptop",
    "price": 1500.50,
    "quantity": 5,
    "category": "Electronics"
  },
  {
    "id": 2,
    "name": "Mouse Logitech",
    "description": "Wireless mouse",
    "price": 25.99,
    "quantity": 50,
    "category": "Accessories"
  }
]
```

---

### 2. **GET /api/products/{id}**
**Descriere**: Obține un produs după ID

**Request**:
```http
GET /api/products/1 HTTP/1.1
Host: localhost:8080
```

**Response (200 OK)**:
```json
{
  "id": 1,
  "name": "Laptop Dell XPS",
  "description": "High performance laptop",
  "price": 1500.50,
  "quantity": 5,
  "category": "Electronics"
}
```

**Response (404 Not Found)**:
```json
{
  "error": "Product not found"
}
```

---

### 3. **POST /api/products**
**Descriere**: Adaugă un produs nou

**Request**:
```http
POST /api/products HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "name": "Monitor LG 27 inch",
  "description": "4K UHD Monitor",
  "price": 450.00,
  "quantity": 15,
  "category": "Electronics"
}
```

**Response (201 Created)**:
```json
{
  "id": 3,
  "name": "Monitor LG 27 inch",
  "description": "4K UHD Monitor",
  "price": 450.00,
  "quantity": 15,
  "category": "Electronics"
}
```

**Response (400 Bad Request)**:
```
Dacă datele sunt invalide (lipsă câmpuri, tip greșit)
```

---

### 4. **PUT /api/products/{id}**
**Descriere**: Actualizează un produs existent

**Request**:
```http
PUT /api/products/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "name": "Laptop Dell XPS (Updated)",
  "description": "Ultra-high performance laptop",
  "price": 1699.99,
  "quantity": 3,
  "category": "Electronics"
}
```

**Response (200 OK)**:
```json
{
  "id": 1,
  "name": "Laptop Dell XPS (Updated)",
  "description": "Ultra-high performance laptop",
  "price": 1699.99,
  "quantity": 3,
  "category": "Electronics"
}
```

**Response (404 Not Found)**:
```
Dacă ID-ul nu există
```

---

### 5. **DELETE /api/products/{id}**
**Descriere**: Șterge un produs

**Request**:
```http
DELETE /api/products/1 HTTP/1.1
Host: localhost:8080
```

**Response (204 No Content)**:
```
(Fără body - ștergere reușită)
```

**Response (404 Not Found)**:
```
Dacă ID-ul nu există
```

---

### 6. **GET /**
**Descriere**: Pagina de bun venit

**Response**:
```
"Welcome to Product Management API! Use /api/products to manage products."
```

---

### 7. **GET /health**
**Descriere**: Verificare status aplicație

**Response**:
```
"Application is running!"
```

---

## 💻 Exemple Practice

### Exemplu 1: Adăugare Produs cu cURL

```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Keyboard Mechanical",
    "description": "RGB Mechanical Keyboard",
    "price": 120.00,
    "quantity": 20,
    "category": "Accessories"
  }'
```

**Rezultat**:
```json
{
  "id": 4,
  "name": "Keyboard Mechanical",
  "description": "RGB Mechanical Keyboard",
  "price": 120.00,
  "quantity": 20,
  "category": "Accessories"
}
```

---

### Exemplu 2: Obținere Toate Produsele

```bash
curl http://localhost:8080/api/products
```

---

### Exemplu 3: Actualizare Produs

```bash
curl -X PUT http://localhost:8080/api/products/4 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Keyboard Mechanical Pro",
    "description": "Premium RGB Mechanical Keyboard",
    "price": 150.00,
    "quantity": 18,
    "category": "Accessories"
  }'
```

---

### Exemplu 4: Ștergere Produs

```bash
curl -X DELETE http://localhost:8080/api/products/4
```

---

### Exemplu 5: Utilizare cu Postman

1. **Deschideți Postman**
2. **Creați request nou**:
   - Method: POST
   - URL: http://localhost:8080/api/products
   - Tab "Body" → raw → JSON
   - Paste:
   ```json
   {
     "name": "Product Name",
     "description": "Description",
     "price": 99.99,
     "quantity": 10,
     "category": "Category"
   }
   ```
3. **Send** și vedeți răspunsul

---

## 🗄️ Baza de Date

### Configurație H2

**Fișier**: `application.properties`

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=create-drop
```

### Acces H2 Console

```
URL: http://localhost:8080/h2-console
Username: sa
Password: (leave empty)
JDBC URL: jdbc:h2:mem:testdb
```

### Structura Tabel

```sql
CREATE TABLE products (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    quantity INTEGER NOT NULL,
    category VARCHAR(255) NOT NULL
);
```

### Tipuri de Date

| Coloană | Tip | Descriere |
|---------|-----|-----------|
| id | BIGINT | Identificator unic, auto-increment |
| name | VARCHAR(255) | Denumirea produsului |
| description | VARCHAR(255) | Descriere detaliată |
| price | DOUBLE | Prețul în RON/USD |
| quantity | INTEGER | Cantitate disponibilă |
| category | VARCHAR(255) | Categoria produsului |

### Comportament DDL

- `create-drop` = Crează tabelele la pornire, șterge la oprire
- Util pentru testare și development
- **NU pentru producție!**

---

## 🛠️ Troubleshooting

### Problema 1: "Port 8080 already in use"

**Soluție**:
```bash
# Găsiți procesul pe port 8080
netstat -ano | findstr :8080

# Opriți procesul (înlocuiți PID)
taskkill /PID <PID> /F

# Sau schimbați portul în application.properties
server.port=8081
```

---

### Problema 2: "Java version not compatible"

**Soluție**:
```bash
# Verificați versiunea Java
java -version

# Instalați Java 17+ de la https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
```

---

### Problema 3: "Gradle build fails"

**Soluție**:
```bash
# Curățare cache
gradlew.bat clean

# Redownload dependencies
gradlew.bat --refresh-dependencies

# Build din nou
gradlew.bat build
```

---

### Problema 4: "H2 console not accessible"

**Verificare**:
1. Aplicația trebuie să ruleze
2. `spring.h2.console.enabled=true` în properties
3. Accesați: http://localhost:8080/h2-console

---

### Problema 5: "Request returns 404 Not Found"

**Verificare**:
- URL corect: `/api/products` (nu `/api/product`)
- Aplicația rulează pe port 8080
- Produs cu ID-ul respectiv există

---

## 📊 Diagrame și Fluxuri

### Request Flow

```
Client Request
    ↓
Controller (@RequestMapping)
    ↓
Service (Business Logic)
    ↓
Repository (Database Access)
    ↓
H2 Database
    ↓
Response JSON
```

### CRUD Operations

```
CREATE (POST)
    └─ Service.createProduct() → Repository.save()

READ (GET)
    └─ Service.getProductById() → Repository.findById()
    └─ Service.getAllProducts() → Repository.findAll()

UPDATE (PUT)
    └─ Service.updateProduct() → Repository.save()

DELETE (DELETE)
    └─ Service.deleteProduct() → Repository.deleteById()
```

---

## 🔐 Securitate (Considerații viitoare)

Pentru producție, recomandări:

1. **Autentificare**: Adăugați Spring Security
2. **Validare Input**: Implementați constraint validators
3. **Rate Limiting**: Protejați API-ul de abuse
4. **Database**: Migrați de la H2 la PostgreSQL/MySQL
5. **Logging**: Adăugați slf4j/logback
6. **HTTPS**: Configurați SSL/TLS

---

## 📚 Resurse Suplimentare

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [REST API Best Practices](https://restfulapi.net/)
- [H2 Database Documentation](http://www.h2database.com/)

---

## 👨‍💻 Informații Developer

**Autor**: Andrei Vitan  
**Versiune**: 1.0.0  
**Data Creării**: 2025  
**Instituție**: UVT (Universitatea de Vest din Timișoara)  
**Curs**: Design Patterns Lab

---

## 📝 License

Acest proiect este open source și disponibil sub licența MIT.

---

**Última actualizare**: 7 Ianuarie 2026  
**Status**: Activ și testat
