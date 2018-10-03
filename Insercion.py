
def insercion(x):
	for i in range(1,len(x)):
		j = i-1
		aux = x[i]
	
		while x[j] >= aux and j>=0:
			x[j+1]=x[j]
			j-=1
		x[j+1] = aux


x = map(int, raw_input().split()) # el: 10 8 7 2 0 11 2 8 6 8 9 
x.pop(0) #Elimina el primer elemento de la lista, que en éste caso es la dimensión de ésta [10]. 

insercion(x)

b=[]
for i in x:
	b.append(str(i))
c=" ".join(b)
print(c)
