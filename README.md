# Ghost-Adapter
> Support Any Type of items in recyclerview with no pain 


### add to project:
`compile 'ir.coderz.ghostadapter:GhostAdapter:0.1@aar'`


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


#### 1. Items must be annotated
```java
@BindItem(layout = R.layout.layout, holder = TextHolder.class)
public class TextItem {  
    @Binder
    public void bind(TextHolder textHolder) {
    }
}
```

#### 2. Use `GhostAdapter` for Recyclerviews adapter
```java
GhostAdapter ghostAdapter = new GhostAdapter();
recycler.setAdapter(ghostAdapter);
```
#### 3. Fill the adapter by core items:
```java
ghostAdapter.addItem(new TextItem());
```


