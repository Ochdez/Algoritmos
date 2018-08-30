def mezcla(A,x,ini,mitad,fin):
	
	i=ini
	j=mitad
	#A=[]
	k=0

	while i < mitad and j < fin:
		if x[i]<=x[j]:
			A.append(x[i])
			i+=1
		else:
			A.append(x[j])
			j+=1
		#k+=1

	while i < mitad:
		A.append(x[i])
		i+=1
		#k+=1

	while j < fin:
		A.append(x[j])
		j+=1
		#k+=1

	return A


def mergeSort(A,x,ini,fin):

	if ini < fin:
		mitad = (ini+fin) / 2
		mergeSort(A,x,ini,mitad)
		mergeSort(A,x,mitad+1,fin)
		mezcla(A,x,ini,mitad,fin)

x=[]
A=[] #Arreglo temporal
n = int(input())

for i in range(0,n):
	e=int(input())
	x.append(e)

mergeSort(A,x,0,n-1)
print("")
for i in range(n): 
    print (A[i])
