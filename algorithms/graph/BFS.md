```python
visited = [False] * n
distance = [0] * n
predecessors = [i for i in range(n)]

def bfs(start):
    if visited[start]:
        queue.append()
        distance[start] = 0
    while queue:
        curr = queue.popleft()
        visited[curr] = True
        for adj in adjs[curr]:
            if not visited[adj]:
                queue.append(adj)
                predecessors[adj] = curr
            distance[adj] = distance[curr] + 1
```