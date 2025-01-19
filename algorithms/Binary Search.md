**Standard**:
```python
def binary_search(nums, target):
    l, r = 0, len(nums)
    while l < r:
        mid = l + (r-l) // 2
    if nums[mid] == target:
        return mid
    elif target < nums[mid]:
        r = mid
    else:
        l = mid + 1
    return -1
```
**Variation**:
- Both `left_bound` and `right_bound` will return a index where if target value is inserted in that position, `nums` will still be sorted.
- If target value exists, `left_bound` will return the `leftmost` index among all target values.
- If target value exists, `right_bound` will return the `rightmost` index among all target values.
- `left_bound` = `bisect_left`.
- `right_bound` = `bisect_right`.

```python
def left_bound(nums, target):
    l, r = 0, len(nums)
    while l < r:
        mid = l + (r-l) // 2
    if nums[mid] == target:
        r = mid
    elif target < nums[mid]:
        r = mid
    else:
        l = mid + 1
    return l

def right_bound(nums, target):
    l, r = 0, len(nums)
    while l < r:
        mid = l + (r-l) // 2
    if nums[mid] == target:
        l = mid + 1
    elif target < nums[mid]:
        r = mid
    else:
        l = mid + 1
    return l
```
