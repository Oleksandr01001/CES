# programa_palabras.py

def contar_vocales(texto):
    vocales = "aeiouAEIOU"
    return sum(1 for letra in texto if letra in vocales)

def main():
    try:
        with open("palabras.txt", "r", encoding="utf-8") as f:
            texto = f.read()
        palabras = texto.lower().split()
        total_palabras = len(palabras)
        total_vocales = contar_vocales(texto)
        conteo = {}
        for palabra in palabras:
            conteo[palabra] = conteo.get(palabra, 0) + 1
        repetidas = {p: c for p, c in conteo.items() if c > 1}
        max_repeticiones = max(conteo.values())
        mas_repetidas = [p for p, c in conteo.items() if c == max_repeticiones]
        print(f"Numero total de palabras: {total_palabras}")
        print(f"Numero total de vocales: {total_vocales}\n")
        print("Palabras repetidas:")
        for palabra, cantidad in repetidas.items():
            print(f" - {palabra}: {cantidad} veces")
        print(f"\nPalabras mas repetidas: {', '.join(mas_repetidas)} ({max_repeticiones} veces)")
        with open("salida.txt", "w", encoding="utf-8") as f1:
            f1.write(f"Numero total de palabras: {total_palabras}\n")
            f1.write(f"Numero total de vocales: {total_vocales}\n\n")
            f1.write("Palabras repetidas:\n")
            for palabra, cantidad in repetidas.items():
                f1.write(f" - {palabra}: {cantidad} veces\n")
            f1.write(f"\nPalabras mas repetidas: {', '.join(mas_repetidas)} ({max_repeticiones} veces)\n")
        with open("salida2.txt", "w", encoding="utf-8") as f2:
            f2.write("Palabras repetidas:\n")
            for palabra, cantidad in repetidas.items():
                f2.write(f" - {palabra}: {cantidad} veces\n")
            f2.write(f"\nPalabras mas repetidas: {', '.join(mas_repetidas)} ({max_repeticiones} veces)\n")

    except FileNotFoundError:
        print("No se encontro el fichero 'palabras.txt'.")

if __name__ == "__main__":
    main()
