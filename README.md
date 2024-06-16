# COMP2511 Notes

# Week1
## Inheritance 继承
  - creating new classes based on existing ones -> reuse the methods and fields of that class can reduce code repetition -> **complex tree structure**
  - **subclass (child)**
  - **superclass (parent)**
  - class ...subclass extends ...superclass
```
SmallCircle extends Circle
SmallCircle s = new SmallCircle(s.x, s.y, s.radius)
```

relationship:
  - is-a -> superclass should contains **common and general** info to all subclass
  - has-a -> combines/reference current class's object to create new class i.e a cube is not a line but it contains

## Java Basic
  - 对象: 实例化一个类 class
      - always keep data private (local)
      - always initialize data
      - break up classes if too many responsibilities
``` 
Circle c = new Circle
```
  - 属性: attributes 
```
private double x;   // c.x = 2
private double y;   // c.y = 5
private double radius;    // c.r = 1
```
  - 初始化:
```
public Circle(double x, double y, double radius) // same as the public class name
  this.x = x;
  this.y = y;
  this.radius = radius;
```

**all variables should be declared in private and access the certain variable via setter or changes certain variable with getter**

# Week2
## Polymorphism 多态
- ability to process objects differently based on their data type or class
- allows one **interface** to be used for a general class of actions 
    - interface contain only constants, abstract by default methods(no bodies) and types.
    - can have multi interfaces or sub-interfaces in a class -> allow inherit and extend methods from different sources

```java
// interfaces example 
interface Animal {
    void makeSound(); // abstract method
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        
        dog.makeSound(); // Outputs: Woof
        cat.makeSound(); // Outputs: Meow
    }
}
```

### Key Q: the difference between **normal class, abstract class and interface**?

**normal class**
- create instances using new keyword
- can directly initialise class

**_abstract class_**
- use 'extend'
- has both abstract and concrete method 
- can have instances variables 
- can have constructors
- a class can only extend one abstract class

```
abstract class Animal {
    abstract void makeSound();

    void sleep() {
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Woof");
    }
}
```

**interface**
- use 'implementation'
- only have abstract method
- cannot have instance, only static
- cannot have constructors
- only define functions signatures
- a class can implement multiple interfaces, but needed to follow all of its rules (like contract)

```
interface Animal {
    void makeSound();
}

interface Pet {
    void play();
}

class Dog implements Animal, Pet {
    public void makeSound() {
        System.out.println("Woof");
    }

    public void play() {
        System.out.println("Playing fetch");
    }
}
```

### Shadowing
occurs when a subclass defines a variable with the same name as one in its superclass,
and thus "shadowing" the superclass variable 

```java
class SuperClass {
    int x = 5;
}

class SubClass extends SuperClass {
    int x = 10;

    void printX() {
        System.out.println("x in SubClass: " + x); // x = 10
        System.out.println("x in SuperClass: " + super.x); // x = 5
    }
}
```

### Method Overriding
allows subclass to provide a specific implementation for a method that is already defined in its superclass. <h>
the method in the subclass should have the same name, return type and parameters as in the superclass

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound(); // Outputs: Woof
    }
}
```

### Method Forwarding
where a method in a class calls another method, either within the same class or in another class

```java
class Helper {
    void help() {
        System.out.println("Helper is helping");
    }
}

class MainClass {
    Helper helper = new Helper();

    void doWork() {
        System.out.println("MainClass is doing work");
        helper.help(); // Method forwarding
    }
}

public class Main {
    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        mainClass.doWork();
    }
}
// MainClass is working
// Helper is helping
```

## Domain Models
- visually represents important domain concepts and relationships -> **UML** and **class diagrams**
- help clarify and communicate during the design phase
- domain models: conceptual models/domain object models

**Think**
- "What are the features of the system to be and who requires these features?" -> external behaviour
- "How elements of system-to-be interact to provide the external behaviour?" -> internal

- Entities / Objects -> class can't represent directly by String/Number
- Relationships
- Properties / fields / attributes
- Actions / functionality -> is going to change the stage

<img width="700" src="https://github.com/Natalie-2004/Java/assets/62165943/38ffe84e-82c2-4379-a8a2-b5102d9d5dcd" alt="#">

**Relationship**

<img width="700" src="https://github.com/Natalie-2004/Java/assets/62165943/88c9f054-a04e-419c-be50-e33001704974" alt="#">

- (directed) Association:  a class "uses" another class. relationship is more like "has-a" between two classes that allows one object instance to cause another to perform an action on its behalf. i.e Hotel has Room, Owner has Car
- Inheritance: when one class (the child) "is a type of" another class (the parent). The child class inherits all features of the parent class and can also have its own additional features
- Realization/Implementation: when a class implements an interface. The class must then implement the methods defined in the interface
- Dependency: loosest relationship. A depends on B in someway
- Aggregation: represents a special "has-a" relationship, but the component or instances can exist independently from the aggregate. Contain cardinality
- Composition: represents a special "has-a" relationship, but the component or instances cannot exist independently from the composite (class or object). If the composite is destroyed, the component is also destroyed. Contain cardinality
<br>

**Cardinality**
- 1..1
- 1..m
- m..m

## Design by Contract
[pdf](https://nw-syd-gitlab.cseunsw.tech/COMP2511/24T2/content/-/blob/main/lecture-slides/week02/DesignByConstract.pdf)

# Week3
## Exceptions
- An exception is an _event_, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions -> something has gone wrong 
- **Throwing Exceptions**: when errors occur, an exception object is generated amd given to the runtime system -> putting all message inside
- Checked Vs. Unchecked -> all classes that are Runtime/Error are unchecked; all classes inherit from Exception but not directly/indirectly from class Runtime are checked
- There are three kinds:
    - Checked exceptions (IOException, SQLException)
    - Error (OutOfMemory)
    - Runtime exceptions (ArrayIndexOutBoundsExceptions)
<img width="700" src="https://github.com/Natalie-2004/Java/assets/62165943/d00a001d-6825-449c-bfac-382c080cdad2" alt="">

<img width="700" src="https://github.com/Natalie-2004/Java/assets/62165943/3a7c2df2-d451-45f4-96f6-679ced80aec1" alt="#">

#### Exceptions in inheritance
if a subclass method _overrides_ a superclass method, a subclass's throws clause can contain a subset of a superclass's throws clause -> subclass can not throw more exceptions or differenet kind of exceptions

## Assertions
- useful at checking preconditions, post-conditions, and control-flow invariants
- **do not** use to check for argument in public methods and do any work that your application requires correct operation
- does not result in side effects
- assert: condition(if false prints error message) : error message
- assertEquals: actual, expected
- assertThrow
- assertNotThrows

### Generics in Java
<br>
Enables types (classes and interfaces) to be parameters when defining <br/>
  - classes <br/>
  - interfaces <br/>
  - methods <br/>

Benefits: 
Removes castings and offers stronger type checks at complie time <br/>
Allows implementations of generic algo, that work on collections of different types, can be customized, and are type safe <br/>
Adds stability to your code by making more of your bugs detectable at complie time <br/>
Have multiple type parameters, i.e the genertic OrderedPair class which implements the generic Pair interface <br/>
<img width="700" src="https://github.com/Natalie-2004/Java/assets/62165943/9db5acb0-a328-4829-ab81-b4d684f793e5" alt="#">
<br/>
**Generic Types**: generic class or interface that is parameterized over types
```
// Define a generic class with one type parameter T
public class Box<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello, Generics!");
        System.out.println(stringBox.getContent()); // Output: Hello, Generics!

        Box<Integer> intBox = new Box<>();
        intBox.setContent(123);
        System.out.println(intBox.getContent()); // Output: 123
    }
}
```
```
public interface Pair<K, V> {
    K getKey();
    V getValue();
}

public class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new OrderedPair<>("One", 1);
        System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue()); // Output: Key: One, Value: 1
    }
}
```
<br/>
**Generic Methods**: methods that introduce their own type parameters
```
public class GenericMethodExample {
    // Define a generic method with a type parameter T
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"A", "B", "C", "D", "E"};

        printArray(intArray); // Output: 1 2 3 4 5 
        printArray(strArray); // Output: A B C D E 
    }
}
```

### Collections
A framework that provides an architecture to store and manipulate _a group of objects_(elements). Collections means an object that groups multiple elements iinto a single unit
<br/>
Java Collection Framework(JDK)
- (Core) Interfaces: allow collections to be manipulated independently of the details of their representation.
    - root interface in the collection hierarchy
    - have constructor that takes a Collection argument
    - main methods perform basic operations such as isEmpty(), size() etc
    - more interface are extends Collections, i.e Queue Interface -> represents a collection designed for holding elements prior to processing
- Implementations: concrete implementations of the collection interfaces
    - purpose is to summarized these:
    - <img width="550" src="https://github.com/Natalie-2004/Java/assets/62165943/2dfe4090-35e8-4f13-975f-bcd0dc59bad9" alt="#"> 
- Algorithms: the methods that perform useful computations, such as searching and sorting -> also said to be _polymorphic_, same methods can be used on many different implementations of the approproate collection interfaces




