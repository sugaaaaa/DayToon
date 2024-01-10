package kh.edu.rupp.ite.daytoon.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LibraryViewModel : ViewModel() {

    private val _table1Visibility = MutableLiveData<Boolean>(true)
    val table1Visibility: LiveData<Boolean>
        get() = _table1Visibility

    private val _goodbyeVisibility = MutableLiveData<Boolean>(false)
    val goodbyeVisibility: LiveData<Boolean>
        get() = _goodbyeVisibility

    fun onComicsClick() {
        _table1Visibility.value = true
        _goodbyeVisibility.value = false
    }

    fun onNovelsClick() {
        _table1Visibility.value = false
        _goodbyeVisibility.value = true
    }
}
