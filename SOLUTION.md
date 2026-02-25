[200~# Imprime texto con formato
printf "Esto es %s con %d formato\n" "un ejemplo" 1

Haz un dibujo

echo "  /\\_/\\"
echo " ( o.o )"
echo "  > ^ <"


figlet y toilet:
# Instalar si no están instalados
sudo apt install figlet toilet

# Generar texto artístico
figlet "Ubuntu"
toilet -f mono12 -F gay "Terminal Art"


Juego de adivinanza:

#!/bin/bash

# Genera un número aleatorio entre 1 y 100
numero_secreto=$(( $RANDOM % 100 + 1 ))
intentos=0

echo "Adivina el número secreto (entre 1 y 100)"

while true; do
  read -p "Introduce tu intento: " intento
  ((intentos++))

  if (( intento == numero_secreto )); then
    echo "¡Correcto! Adivinaste en $intentos intentos."
    break
  elif (( intento < numero_secreto )); then
    echo "Demasiado bajo. Intenta de nuevo."
  else
    echo "Demasiado alto. Intenta de nuevo."
  fi
done

