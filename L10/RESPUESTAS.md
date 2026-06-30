# Hoja de Respuestas - Laboratorio 10

**Nombre:** [Tu Nombre Aquí]
**Código:** [Tu Código Aquí]

---

## Ejercicio 1: Caja Blanca (Evaluador de Créditos)

### 1.1) Cálculo de Complejidad Ciclomática
*(Escribe aquí tus cálculos usando las fórmulas de Nodos/Aristas o Predicados)*

- **Fórmula:** (Ej: Complejidad Ciclomática (V(G)) = Nodos de Decisión + 1)
- **Resultado:** (Ej: 3 + 1 = 4)

### 1.2) Caminos Independientes
*(Lista aquí los caminos independientes encontrados en tu Grafo de Flujo según tu cálculo anterior)*

- Camino 1: Inicio -> B(Sí) -> Retorna RECHAZADO_EDAD *(Ej: edad = 17)*
- Camino 2: 
- Camino 3: 
- ... *(Agrega los renglones necesarios)*

---

## Ejercicio 2: Caja Negra (Validador de Registro)

### 2.1) Tabla de Clases de Equivalencia

| Campo | Clases de Equivalencia Válidas | Clases de Equivalencia Inválidas |
|-------|--------------------------------|----------------------------------|
| Nombre | (Ej: Cualquier cadena que no sea vacía ni nula) | (Ej: Cadena vacía o nula) |
| Email | | |
| Edad | | |
| Tipo de Documento | | |
| Número de Documento | | |

### 2.2) Tabla de Casos de Prueba Válidos (Flujo Ideal)

| ID | Nombre | Email | Edad | Tipo Doc. | Num. Doc. | Resultado Esperado |
|---|--------|-------|------|-----------|-----------|--------------------|
| CP-V-01 | Juan Perez | juan@test.com | 25 | DNI | 12345678 | true *(Ejemplo resuelto)* |
| CP-V-02 | | | | | | |

### 2.3) Tabla de Casos de Prueba Inválidos (Flujos de Error)

| ID | Nombre | Email | Edad | Tipo Doc. | Num. Doc. | Resultado Esperado |
|---|--------|-------|------|-----------|-----------|--------------------|
| CP-I-01 |  | juan@test.com | 25 | DNI | 12345678 | false *(Ejemplo: Nombre vacío)* |
| CP-I-02 | | | | | | |
| CP-I-03 | | | | | | |

---
*(Recuerda que estas tablas te servirán de base para construir tus pruebas en JUnit 5 dentro del proyecto)*
