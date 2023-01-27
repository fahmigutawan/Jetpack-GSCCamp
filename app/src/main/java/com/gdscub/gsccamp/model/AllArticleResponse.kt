package com.gdscub.gsccamp.model

data class AllArticleResponse(
    val meta:MetaResponse,
    val data:List<ArticleModel>
)