**Requirement**:
The graph has to be `directed acyclic`.

### Kahn's algorithm (BFS)
**Process** : 
1. start with nodes that don't have any `indegree`.
2. reduce the `indegree` of adjacent nodes by 1
3. if adjacent node `indegree` become 0, append it to the queue
```python
# indegree
# adjs
# queue = deque
# n = number of node
for i, degree in enumerate(indegree):
    if degree == 0:
        queue.append(i)
count = 0
t_sort = []
while queue:
    node = queue.popleft()
    count += 1
    t_sort.append(node)
    for adj in adjs[node]:
        indegree[adj] -= 1
        if indegree[adj] == 0:
            queue.append(adj)
return t_sort if count == n else []
```