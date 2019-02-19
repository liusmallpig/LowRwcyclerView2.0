package com.huxiaozhu.lowrecyclerview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.huxiaozhu.recyclerviewlib.adapter.BaseAdapter;
import com.huxiaozhu.recyclerviewlib.adapter.ListViewAdapter;
import com.huxiaozhu.recyclerviewlib.adapter.VariableAdapter;
import com.huxiaozhu.recyclerviewlib.adapter.viewholder.BaseViewHolder;
import com.huxiaozhu.recyclerviewlib.widget.ExpandRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandRecyclerView mRecyclerView;
    private ListViewAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.re);
        setData();
        setListener();
    }

    private void setData() {
        List<String> data = new ArrayList<>();
        data.add("listview");
        data.add("水平ListView");
        data.add("GridView");
        data.add("水平GridView");
        data.add("瀑布流");
        data.add("通讯录顶吸效果");
        data.add("画廊");
        adapter = new ListViewAdapter<String>(data, this) {

            @Override
            protected int getItemLayoutId() {
                return R.layout.item;
            }

            @Override
            public void setData(BaseViewHolder holder, int position, String item) {
                Button button = holder.getButton(R.id.btn);
                button.setText(item);
            }

        };

		mRecyclerView.addHeaderView(View.inflate(this,R.layout.header_view,null));
		mRecyclerView.addFooterView(View.inflate(this,R.layout.header_view,null));
        mRecyclerView.addItemDecoration(5, R.color.colorAccent);
		mRecyclerView.setAdapter(adapter);
    }

    private void setListener() {
        adapter.setOnClickListener(R.id.btn, new BaseAdapter.OnClick() {
            @Override
            public void onClick(int position, BaseViewHolder holder) {
                switch (position) {
                    case 0:
                        //ListView
                        Toast.makeText(getBaseContext(), "ListView", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //水平ListView
                        Toast.makeText(getBaseContext(), "水平ListView", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        //GridView
                        Toast.makeText(getBaseContext(), "GridView", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        //水平GridView
                        Toast.makeText(getBaseContext(), "水平GridView", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        //瀑布流
                        Toast.makeText(getBaseContext(), "瀑布流", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        //通讯录顶吸效果
                        Toast.makeText(getBaseContext(), "通讯录顶吸效果", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, AddressListActivity.class));
                        break;
                    case 6:
                        Toast.makeText(getBaseContext(), "画廊", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}