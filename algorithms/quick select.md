```python
def quick_select(nums, target_index):
    def swap(nums, i, j):
            nums[i], nums[j] = nums[j], nums[i]
    
    def shuffle(nums):
        for i in range(n):
            swap(nums, i, random.randint(i, n-1))
    
    def partition(nums, l, r):
        pivot = nums[l]
        l_bound, r_bound = l, r-1
        i = l_bound + 1
        while i <= r_bound:
            if nums[i] > pivot:
                swap(nums, i, r_bound)
                r_bound -= 1
            elif nums[i] < pivot:
                swap(nums, i, l_bound)
                i += 1
                l_bound += 1
            else:
                i += 1
        return l_bound, r_bound

    shuffle(nums)
    l, r = 0, len(nums)
    while l < r:
        l_bound, r_bound = partiton(nums, l, r)
        if target_index < l_bound:
            r = l_bound
        elif target_index > r_bound:
            l + r_bound + 1
        else:
            return nums[l_bound]
```
