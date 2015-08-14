package demos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cratterzone.com.myapplication.R;
import recyclerview.ContactInfo;

/**
 * Created by quickvik on 8/13/2015.
 */
public class ListViewWithCardView extends AppCompatActivity {
    ListView listView;
    List<ContactInfo> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listview);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new CustomAdapter(getItems(), ListViewWithCardView.this));
    }

    private List<ContactInfo> getItems() {
        return createList(50);
    }

    private List<ContactInfo> createList(int size) {

        List<ContactInfo> result = new ArrayList<ContactInfo>();
        for (int i=1; i <= size; i++) {
            ContactInfo ci = new ContactInfo();
            ci.name = "vik"+ i;
            result.add(ci);
        }

        return result;
    }

    private class CustomAdapter extends BaseAdapter {
        List<ContactInfo> items;
        Context context;

        public CustomAdapter(List<ContactInfo> items, Context context) {
            this.items = items;
            this.context = context;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            ItemHolder holder;
            if(view==null)
            {
                holder = new ItemHolder();
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout,parent,false);
                holder.name = (TextView)view.findViewById(R.id.txtName);
                view.setTag(holder);
            }
            else
            {
                holder =(ItemHolder) view.getTag();
            }

            ContactInfo contactInfo = items.get(position);

            holder.name.setText(contactInfo.name);

            return view;
        }

        private class ItemHolder {
            public TextView name;
        }
    }

}
