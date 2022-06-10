import collections
import re
from typing import Deque

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        s = re.sub('[^a-z0-9]','',s)
        return s == s[::-1]

if __name__ == "__main__":
    solution = Solution()
    result = solution.isPalindrome(s="A man, a plan, a canal: Panama")
    print(result)


