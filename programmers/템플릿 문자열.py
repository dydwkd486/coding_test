# tsting="this is {template} {template} is {state}"
# variables = [["template","string"],["state","changed"]]
# tsting="{a} {b} {c} {d} {i}"
# variables = [["b","{c}"],["a","{b}"],["e","{f}"],["h","i"],["d","{e}"],["f","{d}"],["c","d"]]
# tsting="this is {template} {template} is {state}"
# variables = [["template","{state}"],["state","{template}"]]
tstring="this is {template} {template} is {state}"
variables = [["template", "string"], ["state", "changed"]]
text=tstring
var_clone=[]
for i in range(len(variables)):
    var_clone.append([variables[i][0],variables[i][1]])

for j in range(len(variables)):
    temp=variables[j][1]
    a=True
    while a:
        for i in range(len(variables)):
            a=False
            aa="{"+var_clone[i][0]+"}"
            # print(aa,temp)
            if aa==temp and i!=j:
                temp=var_clone[i][1]
                variables[j][1]=temp
                # print(variables)
                a=True
                break
    # print(variables)

for i in variables:
    temp="{"+i[0]+"}"
    tstring.replace(temp,i[1])
print(tstring)

answer=tstring
# return answer

