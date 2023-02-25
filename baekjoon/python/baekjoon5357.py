for i in range(int(input())):
 s='_'
 for i in input():
  if s[-1]!=i:s+=i
 print(s[1:])