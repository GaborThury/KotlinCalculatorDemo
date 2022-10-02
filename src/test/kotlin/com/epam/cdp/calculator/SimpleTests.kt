package com.epam.cdp.calculator

import com.epam.cdp.caclulator.KotlinCalculator
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class SimpleTests: StringSpec({

    val kotlinCalculator = KotlinCalculator()

    "should return correct values"{
        io.kotest.data.forAll(
            table(
                headers("input", "expected result"),
                row("1+1", "2"),
                row("1-1", "0"),
                row("2*3", "6"),
                row("21/7", "3"),
                row("1+2+3+4+5", "15")
            )
        ) { input: String, result: String ->
            kotlinCalculator.calculate(input) shouldBe result
        }
    }
})