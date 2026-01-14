def factorial(x):
    if x == 0:
        return 1            
    else:
        return x * factorial(x - 1)  


def multiplicar(a, b):
    if b == 0:
        return 0              
    else:
        return a + multiplicar(a, b - 1)

    

def potencia(n, m):
    if m == 0:
        return 1            
    else:
        return n * potencia(n, m - 1)
    
    

def resta(a, b):
    if b == 0:
        return a             
    else:
        return resta(a - 1, b - 1)
    

    
