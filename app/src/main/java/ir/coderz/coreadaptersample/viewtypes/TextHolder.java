package ir.coderz.coreadaptersample.viewtypes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ir.coderz.coreadaptersample.R;

/**
 * Created by sajad on 6/30/16.
 */
public class TextHolder extends RecyclerView.ViewHolder {

    private final TextView textView;

    public TextHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
    }

    public TextView getTextView() {
        return textView;
    }
}
