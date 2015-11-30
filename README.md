JJAdapter
=============================================================================

a simple adapter easy to use
--------------------------------------------------------------------------------

rv的出现，不代表lv就要消失，就算消失，也没那么快，对吧。 rv中adapter的写法和lv中adapter有很大的不同，相信熟悉这两种的人都知道。如果你项目中，
既有rv又有lv,每次都要写区别很大的adapter，你会不会觉得很麻烦（btw:如果觉得不麻烦的不用看了，因为下面的对你没意义，啊哈哈，别打我）！

现在来吹逼下JJAdapter,使用简单到很简单，啊哈哈，就是so easy to use.

for listView
------------------------------------------------------------
(1)继承 JJBaseAdapter<J,T> ,其中 泛型 J 代表 model的类型， T 代表 ViewHolder, adapter 构造函数中传入需要的数据，onBindData是数据回调，可以在这里做逻辑处理。

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

(2)MyViewHolder 就是我们平常写的ViewHoler 

eg:
```java
/**
 * 注意 tv_text 需要和xml的 id 一样
 * 其它控件的id都是这条规则 （the same）
 */
public class MyViewHolder{
    public TextView tv_text;
}
```
(3)listView.setAdapter(new MyBaseAdapter),这样就可以了，是不是很简单，啊哈哈。


for RecyclerView
--------------------------------------------------------
(1)继承 JJRvAdapter<J,T> ,其中 泛型 J 代表 model的类型， T 代表 ViewHolder, adapter 构造函数中传入需要的数据，onBindData是数据回调，可以在这里做逻辑处理。
```java
public class MyRvAdapter extends JJRvAdapter<String,MyViewHolder> {

    public MyRvAdapter(List<String> list) {
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
接下来和listView的使用一样，其实，如果你认真看rv(1)的使用只是和listView的继承JJBaseAdapter这个地方不一样而已，它继承JJRvAdapter 。

你没看错，现在你就不用担心老项目中lv,gv什么的了，都可以用这种简单的adapter,啊哈哈。。。。

注意：
---------------------------------------------------
MyViewHolder中的成员变量的名字需要和item xml中id 的 名字相同

其他：
-------------------------------------------------------
```java
public interface DataHandler<J> {

    public void updateData(List<J> list);

    public void updateData(J[] array);

    public void removeData(int pos);

    public void removeData(J item);

    public void addData(List<J> list);

    public void addData(J[] arrays);

    public void addData(J item);

}
```
看名字就知道 adapter有这些数据操作的功能，如果不够，自己看源码修改吧。


If you want to support me,you can follow me on GitHub:
[https://github.com/android-cjj](https://github.com/android-cjj).

缺点：
===========================
就是xml id 要一样，不支持多type...一大堆啊 ，所以，请尽量pull request 吧 ，它还是个小孩。。。。。


License
=======

    The MIT License (MIT)

	Copyright (c) 2015 android-cjj

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all
	copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	SOFTWARE.









