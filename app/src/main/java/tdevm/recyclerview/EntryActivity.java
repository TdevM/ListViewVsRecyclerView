package tdevm.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EntryActivity extends AppCompatActivity {

    Button openListView, openRecyclerView;
    public static final String TAG = "Entry Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        openListView = (Button) findViewById(R.id.btn_list_view);
        openRecyclerView = (Button) findViewById(R.id.btn_recycler_view);
        openListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent list = new Intent(EntryActivity.this, MainActivity.class);
                startActivity(list);
            }
        });
        openRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EntryActivity.this,RecyclerViewActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"OnStart Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"On Stop Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"OnDestroy Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"OnPause Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"OnResume Called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "OnRestart Called");
    }
}
