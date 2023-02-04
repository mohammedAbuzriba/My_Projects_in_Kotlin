package ly.youcan.myprojectsinkotlin.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ly.youcan.myprojectsinkotlin.R

class IntentRecepionActivity : AppCompatActivity() {
    private lateinit var textName:TextView
    private lateinit var textDic:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_recepion)

        initUi()
        textName.text = intent.getStringExtra("name")
        textDic.text = intent.getStringExtra("dic")
    }

    private fun initUi() {
        textName = findViewById(R.id.textView)
        textDic = findViewById(R.id.textView2)

    }
}