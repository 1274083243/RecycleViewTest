package com.recycleviewtest;

import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.recycleviewtest.Wrapper.HeadAndFootWrapper;
import com.recycleviewtest.Wrapper.HeaderAndFooterWrapper;
import com.recycleviewtest.Wrapper.LoadMoreWrapper;
import com.recycleviewtest.Wrapper.MultipleViewAdapter;
import com.recycleviewtest.Wrapper.NormalAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private String Tag="MainActivity";
    private RecyclerView rl;
    private List<String> mData;
    private HeadAndFootWrapper mHeadAndFootWrapper;
    private LoadMoreWrapper mLoadMoreWrapper;
    private View headView,footView;
    private ViewPager head_vp;
    private Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl= (RecyclerView) findViewById(R.id.rl);
        GridLayoutManager layout = new GridLayoutManager(this, 12);
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        rl.setLayoutManager(layout);
        layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return  multipleViewAdapter.getSpanSize(position);
            }
        });
        initData();
        initListner();
    }

    private void initListner() {
//        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
//            @Override
//            public void loadMore() {
////
//
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
////                        mLoadMoreWrapper.notifyDataSetChanged();
//                        mLoadMoreWrapper.showLoadFail();
//                    }
//                },1000);
//            }
//
//        });
    }
    private  MultipleViewAdapter multipleViewAdapter;
    private void initData() {
//        mData=new ArrayList<String>();
//        for (int i=0;i<30;i++){
//            mData.add("我是："+i);
//        }
//        NormalAdapter adater=new NormalAdapter(mData);
//        mHeadAndFootWrapper=new HeadAndFootWrapper(adater);
//        headView=View.inflate(this,R.layout.head_view,null);
        footView=View.inflate(this,R.layout.foot_view,null);
//        head_vp= (ViewPager) headView.findViewById(R.id.head_vp);
//        head_vp.setAdapter(new MyPagerAdapter());
//        mHeadAndFootWrapper.addHeadView(headView);

        multipleViewAdapter = new MultipleViewAdapter();
        mLoadMoreWrapper=new LoadMoreWrapper(multipleViewAdapter);
        mLoadMoreWrapper.setFootView(footView);
        rl.setAdapter(mLoadMoreWrapper);


    }
    class MyPagerAdapter extends PagerAdapter{

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
            ImageView imageView=new ImageView(MainActivity.this);
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
