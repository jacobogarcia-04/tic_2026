# tic_2026
# CICD de APPScript

## Configuración del repositorio y Codespace

- Configurar el entorno
- Instalaciones necesarias:
    - Node.js (LTS)
    - npm o yarn
    - git
    - `clasp` (instalación: `npm install -g @google/clasp`)
- Habilitar la Google Apps Script API en tu configuración de usuario de Google: https://script.google.com/home/settings

## Autenticación de clasp

- Instala y autentica `clasp`:
    - `npm install -g @google/clasp`
    - `clasp login --no-localhost` (o `clasp login` según tu entorno)
- Archivo de credenciales de usuario
    - Puedes usar un archivo `credentials.json` en la raíz del proyecto o almacenar las credenciales como secretos de GitHub (por ejemplo `CLASP_CREDENTIALS`).
    - Si usas OAuth/client secrets, coloca el JSON de credenciales en `credentials.json` (no subir al repositorio público).

## Estructura del proyecto

- Estructura sugerida:

```
.