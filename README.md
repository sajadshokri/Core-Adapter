# Core-Adapter
> Support Any Type of items in recyclerview with no pain 


### add to project:
`compile 'ir.coderz.coreadapter:Core-Adapter:0.1.8@aar'`


### Usage:

#### 0. ViewHolders are normal:
```java
public class TextHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public TextHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
    }

    public TextView getTextView() {
        return textView;
    }
}
```


#### 1. Items must implement `CoreItem<YOUR_VIEW_HOLDER,YOUR_DATA_MODEL>`
```java
public class TextItem implements CoreItem<TextHolder, String> {

    @Override
    public void bind(TextHolder textHolder) {
        // This is the onbind method used to be inside adapter
        textHolder.getTextView().setText(textHolder.getAdapterPosition() + "");
    }

    @Override
    public int getLayout() {
        // You must return the related layout
        return R.layout.text_item;
    }

    @Override
    public String getData() {
        // you might need the data! so return it here :)
        return textHolder.getAdapterPosition() + "";
    }
}
```

#### 2. Use `CoreAdapter` for Recyclerviews adapter
```java
CoreAdapter coreAdapter = new CoreAdapter();
recycler.setAdapter(coreAdapter);
```

#### 3. what layout for what viewholder? 
` coreAdapter.putViewType(R.layout.YOUR_LAYOUT, YOUR_HOLDER.class);`

#### 4. Fill the adapter by core items:
```java
coreAdapter.addItem(new TextItem());
```


