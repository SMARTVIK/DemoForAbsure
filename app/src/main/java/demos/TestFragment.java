package demos;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cratterzone.com.myapplication.R;

/**
 * Created by quickvik on 8/14/2015.
 */
public class TestFragment extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new MyAdapter(getItems(), getActivity()));


        return view;

    }


    private List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            items.add("item"+i);
        }
        return items;
    }

    private class MyAdapter extends RecyclerView.Adapter<Holder> {
        List<String> items;
        Context context;

        public MyAdapter(List<String> items, Context context) {
            this.items = items;
            this.context = context;
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items,parent,false));
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {

            holder.amount.setText(items.get(position));

        }


        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    private class Holder extends RecyclerView.ViewHolder {
        TextView amount;
        public Holder(View itemView) {
            super(itemView);

            amount = (TextView) itemView.findViewById(R.id.pending_inspection_count);
        }
    }

}
