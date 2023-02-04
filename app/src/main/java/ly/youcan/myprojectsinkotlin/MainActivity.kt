package ly.youcan.myprojectsinkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ly.youcan.myprojectsinkotlin.Intent.IntentActivity
import ly.youcan.myprojectsinkotlin.Intent.IntentRecepionActivity
import ly.youcan.myprojectsinkotlin.Intent.RecyclerViewListPrandActivity
import ly.youcan.myprojectsinkotlin.RecyclerView.MainRecyclerViewActivity
import ly.youcan.myprojectsinkotlin.RecyclerViewTwo.RecyclerViewTwoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, MainRecyclerViewActivity::class.java))
        //startActivity(Intent(this, RecyclerViewListPrandActivity::class.java))
        //startActivity(Intent(this, IntentActivity::class.java))

    }
}