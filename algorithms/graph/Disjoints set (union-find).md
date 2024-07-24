### Simple

```python
class UF:
    def __init__(self, n):
        self.roots = [i for i in range(n)]
        self.components = n
    
    def root(self, x):
        if self.roots[x] != x:
            self.roots[x] = self.root(self.roots[x])
        return self.roots[x]
    
    def union(self, u, v):
        root_u, root_v = self.root(u), self.root(v)
        if root_u != root_v:
            self.components -= 1
            self.roots[root_u] = root_v
    
    def connected(self, u, v):
        return self.root(u) == self.root(v)
  
    def all_connected(self):
        return self.components = 1
```

### With Rank

```python
class UF:
    def __init__(self, n):
        self.roots = [i for i in range(n)]
        self.ranks = [1] * n

    def root(self, x):
        if self.roots[x] != x:
            self.roots[x] = self.root(self.roots[x])
        return self.roots[x]
    
    def union(self, u, v):
        root_u, root_v = self.root(u), self.root(v)
        if root_u == root_v:
            return False
        if self.ranks[root_u] < self.ranks[root_v]:
            self.roots[root_u] = root_v
            self.ranks[root_v] += self.ranks[root_u]
        else:
            self.roots[root_v] = root_u
            self.ranks[root_u] += self.ranks[root_v]
        return True

    def connected(self, u, v):
        return self.root(u) == self.root(v)