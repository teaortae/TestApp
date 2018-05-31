package retrofit

import retrofit2.Call
import retrofit2.http.GET
import test.com.testapp.dto.ParkInOutCar

interface ApiService {
    @GET("inOutCarList")
    fun getInOutCar(): Call<ArrayList<ParkInOutCar>>
}