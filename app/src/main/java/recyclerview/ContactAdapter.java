package recyclerview;

import java.util.List;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cratterzone.com.myapplication.*;

public class ContactAdapter extends Adapter<ContactViewHolder> {

    private List<recyclerview.ContactInfo> contactList;

    public ContactAdapter(List<recyclerview.ContactInfo> contactList) {
            this.contactList = contactList;
    }

    @Override
    public int getItemCount() {
          return contactList.size();
    }




//    public int getItemViewType(int position) {
//        int viewType = 0;
//        // add here your booleans or switch() to set viewType at your needed
//        // I.E if (position == 0) viewType = 1; etc. etc.
//        return viewType;
//    }
//
//    @Override
//    public FileViewHolder onCreateViewHolder(ViewGroup parent, int index) {
//        // index is the viewType!!
//        if (index == 0) {
//            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_layout_for_first_row, parent, false));
//        }
//
//        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_other_rows, parent, false));
//    }
//




//    public class MainViewHolder extends RecyclerView.ViewHolder {
//        public MainViewHolder (View itemView) {
//            super (itemView);
//        }
//    }
//
//    public class GroupViewHolder extends MainViewHolder {
//        TextView mTitle;
//        TextView mContent;
//        public GroupViewHolder(View itemView) {
//            super (itemView);
//            // init views...
//        }
//    }
//
//    public class ImageViewHolder extends MainViewHolder {
//        ImageView mImage;
//        public ImageViewHolder(View itemView) {
//            super (itemView);
//            // init views...
//        }
//    }
//

//    @Override
//    public void onBindViewHolder (ViewHolder viewHolder, int i) {
//
//        switch (viewHolder.getItemViewType()) {
//
//            case TYPE_IMAGE:
//                ImageViewHolder imageViewHolder = (ImageViewHolder) viewHolder;
//                imageViewHolder.mImage.setImageResource(...);
//                break;
//
//            case TYPE_GROUP:
//                GroupViewHolder groupViewHolder = (GroupViewHolder) viewHolder;
//                groupViewHolder.mContent.setText(...)
//                groupViewHolder.mTitle.setText (...);
//                break;
//        }
//    }

  //solution for recycler view with different views

//    public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//        class ViewHolder0 extends RecyclerView.ViewHolder {
//
//        }
//
//        class ViewHolder2 extends RecyclerView.ViewHolder {
//
//        }
//
//        @Override
//        public int getItemViewType(int position) {
//            // Just as an example, return 0 or 2 depending on position
//            // Note that unlike in ListView adapters, types don't have to be contiguous
//            return position % 2 * 2;
//        }
//
//        @Override
//        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//             switch (viewType) {
//                 case 0: return new ViewHolder0(...);
//                 case 2: return new ViewHolder2(...);
//                 ...
//             }
//        }
//    }
//

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        recyclerview.ContactInfo ci = contactList.get(i);
        contactViewHolder.vName.setText(ci.name);
        contactViewHolder.vSurname.setText(ci.surname);
        contactViewHolder.vEmail.setText(ci.email);
        contactViewHolder.vTitle.setText(ci.name + " " + ci.surname);
        
//        YoYo.with(Techniques.Pulse).duration(700).playOn(contactViewHolder.vEmail);
//        YoYo.with(Techniques.Pulse).duration(700).playOn(contactViewHolder.vName);
//        YoYo.with(Techniques.Pulse).duration(700).playOn(contactViewHolder.vTitle);
//        YoYo.with(Techniques.Pulse).duration(700).playOn(contactViewHolder.vSurname);
        int duration =500;
        YoYo.with(Techniques.BounceIn).duration(duration).playOn(contactViewHolder.vEmail);
        YoYo.with(Techniques.BounceIn).duration(duration).playOn(contactViewHolder.vName);
        YoYo.with(Techniques.BounceIn).duration(duration).playOn(contactViewHolder.vTitle);
        YoYo.with(Techniques.BounceIn).duration(duration).playOn(contactViewHolder.vSurname);
//        
   }

    
   @Override
   public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater. from(viewGroup.getContext()).inflate(R.layout.card_view_layout, viewGroup, false);
        return new ContactViewHolder(itemView);
   }

  
}
