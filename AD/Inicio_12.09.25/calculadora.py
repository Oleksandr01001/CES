import math
from colorama import init, Fore

init(autoreset=True)

clave = "1234"

def pedir_numero(mensaje):
    return float(input(mensaje))

def sumar(a, b):
    return a + b

def restar(a, b):
    return a - b

def multiplicar(a, b):
    return a * b

def dividir(a, b):
    if b == 0:
        print(Fore.RED + "No se puede dividir por cero")
        return None
    return a / b

def valor_absoluto(a):
    return abs(a)

def seno(a):
    return math.sin(a)

def coseno(a):
    return math.cos(a)

def tangente(a):
    return math.tan(a)

def log10(a):
    if a <= 0:
        print(Fore.RED + "No valido para log10")
        return None
    return math.log10(a)

def loge(a):
    if a <= 0:
        print(Fore.RED + "No valido para loge")
        return None
    return math.log(a)

def exponente(a):
    return math.exp(a)

def raiz(a):
    if a < 0:
        print(Fore.RED + "No valido para raiz")
        return None
    return math.sqrt(a)

# Inicio del programa
print(Fore.CYAN + "Calculadora cientifica")
contraseña = input("Escribe clave: ")

if contraseña != clave:
    print(Fore.RED + "Clave incorrecta")
else:
    while True:
        print(Fore.YELLOW + "Menu:")
        print("1. Sumar")
        print("2. Restar")
        print("3. Multiplicar")
        print("4. Dividir")
        print("5. Valor absoluto")
        print("6. Seno")
        print("7. Coseno")
        print("8. Tangente")
        print("9. Log base 10")
        print("10. Log neperiano")
        print("11. E elevado a x")
        print("12. Raiz cuadrada")
        print("13. Cambiar clave")
        print("14. Apagar")

        opcion = input("Elige opcion: ")

        if opcion == "1":
            a = pedir_numero("Primer numero: ")
            b = pedir_numero("Segundo numero: ")
            print(Fore.GREEN + "Resultado:", sumar(a, b))

        elif opcion == "2":
            a = pedir_numero("Primer numero: ")
            b = pedir_numero("Segundo numero: ")
            print(Fore.GREEN + "Resultado:", restar(a, b))

        elif opcion == "3":
            a = pedir_numero("Primer numero: ")
            b = pedir_numero("Segundo numero: ")
            print(Fore.GREEN + "Resultado:", multiplicar(a, b))

        elif opcion == "4":
            a = pedir_numero("Primer numero: ")
            b = pedir_numero("Segundo numero: ")
            r = dividir(a, b)
            if r is not None:
                print(Fore.GREEN + "Resultado:", r)

        elif opcion == "5":
            a = pedir_numero("Numero: ")
            print(Fore.GREEN + "Resultado:", valor_absoluto(a))

        elif opcion == "6":
            a = pedir_numero("Numero en radianes: ")
            print(Fore.GREEN + "Resultado:", seno(a))

        elif opcion == "7":
            a = pedir_numero("Numero en radianes: ")
            print(Fore.GREEN + "Resultado:", coseno(a))

        elif opcion == "8":
            a = pedir_numero("Numero en radianes: ")
            print(Fore.GREEN + "Resultado:", tangente(a))

        elif opcion == "9":
            a = pedir_numero("Numero: ")
            r = log10(a)
            if r is not None:
                print(Fore.GREEN + "Resultado:", r)

        elif opcion == "10":
            a = pedir_numero("Numero: ")
            r = loge(a)
            if r is not None:
                print(Fore.GREEN + "Resultado:", r)

        elif opcion == "11":
            a = pedir_numero("Numero: ")
            print(Fore.GREEN + "Resultado:", exponente(a))

        elif opcion == "12":
            a = pedir_numero("Numero: ")
            r = raiz(a)
            if r is not None:
                print(Fore.GREEN + "Resultado:", r)

        elif opcion == "13":
            nueva = input("Nueva clave: ")
            clave = nueva
            print(Fore.CYAN + "Clave cambiada")

        elif opcion == "14":
            print(Fore.MAGENTA + "Apagando...")
            break

        else:
            print(Fore.RED + "Opcion no valida")
