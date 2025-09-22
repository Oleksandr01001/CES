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
        print("Triplete")
    if i % 5 == 0:
        print("Cinquillo")   
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


