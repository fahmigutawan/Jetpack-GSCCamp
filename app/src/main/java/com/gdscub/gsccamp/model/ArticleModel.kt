package com.gdscub.gsccamp.model

data class ArticleModel(
    val ID:Int,
    val CreatedAt:String?,
    val UpdatedAt:String?,
    val DeletedAt:String?,
    val Title:String,
    val Body:String,
    val ImageUrl:String,
    val CreatedBy:String
)
