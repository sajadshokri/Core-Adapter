package ir.coderz.coreadaptersample.viewtypes;

import ir.coderz.coreadapter.Binder;
import ir.coderz.coreadapter.BindItem;
import ir.coderz.coreadaptersample.R;

/**
 * Created by sajad on 6/30/16.
 */
@BindItem(layout = R.layout.text_item, holder = TextHolder.class)
public class TextItem {
    private TextHolder textHolder;

    @Binder
    public void bind(TextHolder textHolder) {
        this.textHolder = textHolder;
        this.textHolder.getTextView().setText(textHolder.getAdapterPosition() + "");
    }
//
//    @Override
//    public int getLayout() {
//        return R.layout.text_item;
//    }

    public String getData() {
        return textHolder.getAdapterPosition() + "";
    }


}
