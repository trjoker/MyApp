package com.example.myapp.ui.helper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Ryan on 23/04/2019.
 */
public class MyItemToucherHelperCallback extends ItemTouchHelper.Callback {
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView,
                                @NonNull RecyclerView.ViewHolder viewHolder) {
        // 如果你不想上下拖动，可以将 dragFlags = 0
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;

        // 如果你不想左右滑动，可以将 swipeFlags = 0
        int swipeFlags = ItemTouchHelper.LEFT;

        //最终的动作标识（flags）必须要用makeMovementFlags()方法生成
        int flags = makeMovementFlags(dragFlags, swipeFlags);
        return flags;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView,
                          @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }

//    @Override
//    public boolean isLongPressDragEnabled() {
//        return true;
//    }
}
