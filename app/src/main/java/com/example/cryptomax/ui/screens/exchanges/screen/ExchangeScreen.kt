package com.example.cryptomax.ui.screens.exchanges.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptomax.models.nfts.Nft
import com.example.cryptomax.ui.component.homeScreenComponents.ProgressBar
import com.example.cryptomax.ui.nft.EmbeddedSearchBar
import com.example.cryptomax.ui.nft.NftsItem
import com.example.viewModel.NftViewModel

@Composable
fun ExchangeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 10.dp)
    ){
        Text(
            text = "NFT Marketplace",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )

        var isSearchActive by rememberSaveable { mutableStateOf(false) }

        Scaffold(
            modifier = modifier,
            topBar = {
                Column(
                    modifier = modifier.padding(top = 5.dp)
                ) {
                    EmbeddedSearchBar(
                        onQueryChange = true,
                        onSearch = {searchQuery ->
                            searchQuery
                        },
                        isSearchActive = isSearchActive) { boolean ->
                        isSearchActive = boolean }
                }
            },
        ) { contentPadding ->
            Modifier.padding(contentPadding)
        }
    }

    val nftViewModel: NftViewModel = hiltViewModel()
    val nfTsUiStates = nftViewModel.allNFTs.collectAsState()
    nfTsUiStates.value.let { states ->
        when {
            states.isLoading -> {
                ProgressBar()
            }

            states.success != null -> {
                states.success.nfts?.let { nfts ->
                    NftList(nfts = nfts)
                    NftList2(nfts = nfts)
                    NftList3(nfts = nfts)
                }
            }

            states.error != null -> "An unexpected error occurred"

            else -> {}
        }
    }

}

@Composable
fun NftList(
    nfts: List<Nft>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 140.dp)
    ) {

        Text(
            text = "Most Traded NFTs",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp)
        )

//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            horizontalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            items(nfts) { item ->
//                NftsItem(nft = item)
//            }
//        }
        LazyRow(contentPadding = PaddingValues(top = 10.dp)) {
            items(nfts) { item ->
                NftsItem(nft = item)
            }
        }
    }

}
@Composable
fun NftList2(
    nfts: List<Nft>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 320.dp)
    ) {

        Text(
            text = "Trending NFTs",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp, top = 8.dp)
        )

        LazyRow(contentPadding = PaddingValues(top = 10.dp)) {
            items(nfts) { item ->
                NftsItem(nft = item)
            }
        }
    }

}

@Composable
fun NftList3(
    nfts: List<Nft>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp,top = 500.dp)
    ) {

        Text(
            text = "Hot Collections",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp, top = 8.dp)
        )

        LazyRow(contentPadding = PaddingValues(top = 10.dp)) {
            items(nfts) { item ->
                NftsItem(nft = item)
            }
        }
    }

}


