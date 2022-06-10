import collections
from typing import *


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = collections.defaultdict(list)
        for word in strs:
            # print(''.join(sorted(word)))
            anagrams[''.join(sorted(word))].append(word)
        return list(anagrams.values())

if __name__ == "__main__":
    solution = Solution()
    solution.groupAnagrams(strs = ["eat","tea","tan","ate","nat","bat"])