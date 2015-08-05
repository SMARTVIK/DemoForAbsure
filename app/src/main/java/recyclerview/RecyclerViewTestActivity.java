package recyclerview;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import cratterzone.com.myapplication.*;


public class RecyclerViewTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recList = (RecyclerView) findViewById(R.id.recycler_view);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
/*
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setLayout*/

        ArrayList<recyclerview.ContactInfo>contactList = new ArrayList<recyclerview.ContactInfo>();
        contactList =(ArrayList<recyclerview.ContactInfo>) createList(300);
        ContactAdapter adapter = new ContactAdapter(contactList);
        recList.setAdapter(adapter);

//        ArrayList<Object>objects = new ArrayList<Object>();
//        objects =createObjects(50);
//        MyAdapter adapter = new MyAdapter(objects);
//        recList.setAdapter(adapter);

    }

//
//    private ArrayList<Object> createObjects(int size) {
//
//    	ArrayList<Object> result = new ArrayList<Object>();
//        for (int i=0; i <= size; i++) {
//
//          if(i%2==0)
//          {
//        	  Id id = new Id(R.drawable.ic_launcher, 0);
//        	  result.add(id);
//
//          }
//          else
//          {
//        	  StringClass stringClass = new StringClass("vivek Pratap singh", 1);
//        	  result.add(stringClass);
//          }
//
//
//
//        }
//
//        return result;
//	}
	private List<recyclerview.ContactInfo> createList(int size) {

        List<recyclerview.ContactInfo> result = new ArrayList<recyclerview.ContactInfo>();
        for (int i=1; i <= size; i++) {
            recyclerview.ContactInfo ci = new recyclerview.ContactInfo();
            ci.name = recyclerview.ContactInfo.NAME_PREFIX + i;
            ci.surname = recyclerview.ContactInfo.SURNAME_PREFIX + i;
            ci.email = ContactInfo.EMAIL_PREFIX + i + "@test.com";

            result.add(ci);

        }

        return result;
    }
    
}
