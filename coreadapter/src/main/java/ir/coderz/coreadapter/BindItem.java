package ir.coderz.coreadapter;

import android.support.annotation.LayoutRes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by sajad on 12/2/16.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface BindItem {
    @LayoutRes
    int LAYOUT();

    Class VIEW_HOLDER();

    Class MODEL();
}
