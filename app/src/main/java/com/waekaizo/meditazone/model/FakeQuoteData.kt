package com.waekaizo.meditazone.model

import com.waekaizo.meditazone.data.response.QuoteItem

object FakeQuoteData {
    val quotes = listOf(
        QuoteItem(
            quoteID = 1,
            quote = "Kamu bukan penyakitmu. Kamu memiliki kisah tersendiri untuk diceritakan. Kamu memiliki nama, sejarah, kepribadian. Menjadi diri sendiri adalah bagian dari pertempuran",
            author = "Julian Seifter",
            imageUrl = "https://ibb.co/zZW9gyc"
        ),
        QuoteItem(
            quoteID = 2,
            quote = "Kedamaian batin dimulai saat kamu memilih untuk tidak membiarkan orang atau peristiwa lain mengendalikan emosimu",
            author = "Pena Chordon",
            imageUrl = "https://ibb.co/zZW9gyc"
        ),
        QuoteItem(
            quoteID = 3,
            quote = "Kita hidup di dunia dimana mengakui sesuatu yang negatif tentang diri sendiri dipandang sebagai kelamahan, walau sebenarnya itu kekuatan. Bukan hal yang lemah untuk mengatakan, 'Saya butuh bantuan'",
            author = "Jon Hamm",
            imageUrl = "https://ibb.co/zZW9gyc"
        ),
        QuoteItem(
            quoteID = 4,
            quote = "Kamu tidak dapat mengontrol semuanya. Terkadang kamu hanya perlu rileks dan yakin bahwa segala sesuatunya akan berhasil. Lepaskan sedikit dan biarkan hidup berjalan selayaknya air mengalir",
            author = "Kody Keplinger",
            imageUrl = "https://ibb.co/zZW9gyc"
        ),
    )
}