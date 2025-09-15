import math

"""
num1 = int(input("Ingresa el primer numero: "))
num2 = int(input("Ingresa el segundo numero: "))
suma = num1 + num2
print("La suma es: ",suma)
"""

"""
longuitud = int(input("Ingresa la longuitud de un lado: "))
suma = longuitud * longuitud
print("La suma es: ",suma)
"""

"""
celsius = int(input("Ingresa grados celsios: "))
fahrenheit = (celsius * 9/5) + 32
print("La temperatura en Fahrenheit es:", fahrenheit)
"""

"""
peso = float(input("Ingresa tu peso: "))
altura = float(input("Ingresa tu altura: "))
IMC = peso / (altura**2)
print("Tu IMC es: ",IMC)
"""

"""
cadena1 = input("Ingresa primera cadena: ")
cadena2 = input("Ingresa segunda cadena: ")
final = cadena1 + " " + cadena2
print("Ha salido: ",final)
"""




"""
dato = input("Ingresa un valor: ")
if dato.isdigit():
    print("El tipo de dato es: int (entero)")
elif dato.replace(".", "", 1).isdigit() and dato.count(".") == 1:
    print("El tipo de dato es: float (decimal)")
elif dato.lower() == "true" or dato.lower() == "false":
    print("El tipo de dato es: bool (booleano)")
else:
    print("El tipo de dato es: str (cadena de texto)")
"""



"""
num1 = float(input("Ingresa primer numero: "))
num2 = float(input("Ingresa segundo numero: "))
num3 = float(input("Ingresa tercer numero: "))
resultado = (num1 + num2 + num3) / 3
print("Resultado: ",resultado)
"""

"""
base = float(input("Ingresa la base del triangulo: "))
altura = float(input("Ingresa la altura del triangulo: "))
area = (base * altura) / 2
print("La area del triangulo es: ",area)
"""

"""
anos = int(input("Ingresa tus años: "))
anosAnadidos = int(input("ingresa años para añadir: "))
resultado = anos + anosAnadidos
print("Resultado: ",resultado)
"""

"""
longuitud = float(input("Ingresa la longuitud: "))
ancho = float(input("Ingresa el ancho: "))
area = longuitud * ancho
print("La area es: ",area)
"""

"""
dias = int(input("Ingresa el numero de dias: "))
dia = 24
hora = 60
min = 60

resultado = dias * dia * hora * min
print("En ",dias," dias hay ",resultado, " segundos")
"""

"""
num = float(input("Ingresa un numero: "))

resultado = math.sqrt(num)
print("Resultado: ",resultado)
"""

dolares = float(input("Ingresa cantidad de dolares: "))
cambio = float(input("Ingresa cunto vale un dolar en euro: "))
resultado = dolares * cambio
print(dolares, "dolares son", resultado, "euros")

