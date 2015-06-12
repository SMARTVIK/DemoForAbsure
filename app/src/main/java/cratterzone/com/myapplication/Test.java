package cratterzone.com.myapplication;

import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by user05 on 09-06-2015.
 */
public class Test extends ActionBarActivity {

    private static final int PROGRESS = 0x1;

    private ProgressBar mProgress;
    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        setContentView(R.layout.progressbar_custom);

        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        mProgress.setMax(100);
    }
    public void increaseProgress(View view)
    {
        if(mProgressStatus==100)
        {
           reset();
        }
        Resources resources = getResources();

        mProgressStatus = doWork();

        if(mProgressStatus>=0 && mProgressStatus<=25)
        {
            mProgress.setProgressDrawable(resources.getDrawable(R.drawable.custom_progressbar));
            mProgress.setProgress(mProgressStatus);
        }
        else  if(mProgressStatus>25 && mProgressStatus<=75)
        {
            mProgress.setProgressDrawable(resources.getDrawable(R.drawable.progress_middle));
            mProgress.setProgress(mProgressStatus);
        }
        else  if(mProgressStatus>75 && mProgressStatus<=100)
        {
            mProgress.setProgressDrawable(resources.getDrawable(R.drawable.progress_end));
            mProgress.setProgress(mProgressStatus);
        }

    }

    private void reset() {
        mProgressStatus=0;
        i=0;
        mProgress.setProgress(mProgressStatus);
    }

    private void startProgress() {
        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 50) {

                    mProgressStatus = doWork();

                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                        }
                    });
                }
            }


        }).start();
    }

    private int i=0;
    private int doWork() {
      i=i+5;
    return i;
    }
    private void showCustomProgress() {

        ProgressBar bar;
        Handler progressBarHandler = new Handler();

        GradientDrawable progressGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff1e90ff,0xff006ab6,0xff367ba8});
        ClipDrawable progressClipDrawable = new ClipDrawable(progressGradientDrawable, Gravity.LEFT, ClipDrawable.HORIZONTAL);
        Drawable[] progressDrawables = {new ColorDrawable(0xffffffff), progressClipDrawable, progressClipDrawable};
        LayerDrawable progressLayerDrawable = new LayerDrawable(progressDrawables);

        int status = 0;
        bar = (ProgressBar) findViewById(R.id.progressBar);
        bar.setProgress(0);
        bar.setMax(100);

        progressLayerDrawable.setId(0, android.R.id.background);
        progressLayerDrawable.setId(1, android.R.id.secondaryProgress);
        progressLayerDrawable.setId(2, android.R.id.progress);
        bar.setProgressDrawable(progressLayerDrawable);
    }

//    private void setUpDrawer() {
//        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
//        mContainerToolbar = (ViewGroup) findViewById(R.id.toolbar_container);
//        //set the Toolbar as ActionBar
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
//        //setup the NavigationDrawer
//        mDrawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
//        mDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
//    }
}
