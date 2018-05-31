package test.com.testapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import test.com.testapp.dto.ParkInOutCar
import test.com.testapp.R

class CustomAdapter(private val inOutCar: ArrayList<ParkInOutCar>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.carNo?.text = inOutCar[position].incarno1
    }

    override fun getItemCount(): Int {
        return inOutCar.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carNo = itemView.findViewById<TextView>(R.id.carno)!!
    }


}