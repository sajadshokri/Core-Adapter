package ir.coderz.coreadapter;

import android.support.annotation.IntRange;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sajad on 6/30/16.
 */
public class CoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<CoreItem> items = new ArrayList<>();
    HashMap<Integer, Class<? extends RecyclerView.ViewHolder>> viewTypes = new HashMap<>();
    private LayoutInflater layoutInflater;

    public CoreAdapter(final HashMap<Integer, Class<? extends RecyclerView.ViewHolder>> viewTypes) {
        this.viewTypes = viewTypes;

    }

    private void readAnnotations(AnnotatedElement element) {
        if (element.isAnnotationPresent(BindItem.class)) {
            BindItem bindItem = element.getAnnotation(BindItem.class);
            putViewType(bindItem.LAYOUT(), bindItem.VIEW_HOLDER());
        }
    }

    public CoreAdapter(@LayoutRes int layout, Class<? extends RecyclerView.ViewHolder> holder) {
        this.viewTypes = new HashMap<>();
        this.viewTypes.put(layout, holder);
    }

    public CoreAdapter() {
    }

    public void putViewType(@LayoutRes int layout, Class<? extends RecyclerView.ViewHolder> holder) {
        this.viewTypes.put(layout, holder);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        if (viewTypes.size() == 0) {
            throw new IndexOutOfBoundsException(
                    "No ViewType is specified." +
                            "call putViewType before using adapter");
        }
        View view = layoutInflater.inflate(viewType, parent, false);
        try {
            return viewTypes.get(viewType).getConstructor(View.class).newInstance(view);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        items.get(position).bind(holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getLayout();
    }

    /**
     * @param items CoreAdapter uses these items and bind recycler to them
     */
    public <T extends CoreItem> void setItems(@NonNull List<T> items) {
        this.items.clear();
        this.items.addAll(items);
        for (CoreItem item : items) {
            readAnnotations(item.getClass());
        }
        notifyDataSetChanged();
    }

    public void removeAll() {
        items.clear();
        notifyDataSetChanged();
    }

    /**
     * @param items
     * @param <T>
     * @see CoreItem
     */
    public <T extends CoreItem> void addItems(@NonNull List<T> items) {
        int start = this.items.size() - 1;
        this.items.addAll(items);
        for (CoreItem item : items) {
            readAnnotations(item.getClass());
        }
        if (start >= 0) {
            notifyItemRangeInserted(start, items.size());
        } else {
            notifyDataSetChanged();
        }
    }

    public <T extends CoreItem> void addItems(@IntRange(from = 0) int position, @NonNull List<T> items) {
        if (position > items.size()) {
            throw new IndexOutOfBoundsException();
        }
        this.items.addAll(position, items);
        for (CoreItem item : items) {
            readAnnotations(item.getClass());
        }
        notifyItemRangeInserted(position, items.size());
    }

    /**
     * @param item
     * @param <T>
     * @see CoreItem
     */
    public <T extends CoreItem> void addItem(@NonNull T item) {
        items.add(item);
        readAnnotations(item.getClass());

        notifyItemInserted(items.size() - 1);
    }

    /**
     * @param item
     * @param <T>  extends CoreItem
     * @see CoreItem
     */
    public <T extends CoreItem> void removeItem(@NonNull T item) {
        int index = items.indexOf(item);
        if (index >= 0) {
            items.remove(index);
            notifyItemRemoved(index);
        }


    }

    /**
     * remove items
     *
     * @param start
     * @param end
     */
    public void removeItemRange(@IntRange(from = 0) int start, @IntRange(from = 0) int end) {

        if (start < items.size() && end < items.size()) {

            for (int i = start; i < end; i++) {
                items.remove(i);
            }
            notifyDataSetChanged();

        }
    }


    /**
     * adding an item to a position
     *
     * @param position insert position
     * @param item     input item
     */
    public <T extends CoreItem> void addItem(@IntRange(from = 0) int position, @NonNull T item) {
        if (position > items.size()) {
            throw new IndexOutOfBoundsException();
        }
        items.add(position, item);
        readAnnotations(item.getClass());

        notifyItemInserted(position);
    }
}
