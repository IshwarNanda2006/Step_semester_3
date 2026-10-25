# Week 10 Class Practice - Quiz and Concept Answers

## Part B - Quiz answer key

1. **D** - `==` compares object references, while `equals()` compares String contents.
2. **B** - Reversing `Java Lab` produces `baL avaJ`.
3. **B** - `new Student("Ravi")` directly calls `Student(String name)`, which delegates to the two-argument constructor.
4. **D** - `w1` and `w2` refer to the same Wallet object, so both observe balance 700.
5. **C** - Three constructed Visitor objects increment the shared static counter three times.
6. **A** - The loop visits every array element in its stored order.
7. **B** - `continue` skips printing 3, so output is `1 2 4 5`.
8. **A** - Java passes the primitive value; changing parameter `n` does not change `x`, so it prints 5.
9. **C** - Since `count` is a `double`, the division produces approximately `83.33333333333333`.
10. **B** - The card fee is 2% of 500, so the program prints `Paid 510.0 by card`.
11. **B** - Strings are immutable; `name` stays `java` and `upperName` refers to `JAVA`.
12. **B** - The two literals share one pooled String, while `new String("hello")` creates a second String object.
13. **A** - `Campus` has length 6, and character index 2 is `m`.
14. **A** - The `@` in `user@domain.com` is at index 4.
15. **B** - The default constructor sets title to `Unknown` and price to `0.0`.
16. **A** - The parameterized constructor stores `Java Programming` and `450.0`.
17. **B** - There are two Wallet objects: `w1` and `w2` alias one object, while `w3` refers to another.
18. **C** - Both references see the same Wallet after the balance becomes 700.
19. **C** - Changing `s1` to `Anu` does not alter the separate Student object referenced by `s2`.
20. **C** - Three Visitor instances increment the static count to 3.

## Part C - Concept answers

### 1. String immutability
A Java `String` cannot be changed after it is created. Operations such as concatenation or `toUpperCase()` produce a new String rather than editing the original, so repeated modifications can allocate many temporary objects. Use `StringBuilder` for repeated modifications, especially inside loops, and convert it to a String when finished.

### 2. The `this` keyword
When a constructor parameter has the same name as an instance field, the parameter shadows the field inside that constructor. `this.name = name;` assigns the parameter value to the current object's field; `this.name` refers to the instance field, while `name` refers to the parameter.

### 3. Objects and reference variables
An object is the instance stored in memory; a reference variable holds a reference to that object. Assigning `Wallet w2 = w1;` copies the reference, not the object, so `w1` and `w2` refer to the same object and mutations through either reference are visible through both.

### 4. Static and instance variables
A static variable belongs to the class and is shared by all its instances, making it suitable for a shared visitor count or class-wide constant. An instance variable belongs to each object, making it suitable for each student's name, each wallet's balance, or each employee's salary.

### 5. `for`, `while`, and `do-while`
Use `for` when the iteration count or loop progression is clear, such as traversing an array by index. Use `while` when repetition depends on a condition and the number of iterations is not known in advance, such as reading values until input ends. Use `do-while` when the body must execute at least once, such as displaying a menu before checking whether the user wants to continue.

### 6. Pass-by-value
Java always passes arguments by value. For a primitive, the method receives a copy of the primitive value, so reassigning the parameter does not change the caller's variable. For an object reference, the method receives a copy of the reference; it can mutate the referenced object, but reassigning that copied reference does not reassign the caller's reference.

### 7. Integer division
When both operands are integers, Java integer division discards the fractional part, so `250 / 3` evaluates to `83`. To preserve a fractional result, make at least one operand floating-point before division, such as `250.0 / 3` or `(double) total / count`.

### 8. Encapsulation
Encapsulation keeps an object's state private and exposes controlled operations for reading or changing it. Private fields prevent direct outside modification; getters can provide read-only access and setters or domain methods can validate changes, preserving invariants such as non-negative balances.

### 9. `==` and `equals()`
For objects, `==` checks whether two references identify the same object. `equals()` checks logical equality as defined by the class; overriding it allows objects with the same meaningful data, such as two records with the same ID, to compare equal even when they are different instances.

### 10. Overloading and overriding
Overloading uses the same method name with different parameter lists, and the compiler selects the applicable overload at compile time. Overriding replaces an inherited instance method with a subtype-specific implementation; the implementation called for an overridden method is selected at runtime based on the actual object type.
