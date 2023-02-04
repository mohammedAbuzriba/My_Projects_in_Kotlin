package ly.youcan.myprojectsinkotlin.Intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import ly.youcan.myprojectsinkotlin.R

class IntentActivity : AppCompatActivity() {
    private lateinit var editName:EditText
    private lateinit var editDic:EditText
    private lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        initui()
        btn.setOnClickListener(){
            val name = editName.text.toString()
            val dic = editDic.text.toString()
            val i = Intent(this,IntentRecepionActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("dic",dic)
            startActivity(i)

        }
    }

    private fun initui() {
        editName = findViewById(R.id.editTextTextPersonName)
        editDic = findViewById(R.id.editTextTextPersonName3)
        btn = findViewById(R.id.button)

    }
}