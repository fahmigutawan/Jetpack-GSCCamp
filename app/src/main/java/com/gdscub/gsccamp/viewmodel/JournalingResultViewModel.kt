package com.gdscub.gsccamp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdscub.gsccamp.data.Resource
import com.gdscub.gsccamp.data.repository.Repository
import com.gdscub.gsccamp.model.JournalingResultResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class JournalingResultViewModel : ViewModel() {
    private val respository = Repository()

    val depressionPrediction =
        MutableStateFlow<Resource<JournalingResultResponse>>(Resource.Loading())

    fun getDepressionPrediction(message: String) {
        viewModelScope.launch(
            context = Dispatchers.IO,
            block = {
                respository.predictDepression(message).collect{
                    depressionPrediction.value = it
                }
            }
        )
    }
}