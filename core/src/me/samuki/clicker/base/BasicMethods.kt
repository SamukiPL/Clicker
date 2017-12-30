package me.samuki.clicker.base

import java.math.BigInteger


class BasicMethods {
    companion object {
        private val abbreviation: Array<String> = arrayOf( "",
                " a", " b", " c", " d", " e", " f", " g", " h", " i", " j", " k", " l", " m", " n", " o", " p", " q", " r", " s", " t", " u", " v", " w", " x", " y", " z",
                " A", " B", " C", " D", " E", " F", " G", " H", " I", " J", " K", " L", " M", " N", " O", " P", " Q", " R", " S", " T", " U", " V", " W", " X", " Y", " Z"
        )
        fun shortenNumber(number: String): String {
            var newNumber = number
            var index = ((newNumber.length - (newNumber.length % 6)) / 6)
            newNumber = newNumber.removeRange(newNumber.length - (5 * index), newNumber.length)
            newNumber += abbreviation[index]
            return newNumber
        }

        fun shortenNumberWithAbbreviation(number: Long, abbreviationText: String): String {
            var newNumber = number.toString()
            var index = ((newNumber.length - (newNumber.length % 6)) / 6)
            newNumber = newNumber.removeRange(newNumber.length - (5 * index), newNumber.length)
            newNumber += abbreviation[index + abbreviation.indexOf(abbreviationText)]
            return newNumber
        }

        fun compareAmountWithPrice(amount: BigInteger, priceString: String): Boolean {
            var amountString = shortenNumber(amount.toString())
            var amountAbbreviation = ""
            if (amountString.contains(" ")) {
                amountAbbreviation = amountString.substring(amountString.indexOf(" ", 0, true), amountString.length)
                amountString = amountString.removeRange(priceString.indexOf(" ", 0, true), amountString.length)
            }
            val amountIndex = abbreviation.indexOf(amountAbbreviation)

            var priceStringTMP = priceString
            var priceAbbreviation = ""
            if (priceString.contains(" ")) {
                priceAbbreviation = priceString.substring(priceString.indexOf(" ", 0, true), priceString.length)
                priceStringTMP = priceString.removeRange(priceString.indexOf(" ", 0, true), priceString.length)
            }
            val priceIndex = abbreviation.indexOf(priceAbbreviation)

            if (amountIndex == priceIndex) {
                return amountString.toLong() >= priceStringTMP.toLong()
            } else {
                return amountIndex > priceIndex
            }
        }

        fun addZerosToString(string: String): String {
            var stringToReturn = string
            var stringAbbreviation = ""
            if (string.contains(" ")) {
                stringAbbreviation = string.substring(string.indexOf(" ", 0, true), string.length)
            }
            var index = abbreviation.indexOf(stringAbbreviation)
            while (index > 0) {
                stringToReturn += "00000"
                index--
            }
            return stringToReturn
        }
    }
}