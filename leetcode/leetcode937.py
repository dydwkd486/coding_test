from typing import List


class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        digits, letters=[],[]

        for i in logs:
            if i.split()[1].isdigit():
                digits.append(i)
            else:
                letters.append(i)
        letters.sort(key=lambda x : (x.split()[1:],x.split()[0]))
        return letters+digits

        
if __name__ == "__main__":
    solution = Solution()
    result = solution.reorderLogFiles(logs=["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"])

    print(result)
