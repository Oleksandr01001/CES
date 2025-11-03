with open("fichero1.txt", "w", encoding="utf-8") as f:
    f.write("Linea 1 - cielo\n")
    f.write("Linea 2 - mar\n")
    f.write("Linea 3 - tierra\n")
    f.write("Linea 4 - montana\n")
    f.write("Linea 5 - rio\n")
print("Preparado fichero1 txt con 5 lineas\n")

print("1) Forma clasica open write close")
f = open("fichero2.txt", "w", encoding="utf-8")
f.write("Creando archivo en python de forma clasica\n")
f.close()
print("Escrito y cerrado fichero2 txt")

print("Probando escribir despues de close debe fallar")
try:
    f.write("Debe fallar porque esta cerrado\n")
except Exception as e:
    print("Error esperado", repr(e))
print()

print("2) Forma with as")
with open("fichero2.txt", "w", encoding="utf-8") as f:
    f.write("Creando archivo en python usando with as\n")
print("Escrito y cerrado automaticamente\n")

print("3) Acceso a lineas 2 4 de fichero1 txt con enumerate")
with open("fichero1.txt", "r", encoding="utf-8") as f:
    texto = (linea for i, linea in enumerate(f) if 1 <= i <= 3)
    for linea in texto:
        print(linea, end="")
print()

print("4) read leer todo fichero2 txt")
with open("fichero2.txt", "r", encoding="utf-8") as archivo:
    contenido = archivo.read()
print("Contenido completo de fichero2 txt")
print(contenido, end="")
print()

print("5) readline lee una linea por llamada")
with open("fichero1.txt", "r", encoding="utf-8") as f:
    print(f.readline().rstrip("\n"))
    print(f.readline().rstrip("\n"))

print("\n5b) readlines devuelve lista de lineas")
with open("fichero1.txt", "r", encoding="utf-8") as f:
    lista_lineas = f.readlines()
print("Lista de lineas", lista_lineas, "\n")

print("6) r+ anadir al final")
with open("fichero2.txt", "r+", encoding="utf-8") as f:
    _ = f.read()
    f.write("Anadido al final con r+\n")
print("Linea anadida al final\n")

print("6b) r+ escribir al principio con seek 0 0")
with open("fichero2.txt", "r+", encoding="utf-8") as f:
    original = f.read()
    f.seek(0, 0)
    f.write("Nueva cabecera al principio r+\n")
    f.write(original)
print("Insertada linea al principio\n")

print("7) append con a")
with open("fichero2.txt", "a", encoding="utf-8") as f:
    f.write("Otra opcion con a append\n")
print("Linea anadida con a\n")

print("8) writelines")
Lista = ["Escribiendo\n", "listas\n", "en ficheros\n"]
with open("fichero2.txt", "a", encoding="utf-8") as f:
    f.writelines(Lista)
print("Anadidas lineas con writelines\n")

print("9) seek tell")
with open("fichero3.txt", "w", encoding="utf-8") as f:
    f.write("Primera linea\nSegunda linea\nTercera linea")
with open("fichero3.txt", "r", encoding="utf-8") as f:
    print(f.readline().rstrip("\n"))
    f.seek(0)
    print(f.readline().rstrip("\n"))
    f.seek(15)
    print(f.readline().rstrip("\n"))
    f.seek(0, 2)
    print("Posicion final", f.tell(), "bytes")
print()

print("10) Excepciones fichero existente")
nombre_fichero = "fichero2.txt"
try:
    with open(nombre_fichero, "r", encoding="utf-8") as f:
        print(f.readline().rstrip("\n"))
        print(f.readline().rstrip("\n"))
except FileNotFoundError:
    print("Error no existe el fichero")

print("\n10b) Excepciones fichero inexistente")
nombre_inexistente = "ficheroX.txt"
try:
    with open(nombre_inexistente, "r", encoding="utf-8") as f:
        print(f.read())
except FileNotFoundError:
    print("No existe el fichero capturado FileNotFoundError")
print()

print("11) Resumen de modos")
print("r  lectura error si no existe")
print("w  escritura trunca o crea")
print("a  anexar al final crea si no existe")
print("r+ lectura y escritura error si no existe")
print("w+ lectura y escritura trunca o crea")
print("a+ lectura y escritura puntero al final crea si no existe")

print("\n\nContenido final de fichero2 txt")
with open("fichero2.txt", "r", encoding="utf-8") as f:
    print(f.read())

