package com.recycleviewtest.Wrapper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by ike on 2016/9/26.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> childViews;//整合条目view中的子view
    private View itemView;//条目view
    private Context context;
    public ViewHolder(View itemView,Context context) {
        super(itemView);
        this.itemView=itemView;
        this.context=context;
        childViews=new SparseArray<View>();
    }

    /**
     * 创建新的viewHolder
     */
    public static ViewHolder creatViewHolder(Context context,View itemView){
        ViewHolder viewHolder=new ViewHolder(itemView,context);
        return viewHolder;
    }
    public static ViewHolder creatViewHolder(Context context,int viewId){
        View itemView=View.inflate(context,viewId,null);
        ViewHolder viewHolder=new ViewHolder(itemView,context);
        return viewHolder;
    }

    /**
     * 通过viewId查找控件
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId){
        View view=childViews.get(viewId);
        if (view==null){
            view=itemView.findViewById(viewId);
            childViews.put(viewId,view);
        }
        return (T)view;
    }

    /**
     * 获取整体布局信息
     * @return
     */
    public View getItemView(){
        return  itemView;
    }

    /**
     * 设置某个子控件的点击事件
     */
    public void setOnClickListener(int viewId,View.OnClickListener listener){
        View view=childViews.get(viewId);
        view.setOnClickListener(listener);
    }

    /**
     * 设置某个子控件的长按点击事件
     * @param viewId
     * @param listener
     */
    public void setOnLongClikListener(int viewId,View.OnLongClickListener listener){
        View view=childViews.get(viewId);
        view.setOnLongClickListener(listener);
    }

}
