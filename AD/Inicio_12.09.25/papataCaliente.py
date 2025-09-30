import random
import time


tiempo = random.randint(8, 15)
numeroRandom = random.randint(1, 100)

print(f"Tienes {tiempo} segundos para adivinar el numero entre 1 y 100")


inicio = time.time()

while True:
    if time.time() - inicio >= tiempo:
        print(f"Tiempo acabo, numero era {numeroRandom}")
        break
    intento = int(input("Adivina el numero: "))
    if intento == numeroRandom:
        print("Has ganado")
        break
    elif intento < numeroRandom:
        print("Numero es mayor")
    else:
        print("Numero es menor")
