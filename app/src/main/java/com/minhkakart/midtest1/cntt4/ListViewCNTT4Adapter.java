package com.minhkakart.midtest1.cntt4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.minhkakart.midtest1.R;

import java.util.List;

public class ListViewCNTT4Adapter extends BaseAdapter {
    List<String> list;

    public ListViewCNTT4Adapter(List<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lv_cntt4_item, parent, false);
        }

        TextView tv = convertView.findViewById(R.id.tv_cntt4);
        tv.setText(list.get(position));
        return convertView;
    }
}
