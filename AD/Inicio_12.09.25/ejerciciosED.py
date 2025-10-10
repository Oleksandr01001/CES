# ejercicio 1
"""
for i in range(1,11):
    for j in range(1,11):
        print(i,"*",j,"=",i*j)
    print()
"""

# ejercicio 2
"""
n = int(input("Introduce un numero: "))
for i in range(0,n+1):
    print("*"*i)
"""

# ejercicio 3
"""
n = int(input("Introduce un numero: "))
for i in range(n):
    for j in range(1,n+1):
        print(j,end="")
    print()
"""

# ejercicio 4a
"""
n = int(input("Introduce un numero: "))
for i in range(n):
    print("0"*n)
"""

# ejercicio 4b
"""
n = int(input("Introduce un numero: "))
x = 1
for i in range(n):
    for j in range(n):
        print(x,end="")
        x += 2
    print()
"""

# ejercicio 4c
"""
n = int(input("Introduce un numero: "))
m = []
for i in range(n):
    fila = list(map(int,input().split()))
    m.append(fila)
for i in m:
    print(i)
"""

# ejercicio 5
"""
n = int(input("Introduce un numero: "))
a = []
b = []
for i in range(n):
    a.append(list(map(int,input().split())))
for i in range(n):
    b.append(list(map(int,input().split())))
for i in range(n):
    for j in range(n):
        print(a[i][j]+b[i][j],end=" ")
    print()
"""

# ejercicio 6
"""
n = int(input("Introduce un numero: "))
for i in range(n):
    for j in range(n):
        print(i+j,end="")
    print()
"""

# ejercicio 7
"""
n = int(input("Introduce un numero impar: "))
while n%2==0:
    n = int(input("Debe ser impar: "))
m = n//2
for i in range(m+1):
    print(" "*(m-i)+"*"*(2*i+1))
for i in range(m-1,-1,-1):
    print(" "*(m-i)+"*"*(2*i+1))
"""

# ejercicio 8
"""
m = [
    [1,2,3,4,5],
    [6,7,8,9,10],
    [11,12,13,14,15],
    [16,17,18,19,20],
    [21,22,23,24,25]
]
n = len(m)
p = sum(m[i][i] for i in range(n))
s = sum(m[i][n-1-i] for i in range(n))
x = input("Contar el centro una sola vez? (s/n): ")
if x=="s":
    print(p+s-m[n//2][n//2])
else:
    print(p+s)
"""

# ejercicio 9

n = int(input("Introduce un numero: "))
m = []
for i in range(n):
    fila = list(map(int,input().split()))
    m.append(fila)
p = sum(m[i][i] for i in range(n))
s = sum(m[i][n-1-i] for i in range(n))
x = input("Contar el centro una sola vez? (s/n): ")
if x=="s":
    print(p+s-m[n//2][n//2])
else:
    print(p+s)

