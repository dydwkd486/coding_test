from typing import List
import re
import collections 

class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        word = [word for word in re.sub(r'[^\w]',' ',paragraph).lower().split() if word not in banned]
        return collections.Counter(word).most_common(1)[0][0]
        

if __name__ == "__main__":
    solution = Solution()
    result = solution.mostCommonWord(paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"])
    print(result)