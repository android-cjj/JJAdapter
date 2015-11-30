JJAdapter
=============================================================================

a simple adapter easy to use
--------------------------------------------------------------------------------

rv的出现，不代表lv就要消失，就算消失，也没那么快，对吧。 rv中adapter的写法和lv中adapter有很大的不同，相信熟悉这两种的人都知道。如果你项目中，
既有rv又有lv,每次都要写区别很大的adapter，你会不会觉得很麻烦（btw:如果觉得不麻烦的不用看了，因为下面的对你没意义，啊哈哈，别打我）！

现在来吹逼下JJAdapter,使用简单到很简单，啊哈哈，就是so easy to use.

for listView
------------------------------------------------------------
(1)继承 JJBaseAdapter<J,T> ,其中 泛型 J 代表 model的类型， T 代表 ViewHolder

eg:

```java
public class MyBaseAdapter extends JJBaseAdapter<String,MyViewHolder> {

    public MyBaseAdapter(List<String> list) {
        super(list, R.layout.item_list, MyViewHolder.class);
    }

    @Override
    public void onBindData(final int pos, MyViewHolder holder, String item) {
        holder.tv_text.setText(item);
        holder.tv_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),String.valueOf(pos),Toast.LENGTH_SHORT).show();
            }
        });
        holder.tv_text.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                removeData(pos);
                return false;
            }
        });
    }
}
```



