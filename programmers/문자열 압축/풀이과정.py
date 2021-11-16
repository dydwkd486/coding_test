def solution(s):
    result=1000
    temp=""
    count=1
    for j in range(1,len(s)+1):
        answer = ""
        for i in range(int(len(s)/j)):
            
            # print(s[(i)*j:(i+1)*j],s[(i+1)*j:(i+2)*j],s[(i)*j:(i+1)*j]==s[(i+1)*j:(i+2)*j])
            if s[(i)*j:(i+1)*j]==s[(i+1)*j:(i+2)*j]:
                if temp==s[(i)*j:(i+1)*j]:
                    temp=s[(i)*j:(i+1)*j]
                    count+=1
                elif temp=="":
                    temp=s[(i)*j:(i+1)*j]
                    count+=1
            else:
                # print("count",count)
                if count==1:
                    answer=answer+s[(i)*j:(i+1)*j]
                else:
                    answer=answer+str(count)+s[(i)*j:(i+1)*j]
                temp=""
                count=1
            if len(s[(i)*j:(i+1)*j])!=len(s[(i+1)*j:(i+2)*j]):
                answer=answer+s[(i+1)*j:(i+2)*j]
        # print(answer,len(answer))
        result=min(result,len(answer))
        # print(result)
            
    return result