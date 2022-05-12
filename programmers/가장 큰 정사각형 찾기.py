def solution(board):
    answer = 0
    n=len(board)
    m=len(board[0])
    for i in range(n-1):
        for j in range(m-1):
            if board[i+1][j+1]!=0:
                board[i+1][j+1]=min(board[i][j],board[i+1][j],board[i][j+1])+1
    temp=0
    for i in board:
        temp= max(temp,max(i))
    answer=temp*temp
    return answer