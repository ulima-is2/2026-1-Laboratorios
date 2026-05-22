# Laboratorio 6: Gestión de Historias de Usuario con GitHub Projects

## Objetivo

Aprender a utilizar GitHub Projects como herramienta de gestión ágil para organizar, priorizar y dar seguimiento a las historias de usuario del proyecto del curso.

Al finalizar el laboratorio, cada equipo deberá tener configurado un tablero de proyecto en GitHub con todas sus historias de usuario correctamente registradas y con todas las propiedades del task completas.

---

# Requisitos Previos

- Tener una cuenta en GitHub
- Tener un repositorio creado para el proyecto del curso.
- Todos los integrantes deben tener acceso al repositorio.

---

# Parte 1: Creación del GitHub Project

## Paso 1: Crear el Project

1. Ingresar al repositorio del proyecto.
2. Ir a la pestaña **Projects**.
3. Seleccionar **New Project**.
4. Elegir la plantilla **Board**.
5. Nombrar el proyecto con el formato:

```text
<Nombre de Grupo>- <NombreProyecto>
```

Ejemplo:

```text
G1 - App Ulima
```

---

# Parte 2: Creación de Historias de Usuario

Cada historia de usuario deberá registrarse como un **Issue**.

## Formato del título

```text
Feature: <nombre de la funcionalidad>
```

Ejemplos:

```text
Feature: Registro de usuarios
Feature: Inicio de sesión
Feature: Gestión de inventario
```

---

## Formato de descripción

Usar el siguiente formato:

```markdown
## Historia de Usuario

Como <tipo de usuario>,
quiero <objetivo>,
para <beneficio>.

## Criterios de Aceptación

- [ ] Criterio 1
- [ ] Criterio 2
- [ ] Criterio 3
```

### Ejemplo

```markdown
## Historia de Usuario

Como usuario registrado,
quiero iniciar sesión con mi correo y contraseña,
para acceder a mi panel personal y ver mi progreso.

## Criterios de Aceptación

- [ ] El usuario puede ingresar correo y contraseña.
- [ ] La sesión se inicia correctamente con credenciales válidas.
- [ ] Se muestra un mensaje de error para credenciales inválidas.
```

---

# Parte 3: Completar Todas las Propiedades del Task

Cada Issue creado deberá tener TODAS las propiedades configuradas.

## Propiedades obligatorias

| Propiedad   | Descripción            |
| ----------- | ---------------------- |
| Status      | Estado actual del task |
| Assignee    | Responsable asignado   |
| Labels      | Tipo de tarea          |
| Priority    | Prioridad del task     |
| Size        | Tamaño o complejidad   |
| Estimate    | Estimación en puntos   |
| Iteration   | Sprint o iteración     |
| Start Date  | Fecha de inicio        |
| Target Date | Fecha objetivo         |

---

## Valores sugeridos

### Priority

- P0 → Crítico
- P1 → Alta
- P2 → Media
- P3 → Baja

### Size

- XS
- S
- M
- L
- XL

### Labels

- enhancement
- bug
- documentation
- backend
- frontend
- database

---

# Parte 4: Organización del Project

Deberán:

- Mover los tasks según el progreso.
- Asignar responsables reales.
- Mantener actualizado el estado de cada historia.
- Priorizar correctamente las funcionalidades.
- Estimar el esfuerzo de desarrollo.

---

# Entregable

Cada grupo deberá entregar:

1. URL del repositorio GitHub.
2. URL del GitHub Project.
3. Mínimo 10 historias de usuario registradas.
4. Todas las historias deben tener:
   - Descripción completa
   - Responsable asignado
   - Prioridad
   - Estimación
   - Fechas
   - Labels
   - Estado actualizado

---

# Criterios de Evaluación

| Criterio                            |
| ----------------------------------- |
| Creación correcta del Project       |
| Historias de usuario bien definidas |
| Uso correcto de propiedades         |
| Organización y priorización         |
| Asignacion de permisos admin a los  siguientes usuarios `jsatch` & `aronlo98`   |

---

# Recomendaciones

- Mantener nombres claros y consistentes.
- Crear tareas pequeñas y manejables.
- Usar criterios de aceptación específicos.
- Actualizar el board constantemente.
- Evitar tasks demasiado generales.

---

# Recursos

- https://docs.github.com/en/issues/planning-and-tracking-with-projects/learning-about-projects/about-projects
- https://docs.github.com/en/issues/tracking-your-work-with-issues/about-issues
- https://www.markdownguide.org/basic-syntax/