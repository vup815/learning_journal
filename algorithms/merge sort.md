- sorting `nums` in the range of [left, right)
```python
def sort(nums):
    n = len(nums)
    merge_sort(nums, [0]*n, 0, n)

    def merge_sort(nums, temp, left, right):
        if not nums or left == right - 1:
            return
        def merge():
            for i in range(left, right):
                temp[i] = nums[i]
                l, r = left, mid
            for i in range(left, right):
                if l == mid:
                    nums[i] = temp[r]
                    r += 1
                elif r == right:
                    nums[i] = temp[l]
                    l += 1
                elif temp[r] < temp[l]:
                    nums[i] = temp[r]
                    r += 1
                else:
                    nums[i] = temp[l]
                    l += 1
        mid = (left + right) // 2
        merge_sort(nums, temp, left, mid)
        merge_sort(nums, temp, mid, right)
        merge()
```