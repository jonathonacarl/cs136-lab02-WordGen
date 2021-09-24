# Lab 2 - Random Writing : Thought Questions

_Self Check_ Problem 3.2: What is the difference between the `add(v)` and `add(i,v)` methods of Vector?
 `add(v)` adds an element to the array at the end of the vector, possibly expanding it (depending on whether it has capacity to).
 `add(i,v)` adds an element to the array at a particular location.

_Self Check_ Problem 3.3: What is the difference between the `add(i,v)` method and the `set(i,v)` method?
 `add(i,v)` adds an element to the array at a particular location.
 `set(i,v)` sets a particular location of the index to a specified value. In other words, the length of the vector does not increase and instead the old value is replaced by the new one.

_Self Check_ Problem 3.4: What is the difference between the `remove(v)` method (where `v` is an `Object` value), and the `remove(i)` (where `i` is an `int`)?
 `remove(v)` removes the first specified object in the vector, whereas `remove(i)` removes a specified index of the vector and does not depend on what object is contained in that index.

Problem 3.6: This question asks about *trade-offs*. Consider a fictional class called `BitVector` that has an interface similar to `Vector`, but the values stored within the `BitVector` are all known to be `boolean` (the primitive type). Why might we choose to write a special-purpose class like `BitVector` instead of using a `Vector<Boolean>`? A good answer will (very) briefly compare any advantages a designer might gain from specialization vs. the advantages of using Java Generics.
  Using a Vector<Boolean> does not use the primitive type boolean, while BitVector does use the primitive type. While using Vector<Boolean>, a transaction occurs in order to convert the boolean to a Boolean. Vectors can store many different types of objects, whether it be String, Integer, Boolean, etc. By making a BitVector class, you limit the number of objects you can put inside the vector, which increases the efficiency of the program. When Java has many ways to solve a problem (or many objects to choose from in this case), the program is usually less efficient.