package ir.coderz.coreadaptersample.viewtypes;

import ir.coderz.coreadapter.CoreItem;
import ir.coderz.coreadaptersample.R;

/**
 * Created by sajad on 6/30/16.
 */
public class TextItem implements CoreItem<TextHolder, String> {
    private TextHolder textHolder;

    @Override
    public void bind(TextHolder textHolder) {
        this.textHolder = textHolder;
        this.textHolder.getTextView().setText(textHolder.getAdapterPosition() + "");
    }

    @Override
    public int getLayout() {
        return R.layout.text_item;
    }

    @Override
    public String getData() {
        return textHolder.getAdapterPosition() + "";
    }


}
