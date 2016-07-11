package ir.coderz.coreadapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;

/**
 * Created by sajad on 6/30/16.
 */
public interface CoreItem<T extends RecyclerView.ViewHolder, E> {

    void bind(T viewHolder);

    @LayoutRes
    int getLayout();

    E getData();


}
