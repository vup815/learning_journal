- Shuffle first in case `nums` is already sorted which will cause quadratic time complexity
- Partition the array into three part in case there's to many duplicate elements which again will result in quadratic time complexity
	1. less than pivot (index less than `lt`)
	2. equal to pivot (index in range(`lt`, `gt+1`))
	3. greater than pivot (index greater than `gt`)
- This implementation make sure that the window of `lo`, `hi` is `[lo, hi)`, thats why we need to write `gt = hi-1` in `partiton` and don't have to decrement `lt` in `sort`.
- In function`partition`, because we swap `i` with `lt` first then increment them, we can make sure that our pivot is moved to the right position along the way. Some implementation will not swap the pivot in the loop, so they need to swap `lo` with `lt` after the while loop.
```python
def quick_sort(nums):
    n = len(nums)
    def swap(nums, i, j):
        nums[i], nums[j] = nums[j], nums[i]
    
    def shuffle(nums):
        for i in range(n):
            swap(nums, i, random.randint(i, n-1))
    
    def partition(nums, lo, hi):
        pivot = nums[lo]
        lt, gt = lo, hi-1
        i = lt + 1
        while i <= gt:
            if nums[i] > pivot:
                swap(nums, i, gt)
                gt -= 1
            elif nums[i] < pivot:
                swap(nums, i, lt)
                i += 1
                lt += 1
            else:
                i += 1
        return lt, gt
    
    def sort(nums, lo, hi):
        if lo + 1 >= hi:
            return
        lt, gt = partition(nums, lo, hi)
        sort(nums, lo, lt)
        sort(nums, gt+1, hi)
    
    shuffle(nums)
    sort(nums, 0, n)
```
