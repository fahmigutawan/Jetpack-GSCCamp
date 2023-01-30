package com.gdscub.gsccamp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class JournalingViewModel:ViewModel() {
    val inputValue = mutableStateOf("")
}