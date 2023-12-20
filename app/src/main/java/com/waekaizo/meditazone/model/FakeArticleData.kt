package com.waekaizo.meditazone.model

import com.waekaizo.meditazone.data.response.ArticleItem

object FakeArticleData {
    val articles = listOf(
        ArticleItem(
            articleID = 1,
            title = "Apa itu meditasi ?",
            category = "General",
            thumbnail = "",
            author = "",
            articleUrl = ""
        ),
        ArticleItem(
            articleID = 2,
            title = "Tips Mengelola Stress",
            category = "Anxiety",
            thumbnail = "",
            author = "",
            articleUrl = ""
        ),
        ArticleItem(
            articleID = 3,
            title = "Efek dari Begadang Terus Menerus",
            category = "Depresi",
            thumbnail = "8 Minute",
            author = "Meditation",
            articleUrl = ""
        )
    )
}