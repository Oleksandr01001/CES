NULL_INICIO = 0
NULL_FINAL = 99
MIN_DATO = 1
MAX_DATO = 98


def validar_dato(d):
    if not (MIN_DATO <= d <= MAX_DATO):
        raise ValueError("Dato fuera de rango")


def crear_nodo(tipo, dato):
    validar_dato(dato)
    nodo = {"dato": dato, "sig": NULL_FINAL}
    if tipo in ("enlazada_d", "circular_d"):
        nodo["ant"] = NULL_INICIO
    return nodo


def recorrer(tipo, mem, inicio):
    if inicio == NULL_INICIO:
        return []
    res = []
    actual = inicio
    circular = tipo in ("circular", "circular_d")
    while True:
        res.append(actual)
        sig = mem[actual]["sig"]
        if not circular:
            if sig == NULL_FINAL:
                break
            actual = sig
        else:
            actual = sig
            if actual == inicio:
                break
    return res


def buscar_ultimo(tipo, mem, inicio):
    if inicio == NULL_INICIO:
        raise ValueError("Lista vacía")
    circular = tipo in ("circular", "circular_d")
    actual = inicio
    if not circular:
        while mem[actual]["sig"] != NULL_FINAL:
            actual = mem[actual]["sig"]
        return actual
    while mem[actual]["sig"] != inicio:
        actual = mem[actual]["sig"]
    return actual


def insertar_inicio(tipo, mem, inicio, dato):
    if dato in mem:
        raise ValueError("Nodo duplicado")
    nodo = crear_nodo(tipo, dato)
    doble = tipo in ("enlazada_d", "circular_d")
    circular = tipo in ("circular", "circular_d")

    if inicio == NULL_INICIO:
        mem[dato] = nodo
        inicio = dato
        if circular:
            mem[dato]["sig"] = dato
            if doble:
                mem[dato]["ant"] = dato
        return inicio

    antiguo = inicio
    mem[dato] = nodo

    if not circular:
        mem[dato]["sig"] = antiguo
        if doble:
            mem[antiguo]["ant"] = dato
        inicio = dato
        return inicio

    ultimo = buscar_ultimo(tipo, mem, inicio)
    mem[dato]["sig"] = antiguo
    mem[ultimo]["sig"] = dato
    if doble:
        mem[dato]["ant"] = ultimo
        mem[antiguo]["ant"] = dato
    inicio = dato
    return inicio


def insertar_final(tipo, mem, inicio, dato):
    if inicio == NULL_INICIO:
        raise ValueError("Lista vacía")
    if dato in mem:
        raise ValueError("Nodo duplicado")
    nodo = crear_nodo(tipo, dato)
    doble = tipo in ("enlazada_d", "circular_d")
    circular = tipo in ("circular", "circular_d")

    ultimo = buscar_ultimo(tipo, mem, inicio)
    mem[dato] = nodo

    if not circular:
        mem[ultimo]["sig"] = dato
        if doble:
            mem[dato]["ant"] = ultimo
        return inicio

    mem[ultimo]["sig"] = dato
    mem[dato]["sig"] = inicio
    if doble:
        mem[dato]["ant"] = ultimo
        mem[inicio]["ant"] = dato
    return inicio


def insertar_nodo(tipo, mem, inicio, dato, anterior, siguiente):
    circular = tipo in ("circular", "circular_d")
    doble = tipo in ("enlazada_d", "circular_d")

    if anterior == NULL_INICIO:
        return insertar_inicio(tipo, mem, inicio, dato)

    if not circular and siguiente == NULL_FINAL:
        return insertar_final(tipo, mem, inicio, dato)

    if inicio == NULL_INICIO:
        raise ValueError("Lista vacía")

    if dato in mem:
        raise ValueError("Nodo duplicado")

    if anterior not in mem:
        raise ValueError("Anterior no existe")

    if circular:
        if siguiente not in mem:
            raise ValueError("Siguiente no existe")
    else:
        if siguiente != NULL_FINAL and siguiente not in mem:
            raise ValueError("Siguiente no existe")

    if mem[anterior]["sig"] != siguiente:
        raise ValueError("Enlace incorrecto")

    mem[dato] = crear_nodo(tipo, dato)
    mem[anterior]["sig"] = dato
    mem[dato]["sig"] = siguiente

    if doble:
        mem[dato]["ant"] = anterior
        if siguiente != NULL_FINAL:
            mem[siguiente]["ant"] = dato

    return inicio


def contar_nodos(tipo, mem, inicio):
    return len(recorrer(tipo, mem, inicio))


def buscar_nodo(tipo, mem, inicio, dato):
    sec = recorrer(tipo, mem, inicio)
    if dato in sec:
        return mem[dato]
    return None


def eliminar_nodo(tipo, mem, inicio, dato):
    if inicio == NULL_INICIO:
        return inicio, False
    if dato not in mem:
        return inicio, False

    sec = recorrer(tipo, mem, inicio)
    if dato not in sec:
        del mem[dato]
        return inicio, True

    circular = tipo in ("circular", "circular_d")
    doble = tipo in ("enlazada_d", "circular_d")

    if len(sec) == 1 and sec[0] == dato:
        del mem[dato]
        return NULL_INICIO, True

    idx = sec.index(dato)

    if not circular:
        if idx == 0:
            nuevo_inicio = mem[dato]["sig"]
            inicio = nuevo_inicio
            if doble:
                mem[nuevo_inicio]["ant"] = NULL_INICIO
        else:
            anterior = sec[idx - 1]
            sig = mem[dato]["sig"]
            mem[anterior]["sig"] = sig
            if doble and sig != NULL_FINAL:
                mem[sig]["ant"] = anterior
        del mem[dato]
        return inicio, True

    if idx == 0:
        ultimo = buscar_ultimo(tipo, mem, inicio)
        nuevo_inicio = mem[dato]["sig"]
        inicio = nuevo_inicio
        mem[ultimo]["sig"] = nuevo_inicio
        if doble:
            mem[nuevo_inicio]["ant"] = ultimo
        del mem[dato]
        return inicio, True

    anterior = sec[idx - 1]
    sig = mem[dato]["sig"]
    mem[anterior]["sig"] = sig
    if doble:
        mem[sig]["ant"] = anterior
        if dato == buscar_ultimo(tipo, mem, inicio):
            mem[inicio]["ant"] = anterior
    del mem[dato]
    return inicio, True


def imprimir_valor_lista(tipo, mem, inicio):
    sec = recorrer(tipo, mem, inicio)
    if not sec:
        return ""
    circular = tipo in ("circular", "circular_d")
    if not circular:
        return "0 -> " + " -> ".join(map(str, sec)) + " -> 99"
    return "0 -> " + " -> ".join(map(str, sec)) + " -> " + str(inicio)


def imprimir_lista_completa(tipo, mem, inicio):
    sec = recorrer(tipo, mem, inicio)
    lineas = []
    for d in sec:
        n = mem[d]
        if tipo in ("enlazada_d", "circular_d"):
            lineas.append(f"[{d}] dato={n['dato']} ant={n['ant']} sig={n['sig']}")
        else:
            lineas.append(f"[{d}] dato={n['dato']} sig={n['sig']}")
    return "\n".join(lineas)


def imprimir_reves(tipo, mem, inicio):
    sec = recorrer(tipo, mem, inicio)
    if not sec:
        return ""
    doble = tipo in ("enlazada_d", "circular_d")
    circular = tipo in ("circular", "circular_d")

    if not doble:
        return " -> ".join(map(str, reversed(sec)))

    ultimo = buscar_ultimo(tipo, mem, inicio)
    res = []
    actual = ultimo
    while True:
        res.append(actual)
        ant = mem[actual]["ant"]
        if not circular:
            if ant == NULL_INICIO:
                break
            actual = ant
        else:
            actual = ant
            if actual == ultimo:
                break
    if circular and len(res) > 1 and res[-1] == ultimo:
        res.pop()
    return " -> ".join(map(str, res))


def copiar_lista(tipo, mem, inicio):
    nombre = {
        "enlazada": "lista_enlazada.txt",
        "enlazada_d": "lista_enlazada_d.txt",
        "circular": "lista_circular.txt",
        "circular_d": "lista_circular_d.txt",
    }[tipo]
    with open(nombre, "w", encoding="utf-8") as f:
        f.write(imprimir_lista_completa(tipo, mem, inicio) + "\n")
        f.write(imprimir_valor_lista(tipo, mem, inicio) + "\n")
    return nombre


def ordenar_lista(tipo, mem, inicio):
    sec = recorrer(tipo, mem, inicio)
    if not sec:
        return inicio
    sec = sorted(sec)
    doble = tipo in ("enlazada_d", "circular_d")
    circular = tipo in ("circular", "circular_d")

    inicio = sec[0]

    if not circular:
        for i, d in enumerate(sec):
            mem[d]["sig"] = sec[i + 1] if i < len(sec) - 1 else NULL_FINAL
            if doble:
                mem[d]["ant"] = sec[i - 1] if i > 0 else NULL_INICIO
        return inicio

    for i, d in enumerate(sec):
        mem[d]["sig"] = sec[i + 1] if i < len(sec) - 1 else sec[0]
        if doble:
            mem[d]["ant"] = sec[i - 1] if i > 0 else sec[-1]
    return inicio


def leer_int(msg):
    while True:
        try:
            return int(input(msg))
        except ValueError:
            print("Introduce un entero")


def elegir_tipo():
    print("1) enlazada")
    print("2) enlazada_d")
    print("3) circular")
    print("4) circular_d")
    op = leer_int("Opción: ")
    return {1: "enlazada", 2: "enlazada_d", 3: "circular", 4: "circular_d"}.get(op, "enlazada")


def main():
    tipo = elegir_tipo()
    mem = {}
    inicio = NULL_INICIO

    while True:
        print("\nTipo:", tipo, "Inicio:", inicio, "Nodos:", contar_nodos(tipo, mem, inicio))
        print("1) insertar_inicio")
        print("2) insertar_final")
        print("3) insertar_nodo")
        print("4) eliminar_nodo")
        print("5) buscar_nodo")
        print("6) imprimir_valor_lista")
        print("7) imprimir_lista_completa")
        print("8) imprimir_reves")
        print("9) copiar_lista")
        print("10) ordenar_lista")
        print("0) salir")

        op = leer_int("Opción: ")

        try:
            if op == 1:
                d = leer_int("Dato: ")
                inicio = insertar_inicio(tipo, mem, inicio, d)
            elif op == 2:
                d = leer_int("Dato: ")
                inicio = insertar_final(tipo, mem, inicio, d)
            elif op == 3:
                d = leer_int("Dato nuevo: ")
                a = leer_int("Anterior (0 para inicio): ")
                if tipo in ("circular", "circular_d"):
                    s = leer_int("Siguiente: ")
                else:
                    s = leer_int("Siguiente (99 para final): ")
                inicio = insertar_nodo(tipo, mem, inicio, d, a, s)
            elif op == 4:
                d = leer_int("Nodo a eliminar: ")
                inicio, ok = eliminar_nodo(tipo, mem, inicio, d)
                print("Eliminado" if ok else "No existe")
            elif op == 5:
                d = leer_int("Nodo a buscar: ")
                n = buscar_nodo(tipo, mem, inicio, d)
                print(n if n else "No está")
            elif op == 6:
                print(imprimir_valor_lista(tipo, mem, inicio))
            elif op == 7:
                print(imprimir_lista_completa(tipo, mem, inicio))
            elif op == 8:
                print(imprimir_reves(tipo, mem, inicio))
            elif op == 9:
                print(copiar_lista(tipo, mem, inicio))
            elif op == 10:
                inicio = ordenar_lista(tipo, mem, inicio)
            elif op == 0:
                break
        except Exception as e:
            print("Error:", e)


if __name__ == "__main__":
    main()
