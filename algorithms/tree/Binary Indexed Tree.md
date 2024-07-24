**Time Complexity**:
-  n log(n) for _init_
- log(n) for update and query
![[Pasted image 20240707235441.png]]

```python
class BinaryIndexedTree:
    def __init__(self, nums):
        n = len(nums) + 1
        self.bits = [0] * n
        for i, num in enumerate(nums, 1):
        self.update(i, num)
  
    def update(self, index, value):
        while index < len(self.bits):
            self.bits[index] += value
            index += index & (-index)
  
    def query(self, index):
        total = 0
        while index > 0:
            total += self.bits[index]
            index -= index & (-index)
        return total
  
    def range_query(self, left, right):
    # [left, right)
    return self.query(right) - self.query(left)
```