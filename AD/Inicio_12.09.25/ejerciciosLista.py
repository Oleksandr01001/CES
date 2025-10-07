# Ejercicio 1
frutas = ["manzana", "pera", "platano", "naranja", "uva"]
print("Lista completa:", frutas)
print("Primera fruta:", frutas[0])
print("Ultima fruta:", frutas[-1])

# Ejercicio 2
numeros = []
numeros.append(10)
numeros.append(20)
numeros.append(30)
del numeros[1]
print("Lista final:", numeros)

# Ejercicio 3
numeros = [1, 2, 3, 4, 5]
for n in numeros:
    print(n * 2)

# Ejercicio 4
palabras = ["manzana", "pera", "naranja"]
buscar = input("Introduce una palabra: ")
if buscar in palabras:
    print("La palabra esta en la lista.")
else:
    print("La palabra no esta en la lista.")

# Ejercicio 5
numeros = [1,2,3,4,5,6,7,8,9,10]
print("Primeros 3:", numeros[:3])
print("Ultimos 3:", numeros[-3:])
print("De posicion 3 a 7:", numeros[3:8])
