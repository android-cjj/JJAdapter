package com.cjj.demo;

import android.view.View;
import android.widget.Toast;

import com.cjj.adapter.JJRvAdapter;

import java.util.List;

/**
 *  J （J代表cjj,说笑，别打我，J是model的类型）
 *  T （T代表Viewholder）
 */
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
