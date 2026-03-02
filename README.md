#  Sistema de Gestión Hospitalaria – POO

Este proyecto es una aplicación Java desarrollada con principios de **Programación Orientada a Objetos (POO)** que simula procesos y operaciones de un hospital, incluyendo la administración de pacientes, médicos, pabellones y procedimientos quirúrgicos.

##  Características principales

-  Gestión integral de médicos, pacientes, EPS y pabellones
-  Simulación realista de procedimientos médicos y quirúrgicos  
-  Interfaz gráfica intuitiva y amigable
-  Generación de reportes detallados de simulaciones
-  Consultas en tiempo real de disponibilidad de pabellones

---

##  Flujo de la Aplicación y Funcionamiento

### **1. Pantalla Principal - Menú de Opciones**
<img width="395" height="365" alt="image" src="https://github.com/user-attachments/assets/31768ac3-f89e-4f73-a863-4844da126281" />


La aplicación inicia mostrando un menú intuitivo con ícono médico. El usuario puede seleccionar entre:
- **Simulación hospitalaria**: Ejecutar una simulación completa de atención
- **Consultar pabellón**: Ver disponibilidad de pabellones
  

**Menú**

*Pantalla inicial con selector de operaciones hospitalarias*

---

### **2. Consultar Pabellón**
<img width="435" height="276" alt="image" src="https://github.com/user-attachments/assets/430872b7-dbfd-448e-ae33-6b838e0e1e98" />


Módulo para consultar la disponibilidad de pabellones quirúrgicos. Permite:
- Seleccionar **EPS** (empresa de salud)
- Seleccionar **pabellón** disponible
- Ver información del pabellón
- Opciones para **Consultar**, **Limpiar** datos o **Volver** al menú

Consulta de **Pabellón**

*Interfaz de consulta con filtrado por EPS y pabellón*

---

### **3. Simulación Hospitalaria - Panel de Control Principal**
<img width="1366" height="729" alt="image" src="https://github.com/user-attachments/assets/9ad0e77f-42e6-4623-989d-cbeb663a81c3" />


Es el corazón de la aplicación. Permite registrar todos los datos necesarios para una simulación:

**Campos de entrada:**
- **Nombre médico**: Médico que atiende el caso
-  **Especialidad**: Área médica (Doctorio, Cirugía, etc.)
- **Nombre cirujano**: Especialista quirúrgico
- **Nombre paciente**: Identificación del paciente
- **EPS**: Entidad prestadora de salud
- **Síntoma**: Diagnóstico o condición médica
-  **Saldo disponible**: Presupuesto para la atención

**Botones de control:**
- **Ejecutar simulación**: Procesa toda la información
- **Limpiar salida**: Borra resultados anteriores
- **Volver**: Retorna al menú principal

**Simulación Hospitalaria**

*Panel completo de simulación con registro de datos y resultados en tiempo real*

---

## Resultados de la Simulación

Cuando se ejecuta una simulación, el sistema genera un reporte detallado que incluye:

- **Presentación**: Datos del médico, cirujano y paciente
- **Revisión médica**: Pacientes atendidos y diagnósticos
- **Priorización**: Orden de atención según urgencia
- **Procedimientos**: Operaciones realizadas y resultados
- **Atención post-operatoria**: Destino del paciente (Pabellón específico)

### Ejemplo de output:
```
[Médico] Sergio Perio Especialidad: Doctorio
[Cirujano] Dr. Aura Especialidad: Cirugía Quirófano: 5
[Paciente] Laura Aurea EPS: Sura Síntoma: Infarto

Dr. Sergio Perio revisando pacientes:
- Laura Aurea
Prioridad asignada: ALTA
El paciente Laura Aurea intenta pagar $50.0. Saldo actual $700000.0 Resultado: Exito
El cirujano Dr. Aura realizó operación en quirófano 5

Atención paciente Laura Aurea
Enviado a Pabellón A
```

---

##  Estructura del Proyecto

```
POO/
├── GestionHospital/       #  Código fuente Java (clases POO)
│   ├── Medico.java
│   ├── Paciente.java
│   ├── Cirujano.java
│   ├── Hospital.java
│   └── ... (otras clases)
├── screenshots/           # Imágenes de la interfaz
│   ├── 1-menu-principal.png
│   ├── 2-consultar-pabellon.png
│   └── 3-gestion-hospital-interfaz.png
├── index.html             # Documentación JavaDoc
├── README.md              # Este archivo
├── POO.iml                # Configuración IntelliJ IDEA
└── loquetoca.yaml         # Configuración adicional
```

---

##  Cómo Usar la Aplicación

### **Requisitos previos:**
- Java 8 o superior instalado
- IntelliJ IDEA (recomendado) u otro IDE Java
### **Pasos para ejecutar:**

1. **Clonar/descargar el repositorio**
   ```bash
   git clone https://github.com/Victor13578/POO.git
   cd POO
   ```

2. **Abrir en IDE**
   - Abrir IntelliJ IDEA
   - File → Open → Seleccionar carpeta POO
   - Esperar a que se indexe el proyecto

3. **Ejecutar la aplicación**
   - Buscar clase `Main` o `GestionHospital` en GestionHospital/
   - Click derecho → Run

4. **Interactuar con la interfaz**
   - Usar menú desplegable para seleccionar operación
   - Llenar formularios con datos hospitalarios
   - Revisar resultados en el panel de texto

---

## Conceptos POO Implementados

- **Clases y Objetos**: Médico, Paciente, Cirujano, Hospital
- **Herencia**: Especialización de roles hospitalarios
- **Encapsulación**: Atributos privados con getters/setters
- **Polimorfismo**: Diferentes tipos de atención médica
- **Composición**: Relaciones entre pacientes, médicos y pabellones

---

## Notas del Proyecto

-La book se durmió de tanto hacer commits
-No hay propósito en quitar las .classex porque son ejecutables se generan automáticamente cuando se corre el programa

---

##  Autor

**Victor13578** - Desarrollador del proyecto

**sergioaarangoh-cpu** - Desarrollador y cpu del proyecto

**Victor13578** - Desarrollador y gitgay del proyecto

---

## Contacto y Contribuciones

Si tienes sugerencias o mejoras, siéntete libre de:
- Abrir un **Issue**
- Enviar un **Pull Request**
- Contactar al autor

---
 


**Última actualización**: Marzo 2026 :)
**QUE VIVAN LO COCO**:*
**JUNQUESO ES GAY**
💯
💯
