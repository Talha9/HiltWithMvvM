package com.gamess.hiltwithmvvm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.gamess.hiltwithmvvm.models.ApiModel
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class FourSquareRepository @Inject constructor(@ApplicationContext mContext: Context, @Named("retrofitServiceFourSquare") val retrofitServiceFourSquare:ApiInterface) {
val mFourSquareLiveData=MutableLiveData<ApiModel>()



    fun getFourSquareData(){
        val result = retrofitServiceFourSquare.getPlaces(
            ("33.1234" + "," + "74.1234"),
            "RQ4WXX2HRDY3I0SQ5URFUZ4YHWX1HH101PGTXAND4ALXSI1B ",
            "HJ5GJAJNMHHIH241JZPUWRUCOMFPTUR1VSWU01EVX1IFOXPJ",
            "20210422",
            10000,
            "13065",
            50,
            "fsq3cveWs0hjI9jlXryA+zOj0fbVgvoorWX8mFqJCejj2Ig="
        )
        result.enqueue(object : Callback<ApiModel> {
            override fun onResponse(
                call: Call<ApiModel>,
                response: Response<ApiModel>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.results != null && response.body()!!.results.size > 0) {
                        mFourSquareLiveData.value=response.body()
                    }
                }
            }

            override fun onFailure(call: Call<ApiModel>, t: Throwable) {

            }

        })

    }
}