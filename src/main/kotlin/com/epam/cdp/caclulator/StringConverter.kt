package com.epam.cdp.caclulator

class StringConverter {

    fun convertStringToIntegerArray(numbersAsString: List<String>): MutableList<Int> {
        return numbersAsString.map { it.toInt() }.toMutableList()
    }

}