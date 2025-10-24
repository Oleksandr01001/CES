mi_tupla = (1, 2, 3, "cuatro", "cinco")
for i in mi_tupla:
    print(i)

print("La longitud de la tupla es:", len(mi_tupla))

if("cuatro" in mi_tupla):
    print("Cuatro esta en tupla")
print("'2' esta en la tupla?", "2" in mi_tupla)
print("2 esta en la tupla?", 2 in mi_tupla)

valor = input("Introduce un valor para buscar en la tupla: ")

if valor.isdigit():  
    valor = int(valor)

if valor in mi_tupla:
    print(f"El valor {valor} está en la tupla")
else:
    print(f"El valor {valor} NO está en la tupla")

x = input("Introduce el primer valor: ")
y = input("Introduce el segundo valor: ")
z = input("Introduce el tercer valor: ")

mi_tupla = (x, y, z)
print("La nueva tupla es:", mi_tupla)

a = input("Introduce una letra: ")
x = int(input("Introduce un número: "))

mi_tupla = (a, x)
print("La tupla es:", mi_tupla)

a = input("Introduce la primera letra: ")
x = input("Introduce el número para la primera letra: ")

b = input("Introduce la segunda letra: ")
y = input("Introduce el número para la segunda letra: ")

c = input("Introduce la tercera letra: ")
z = input("Introduce el número para la tercera letra: ")

mi_tupla = ((a, x), (b, y), (c, z))

for letra, valor in mi_tupla:
    print(f"El valor {letra} vale {valor}")

def desempaquetar_tupla(tupla):
    (a, x), (b, y), (c, z) = tupla
    print(f"El valor {a} vale {x}")
    print(f"El valor {b} vale {y}")
    print(f"El valor {c} vale {z}")

desempaquetar_tupla(mi_tupla)

tupla1 = (1, 2, 3, 4, 5)
tupla2 = (3, 4, 5, 6, 7)

interseccion = tuple(set(tupla1) & set(tupla2))
diferencia = tuple(set(tupla1) ^ set(tupla2))  

print("Intersección:", interseccion)
print("Diferencia:", diferencia)

ciudades_temperaturas = (
    ("Madrid", (30, 32, 31)),
    ("Barcelona", (20, 26, 21)),
    ("Valencia", (28, 29, 27))
)

ciudad = input("Introduce el nombre de la ciudad: ")

for nombre, temps in ciudades_temperaturas:
    if nombre.lower() == ciudad.lower():
        media = sum(temps) / len(temps)
        print(f"La temperatura media de {nombre} es {round(media, 1)}°C")
        break
else:
    print("Ciudad no encontrada")

import random

digitos = tuple(str(i) for i in range(10))
letras = tuple("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
especiales = tuple("!@#$%&/()=?¿*-_+<>^~")

longitud = int(input("Introduce la longitud de la contraseña (8-64): "))
while longitud < 8 or longitud > 64:
    longitud = int(input("Longitud inválida. Introduce un valor entre 8 y 64: "))

def generar_contraseña(longitud, proporciones):
    n_dig = int(longitud * proporciones[0])
    n_let = int(longitud * proporciones[1])
    n_esp = longitud - (n_dig + n_let)

    elementos = (
        random.sample(digitos, n_dig) +
        random.sample(letras, n_let) +
        random.sample(especiales, n_esp)
    )
    random.shuffle(elementos)
    return tuple(elementos)

fuerte = generar_contraseña(longitud, (0.2, 0.4, 0.4))
debil = generar_contraseña(longitud, (0.8, 0.15, 0.05))

print("Contraseña fuerte:", "".join(fuerte))
print("Contraseña débil:", "".join(debil))
