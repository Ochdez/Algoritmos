from math import ceil

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

	while i < len(L1) and j < len(L2):
  
		if L1[i] <= L2[j]:
			A.append(L1[i])
			i+=1
		else:
			A.append(L2[j])
			j+=1

	while j < len(L2) and k < len(L3):

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
			k+=1


	while i < len(L1):
		
		A.append(L1[i])
		i+=1

	while j < len(L2):
		
		A.append(L2[j])
		j+=1

	while k < len(L3):
		
		A.append(L3[k]) 
		k+=1
		
	return A	
	

def mergeSort(x):

	n = len(x)

	if n <= 1:
		return x

	m = n//3
	
	if len(x)==2:
		h = [0] #cuando se tenga al final una lista de 2 elementos
		resultado = mezcla(x[:1],x[1:2],h)
		
	else:
		L1 = mergeSort(x[:m])
		L2 = mergeSort(x[m:2*m])
		L3 = mergeSort(x[2*m:])
		 
		resultado = mezcla(L1,L2,L3)	 

	return resultado

	
x=[]
x = map(int, raw_input().split())

f = x.count(0)
a = mergeSort(x)
p = a.count(0)

for i in range(p-f):
	a.remove(0)

b=[]
for i in a:
	b.append(str(i))
c=" ".join(b)
print(c)

