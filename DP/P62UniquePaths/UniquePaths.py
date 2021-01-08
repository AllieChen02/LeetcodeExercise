import unittest

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1] * n for _ in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[m-1][n-1]

class UnitTest(unittest.TestCase):
    def test_1(self):
        m, n = 3, 7
        self.assertEqual(28, Solution().uniquePaths(m, n))
if __name__ == "__main__":
    unittest.main()