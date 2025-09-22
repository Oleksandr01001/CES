"""
suma = 0
for i in range(1, 11):
    suma += i
print("La suma de los primeros 10 numeros enteros es:", suma)    
"""

"""
num = int(input("Introduce un numero: "))
fact = 1
i = 1
for i in range(1, num + 1):
    fact *= i
print("El factorial de", num, "es:", fact)
"""

"""
for num in range(1, 51):
    divisores = 0

    for j in range(num, 0, -1):
        if num % j == 0:
            divisores += 1

    if divisores == 2:
        print(num, "es primo")
    else:
        print(num, "no es primo")     
"""

"""
num = int(input("Introduce un numero: "))
suma = 0
for digito in str(num):
    suma += int(digito)
print("La suma de los digitos de", num, "es:", suma)
"""

"""
resultado = 0
for i in range(1, 101):
    if i % 2 == 0:
        resultado += i
print("El resultado es:", resultado)
"""

"""
base = int(input("Introduce la base: "))
altura = int(input("Introduce la altura: "))
area = (base * altura) / 2
print("El area:", area)
"""

"""
for i in range(1, 101):
    if i % 3 == 0:
        print("Fizz")
    if i % 5 == 0:
        print("Buzz")   
    print(i)    
"""

"""
import random
numRandom = random.randint(1, 100)
num = 0
while num != numRandom:
    num = int(input("Introduce un numero: "))
    if num < numRandom:
        print("El numero es mayor")
    elif num > numRandom:
        print("El numero es menor")
    else:    
        print("Has acertado")   
        break
"""
"""
cantidad = int(input("¿Cuántos números quieres introducir? "))
suma = 0
for i in range(cantidad):
    n = float(input("Introduce un número: "))
    suma += n

promedio = suma / cantidad
print("El promedio de los números es:", promedio)
"""

"""
cadena = input("Introduce una cadena: ")
vocales = "aeiouAEIOU"
contador = 0
for char in cadena:
    if char in vocales:
        contador += 1   
print("El numero de vocales en la cadena es:", contador)
"""        

"""
palabra = input("Introduce una palabra: ")
reversa = ""
for letra in palabra:
    reversa = letra + reversa
if palabra == reversa:
    print("Es un palindromo")
else:
    print("No es un palindromo")
"""
"""
import math
radio = float(input("Introduce el radio: "))
pi = math.pi
area = pi * (radio ** 2)
print("El area del circulo es:", area)
"""
"""
num = int(input("Introduce un numero: "))
for i in range(1, 11):
    print(num, "*", i, "=", num * i)
"""
"""
resultado = 0
for i in range(1, 101):
    if i % 2 != 0:
        resultado += i
print("El resultado es:", resultado)
"""
"""
cadena = input("Introduce una cadena de texto: ")
letraEspecifica = input("Introduce una letra especifica: ")
contador = 0
for i in cadena:
    if i == letraEspecifica:
        contador += 1
print("La letra", letraEspecifica, "aparece", contador, "veces")
"""
"""
a = int(input("Introduce el primer numero: "))
b = int(input("Introduce el segundo numero: "))

while b != 0:
    resto = a % b
    a = b
    b = resto
print("El MCD es:", a)
"""
"""
n = int(input("Introduce un numero: "))
k = int(input("Introduce otro numero: "))

if k < 0 or n < 0 or k > n:
    print("Error en los valores")
else:

    factN = 1
    for i in range(1, n + 1):
        factN *= i

    factK = 1   
    for i in range(1, k + 1):
        factK *= i

    factNK = 1
    for i in range(1, (n - k) + 1):
        factNK *= i

    resultado = factN // (factK * factNK)
    print("El resultado es:", resultado)            

"""
"""
import random

while True:
    print("Elige tu opcion:")
    print("1 - Piedra")
    print("2 - Papel")
    print("3 - Tijeras")

    jugador = int(input("Introduce la opcion: "))
    numRandom = random.randint(1, 3)

    if jugador == 1:
        print("Has elegido Piedra")
    elif jugador == 2:
        print("Has elegido Papel")
    elif jugador == 3:
        print("Has elegido Tijeras")
    else:
        print("Opcion no valida")
        continue

    if numRandom == 1:
        print("La maquina ha elegido Piedra")
    elif numRandom == 2:
        print("La maquina ha elegido Papel")
    else:
        print("La maquina ha elegido Tijeras")  
    
    if jugador == numRandom:
        print("Empate")
    elif (jugador == 1 and numRandom == 3) or (jugador == 2 and numRandom == 1) or (jugador == 3 and numRandom == 2):
        print("Has ganado")
    else:
        print("Has perdido")


    jugarOtra = input("Quieres jugar de nuevo? (s,n): ")
    if jugarOtra.lower() != 's':
        break    
"""        
