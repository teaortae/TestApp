package test.com.testapp.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.com.testapp.adapter.CustomAdapter
import test.com.testapp.dto.ParkInOutCar
import test.com.testapp.R

class MainActivity : AppCompatActivity(), Callback<ArrayList<ParkInOutCar>> {
    private val TAG: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView!!.layoutManager = LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false)
        ApiClient.apiservice.getInOutCar().enqueue(this)
    }

    override fun onFailure(call: Call<ArrayList<ParkInOutCar>>?, t: Throwable?) {
        Log.d(TAG, t?.message)
    }

    override fun onResponse(call: Call<ArrayList<ParkInOutCar>>?, response: Response<ArrayList<ParkInOutCar>>?) {
        Log.d(TAG, response?.body()?.get(0)!!.incarno1)
        var customAdapter= CustomAdapter(response?.body()!!)
        recyclerView.adapter = customAdapter
    }
}
