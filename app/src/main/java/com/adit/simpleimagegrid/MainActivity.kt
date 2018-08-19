package com.adit.simpleimagegrid

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.adit.simpleimagegrid.recyclerview.CustomAdapter
import com.adit.simpleimagegrid.recyclerview.model.ImageModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this, 3)
        val images = ArrayList<ImageModel>()
        for (i in 1..6){
            images.add(ImageModel(i,getURLForResource(R.drawable.ic_add)))
        }
        recyclerView.adapter = CustomAdapter(images)

    }

    fun getURLForResource(resourceId: Int): String {
        return Uri.parse("android.resource://" + R::class.java.getPackage().name + "/" + resourceId).toString()
    }
}
