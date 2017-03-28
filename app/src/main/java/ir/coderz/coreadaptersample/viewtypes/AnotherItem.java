package ir.coderz.coreadaptersample.viewtypes;

import android.view.View;

import ir.coderz.coreadapter.Binder;
import ir.coderz.coreadapter.BindItem;
import ir.coderz.coreadaptersample.AnotherModel;
import ir.coderz.coreadaptersample.R;

/**
 * Created by sajad on 6/30/16.
 */
@BindItem(layout = R.layout.another_layout, holder = AnotherHolder.class)
public class AnotherItem {
    AnotherModel anotherModel;
    OnItemClickListener onItemClickListener;

    public AnotherItem(AnotherModel anotherModel) {
        this.anotherModel = anotherModel;
    }

    @Binder
    public void bind(AnotherHolder viewHolder) {
        viewHolder.getText().setText(anotherModel.getText() + " " + anotherModel.getMessage());
        viewHolder.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.itemClick(v, getData());
                }
            }
        });
    }
//
//    @Override
//    public int getLayout() {
//        return R.layout.another_layout;
//    }

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
