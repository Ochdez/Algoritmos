def mezcla(x,ini,mitad,fin):
	izr = mitad-ini+1
	der = fin-mitad
	i=ini
	j=mitad
	A=[]
	k=0

	while i < mitad and j < fin:
		if x[i]<=x[j]:
			A[k]=x[j]
			i+=1
		else:
			A[k]=x[j]
			j+=1
		k+=1

	while i < izq:



def mergeSort(x,ini,fin):

	if ini < fin:
		mitad = (ini+fin) / 2
		mergeSort(x,ini,mitad-1)
		mergeSort(x,mitad,fin)
		mezcla(x,ini,mitad,fin)


x=[]
n = int(input())

for i in range(0,n):
	e=int(input())
	x.append(e)

def mergeSort(x,0,n-1)

