package ly.youcan.myprojectsinkotlin.RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ly.youcan.myprojectsinkotlin.R

class ItemInfoActivity : AppCompatActivity() {
    private lateinit var title: TextView
    private lateinit var body: TextView
    private lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_info)

        initUi()
        val bundle:Bundle?=intent.extras
        title.text=bundle!!.getString("heading")
        body.text=bundle.getString("body")
        image.setImageResource(bundle.getInt("title_image"))

        image.setOnLongClickListener{
            Toast.makeText(this, "Long click detected", Toast.LENGTH_SHORT).show()

            true
        }


    }

    private fun initUi() {
        title=findViewById(R.id.title)
        image=findViewById(R.id.image)
        body=findViewById(R.id.body)


    }
}