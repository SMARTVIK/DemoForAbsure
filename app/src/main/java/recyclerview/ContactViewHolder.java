package recyclerview;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import cratterzone.com.myapplication.R;

public  class ContactViewHolder extends ViewHolder {
    protected TextView vName;
    protected TextView vSurname;
    protected TextView vEmail;
    protected TextView vTitle;

    public ContactViewHolder(View v) {
         super(v);
         vName =  (TextView) v.findViewById(R.id.txtName);
         vSurname = (TextView)  v.findViewById(R.id.txtSurname);
         vEmail = (TextView)  v.findViewById(R.id.txtEmail);
         vTitle = (TextView) v.findViewById(R.id.title);
     }
}