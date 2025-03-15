# Math Expression Evaluator

## Description
This project implements a mathematical expression evaluator in Java that supports arithmetic operations, multi-digit numbers, floating point numbers, and parentheses. It converts an infix expression (standard mathematical notation) into postfix notation using the Shunting-Yard algorithm and then evaluates the postfix expression to produce the final result.

## Features
- **Operators:** Supports `+`, `-`, `*`, `/`
- **Parentheses:** Handles nested parentheses `()`
- **Numbers:** Supports multi-digit and floating point numbers
- **Operator Precedence:** The evaluator follows standard operator precedence rules:
  - Multiplication (`*`) and Division (`/`) have higher precedence than Addition (`+`) and Subtraction (`-`).
  - Operators with equal precedence are evaluated from left to right.

## Limitations
- Advanced mathematical functions (e.g., exponentiation, trigonometric functions) are not supported.
- The evaluator assumes that the input expression is correctly formatted and does minimal error handling for malformed expressions.
- Only basic error messages are provided for invalid input.

## Compilation Instructions
1. Open a terminal and navigate to the `src` directory:
   ```bash
   cd RUGVED_JUNGHARE_12211514/src
    ```

2. Compile the Java Source Code
    ```bash
    javac MathExpressionEvaluator.java
    ```

This will generate the corresponding .class file(s) in the same directory.

3. Run the Program

Execute the compiled program with: 
```bash
    java MathExpressionEvaluator
```

The program will run and output the result of the evaluated mathematical expression.

## Test Cases

Below are some test cases to validate the functionality of the Math Expression Evaluator. You can modify the `expression` variable in the `main` method of the `MathExpressionEvaluator.java` file to test each case.

### Test Case 1: Simple Expression
- **Expression:** `(3+5)*(2-1)`
- **Expected Output:** `Result: 8.0`
- **Explanation:**
  - `(3+5)` evaluates to `8`
  - `(2-1)` evaluates to `1`
  - **Final result:** `8 * 1 = 8`

### Test Case 2: Expression with Division
- **Expression:** `(3+5)*(2-1)/4`
- **Expected Output:** `Result: 2.0`
- **Explanation:**
  - `(3+5)` evaluates to `8`
  - `(2-1)` evaluates to `1`
  - **Multiplication:** `8 * 1 = 8`
  - **Division:** `8 / 4 = 2`

### Test Case 3: Complex Expression
- **Expression:** `(5*(3+(4/2)*3-6))/(9*(5-3/2))`
- **Expected Output:** `Result: 0.4761904761904762` (approximately)
- **Explanation:**
  - Evaluate inner expression `(4/2)` = `2`
  - Multiply: `2 * 3 = 6`
  - Then: `(3 + 6 - 6) = 3`
  - **Numerator:** `5 * 3 = 15`
  - For the denominator:
    - Evaluate `(3/2)` = `1.5`
    - Then: `(5 - 1.5) = 3.5`
    - Multiply: `9 * 3.5 = 31.5`
  - **Final division:** `15 / 31.5 ≈ 0.47619`
