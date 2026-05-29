# Taller: Modelo 4+1 — Taller Integrador
**Curso:** Ingeniería de Software 2 · 2026-1
**Tema:** Integración de las 5 vistas del Modelo 4+1 para documentar un sistema completo

---

## Objetivo
Aplicar las cinco vistas del modelo 4+1 de forma integrada para documentar la arquitectura completa de un nuevo sistema, verificando la coherencia entre vistas y comunicando la arquitectura a diferentes audiencias.

---

## Caso de estudio: Sistema de Reserva de Salas — SalaUlima

Para este taller se les ha pedido implementar el sistema de reserva de salas de estudio y laboratorios de la Universidad de Lima (**SalaUlima**).

**Descripción del sistema:**
- Los estudiantes y profesores pueden reservar salas de estudio o laboratorios de cómputo
- Cada sala tiene capacidad, equipamiento y horarios disponibles
- Las reservas son por franjas horarias (ej: 10:00-12:00)
- Se puede cancelar una reserva hasta 1 hora antes del inicio
- El sistema envía recordatorios 30 minutos antes de la reserva
- El administrador puede bloquear salas por mantenimiento

**Actores:** Estudiante, Profesor, Administrador
**Sistemas externos:** SSO Universitario, SendGrid (notificaciones)
**Atributo de calidad crítico:** Disponibilidad 99% (las reservas se hacen online, pero el acceso a la sala es presencial)

---

## Ejercicio 1: Vista Lógica — Modelo del dominio

Crea el **diagrama de clases UML** del dominio de SalaUlima.

**Entidades mínimas a incluir:**
- `Sala` (con capacidad, tipo, equipamiento, ubicación)
- `Reserva` (con fecha, franja horaria, estado)
- `FranjaHoraria` (inicio, fin)
- `Usuario` abstracta con `Estudiante` y `Profesor`
- `Bloqueo` (administrador bloquea una sala por mantenimiento)

**Reglas de negocio a reflejar:**
- Una `Sala` puede tener múltiples `Reserva` pero no en franjas solapadas
- Una `Reserva` puede estar en: PENDIENTE, CONFIRMADA, CANCELADA, COMPLETADA
- Un `Bloqueo` tiene fecha inicio, fecha fin y motivo

**Entregable:** Diagrama de clases con multiplicidades y métodos clave.

---

## Ejercicio 2: Vista de Procesos — Comportamiento dinámico

Crea DOS diagramas:

**2a. Diagrama de estados** del objeto `Reserva`:
- Estados: PENDIENTE → CONFIRMADA → COMPLETADA
- Transiciones: cancelación (antes de 1h), no-show (expiración sin confirmación)
- Incluir acciones de entrada/salida

**2b. Diagrama de secuencia** para "Estudiante reserva una sala":
1. El estudiante busca salas disponibles para una fecha y horario
2. El sistema verifica disponibilidad (no hay solapamiento con otras reservas ni bloqueos)
3. El estudiante confirma la reserva
4. El sistema registra la reserva y envía confirmación por email
5. 30 minutos antes: el sistema envía un recordatorio (proceso batch)

**Entregable:** Diagrama de estado y diagrama de secuencia.

---

## Ejercicio 3: Vista de Desarrollo — Organización del código

Crea el **diagrama de paquetes** de SalaUlima con arquitectura hexagonal.

**Módulos de dominio:**
- `rooms` — catálogo y disponibilidad de salas
- `reservations` — gestión de reservas
- `users` — autenticación y perfiles
- `notifications` — envío de recordatorios y confirmaciones

**Requisitos:**
- Cada módulo con sus sub-paquetes `domain`, `application`, `infrastructure`
- Dependencias correctas (nunca infrastructure → domain directamente en módulos ajenos)
- Módulo `shared` para código transversal

**Entregable:** Diagrama de paquetes en PlantUML.

---

## Ejercicio 4: Vista Física — Infraestructura de despliegue

Crea el **diagrama de despliegue** para el entorno de producción de SalaUlima.

**Restricciones de infraestructura:**
- Presupuesto limitado: solo 1 EC2 t3.small (sin cluster)
- RDS t3.micro PostgreSQL
- Sin CDN (el frontend está en el mismo servidor)
- Redis ElastiCache para evitar solapamientos de reserva (lock distribuido)

**Tarea adicional:** ¿Qué riesgo de disponibilidad introduce esta arquitectura de menor costo? ¿Cómo lo documenta la Vista Física?

**Entregable:** Diagrama de despliegue + análisis de riesgo.

---

## Ejercicio 5: Vista de Escenarios — Validación cruzada

Elige el escenario **"Dos estudiantes intentan reservar la misma sala en la misma franja simultáneamente"** y valida la arquitectura:

**Tabla de trazabilidad:**
| Vista | Elementos involucrados | ¿La vista lo soporta correctamente? |
|---|---|---|
| Lógica | ? | ? |
| Procesos | ? | ? |
| Desarrollo | ? | ? |
| Física | ? | ? |

**Diagrama de secuencia** del escenario con control de concurrencia.

**Pregunta clave:** La Vista Física muestra que Redis se usa para lock distribuido. ¿Cómo se refleja esto en la Vista de Procesos (diagrama de secuencia)?

**Entregable:** Tabla de trazabilidad + diagrama de secuencia con lock de Redis.

---

## Ejercicio 6: Documento de arquitectura integrado

Produce un **resumen ejecutivo del documento de arquitectura** de SalaUlima que incluya:

1. **Tabla de vistas** (qué diagrama cubre cada vista y para qué audiencia)
2. **Matriz de trazabilidad** (escenarios × vistas): qué escenarios ejercen qué vistas
3. **Top 3 decisiones arquitectónicas** (ADRs resumidos en 1-2 oraciones cada uno)
4. **Riesgos identificados** en las vistas (al menos 3)
5. **Cómo comunicarías esta arquitectura** a: (a) un nuevo desarrollador, (b) el director de TI de la universidad

**Entregable:** Documento Markdown de 400-600 palabras.
