import sys

input = sys.stdin.readline

def main():
    n = input().strip()

    m = input().strip()

    n_list =[]

    for i in range(len(n)):
        n_list.append(n[i])
        if n[i]==m[-1]:
            if "".join(n_list[-len(m):])== m:
                del n_list[-len(m):]

    if "".join(n_list)!="":
        print("".join(n_list))
    else:
        print("FRULA")
    
main()