import sys
sys.setrecursionlimit(6000000)
def req(len):
    if len==1:
        return ["*"]
    
    star= req(len//3)
    L=[]

    for s in star:
        L.append(s*3)
    for s in star:
        L.append(s+" "*(len//3)+s)
    for s in star:
        L.append(s*3)
    return L


n= int(input())

print("\n".join(req(n)))