### Intention: 
Create a group of items which has to be used together.

### Force: 
Clients don't need to know about the connection between them. They only want to use those objects without worrying the compatibility issues.

### Solution:
Declare a abstract factory interface to create objects under the same category. Implementation classes are responsible for creating actual objects. 

![[Pasted image 20230926195339.png]]

### Result:
Abstract factory separate the concrete object and client.
Client will not be affected when the implementation of object's creation changes. Client needs to use concrete factory to create different objects under the same category in order to avoid any compatibility issue.

The method of creating objects is defined in the abstract factory, so if there is any new type of objects, we have to change the interface, thus changing all the concrete factory classes. Thus, this pattern will make creating new type of object harder.