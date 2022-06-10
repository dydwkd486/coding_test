class Solution:
    def isPalindrome(self, s: str) -> bool:
        n_list = []
        for char in s:
            if char.isalnum():
                n_list.append(char.lower())
        # print(n_list)
        while len(n_list)>1:
            if n_list.pop() != n_list.pop(0):
                return False

        # if n_list==n_list_reverse:
        # print(n_list_reverse)
        return True

if __name__ == "__main__":
    solution = Solution()
    result = solution.isPalindrome(s="A man, a plan, a canal: Panama")
    print(result)

