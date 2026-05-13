# API de Gestión de Clientes

Esta es una API REST desarrollada con **Spring Boot** para la gestión de clientes, diseñada como parte de la Diplomatura en Desarrollo de Software FinTech.

## 🚀 Tecnologías Utilizadas

*   **Java 21**
*   **Spring Boot 4.0.6**
*   **Spring Data JPA** (Persistencia)
*   **Spring Web** (API REST)
*   **MySQL** (Base de datos de producción)
*   **H2 Database** (Base de datos en memoria para tests)
*   **Lombok** (Productividad)
*   **Maven** (Gestión de dependencias)

## 📋 Requisitos Previos

*   JDK 21 instalado.
*   Maven 3.x instalado (o usar el `mvnw` incluido).
*   MySQL Server corriendo localmente.

## ⚙️ Configuración de la Base de Datos

El proyecto utiliza una base de datos MySQL. Asegúrate de crear la base de datos antes de correr la aplicación:

```sql
CREATE DATABASE belendiplomatura;
```

La configuración por defecto en `src/main/resources/application.yaml` es:
*   **URL:** `jdbc:mysql://127.0.0.1:3306/belendiplomatura`
*   **Usuario:** `belen`
*   **Contraseña:** `1234`

## 🛠️ Instalación y Ejecución

1. Clonar el repositorio o descargar los archivos.
2. Navegar a la carpeta del proyecto:
   ```bash
   cd SpringInitializr/api
   ```
3. Compilar y ejecutar la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```

La API estará disponible en `http://localhost:8080`.

## 📌 Endpoints de la API

La base de la URL es `/clientes`.

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| **GET** | `/clientes` | Obtiene la lista de todos los clientes. |
| **GET** | `/clientes/{id}` | Obtiene los detalles de un cliente por ID. |
| **POST** | `/clientes/agregar` | Crea un nuevo cliente. |
| **PUT** | `/clientes/{id}` | Actualiza un cliente existente. |
| **DELETE** | `/clientes/{id}` | Elimina un cliente. |

### Ejemplo de JSON para POST/PUT:
```json
{
  "nombre": "Juan",
  "apellidoRazonSocial": "Pérez",
  "documentoCuit": "20-12345678-9",
  "direccion": "Calle Falsa 123",
  "telefono": "1144556677",
  "email": "juan.perez@example.com",
  "tipoCliente": "PERSONA_FISICA",
  "activo": true,
  "saldoPendiente": 0.0,
  "fechaAlta": "2024-05-13"
}
```

## 🧪 Pruebas

Para ejecutar los tests unitarios y de integración:
```bash
./mvnw test
```

---
*Proyecto desarrollado para la Diplomatura en Desarrollo de Software FinTech.*
