package com.gdscub.gsccamp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdscub.gsccamp.data.Resource
import com.gdscub.gsccamp.data.repository.Repository
import com.gdscub.gsccamp.model.ArticleByIdResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch

class ArticleDetailViewModel : ViewModel() {
    private val repository = Repository()

    val articleById = MutableStateFlow<Resource<ArticleByIdResponse>>(Resource.Loading())

    fun getArticleById(id: String) {
        viewModelScope.launch(
            context = Dispatchers.Default,
            block = {
                repository.getArticleById(id).collect {
                    articleById.value = it
                }
            }
        )
    }
}