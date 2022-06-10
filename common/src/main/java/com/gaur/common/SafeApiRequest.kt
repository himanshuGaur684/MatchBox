package com.gaur.common

import com.google.android.gms.common.api.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.Exception
import java.lang.StringBuilder

abstract class SafeApiRequest {

    suspend  fun <T:Any> safeApiRequest(call: suspend ()->Response<T>): T {

        val response = call.invoke()

        if(response.isSuccessful){
            return response.body()!!
        }else{

            val errorMsg = response.errorBody()?.string()
            val message = StringBuilder()

            errorMsg?.let {
                try{
                    val msg = JSONObject(errorMsg).get("error")
                    message.append(msg)
                }catch (e:JSONException){

                }
            }
            throw ApiException(message = message.toString())

        }


    }


}