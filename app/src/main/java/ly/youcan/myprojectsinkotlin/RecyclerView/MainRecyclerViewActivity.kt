package ly.youcan.myprojectsinkotlin.RecyclerView

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ly.youcan.myprojectsinkotlin.R
import ly.youcan.myprojectsinkotlin.RecyclerView.model.News
import java.util.*
import kotlin.collections.ArrayList

class MainRecyclerViewActivity : AppCompatActivity() {
    private lateinit var myRecyclerView:RecyclerView
    private lateinit var shimmer_view_container:ShimmerFrameLayout
    private lateinit var swiperefresh:SwipeRefreshLayout
    private var newsArrayList= ArrayList<News>()
    private var tempArrayList= ArrayList<News>()
    private lateinit var myadapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_recycler_view)

        shimmer_view_container=findViewById(R.id.shimmer_view_container)
        shimmer_view_container.startShimmer()

        initnewsArrayList()
        initUi()

        val thread = GlobalScope.launch (Dispatchers.Main) {
            delay(2000)
            myRecyclerView.visibility= View.VISIBLE
            shimmer_view_container.visibility= View.GONE

        }



//        myRecyclerView.visibility= View.VISIBLE
//        shimmer_view_container.visibility= View.GONE
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_item,menu)
        val item=menu?.findItem(R.id.search_action)
        val searchView=item?.actionView as SearchView
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String?): Boolean {

                tempArrayList.clear()
                val searchText=newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    newsArrayList.forEach(){
                        if(it.heading.toLowerCase(Locale.getDefault()).contains(searchText) ){
                            tempArrayList.add(it)
                        }
                    }

                    myRecyclerView.adapter!!.notifyDataSetChanged()

                }else{
                    tempArrayList.clear()
                    tempArrayList.addAll(newsArrayList)
                    myRecyclerView.adapter!!.notifyDataSetChanged()
                }


                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }


    private fun initnewsArrayList() {
        newsArrayList.add(News(R.drawable.imagea,"mohamed Ahmed MyViewHolder newsArrayList","MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList"))
        newsArrayList.add(News(R.drawable.imageb,"ali newsArrayList MyViewHolder"," newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder "))
        newsArrayList.add(News(R.drawable.imagec,"Ali cheading heading newsArrayList","MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList heading heading newsArrayList"))
        newsArrayList.add(News(R.drawable.imaged,"sara newsArrayList  newsArrayList"," MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList"))
        newsArrayList.add(News(R.drawable.imagea,"Sara ali MyViewHolder newsArrayList","MyViewHolder newsArrayList MyViewHolder new newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList"))
        newsArrayList.add(News(R.drawable.imageb,"Ahmed mohamed newsArrayList MyViewHolder"," MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList"))
        newsArrayList.add(News(R.drawable.imagec,"Mohamed ahmedheading heading newsArrayList","MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList"))
        newsArrayList.add(News(R.drawable.imaged,
                "newsArrayList  newsArrayList newsArrayList  newsArrayList ",
                  " MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder" +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " MyViewHolder newsArrayList newsArrayList  newsArrayList"
            )
        )

        newsArrayList.add(News(R.drawable.imaged,
                "newsArrayList  newsArrayList newsArrayList  newsArrayList",
                " MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder" +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList My ViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder news ArrayList MyView Holder news ArrayList MyView Holder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList My ViewHolder news ArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder news ArrayList MyView Holder newsA rrayList MyViewH older newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList My ViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArray List MyViewHolder newsArray List MyViewHolder newsArrayList MyView Holder newsArrayList " +
                        " newsArrayList MyView Holder newsArrayList MyViewHolder news ArrayList MyView Holder newsArrayList " +
                        " news ArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyView Holder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyVie wHolder newsArr ayList MyView Holder new sArrayList MyViewH older newsArrayList " +
                        " newsArray List My ViewHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList MyView Holder newsArray List MyView Holder newsArrayList MyViewHolder newsArrayList " +
                        " news ArrayList MyVie wHolder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList My ViewHolder news ArrayList MyViewHolder newsArra yList MyView Holder newsArrayList " +
                        " newsArrayList MyView Holder newsArrayList MyViewHolder newsArrayList MyViewHolder newsArrayList " +
                        " newsArrayList My ViewHolder news ArrayList MyViewHolder newsArrayList MyViewH older newsArrayList " +
                        " newsArrayList MyViewHolder newsArrayList MyView Holder newsArrayList MyViewHolder newsArrayList " +
                        " MyViewHolder newsArray List newsArrayList  newsA rrayList"
            )
        )


//        newsArrayList.sortBy {
//            it.heading
//        }
        tempArrayList.addAll(newsArrayList)
        //tempArrayList.clear()


    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initUi() {

        myRecyclerView=findViewById(R.id.recyclerview)
        swiperefresh=findViewById(R.id.swiperefresh)
        swiperefresh.setOnRefreshListener {
            shimmer_view_container.visibility= View.VISIBLE
            GlobalScope.launch (Dispatchers.Main) {
                delay(2000)
                myRecyclerView.visibility= View.VISIBLE
                tempArrayList.addAll(newsArrayList)
                myRecyclerView.adapter!!.notifyDataSetChanged()
                swiperefresh.isRefreshing=false
                shimmer_view_container.visibility= View.GONE

            }
            tempArrayList.clear()
            myRecyclerView.visibility= View.GONE


        }

        myRecyclerView.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        myRecyclerView.setHasFixedSize(true)
        myadapter= MyAdapter(tempArrayList)


        val swipegesture =object :SwipeGesture(this){
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {

                val from_pos= viewHolder.absoluteAdapterPosition
                val to_pos = target.absoluteAdapterPosition

                Collections.swap(tempArrayList,from_pos,to_pos)

                myadapter.notifyItemMoved(from_pos,to_pos)
                myadapter.notifyDataSetChanged()
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                when(direction){
                    ItemTouchHelper.LEFT->{
                        myadapter.deleteItem(viewHolder.absoluteAdapterPosition)
                    }
                    ItemTouchHelper.RIGHT->{
                        val archiveItem=tempArrayList[viewHolder.absoluteAdapterPosition]
                        myadapter.deleteItem(viewHolder.absoluteAdapterPosition)
                        myadapter.addItem(tempArrayList.size,archiveItem)
                    }
                }

                //super.onSwiped(viewHolder, direction)
            }
        }

        val touchHelper=ItemTouchHelper(swipegesture)
        touchHelper.attachToRecyclerView(myRecyclerView)

        myRecyclerView.adapter=myadapter

        myadapter.setOnItemClickListener(object :MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@MainRecyclerViewActivity,"${newsArrayList[position].heading}",Toast.LENGTH_SHORT).show()
                val intent=Intent(this@MainRecyclerViewActivity,ItemInfoActivity::class.java)

                intent.putExtra("title_image",tempArrayList[position].title_image)
                intent.putExtra("heading",tempArrayList[position].heading)
                intent.putExtra("body",tempArrayList[position].body)
                startActivity(intent)
            }

        })




    }
}




