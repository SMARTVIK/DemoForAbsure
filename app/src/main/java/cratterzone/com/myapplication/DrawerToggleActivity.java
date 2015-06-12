package cratterzone.com.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SlidingDrawer;


public class DrawerToggleActivity extends ActionBarActivity {
private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test3);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_action);
//
//        final SlidingDrawer drawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);
//        Button next = (Button) findViewById(R.id.button);
//        next.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                drawer.animateOpen();
//            }
//        });
//
//        drawer.setOnClickListener(new View.OnClickListener(){
//
//            public void onClick(View view) {
//                drawer.animateClose();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drawer_toggle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}