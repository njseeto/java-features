### STREAMS

Notes from reading [Java 8 In Action: Lambdas, Streams and Functional Programming](https://www.manning.com/books/java-8-in-action)

> INTERMEDIATE OPERATORS
> 
> | Operation     | Return Type   | Type/Functional Interface Used | Function Descriptor |
> | ------------- |:-------------:| ------------------------------:| -------------------:|
> | filter        | `Stream <T>`  | `Predicate <T>`                |  `T -> boolean`     |
> | map           | `Stream <R>`  | `Function <T, R>`              |  `T -> R`           |
> | flatMap       | `Stream <R>`  | `Function <T, R>`              |  `T -> Stream<R>`   |  
> | limit         | `Stream <T>`  |    `long`                      |                     |     
> | sorted        | `Stream <T>`  | `Comparator<T>`                |  `<T, T> -> int`    |     
> | distinct      | `Stream <T>`  |    `long`                      |                     |   
> | skip          | `Stream <T>`  |    `long`                      |                     |
  
  
 <br>
  
> TERMINAL OPERATORS
> 
> | Operation     | Return Type   | Type/Functional Interface Used | Function Descriptor |
> | ------------- |:-------------:| ------------------------------:| -------------------:|
> | forEach       | `void`        | `Consumer <T>`                 |  `T -> void`        |
> | count         | `long`        |                                |                     |
> | collect       | `Collection`  | `Collector <T, A, R>`          |                     |  
> | allMatch      | `boolean`     | `Predicate <T>`                |  `T -> boolean`     |     
> | anyMatch      | `boolean`     | `Predicate <T>`                |  `T -> boolean`     |     
> | noneMatch     | `boolean`     | `Predicate <T>`                |  `T -> boolean`     |   
> | findAny       | `Optional<T>` |                                |                     | 
> | findFirst     | `Optional<T>` |                                |                     | 
> | reduce        | `Optional<T>` | `BinaryOperator <T>`           |  `(T, T) -> T`      |    
  