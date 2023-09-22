package com.example.cryptomax.common.util

object ConvertCoins {
    fun formatShortValue(value: Double): String {
        val suffix = charArrayOf(' ', 'K', 'M', 'B', 'T')
        var newValue = value
        var i = 0

        while (newValue >= 1000 && i < suffix.size - 1) {
            newValue /= 1000
            i++
        }

        return "%.2f%s".format(newValue, suffix[i])
    }
}