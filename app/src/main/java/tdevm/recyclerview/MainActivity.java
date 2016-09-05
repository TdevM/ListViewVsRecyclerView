package tdevm.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ArrayList<PojoClass.Accounts> aHolders;
    ListView accountListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!= null) {
            getSupportActionBar().setTitle("ListViews");
        }
        accountListView = (ListView) findViewById(R.id.list_view_main);
        aHolders = PojoClass.getHolders();
        AccountsAdapter accountsAdapter = new AccountsAdapter(aHolders);
        accountListView.setAdapter(accountsAdapter);
    }

    private class AccountsAdapter extends BaseAdapter {

        class ViewHolder {
            TextView fName;
            TextView lName;
            TextView bal;
            TextView branch;
            TextView cur;
            TextView date;
        }

        private ArrayList<PojoClass.Accounts> mHolders;


        public AccountsAdapter(ArrayList<PojoClass.Accounts> mHolders) {
            this.mHolders = mHolders;

        }

        @Override
        public int getCount() {
            return mHolders.size();
        }

        @Override
        public PojoClass.Accounts getItem(int position) {
            return mHolders.get(position);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = getLayoutInflater();
            ViewHolder v;
            if (convertView == null) {
                convertView = li.inflate(R.layout.list_item_single, null);
                v = new ViewHolder();
                v.fName = (TextView) convertView.findViewById(R.id.tv_fname);
                v.lName = (TextView) convertView.findViewById(R.id.tv_lname);
                v.bal = (TextView) convertView.findViewById(R.id.tv_bal);
                v.branch = (TextView) convertView.findViewById(R.id.tv_branch);
                v.cur = (TextView) convertView.findViewById(R.id.tv_currency);
                v.date = (TextView) convertView.findViewById(R.id.tv_date);
                convertView.setTag(v);
            } else {
                v = (ViewHolder) convertView.getTag();
            }

            PojoClass.Accounts thisO = (PojoClass.Accounts) getItem(position);
            v.fName.setText(thisO.fName);
            v.lName.setText(thisO.lName);
            v.branch.setText(thisO.branch);
            v.date.setText(thisO.balDate);
            v.cur.setText(thisO.currency);
            v.bal.setText(String.valueOf(thisO.balance));
            return convertView;
        }
    }

}
