package com.adit.simpleimagegrid.recyclerview

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.adit.simpleimagegrid.R
import com.adit.simpleimagegrid.databinding.ImageBinding
import com.adit.simpleimagegrid.recyclerview.listener.ClickListener
import com.adit.simpleimagegrid.recyclerview.model.ImageModel

class CustomAdapter(val image:List<ImageModel>):RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_image, parent, false)

        val layoutInflater = LayoutInflater.from(parent?.context)
        val imageBinding = ImageBinding.inflate(layoutInflater, parent, false)

        imageBinding.presenter = (object:ClickListener{
            override fun onClickListener() {
                Log.d("Click me", "Click me")
                Toast.makeText(parent.context,""+imageBinding.imageData.toString(),Toast.LENGTH_LONG).show()
            }

        })

        return ViewHolder(imageBinding)
    }

    override fun getItemCount(): Int {
        return image.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        if (!image[position].path.isNullOrEmpty())
//            Picasso.get().load(image[position].path).into(holder.imgHolder)

        val imgModel = image.get(position)
        holder.bind(imgModel)

    }

    class ViewHolder(imageBinding: ImageBinding) : RecyclerView.ViewHolder(imageBinding.root) {
        //val imgHolder = itemView.findViewById<ImageView>(R.id.rv_image)

        var imgBinding: ImageBinding

        init {
            imgBinding = imageBinding
        }

        fun bind(imageModel: ImageModel){
            imgBinding.imageData = imageModel
        }

        fun getImageBinding():ImageBinding{
            return imgBinding
        }
    }

}