# Java Postfix Calculator

This project implements an interactive **Postfix (Reverse Polish Notation) Calculator** in Java using a **stack-based evaluation strategy**. It supports both integer and **floating-point numbers**, allowing users to input mathematical expressions in postfix format and receive immediate results.

---

## Features

- Accepts multi-token postfix expressions (e.g., `3.5 1.2 +`)
- Supports floating-point arithmetic
- Handles operators: `+`, `-`, `*`, `/`, `%`
- Detects and reports:
  - Invalid tokens
  - Insufficient operands
  - Division or modulo by zero
  - Malformed expressions
- Continuous interactive input (type `exit` to quit)

## Concepts Covered
- Stacks (data structures)
- Expression parsing
- Error handling and validation
- Algorithmic problem solving

## How It Works
Postfix expressions are evaluated using a stack:

1. Numbers are pushed onto the stack  
2. When an operator is encountered, two operands are popped  
3. The operation is applied  
4. The result is pushed back onto the stack  

At completion, the stack contains a single result.

## Example

Input:
5 1 2 + 4 * + 3 -

Output:
14.0000

## How to Run

1. Open the project in a Java IDE or terminal
2. Compile:
```bash
javac PostfixCalculator.java
```
3. Run:
```
java PostfixCalculator
```
## Example Output
Postfix Calculator (Supports floating-point numbers)
Enter a postfix expression or type 'exit' to quit.
Expression: 3.5 1.5 +
Result: 5.0000
Expression: 10 2 /
Result: 5.0000
Expression: exit
Calculator terminated.

## Future Improvements

## Future Improvements
- Add graphical user interface (GUI)
- Support additional mathematical functions
- Improve expression validation and error messaging

Expression: exit
Calculator terminated.
