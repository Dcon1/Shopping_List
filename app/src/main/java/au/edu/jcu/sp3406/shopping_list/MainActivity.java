package au.edu.jcu.sp3406.shopping_list;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String item1 = extras.getString("item");
            list = findViewById(R.id.list);
            if (savedInstanceState != null) {
                String savedState = savedInstanceState.getString("savedState");
                adapter.addAll(savedState);
            }
            adapter.add(item1);
            adapter.addAll("test");
            list.setAdapter(adapter);
        }

//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String item = adapter.getItem(position);
//                adapter.remove(item);
//                //Toast.makeText(this, "deleted", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void add(View view) {
        Intent intent = new Intent(this, AddToList.class);
        startActivity(intent);
    }
}
