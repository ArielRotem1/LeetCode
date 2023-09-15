class Solution:
    def candy(self, ratings: List[int]) -> int:
        def solve(i: int, ratings: List[int], candies_per_rate: List[int]) -> None:
            index = i - 1
            while index > -1 and ratings[index] > ratings[index + 1]:
                candies_per_rate[index] = max(candies_per_rate[index], candies_per_rate[index + 1] + 1)
                
                index -= 1

            index = i + 1
            while index < len(ratings) and ratings[index] > ratings[index - 1]:
                candies_per_rate[index] = max(candies_per_rate[index], candies_per_rate[index - 1] + 1)
                
                index += 1

        length = len(ratings)
        if length == 1: return 1

        candies_per_rate = [1] * length

        if ratings[0] < ratings[1]:
            solve(0, ratings, candies_per_rate)

        if ratings[length - 1] < ratings[length - 2]:
            solve(length - 1, ratings, candies_per_rate)

        for i in range(1, length - 1):
            if ratings[i] <= ratings[i + 1] and ratings[i] <= ratings[i - 1]:
                solve(i, ratings, candies_per_rate)

        result = 0
        for candy in candies_per_rate:
            result += candy

        return result
