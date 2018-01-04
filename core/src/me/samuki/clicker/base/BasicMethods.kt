package me.samuki.clicker.base

import java.math.BigInteger
import java.text.DecimalFormat


class BasicMethods {
    companion object {
        private val abbreviation: Array<String> = arrayOf( "",
                " a", " b", " c", " d", " e", " f", " g", " h", " i", " j", " k", " l", " m", " n", " o", " p", " q", " r", " s", " t", " u", " v", " w", " x", " y", " z",
                " A", " B", " C", " D", " E", " F", " G", " H", " I", " J", " K", " L", " M", " N", " O", " P", " Q", " R", " S", " T", " U", " V", " W", " X", " Y", " Z"
        )
        private val numbersBeforeShortening = Constants.numbers.numbers_before_shortening
        private val df: DecimalFormat = DecimalFormat("#.##")
        fun shortenNumber(number: String): String {
            var newNumber = number
            val index = ((newNumber.length - (newNumber.length % (numbersBeforeShortening + 1))) / (numbersBeforeShortening + 1))
            val cutFrom = newNumber.length - (numbersBeforeShortening * index)
            var decimalPart = ""
            if (index > 0)
                decimalPart = "." + newNumber.substring(cutFrom, cutFrom + 2)
            newNumber = newNumber.removeRange(cutFrom, newNumber.length)
            newNumber += decimalPart + abbreviation[index]
            return newNumber
        }

        fun shortenNumberWithAbbreviation(number: Double, abbreviationText: String): String {
            var newNumber = df.format(number).replace(",", ".")
            var decimalPart = ""
            if (newNumber.contains(".")) {
                decimalPart = newNumber.substring(newNumber.indexOf("."))
                newNumber = newNumber.substring(0, newNumber.indexOf("."))
            }
            val index = ((newNumber.length - (newNumber.length % (numbersBeforeShortening + 1))) / (numbersBeforeShortening + 1))
            val cutFrom = newNumber.length - (numbersBeforeShortening * index)
            if (index > 0)
                decimalPart = "." + newNumber.substring(cutFrom, cutFrom + 2)
            newNumber = newNumber.removeRange(cutFrom, newNumber.length)
            newNumber += decimalPart + abbreviation[index + abbreviation.indexOf(abbreviationText)]
            return newNumber
        }

        fun compareAmountWithPrice(amount: BigInteger, priceString: String): Boolean {
            var amountString = shortenNumber(amount.toString())
            var amountAbbreviation = ""
            if (amountString.contains(" ")) {
                amountAbbreviation = amountString.substring(amountString.indexOf(" ", 0, true), amountString.length)
                amountString = amountString.replace(amountAbbreviation, "")
            }
            val amountIndex = abbreviation.indexOf(amountAbbreviation)

            var priceStringTMP = priceString
            var priceAbbreviation = ""
            if (priceString.contains(" ")) {
                priceAbbreviation = priceString.substring(priceString.indexOf(" ", 0, true), priceString.length)
                priceStringTMP = priceString.replace(priceAbbreviation, "")
            }
            val priceIndex = abbreviation.indexOf(priceAbbreviation)

            if (amountIndex == priceIndex) {
                return amountString.toDouble() >= priceStringTMP.toDouble()
            } else {
                return amountIndex > priceIndex
            }
        }

        fun addZerosToString(string: String): String {
            var stringAfterDot = ""
            var stringToReturn = ""
            var stringAbbreviation = ""

            if (string.contains(".")) {
                stringAfterDot = string.substring(string.indexOf(".") + 1)
                stringToReturn = string.substring(0, string.indexOf("."))
            } else {
                stringToReturn = string
            }

            if (string.contains(" ") && !stringAfterDot.isEmpty()) {
                stringAbbreviation = string.substring(string.indexOf(" ", 0, true), string.length)
                stringAfterDot = stringAfterDot.replace(stringAbbreviation, "")
            } else if (string.contains(" ")) {
                stringAbbreviation = string.substring(string.indexOf(" ", 0, true), string.length)
                stringToReturn = stringToReturn.replace(stringAbbreviation, "")
            }
            val index = abbreviation.indexOf(stringAbbreviation)
            val addMoreZeros = numbersBeforeShortening - stringAfterDot.length

            if (index == 1) {
                stringToReturn += stringAfterDot + "0".repeat(addMoreZeros)
            } else if (index > 1) {
                stringToReturn += "0".repeat((index - 1) * numbersBeforeShortening) + stringAfterDot + "0".repeat(addMoreZeros)
            }

            return stringToReturn
        }
    }
}