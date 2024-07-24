```python
# nums [1, 2, 3, 4, 5]
n = len(nums) + 1
preSum = [0] * n
# [0, 1, 3, 6, 10, 15]
for i in range(1, n):
    preSum[i] = preSum[i-1] + nums[i-1]

# find rangeSum in window [left, right)
def rangeSum(preSum, left, right):
    return preSum[right] - preSum[left]
```