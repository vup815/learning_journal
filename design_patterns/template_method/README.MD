# Template Method
## Definition
```
    Template Method define the sekeleton of an algorithm in an operation, deferring
    some steps to subclasses. Template Method lets subclasses redefine 
    certain steps of an algorithm without changeing the structure.
```
## Components
1. Template method: Define the algorithm's structure.
2. Primitive operation: Allow subclasses to behave differently.
3. Concrete operation: Define operation that cannot be overwritten.
4. Hook method: Allow subclasses have freedom to overwrite or not.

## Pseudo-code
```java
public abstract class AbstractClass {

   final void templateMethod() {
       primitiveOperation1();
       primitiveOperation2();
       concreteOperation();
       hook();
   }
   
   abstract void primitiveOperation1();
   abstract void primitiveOperation2();
   final void concreteOperation() {
       // some implementation
   }
   void hook() {}
}
```
