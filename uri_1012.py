a=[float(i) for i in input().split()]
area_tri=0.5*a[0]*a[2]
area_circle=(3.14159*a[2]*a[2])
area_trip=0.5*a[2]*(abs(a[1]+a[0]))
area_sq=a[1]*a[1]
area_rec=a[0]*a[1]
print("TRIANGULO:",format(area_tri,'0.3f'))
print("CIRCULO:",format(area_circle,'0.3f'))
print("TRAPEZIO:",format(area_trip,'0.3f'))
print("QUADRADO:",format(area_sq,'0.3f'))
print("RETANGULO:",format(area_rec,'0.3f'))
