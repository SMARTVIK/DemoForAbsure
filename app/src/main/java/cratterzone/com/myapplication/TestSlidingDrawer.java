package cratterzone.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SlidingDrawer;

/**
 * Created by user05 on 09-06-2015.
 */

public class TestSlidingDrawer extends ActionBarActivity {
    private Toolbar toolbar;
    private SlidingDrawer drawer;
    Animation animationUp, animationLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding_drawer_layout);
        drawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);
        animationUp = AnimationUtils.loadAnimation(this, R.anim.layout_up_animation);
        animationLeft = AnimationUtils.loadAnimation(this, R.anim.layout_left_animation);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_action);

//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button next = (Button) findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                drawer.animateOpen();
            }
        });

        drawer.setOnDrawerScrollListener(new SlidingDrawer.OnDrawerScrollListener() {
            @Override
            public void onScrollStarted() {
                drawer.startAnimation(animationUp);
            }

            @Override
            public void onScrollEnded() {

            }
        });
        drawer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toolbar.setNavigationIcon(R.mipmap.ic_action);
                drawer.animateClose();
            }
        });

    }

    private void closeDrawer()
    {
        toolbar.setNavigationIcon(R.mipmap.ic_action);
        drawer.animateClose();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(TestSlidingDrawer.this,MainActivity.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sliding_main, menu);
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
        else if (id ==android.R.id.home)
        {
            if(drawer.isOpened())
            {
                closeDrawer();
                return true;
            }
            drawer.animateOpen();
            toolbar.setNavigationIcon(R.drawable.shine_btn);
        }
        return super.onOptionsItemSelected(item);
    }

}
