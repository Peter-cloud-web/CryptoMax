package com.example.cryptomax.dtoModel.mapper

import com.example.cryptomax.dtoModel.CoinDto
import com.example.cryptomax.models.coinListModel.Coin


object Mappers {
    fun CoinDto.toCoin(model: CoinDto): Coin {
        return Coin(
            id = model.id,
            marketCapUsd = model.marketCapUsd,
            maxSupply = model.maxSupply,
            name = model.name,
            priceUsd = model.priceUsd,
            supply = model.supply,
            symbol = model.symbol,
        )
    }
}