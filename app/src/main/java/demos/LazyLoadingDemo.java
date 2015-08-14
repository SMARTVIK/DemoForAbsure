package demos;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cratterzone.com.myapplication.R;

/**
 * Created by quickvik on 8/14/2015.
 */
public class LazyLoadingDemo extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lazyloading_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        setUpRecyclerView(mRecyclerView);
    }

    private void setUpRecyclerView(RecyclerView mRecyclerView) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                adapter.loadmoreitems();
            }
        });
        adapter = new MyAdapter(loaditems(), LazyLoadingDemo.this);
        mRecyclerView.setAdapter(adapter);
    }

    private List<String> loaditems() {

        List<String> stringList  = new ArrayList<>();

        for(int i=0;i<100;i++)
        {
            stringList.add("loading ..plz wait"+i);
        }

        return stringList;
    }


    private class MyAdapter extends RecyclerView.Adapter<Holder> {
        List<String> list;
        Context context;
        int i=0;

        public MyAdapter(List<String> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false));
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.textView.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public void loadmoreitems() {

            for(int j=0;j<10;j++)
            {
                list.add("more items"+i);
                i++;
            }
            notifyDataSetChanged();
        }
    }

    private class Holder extends RecyclerView.ViewHolder {
       TextView textView;
        public Holder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.text);
        }
    }
}
