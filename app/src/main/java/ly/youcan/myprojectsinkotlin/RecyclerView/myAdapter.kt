package ly.youcan.myprojectsinkotlin.RecyclerView

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import ly.youcan.myprojectsinkotlin.R
import ly.youcan.myprojectsinkotlin.RecyclerView.model.News

class MyAdapter(private val newsList:ArrayList<News>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener:onItemClickListener){
        mListener=listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteItem(i:Int){
        newsList.removeAt(i)
        notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun addItem(i:Int, news:News){
        newsList.add(i,news)
        notifyDataSetChanged()
    }



    inner class MyViewHolder(itemview:View,listener: onItemClickListener):RecyclerView.ViewHolder(itemview){
        val titleImage=itemview.findViewById<ShapeableImageView>(R.id.title_image)
        val tvHeading=itemview.findViewById<TextView>(R.id.tvHeading)
        val briefnews=itemview.findViewById<TextView>(R.id.briefnews)
        val constraintlayout=itemview.findViewById<ConstraintLayout>(R.id.expanded_layout)

        init {
            itemview.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview=LayoutInflater.from(parent.context)
            .inflate(R.layout.listnewsitem,parent,false)

        return MyViewHolder(itemview,mListener)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.titleImage.setImageResource(currentItem.title_image)
        holder.tvHeading.text=currentItem.heading
        holder.briefnews.text=currentItem.body

        val isVisible:Boolean=currentItem.visibility

        holder.constraintlayout.visibility = if(isVisible) View.VISIBLE else View.GONE
        holder.tvHeading.setOnClickListener {
            currentItem.visibility=!currentItem.visibility
            notifyItemChanged(position)
        }

    }

}