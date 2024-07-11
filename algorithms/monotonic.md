**queue**
```python
maxq = []
minq = []
for num in nums:
	while maxq and maxq[-1] < num:
		maxq.pop()
			maxq.append(num)
	while minq and minq[-1] > num:
		minq.pop()
	minq.append(num)
```
**stack**
```python
maxs = []
mins = []
for num in reversed(nums):
	while maxs and maxs[-1] < num:
		maxs.pop()
			maxs.append(num)
	while mins and mins[-1] > num:
		mins.pop()
	mins.append(num)
```