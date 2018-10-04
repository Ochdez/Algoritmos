def mezcla(L1,L2,L3):
	
	i, j, k= 0, 0, 0
	A=[]

	while i < len(L1) and j < len(L2) and k < len(L3):
		
		if L1[i]<=L2[j] and L1[i]<=L3[k]:
			A.append(L1[i])
			i+=1
		elif L2[j] <= L1[i] and L2[j] <= L3[k]:
			A.append(L2[j])
			j+=1

		elif L3[k] <= L1[i] and L3[k] <= L2[j]:
			A.append(L3[k])
			k+=1

	while i < len(L1) and j < len(L2): #Si aun quedan elementos en L1 y L2, se comparan

		if L1[i] <= L2[j]:
			A.append(L1[i])
			i+=1
		else:
			A.append(L2[j])
			j+=1

	while j < len(L2) and k < len(L3): #Si aun quedan elementos en L2 y L3

		if L2[j] <= L3[k]:
			A.append(L2[j])
			j+=1
		else:
			A.append(L3[k])
			k+=1

	while i < len(L1) and k < len(L3):

		if L1[i] <= L3[k]:
			A.append(L1[i])
			i+=1
		else:
			A.append(L3[k])
			k+=!

	#Falta cuando aun quedan elementos en una de las lista...

	return A


def mergeSort(x):

	n = len(x)

	if n <= 1:
		return x

	e = n//3	
	m = n%3
	
	L1=mergeSort(x[:e])
	L2=mergeSort(x[e:2*e])
	L3=mergeSort(x[2*e:])
	resultado = mezcla(L1,L2,L3)
	
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