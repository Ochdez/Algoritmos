def mezcla(izquierda,derecha):
	
	i, j = 0, 0
	A=[]

	while i < len(izquierda) and j < len(derecha):
		if izquierda[i]<=derecha[j]:
			A.append(izquierda[i])
			i+=1
		else:
			A.append(derecha[j])
			j+=1

	while i < len(izquierda):
		A.append(izquierda[i])
		i+=1

	while j < len(derecha):
		A.append(derecha[j])
		j+=1

	return A


def mergeSort(x):

	if len(x) <= 1:
		return x

	mitad = len(x) // 2
	izquierda = mergeSort(x[:mitad])
	derecha = mergeSort(x[mitad:])
	resultado = mezcla(izquierda, derecha)

	return resultado

x=[]
n = int(input())

for i in range(0,n):
	e=int(input())
	x.append(e)

a = mergeSort(x)
b=[]
for i in a:
	b.append(str(i))
c=" ".join(b)
print(c)
