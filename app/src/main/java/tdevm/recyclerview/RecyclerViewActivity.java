package tdevm.recyclerview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    ArrayList<PojoClass.Accounts> listRecycler;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        if(getSupportActionBar()!= null) {
            getSupportActionBar().setTitle("RecyclerViews");
        }
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_layout);
        listRecycler = PojoClass.getHolders();

        //Create adapter objects, layout manager and set them following notifyDataSetChanged
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);


        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(listRecycler);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    //RecyclerView Holder class and its constructor
    public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView fName;
        TextView lName;
        TextView branch;
        TextView bal;
        TextView currency;
        TextView date;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            fName = (TextView) itemView.findViewById(R.id.tv_fname);
            lName = (TextView) itemView.findViewById(R.id.tv_lname);
            branch = (TextView) itemView.findViewById(R.id.tv_branch);
            bal = (TextView) itemView.findViewById(R.id.tv_bal);
            currency = (TextView)itemView.findViewById(R.id.tv_currency);
            date = (TextView)itemView.findViewById(R.id.tv_date);
        }
    }


    //The RecyclerView Adapter which takes RecyclerViewHolder as parameter
    public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {

        private ArrayList<PojoClass.Accounts> mHolders;

        public MyRecyclerViewAdapter(ArrayList<PojoClass.Accounts> mHolders) {
            this.mHolders = mHolders;

        }

        @Override
        public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            MyRecyclerViewHolder rHolder;
            LayoutInflater li = getLayoutInflater();
            View itemView = li.inflate(R.layout.list_item_single, null);

            rHolder = new MyRecyclerViewHolder(itemView);
            return rHolder;
        }

        @Override
        public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {

            PojoClass.Accounts thisHolder  = mHolders.get(position);
            holder.fName.setText(thisHolder.fName);
            holder.lName.setText(thisHolder.lName);
            holder.branch.setText(thisHolder.branch);
            holder.date.setText(thisHolder.balDate);
            holder.bal.setText(String.valueOf(thisHolder.balance));
            holder.currency.setText(thisHolder.currency);

        }

        @Override
        public int getItemCount() {
            return mHolders.size();
        }

    }


}
