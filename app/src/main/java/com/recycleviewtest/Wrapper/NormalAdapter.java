package com.recycleviewtest.Wrapper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recycleviewtest.R;
import com.recycleviewtest.utils.ViewHolder;

import java.util.List;

/**
 * Created by ike on 2016/9/26.
 */
public class NormalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mData;
    private String Tag="NormalAdapter";
    public NormalAdapter(List<String> mData) {
        this.mData = mData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       // View itemView=View.inflate(parent.getContext(),R.layout.item,null);
        ViewHolder viewHolder=ViewHolder.createViewHolder(parent.getContext(),parent,R.layout.item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        TextView tv= viewHolder.getView(R.id.tv);
        tv.setText(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
