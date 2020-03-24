class Solution:
    def distributeCandies(self, candies: int, num_people: int) -> List[int]:
        # N(N+1)/2 >= c > N(N-1)/2--> (sqrt(1+8c)-1)/2 <= N < (sqrt(1+8c)+1)/2
        # 一共发多少人次
        N = math.ceil((math.sqrt(1 + 8 * candies)-1) / 2)
        # 需要发完整的轮次
        k = math.ceil(N / num_people) - 1
        addition = num_people * k * (k - 1) // 2
        ans = [k * i + addition for i in range(1, num_people + 1)]
        # 最后一个分到糖果的人
        lastIdx = N % num_people
        if lastIdx == 0:
            lastIdx = num_people
        lastIdx -= 1
        # 最后一轮发糖果
        for i in range(lastIdx):
            ans[i] += k * num_people + i + 1
        ans[lastIdx] += candies - (N - 1) * N // 2
        return ans
