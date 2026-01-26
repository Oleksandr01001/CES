from datetime import datetime

def crear_nodo(valor):
    return {
        'valor': valor,
        'izq': None,
        'der': None
    }


def insertar(raiz, valor):
    if raiz is None:
        return crear_nodo(valor)

    if valor < raiz['valor']:
        raiz['izq'] = insertar(raiz['izq'], valor)
    else:
        raiz['der'] = insertar(raiz['der'], valor)

    return raiz



def preorder(raiz, resultado):
    if raiz is None:
        return
    resultado.append(raiz['valor'])
    preorder(raiz['izq'], resultado)
    preorder(raiz['der'], resultado)


def inorder(raiz, resultado):
    if raiz is None:
        return
    inorder(raiz['izq'], resultado)
    resultado.append(raiz['valor'])
    inorder(raiz['der'], resultado)


def postorder(raiz, resultado):
    if raiz is None:
        return
    postorder(raiz['izq'], resultado)
    postorder(raiz['der'], resultado)
    resultado.append(raiz['valor'])



def contar_nodos(raiz):
    if raiz is None:
        return 0
    return 1 + contar_nodos(raiz['izq']) + contar_nodos(raiz['der'])


def buscar(raiz, valor):
    if raiz is None:
        return None
    if raiz['valor'] == valor:
        return raiz
    if valor < raiz['valor']:
        return buscar(raiz['izq'], valor)
    else:
        return buscar(raiz['der'], valor)


def vaciar_arbol():
    return None


def guardar_arbol(raiz, nombre="arbol.txt"):
    try:
        with open(nombre, "w", encoding="utf-8") as f:
            f.write("=== ÁRBOL BINARIO ===\n")
            f.write(f"Fecha: {datetime.now().isoformat(sep=' ', timespec='seconds')}\n")
            f.write(f"Nodos: {contar_nodos(raiz)}\n\n")

            pre = []
            ino = []
            post = []

            preorder(raiz, pre)
            inorder(raiz, ino)
            postorder(raiz, post)

            f.write("Preorder:\n")
            f.write(" ".join(map(str, pre)) + "\n\n")

            f.write("Inorder:\n")
            f.write(" ".join(map(str, ino)) + "\n\n")

            f.write("Postorder:\n")
            f.write(" ".join(map(str, post)) + "\n")

        print(f"Árbol guardado en '{nombre}'")
    except OSError:
        print("Error al escribir fichero")



def imprimir_arbol(raiz, nivel=0, lado="R"):
    if raiz is not None:
        imprimir_arbol(raiz['der'], nivel + 1, "D")
        print("   " * nivel + f"{lado}-> {raiz['valor']}")
        imprimir_arbol(raiz['izq'], nivel + 1, "I")



def menu():
    raiz = None

    while True:
        print("\n--- MENÚ ÁRBOLES BINARIOS ---")
        print("1. Insertar nodo")
        print("2. Recorrido Preorder")
        print("3. Recorrido Inorder")
        print("4. Recorrido Postorder (extra)")
        print("5. Buscar nodo")
        print("6. Contar nodos")
        print("7. Imprimir árbol (visual)")
        print("8. Vaciar árbol")
        print("9. Guardar árbol en fichero")
        print("10. Salir")

        opc = input("Opción: ").strip()

        if opc == "1":
            try:
                v = int(input("Valor: "))
                raiz = insertar(raiz, v)
                print("Nodo insertado.")
            except ValueError:
                print("Valor inválido.")

        elif opc == "2":
            res = []
            preorder(raiz, res)
            print("Preorder:", res)

        elif opc == "3":
            res = []
            inorder(raiz, res)
            print("Inorder:", res)

        elif opc == "4":
            res = []
            postorder(raiz, res)
            print("Postorder:", res)

        elif opc == "5":
            try:
                v = int(input("Valor a buscar: "))
                n = buscar(raiz, v)
                if n:
                    print("Nodo encontrado.")
                else:
                    print("Nodo no encontrado.")
            except ValueError:
                print("Valor inválido.")

        elif opc == "6":
            print("Total nodos:", contar_nodos(raiz))

        elif opc == "7":
            print("\nÁRBOL:")
            imprimir_arbol(raiz)

        elif opc == "8":
            raiz = vaciar_arbol()
            print("Árbol vaciado.")

        elif opc == "9":
            nombre = input("Nombre fichero (enter = arbol.txt): ").strip()
            if not nombre:
                nombre = "arbol.txt"
            guardar_arbol(raiz, nombre)

        elif opc == "10":
            print("Saliendo...")
            break

        else:
            print("Opción no válida.")


if __name__ == "__main__":
    menu()