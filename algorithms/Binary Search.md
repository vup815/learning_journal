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
- Both `left_bound` and `right_bound` will return a index where if target is inserted in that position, `nums` will still be sorted
- If there exist already target values, `left_bound` will return the index to the `left` of all target values.
- If there exist already target values, `right_bound` will return the index to the `right` of all target values.
- `left_bound` is same as `bisect_left`
- `right_bound` is same as `bisect_right`

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