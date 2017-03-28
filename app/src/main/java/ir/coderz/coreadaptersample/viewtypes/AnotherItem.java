package ir.coderz.coreadaptersample.viewtypes;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import ir.coderz.coreadapter.BindItem;
import ir.coderz.coreadapter.CoreItem;
import ir.coderz.coreadaptersample.AnotherModel;
import ir.coderz.coreadaptersample.R;

/**
 * Created by sajad on 6/30/16.
 */
@BindItem(LAYOUT = R.layout.another_layout, VIEW_HOLDER = AnotherHolder.class, MODEL = AnotherModel.class)
public class AnotherItem implements CoreItem{
    AnotherModel anotherModel;
    OnItemClickListener onItemClickListener;

    public AnotherItem(AnotherModel anotherModel) {
        this.anotherModel = anotherModel;
    }

    @Override
    public void bind(RecyclerView.ViewHolder rviewHolder) {
        AnotherHolder viewHolder = (AnotherHolder) rviewHolder;
        viewHolder.getText().setText(anotherModel.getText());
        viewHolder.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.itemClick(v, getData());
                }
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.another_layout;
    }

    @Override
    public AnotherModel getData() {
        return anotherModel;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {

        void itemClick(View v, AnotherModel data);
    }
}
