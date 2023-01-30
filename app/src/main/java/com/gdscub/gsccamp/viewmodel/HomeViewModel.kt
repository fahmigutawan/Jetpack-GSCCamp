package com.gdscub.gsccamp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdscub.gsccamp.data.Resource
import com.gdscub.gsccamp.data.repository.Repository
import com.gdscub.gsccamp.model.AllArticleResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class HomeViewModel : ViewModel() {
    private val repository = Repository()

    val allArticle = MutableStateFlow<Resource<AllArticleResponse>>(Resource.Loading())

    fun getAllArticle() {
        viewModelScope.launch(
            context = Dispatchers.Default,
            block = {
                repository.getAllArticle().collect {
                    allArticle.value = it
                }
            }
        )
    }

    init {
        getAllArticle()
    }
}