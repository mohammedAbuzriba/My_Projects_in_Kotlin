package ly.youcan.myprojectsinkotlin.RecyclerView

import ly.youcan.myprojectsinkotlin.R
import android.content.Context
import android.graphics.Canvas
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator


abstract class SwipeGesture(context: Context):ItemTouchHelper.SimpleCallback(
    ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END
    ,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    val deletecolor = ContextCompat.getColor(context,R.color.delete_color)
    val addcolor = ContextCompat.getColor(context,R.color.add_color)
    val deleteIcon = R.drawable.baseline_delete_24
    val addIcon = R.drawable.baseline_archive_24




    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {


        RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            .addSwipeLeftBackgroundColor(deletecolor)
            .addSwipeLeftActionIcon(deleteIcon)
            .addSwipeRightBackgroundColor(addcolor)
            .addSwipeRightActionIcon(addIcon)
            .create()
            .decorate()


        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

}