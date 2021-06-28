x,y,w,h=map(int,input().split())

# print(x,y,w,h)
min_x=min((x-0),(w-x))
min_y=min((y-0),(h-y))

print(min(min_x,min_y))