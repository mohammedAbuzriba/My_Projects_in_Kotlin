package ly.youcan.myprojectsinkotlin.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ly.youcan.myprojectsinkotlin.Intent.Model.Brand
import ly.youcan.myprojectsinkotlin.R

class RecyclerViewListPrandActivity : AppCompatActivity() {

    private lateinit var recyclerview :RecyclerView
    var arraybrand=ArrayList<Brand>()
    private lateinit var myadapter: CoustemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_list_prand)

        init()

    }


    fun init(){

        arraybrand.add(Brand("zara","zara dic",R.drawable.ic_launcher_background))
        arraybrand.add(Brand("iphon","iphon dic",R.drawable.ic_launcher_background))
        arraybrand.add(Brand("hp","hp dic",R.drawable.ic_launcher_background))
        arraybrand.add(Brand("zara","zara dic",R.drawable.ic_launcher_background))
        arraybrand.add(Brand("iphon","iphon dic",R.drawable.ic_launcher_background))
        arraybrand.add(Brand("hp","hp dic",R.drawable.ic_launcher_background))
        arraybrand.add(Brand("samsung","samsung dic",R.drawable.ic_launcher_background))


        recyclerview = findViewById(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        myadapter=CoustemAdapter(this,arraybrand)
        recyclerview.adapter=myadapter

    }
}