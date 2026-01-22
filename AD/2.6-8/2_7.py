from datetime import datetime

def crear_pila(nombre):
    return {
        "nombre": nombre,
        "tope": None,
        "tam": 0
    }

def pila_vacia(pila):
    return pila["tope"] is None

def apilar(pila, dato):
    if dato.strip() == "":
        raise ValueError("Dato vacío")
    nodo = {
        "dato": dato,
        "sig": pila["tope"]
    }
    pila["tope"] = nodo
    pila["tam"] += 1

def desapilar(pila):
    if pila_vacia(pila):
        raise IndexError("Pila vacía")
    dato = pila["tope"]["dato"]
    pila["tope"] = pila["tope"]["sig"]
    pila["tam"] -= 1
    return dato

def tope(pila):
    if pila_vacia(pila):
        raise IndexError("Pila vacía")
    return pila["tope"]["dato"]

def imprimir_pila(pila):
    if pila_vacia(pila):
        print("Pila vacía")
        return
    actual = pila["tope"]
    while actual is not None:
        print(actual["dato"])
        actual = actual["sig"]

def contar(pila):
    print(pila["tam"])
    return pila["tam"]

def invertir_pila(pila):
    nueva = crear_pila(pila["nombre"] + " invertida")
    actual = pila["tope"]
    while actual is not None:
        apilar(nueva, actual["dato"])
        actual = actual["sig"]
    return nueva

def copiar_pila(pila):
    aux = crear_pila("aux")
    copia = crear_pila(pila["nombre"] + " copia")
    actual = pila["tope"]
    while actual is not None:
        apilar(aux, actual["dato"])
        actual = actual["sig"]
    while not pila_vacia(aux):
        apilar(copia, desapilar(aux))
    return copia

def vaciar_pila(pila):
    pila["tope"] = None
    pila["tam"] = 0

def guardar_pila(pila, ruta):
    with open(ruta, "w", encoding="utf-8") as f:
        f.write(pila["nombre"] + "\n")
        f.write(str(datetime.now()) + "\n")
        f.write(str(pila["tam"]) + "\n")
        actual = pila["tope"]
        while actual is not None:
            f.write(actual["dato"] + "\n")
            actual = actual["sig"]

def menu():
    print("""
1 Apilar
2 Desapilar
3 Tope
4 Pila vacía
5 Imprimir pila
6 Contar
7 Invertir pila
8 Copiar pila
9 Vaciar pila
10 Guardar pila
0 Salir
""")

def main():
    pila = crear_pila("Pila de marcas de coches")

    while True:
        menu()
        op = input("Opción: ").strip()

        try:
            if op == "1":
                marca = input("Marca: ")
                apilar(pila, marca)
            elif op == "2":
                print(desapilar(pila))
            elif op == "3":
                print(tope(pila))
            elif op == "4":
                print(pila_vacia(pila))
            elif op == "5":
                imprimir_pila(pila)
            elif op == "6":
                contar(pila)
            elif op == "7":
                invertir_pila(pila)
            elif op == "8":
                copiar_pila(pila)
            elif op == "9":
                vaciar_pila(pila)
            elif op == "10":
                ruta = input("Ruta fichero: ")
                guardar_pila(pila, ruta)
            elif op == "0":
                break
            else:
                print("Opción incorrecta")
        except Exception as e:
            print(e)

main()
