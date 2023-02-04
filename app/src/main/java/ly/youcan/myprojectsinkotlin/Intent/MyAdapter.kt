package ly.youcan.myprojectsinkotlin.Intent

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.snackbar.Snackbar
import ly.youcan.myprojectsinkotlin.Intent.Model.Brand
import ly.youcan.myprojectsinkotlin.R

class CoustemAdapter(val context: Context,val names:ArrayList<Brand>):RecyclerView.Adapter<CoustemAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View): ViewHolder(itemView){
        val txtView = itemView.findViewById(R.id.textView) as TextView
        val txtView2 = itemView.findViewById(R.id.textView2) as TextView
        val imgView = itemView.findViewById(R.id.imageView2) as ImageView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val listviewitem = LayoutInflater.from(parent.context).inflate( R.layout.listnewsitem,parent,false)

        return MyViewHolder(listviewitem)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val name = names[position]
        holder.txtView.text = name.name
        holder.txtView2.text = name.dic
        holder.imgView.setImageResource(name.img)

        holder.imgView.setOnClickListener(){
            Snackbar.make(it,"name: ${name.name}\ndic: ${name.dic}", Snackbar.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener(){
            val i = Intent(context, IntentRecepionActivity::class.java)
            i.putExtra("name",name.name)
            i.putExtra("dic",name.dic)
            i.putExtra("img",name.img)
            context.startActivity(i)
        }

    }




}





