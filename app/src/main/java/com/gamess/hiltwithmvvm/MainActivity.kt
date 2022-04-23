package com.gamess.hiltwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.gamess.hiltwithmvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val mFourSquareModel:FourSquareViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getData()
    }

    private fun getData() {
        mFourSquareModel.callForData()
        mFourSquareModel.mFourSquareData.observe(this) {
            if (it != null) {
                if (it.results.size > 0) {
                    for(i in it.results){
                        Log.d("TAG", "getData: "+i.name+","+i.timezone)
                    }
                }
            }
        }
    }
}