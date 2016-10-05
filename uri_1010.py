a=[float(i) for i in input().split(" ")]
b=[float(i) for i in input().split(" ")]
c=a[1]*a[2]
d=b[1]*b[2]
avg=c+d
print("VALOR A PAGAR: R$",format(avg, '.2f'))