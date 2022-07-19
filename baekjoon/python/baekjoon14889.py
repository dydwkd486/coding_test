import sys
from itertools import combinations
input=sys.stdin.readline

n = int(input()) # 총 인원
s=[] # 각 능력치
for i in range(n):
    s.append(list(map(int,input().split())))
members = [i for i in range(n)]
possible_team = []

# 조합으로 가능한 팀 생성
for team in list(combinations(members, n//2)):
    possible_team.append(team)

min_score=1000000
for i in range(len(possible_team)//2):
    team = possible_team[i]
    a_team=0 # a 팀
    for j in team:
        for k in team:
            a_team+=s[j][k]
    team = possible_team[-i-1]
    b_team=0 # b 팀
    for j in team:
        for k in team:
            b_team+=s[j][k]
    min_score=min(min_score,abs(a_team-b_team)) #최소 값

print(min_score)