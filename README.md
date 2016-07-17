# Core-Adapter
Support Any Type of items in recyclerview, 

## Usage:

* Items must implement `CoreItem<YOUR_DATA_MODEL,YOUR_VIEW_HOLDER>`

* Use `CoreAdapter` for recyclerviews adapter

* what layout for what viewholder? ` coreAdapter.putViewType(R.layout.YOUR_LAYOUT, YOUR_HOLDER.class);`



## add to project:
`compile 'ir.coderz.coreadapter:Core-Adapter:0.1.5'`
