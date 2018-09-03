def mezcla(x,ini,mitad,fin):
	
	i=ini
	j=mitad
	A=[]
	k=0
		  #0   #2      #2	#5
	while i < mitad and j < fin:
		if x[i]<=x[j]:
			A.append(x[i])
			i+=1
		else:
			A.append(x[j])
			j+=1
		k+=1

	while i < mitad:
		A.append(x[i])
		i+=1
		k+=1

	while j < fin:
		A.append(x[j])
		j+=1
		k+=1

	return A


def mergeSort(x,ini,fin):

	if len(x) <= 1:
		return x

	mitad = (ini+fin) // 2
	mergeSort(x,0,mitad)
	mergeSort(x,mitad+1,fin)
	a = mezcla(x,0,mitad,fin)
	return a

x=[]
n = int(input())

for i in range(0,n):
	e=int(input())
	x.append(e)

q = mergeSort(x,0,n-1)
print("")
print (q)
