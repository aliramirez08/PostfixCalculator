# Java Postfix Calculator

This project implements an interactive **Postfix (Reverse Polish Notation) Calculator** in Java using a **stack-based evaluation strategy**. It supports both integer and **floating-point numbers**, allowing users to input mathematical expressions in postfix format and receive immediate results.

---

## Features

- Accepts multi-token postfix expressions (e.g., `3.5 1.2 +`)
- Supports **floating-point arithmetic**
- Supported operators: `+`, `-`, `*`, `/`, `%`
- Detects and reports:
  - Invalid tokens
  - Insufficient operands
  - Division/modulo by zero
  - Malformed expressions
- Allows continuous interactive input (`exit` to quit)

---

## How It Works

Postfix expressions are evaluated using a stack:

1. Numbers are pushed onto the stack.
2. When an operator is encountered, two operands are popped.
3. The operation is applied and the result is pushed back.
4. At the end, the stack should contain exactly one result.

Example:
Input: 5 1 2 + 4 * + 3 -
Evaluates to: 14.0000

---

## ▶ How to Run

Compile and run the program from the terminal:

```bash
javac PostfixCalculator.java
java PostfixCalculator
```

Postfix Calculator (Supports floating-point numbers)
Enter a postfix expression or type 'exit' to quit.

Expression: 3.5 1.5 +
Result: 5.0000

Expression: 10 2 /
Result: 5.0000

Expression: exit
Calculator terminated.
