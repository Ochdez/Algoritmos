
def insercion(x):
	for i in range(1,len(x)):
		j = i-1
		aux = x[i]
	
		while x[j] >= aux and j>=0:
			x[j+1]=x[j]
			j-=1
		x[j+1] = aux


x=[]
n = int(input())

for i in range(0,n):
	e=int(input())
	x.append(e)

insercion(x)

b=[]
for i in x:
	b.append(str(i))
c=" ".join(b)
print(c)