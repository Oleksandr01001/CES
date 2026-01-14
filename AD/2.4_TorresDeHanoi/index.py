def torre(n, origen, auxiliar, destino):
    if n == 1:
        print("Mover disco 1 de", origen, "a", destino)
        return

    torre(n - 1, origen, destino, auxiliar)
    print("Mover disco", n, "de", origen, "a", destino)
    torre(n - 1, auxiliar, origen, destino)


n = int(input("Introduce el numero de discos: "))

print("Movimientos necesarios:")
torre(n, "A", "B", "C")

minimo = 2 ** n - 1
print("Minimo de movimientos:", minimo)
