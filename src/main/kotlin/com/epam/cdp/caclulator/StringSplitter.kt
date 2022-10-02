package com.epam.cdp.caclulator

import java.util.regex.Pattern

class StringSplitter {
    fun getMathOperationsFromString(string: String): MutableList<String> {
        return string.split("[0-9]+".toRegex())
            .dropLastWhile { it.isEmpty() }
            //.toTypedArray()
            .toMutableList()
    }

    fun getNumbersFromString(string: String): List<String> {
        return string.split(regex = Regex("[" + Pattern.quote("+-*/") + "]"))
    }
}