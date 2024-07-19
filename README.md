# COMP2511 Notes

OOP principles: encapsulation, abstraction, inheritance, polymorphism

**Side Note: Porgram to an interface not an implementation (对接口编程而不是对实现编程); Favor object composition over inheritance (优先使用对象组合而不是继承)**

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

<br/>

Tips: use inheritance (is-a) wisely, do not overuse it. Has-a relationship such as composition is more easy to control and maintain

<br/>

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
allows subclass to provide a specific implementation for a method that is already defined in its superclass. <br/>
the method in the subclass should have the same name, return type and parameters as in the superclass <br/>

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

<br/>

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
Have multiple type parameters, i.e the genertic OrderedPair class which implements the generic Pair interface
<br/>

<img width="700" src="https://github.com/Natalie-2004/Java/assets/62165943/9db5acb0-a328-4829-ab81-b4d684f793e5" alt="#">

<img width="700" src="https://github.com/Natalie-2004/Java/assets/62165943/80889236-4921-4b95-a9bf-b5565deda6f8" alt="#">

<br/>

**Generic Types**: generic class or interface that is parameterized over types <br/>

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

// Define a generic interface with Key K and V value
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

**Generic Methods**: methods that introduce their own type parameters <br/>

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
A framework that provides an architecture to store and manipulate _a group of objects_(elements). Collections means an object that groups multiple elements iinto a single unit.
<br/>
It uses the design rule in which we keep the stuff require to change in one class, and those which don't need to change remains another class (sorting algo etc.)
<br/>
**Java Collection Framework(JDK)**
- (Core) Interfaces: allow collections to be manipulated independently of the details of their representation.
    - root interface in the collection hierarchy
    - have constructor that takes a Collection argument
    - main methods perform basic operations such as isEmpty(), size() etc
    - more interface are extends Collections, i.e Queue Interface -> represents a collection designed for holding elements prior to processing
- Implementations: concrete implementations of the collection interfaces
    - purpose is to summarized these:
    - <img width="550" src="https://github.com/Natalie-2004/Java/assets/62165943/2dfe4090-35e8-4f13-975f-bcd0dc59bad9" alt="#"> 
- Algorithms: the methods that perform useful computations, such as searching and sorting -> also said to be _polymorphic_, same methods can be used on many different implementations of the approproate collection interfaces

**Note**: for implementations, there must comes with a method 'int compareTo(Obj other)'

### Anonymous class
While local classes are class declarations, anonymous classes are expressions, which means that you define the class in another expression.
<br/>
Less useful when creating object of a particulcar class many times -> code repeat
<br/>
```
 HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            // two methods implement the interface
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };
```

### Lambda experssion
Using '->' to simplify operation into one line, like => in js.

### JUnit
- a type of unit testing
- useful for refactoring tasks
- includes:
  - test case -> java class contains test methods
  - test method -> executes the test code, annotated with @Test, in a test case
  - asserts -> assert or assert statements checks and expected statement versus the actual statements
  - test suites -> collection of several test cases
<br/>
<img width="700" src="https://github.com/Natalie-2004/Java/assets/62165943/01226dbc-b214-4a9b-b387-bdd8790e37c0" alt="#">
<br/>

**Tips:**
- @BeforeEach -> initialise test setting
- @AfterEach -> clear test data
- @TestFactory -> allow create multiple tests of type denamicTest, they return: Iterable/Collection/Stream (note beforeEach and afterEach are not called in this case)

### Design Principles
What's Good software design? <br/>
- **loose coupling** -> allow components to be used and modified independently of each other (but not zero couple!)
- **high cohesion** -> all code in methods work toegther to create same purpose, and methods and properties of a class work toegther to define purpose

<br/>

Design Smells:
- Rigidity (program more difficult to change)
- fragility (program break in many place with minor change)
- Immobility (hard to reuse)
- Viscosity (changes are easier to implement through 'hacks' over 'design preserving methods')
- Opacity (module to be difficult to understand)
- Needless complexity: keep it simple
- Needless repetition: should not repeat everything

<br/>

**DO NOT USE DESIGN PRINCIPLE IF THE CODE DOESNT HAVE DESIGN SMELL**

<br/>

**Single Responsibility**

- have one responsibility over a single function
<br/>

**Open-Closed Principle**

- open for extension but close for modification -> add new stuff instead of modify old thing
<br/>

**Law of Demeter**

- class should interact as few classes as possible
- only interact with friend isteand of fof: A.getObjectB().getObjectC().display() is violate
<br/>

**Interface segregation principle**

- split up massive interface into small ones so that reduces so called "dead code", the class is unlikely to implement methods it doesn't use at all
<br/>

**Dependency Inversion Principle**

- high level modules should not depend on low-level modules
- both should depends on abstraction
<br/>

**Liskov Substitution principle**

- objects of superclass should be replace by with objects of its subclass without breaking the application
- the subclass should inherit and do not change the properties that superclass had
- i.e plane is not subclass of car, it can't drive on road; 3d map is not subclass of 3d, missing z-coordinate
<br/>

Tips for @Override:
- argument list should be exactly the same as that of the overriden method
- if the super class method is public then the subclass class method cannot be protect or private
- statics, constructors and attribute with final cannot be override

# Week 4

### Refactor Part 1

Bad code Smell:
- duplicated code in more than one place
- long methods
- large class
- long parameter list
- divergent change: one class is commonly changed in different ways for different reasons
- shotgun surgery: make lot of different change to a lot of different classes

Lec example: Rental

<br/>

Ways to improvement:

1. Extract methods
2. Rename variable
3. Move(Re-examine) method
4. Replace conditional logic with polymorphism

<br/>

These techniques make code reusebale through **encapsulation(protect data and behaviour) and delegation(use an object of another class as an instance variable, and forward messages to the instance.)**

<br/>

### Lambda Expressions

Benefits:
- easily define anoymous methods
- treat code as data, function as object
- pass functionality as method argument
- use to implement interface with only one abstract class -> function interface

```
public interface MuFunctionInterface A {
    public int myCompute(int x, int y)
}

// component: comma-separated list of formal parameters; arrow; body 
MyFunctionInterfaceA f1 = (x, y) -> x + y;

public interfaceInterfaceC {
    public double doSomething(int x)
}

MuFunctionInterfaceC f4 = x -> {
    double y = 1.5 * x;
    return y + 8.0;
}
```

<br/>

### Method Referencing

Benefits:
- reuse methods: treating methods as an instance of a functional interface
- ClassName::methodName; ClassName::new -> constructor

The function interface: interface with single abstract method <br/>
This stored in .util.function package including labda expressions and method references <br/>

Several function shapes:
- Function (from T to R)
- Consumer (T to void)
- Predicate (T to boolean)
- Supplier (R)

## Design Patterns

Write code under the principles so that it become easy to maintain and represent a template for how to solve problem <br/>
Also provide shared vocabularies, improve communications and documentaion

- Creational
- Structural
- Behavioural 

**Strategy Pattern (Behavioural)**

Strategy lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable (互相替换).
For example, Sorting Algos
<br/>

Key: implement concrete algorithms via the same interface <br/>

When to use it? <br/>

- When you have multiple algos for a specific task and you want to switch between them easily.
- When you need to avoid bunch of conditional statements that executing similar algos
- When a class has multiple behaviors that can be turned on or off based on runtime conditions.

Pros and Cons <br/>
- Flexibility: Strategies can be changed dynamically at runtime.
- Encapsulation: Each strategy encapsulates its algorithm, adhering to the Single Responsibility Principle.
- Elimination of Conditional Statements: Reduces the need for complex conditional logic.

<br/>

- Increased Number of Classes: As each strategy requires a separate class, this can lead to an increase in the number of classes in the system.
- Client Awareness: The client must be aware of different strategies to select the appropriate one.
- All strategy classes are exposed to outside

<br/>

**State Pattern (Behavioural)**

State lets an object alter its behavior when its internal state changes. It appears as if the object changed its class. <br/>

Finite State Machine: an abstract method which can change from one state to another state in response to some external inputs (transition).  
It must contains:
- a list of its states
- limited condition for each transition
- its initial state

<br/>

**Key idea: the same event or input (stimulus) can result in different behaviors (actions) depending on the current state of the object. Traffic Light changes from Green -> Yellow -> Red using the same timer event(stimulus)**

<img width="700" alt="Screenshot 2024-07-03 at 4 14 03 pm" src="https://github.com/Natalie-2004/Java/assets/62165943/cee9bcac-2ef4-4e22-b102-fd7888e861cd">

More example, vending machines: dispense products when the proper combination of coins is deposited <br/>

When to use it? <br/>

- When an object's behavior depends on its state, and it must change its behavior at runtime depending on that state.
- When state-specific behavior should be localized to the state objects themselves.
- When the code has multiple conditional branches that depend on the object's state.

Pros and Cons <br/>

- Encapsulation of State-specific Behavior: Each state-specific behavior is encapsulated in its own class.
- Simplifies Complex Conditionals: Reduces the need for complex conditional statements.
- Encourages Single Responsibility Principle: Each state class handles one particular state-specific behavior.

<br/>

- Increased Number of Classes: As each state requires a separate class, this can lead to an increase in the number of classes in the system.
- State Transitions: The transitions between states can become complex if not managed properly.

<br/>

# Week 5

**Observer Pattern (Behavioural)**

An object, named the subject/observable, maintains a list of its dependents (observers) and notifies them automatically of any state changes, usually by calling one of their methods. <br/>

So subject and observers are loosely coupled. (cobservers can be add/remve at runtime) And they are one-to-many dependency.
Also an object can be an observer and also be subject (double dispatch) <br/>
For example, button-event in web development -> nothing happen until user click on the button <br/>

Event driven programming: only carry out a task if a particular event takes place, otherwise do nothing. <br/>

Pull and Push Data: <br/>

subject need to change data while notifying a change to the observers <br/>

- push data
  - pass the changed data to its observers that must implement such methods for example -> update(data1, data2)

- pull data
  - pass the reference to itself to its observers, and the observers need to get the required data from subject -> update(this)
  - subject needs to provide the required access methods for its observers


When to use it? <br/>

- When a one-to-many dependency between objects is required.
- When changes to one object need to trigger updates to other objects.
- When an object should be able to notify other objects without making assumptions about who these objects are.

Pros and Cons <br/>

- Loose Coupling: The subject and observers are loosely coupled. The subject doesn't need to know the details of the observers.
- Flexibility: Observers can be added or removed at runtime.
- Communication: A subject can updates to all registered observers.

<br/>

- Unexpected Updates: Observers might be notified at unexpected times, which can lead to unpredictable behavior.
- Memory Leaks: In some programming languages, there is a risk of memory leaks if observers are not properly unregistered.

**Composite Pattern (Structural)**

Compose objects into tree structures to represent part-whole hierarchies. This pattern lets clients ignore differences between individual objects and compositions of objects. <br/>

Motivation and Intent: mainipulate a single instance of the object just as we would manipulate a group of them, such that no discrimination between them <br/>

Component Object: An abstract class or interface that declares the interface for objects in the composition <br/>

Leaf: A class representing leaf objects, operating directly on the object -> Single <br/>

Components: A interface stores collection of children components -> either leaf and/or composite <br/>

Composite: A class representing composite objects (subtree), operating on its children, and if require, collect the returning values and derives the required ans -> Group <br/>

<br/>

### Refactor Part 2

In part 1, we mainly introduces low-level refactoring. Today we introduce how high-level refactoring works

- is more important
- plays with design patterns
- change languaage idioms
- improve optimization i.e time complexcity

<br/>

Code smell: structure, complex logic and conditional statements, large method </br>

Design smell: class level abstractions, class with multi responsibilities <br/>

Specific tech:

- Extract Method: Creating new methods from parts of larger methods
- Introduce Parameter Object: Consolidating groups of parameters into a single object
- Replace Temp with Query: Moving expressions to methods to avoid temporary variables (not a common way)
- Extract Class: Creating new classes from existing ones to improve cohesion
- Move Method: Shifting methods to more appropriate classes

<br/>

Common code smell and solution:

- Long Method: Extracting parts of the method to reduce length
- Large Class: Using Extract Class or Extract Sub-Class to split responsibilities
- **Long Parameter List**: Consolidating parameters into objects (Encapsulate these parameters into a single object, and then this object in this new parameter)
- Duplicate Code: Using Extract Method or Pull Up Field to consolidate duplicate code
- Feature Envy (frequently access the data or methods of another class): Relocate methods to the classes they primarily interact with
- Divergent Change and Shotgun Surgery: Grouping related changes together to minimize widespread modifications
- Data Classes: Adding behavior to classes that only store data
- Lazy Classes: Removing classes that do not add significant value
- Switch Statements: Replacing with polymorphic solutions using like the Strategy Pattern

<br/>

**Factory Method (Creational)**

Defines an interface for creating an object but allows subclasses to alter the type of objects that will be created. It focuses on a single product. It provides a way to delegate the instantiation of derived classes to subclasses <br/>

In the factory pattern, we do not expose the creation logic to client when creating object, and we use common interface to point to the newly created bject <br/>

When to use it? <br/>

- When a class cannot anticipate the class of objects it needs to create: If the class does not know in advance the exact types and dependencies of the objects it needs to create.
- When a class wants its subclasses to specify the objects it creates: The superclass delegates the responsibility of creating an object to its subclasses.
- When you need to create complicated object

Pros and Cons <br/>

- Single Responsibility Principle: Factory Method encapsulates the code for object creation.
- Open/Closed Principle: You can introduce new types of products without changing the creator code -> high extension
- When caller want to create an object, he only require to know the name
- Hide the product discrete implementation, caller only need to care about product's interface

<br/>

- Subclassing: Requires creating a subclass for each type of product -> increase system complexity

<br/>

**Abstract Factory Method (Creational)**

Provides an interface for creating families of related or dependent objects without specifying their concrete classes. Key point is focus on families of related products. It provides a way to encapsulate a group of individual factories that share a common idea <br/>

When to use it? <br/>

- Used when a system needs to be independent of how its objects are created, composed, and represented
- when a system needs to support multiple families of products.

<br/>


# Week 7

**Template Pattern**

**Singleton Pattern (Creational)**

One of the simplest pattern in design patterns, it involves a single class responsible for creating its own object while ensuring that only one instance of the object is created.
This class provides a way to access its only instance without needing to instantiate the class. <br/>

Note:

- singleton can only have one instance and must self create own's instance
- singleton must provide this instance to other object

<br/>

When to use it? <br/>

- This is useful when exactly one object is needed to coordinate actions across the system.
- Control the number of instances
- Gobally used class request frequent create and/or destroy

Pros and Cons <br/>

- In memory there's only one instance, saving memory particularly frequent create and/or destroy
- avoid multi-occupied to memory

<br/>

- no interface
- can't inheritance
- avoid with single responsibility principle: a class should only focus on inner-logic, and not care how to do instantiate outside

<br/>
