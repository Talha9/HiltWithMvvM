package com.gamess.hiltwithmvvm

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FourSquareViewModel @Inject constructor(private val mFourSquareRepository: FourSquareRepository):ViewModel(){
    var mFourSquareData=mFourSquareRepository.mFourSquareLiveData

    fun callForData(){
        mFourSquareRepository.getFourSquareData()
    }


}