**Key points**:
- Use dummy head and tail node in the `DoubleList`
- Only add from tail to have most recently logic
- LRUCache#put: if the key already exist, no need to increment size. The order matters here, if condition `if self.cache.size == self.cap` get execute first, we might have an unexpected cache evicted.

```python
class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None

class DoubleList:
    def __init__(self):
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.size = 0

    def addLast(self, node: Node):
        node.prev = self.tail.prev
        node.next = self.tail
        self.tail.prev.next = node
        self.tail.prev = node
        self.size += 1

    def remove(self, node: Node):    
        node.prev.next = node.next
        node.next.prev = node.prev
        self.size -= 1

    def removeFirst(self):
        if self.head == self.tail:
            return None
        first = self.head.next
        self.remove(first)
        return first

    def size(self):
        return self.size

class LRUCache:
    def __init__(self, capacity: int):
        self.cap = capacity
        self.map = {}
        self.cache = DoubleList()
    
    def makeRecently(self, node):
        self.cache.remove(node)
        self.cache.addLast(node)
    
    def addRecently(self, key, val):
        node = Node(key, val)
        self.cache.addLast(node)
        self.map[key] = node

    def removeLeastRecently(self):
        first = self.cache.removeFirst()
        if first:
            del self.map[first.key]

    def get(self, key: int) -> int:
        if key not in self.map:
            return -1
        self.makeRecently(self.map[key])
        return self.map[key].val

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            self.cache.remove(self.map[key])
            self.addRecently(key, value)
            return 
        if self.cache.size == self.cap:
            self.removeLeastRecently()
        self.addRecently(key, value)
```