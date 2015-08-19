package demos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cratterzone.com.myapplication.R;

/**
 * Created by quickvik on 8/14/2015.
 */
public class SomethingNew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_card_toolbar);
        getSupportFragmentManager().beginTransaction().add(R.id.ly_content,new TestFragment(),"tag").commit();
    }
}
