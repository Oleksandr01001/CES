import json

def crear_cola():
    return {"frente": None, "final": None, "tam": 0}

def crear_nodo(animal):
    return {"dato": animal, "sig": None}

def colavacia(cola):
    return cola["tam"] == 0

def encolar(cola, animal):
    nodo = crear_nodo(animal)
    if colavacia(cola):
        cola["frente"] = nodo
        cola["final"] = nodo
    else:
        cola["final"]["sig"] = nodo
        cola["final"] = nodo
    cola["tam"] += 1

def desencolar(cola):
    if colavacia(cola):
        return None
    dato = cola["frente"]["dato"]
    cola["frente"] = cola["frente"]["sig"]
    cola["tam"] -= 1
    if cola["frente"] is None:
        cola["final"] = None
    return dato

def frente(cola):
    if colavacia(cola):
        return None
    return cola["frente"]["dato"]

def imprimircola(cola):
    if colavacia(cola):
        print("Cola vacía")
        return
    actual = cola["frente"]
    i = 1
    while actual:
        a = actual["dato"]
        print(i, a["nombre"], a["clase"], a["habitat"], a["dieta"], a["edad"])
        actual = actual["sig"]
        i += 1

def contar(cola):
    return cola["tam"]

def invertircola(cola):
    pila = []
    actual = cola["frente"]
    while actual:
        pila.append(actual["dato"])
        actual = actual["sig"]
    nueva = crear_cola()
    while pila:
        encolar(nueva, pila.pop())
    return nueva

def copiarcola(origen, destino):
    actual = origen["frente"]
    while actual:
        encolar(destino, actual["dato"])
        actual = actual["sig"]

def vaciarcola(cola):
    cola["frente"] = None
    cola["final"] = None
    cola["tam"] = 0

def guardarcola(cola, fichero):
    datos = []
    actual = cola["frente"]
    while actual:
        datos.append(actual["dato"])
        actual = actual["sig"]
    contenido = {
        "tamanio": cola["tam"],
        "elementos": datos
    }
    with open(fichero, "w", encoding="utf-8") as f:
        json.dump(contenido, f, ensure_ascii=False, indent=2)

def pedir_animal():
    nombre = input("Nombre: ")
    clase = input("Clase: ")
    habitat = input("Habitat: ")
    dieta = input("Dieta: ")
    edad = int(input("Edad: "))
    return {
        "nombre": nombre,
        "clase": clase,
        "habitat": habitat,
        "dieta": dieta,
        "edad": edad
    }

def menu():
    print("1 Encolar")
    print("2 Desencolar")
    print("3 Frente")
    print("4 Cola vacía")
    print("5 Imprimir cola")
    print("6 Contar")
    print("7 Invertir cola")
    print("8 Copiar cola")
    print("9 Vaciar cola")
    print("10 Guardar cola")
    print("0 Salir")

def main():
    cola = crear_cola()
    cola_destino = crear_cola()

    while True:
        menu()
        op = int(input("Opción: "))

        if op == 1:
            encolar(cola, pedir_animal())

        elif op == 2:
            a = desencolar(cola)
            print(a if a else "Cola vacía")

        elif op == 3:
            print(frente(cola))

        elif op == 4:
            print(colavacia(cola))

        elif op == 5:
            imprimircola(cola)

        elif op == 6:
            print(contar(cola))

        elif op == 7:
            inv = invertircola(cola)
            imprimircola(inv)

        elif op == 8:
            copiarcola(cola, cola_destino)
            imprimircola(cola_destino)

        elif op == 9:
            vaciarcola(cola)

        elif op == 10:
            nombre = input("Fichero: ")
            guardarcola(cola, nombre)

        elif op == 0:
            break

main()
