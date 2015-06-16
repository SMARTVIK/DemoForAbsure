package floatingactionbutton;




import android.app.Activity;

import android.os.Bundle;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.ListView;
import android.widget.Toast;

import cratterzone.com.myapplication.R;


public class FloatingActionButtonActivity extends Activity 
{
 
 @Override
  
protected void onCreate(Bundle savedInstanceState) 
{
    
super.onCreate(savedInstanceState);
    
setContentView(R.layout.activity_main_floating_action_button);

    
findViewById(R.id.pink_icon).setOnClickListener(new OnClickListener() 
{
      
@Override
      
public void onClick(View v) 
{
        
Toast.makeText(FloatingActionButtonActivity.this, "Clicked pink Floating Action Button", Toast.LENGTH_SHORT).show();
      
}
    
});

  ListView listView; 
 
FloatingActionButton button = (FloatingActionButton) findViewById(R.id.setter);


   
 button.setSize(FloatingActionButton.SIZE_MINI);
   
 button.setColorNormalResId(R.color.pink);
    
 button.setColorPressedResId(R.color.pink_pressed);
    
 button.setIcon(R.drawable.ic_fab_star);

    
FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
    
((FloatingActionsMenu) findViewById(R.id.multiple_actions)).addButton(actionC);

   
 final FloatingActionButton actionA = (FloatingActionButton) findViewById(R.id.action_a);
    
actionA.setOnClickListener(new OnClickListener() 
{
      
@Override
      
public void onClick(View view) 
{
        
actionA.setTitle("Action A clicked");
     
 }
   
 });
 
}

}
