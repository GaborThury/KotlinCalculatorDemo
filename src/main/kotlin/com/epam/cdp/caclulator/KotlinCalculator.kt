package com.epam.cdp.caclulator

class KotlinCalculator {

    fun calculate(input: String): String {
        val stringSplitter = StringSplitter()
        val stringConverter = StringConverter()

        val operations = stringSplitter.getMathOperationsFromString(input)
        val numbersAsStrings = stringSplitter.getNumbersFromString(input)
        val numbers = stringConverter.convertStringToIntegerArray(numbersAsStrings)

        performMultipliesAndDivides(operations, numbers)
        performSumsAndSubtractions(operations, numbers)

        return numbers[0].toString()
    }

    private fun performMultipliesAndDivides(
        operations: MutableList<String>,
        numbers: MutableList<Int>
    ) {
            performOperations(operations, numbers, "*", "/")
    }

    private fun performSumsAndSubtractions(
        operations: MutableList<String>,
        numbers: MutableList<Int>
    ) {
        performOperations(operations, numbers, "+", "-")
    }

    private fun performOperations(
        operations: MutableList<String>,
        numbers: MutableList<Int>,
        firstOperator: String,
        secondOperator: String
    ) {
        var numberOfOperations = operations.size
        var index = 1

        while (index < numberOfOperations) {
            val operation = operations[index]
            if (currentOperationMatchesForInputOperator(operation, firstOperator, secondOperator)) {
                performSingleOperation(numbers, index, operation)
                moveElementsInListToLeft(index, numberOfOperations, operations, numbers)
                numberOfOperations--;
            } else {
                index++
            }
        }
    }

    private fun moveElementsInListToLeft(
        index: Int,
        numberOfOperations: Int,
        operations: MutableList<String>,
        numbers: MutableList<Int>
    ) {
        for (i in index until numberOfOperations - 1) {
            numbers[i] = numbers[i + 1]
            operations[i] = operations[i + 1]
            operations[i + 1] = ""
        }
    }

    private fun currentOperationMatchesForInputOperator(
        operation: String,
        firstOperator: String,
        secondOperator: String
    ): Boolean {
        return firstOperator == operation || secondOperator == operation
    }

    private fun performSingleOperation(
        numbers: MutableList<Int>,
        index: Int,
        operator: String
    ) {
        val number1 = numbers[index - 1]
        val number2 = numbers[index]
        when (operator) {
            "+" -> numbers[index - 1] = number1+number2
            "-" -> numbers[index - 1] = number1-number2
            "*" -> numbers[index - 1] = number1*number2
            "/" -> numbers[index - 1] = number1/number2
        }
    }
}