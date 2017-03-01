package com.recycleviewtest.Wrapper;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.recycleviewtest.R;
import com.recycleviewtest.utils.*;
import com.recycleviewtest.utils.ViewHolder;

/**
 * Created by ike
 * on 2016/9/28.
 */
public class MultipleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static int ITEM_BANNER=0;
    private final static int ITEM_QUICK_ENTRY=1;
    private final static int ITEM_TITLE=2;
    private final static int ITEM_NORMAL=3;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==ITEM_BANNER){
            com.recycleviewtest.utils.ViewHolder viewHolder= ViewHolder.createViewHolder(parent.getContext(), parent,R.layout.head_view);
            return viewHolder;
        }
        if (viewType==ITEM_NORMAL){
            com.recycleviewtest.utils.ViewHolder viewHolder= ViewHolder.createViewHolder(parent.getContext(), parent,R.layout.common_item);
            return viewHolder;
        }
        if (viewType==ITEM_QUICK_ENTRY){
            com.recycleviewtest.utils.ViewHolder viewHolder= ViewHolder.createViewHolder(parent.getContext(), parent,R.layout.quick_item);
            return viewHolder;
        }
        if (viewType==ITEM_TITLE){
            com.recycleviewtest.utils.ViewHolder viewHolder= ViewHolder.createViewHolder(parent.getContext(), parent,R.layout.item_title);
            return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position==0){
            ViewHolder viewHolder= (ViewHolder) holder;
            ViewPager viewPager=viewHolder.getView(R.id.head_vp);
            viewPager.setAdapter(new MyPagerAdapter());
        }
    }
    public int getSpanSize(int pos)
    {

        int viewType = getItemViewType(pos);
        switch (viewType)
        {
            case ITEM_QUICK_ENTRY:
                return 3;
            case ITEM_NORMAL:
                return 6;
            case ITEM_TITLE:
                return 12;
            case ITEM_BANNER:
                return 12;
        }
        return 0;
    }
    @Override
    public int getItemCount() {
        return 30;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return ITEM_BANNER;
        }
        if (position!=0&&position<5){
            return ITEM_QUICK_ENTRY;
        }
        if (isTitle(position)) {
            return ITEM_TITLE;
        }
        return ITEM_NORMAL;
    }

    /**
     * 判断是否是标题
     * @param position
     */
    public boolean isTitle(int position){
        if (position>=5){
            return (position%5==0);
        }
        return false;
    }
    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView=new ImageView(container.getContext());
            imageView.setImageResource(R.mipmap.ic_launcher);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
