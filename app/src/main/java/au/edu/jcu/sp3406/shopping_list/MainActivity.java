package au.edu.jcu.sp3406.shopping_list;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        list = findViewById(R.id.list);
        list.setAdapter(adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Toast.makeText(this, "Please enter an item!", Toast.LENGTH_SHORT).show();
                    String itemClicked = adapter.getItem(position);
                    adapter.remove(itemClicked);
                    adapter.notifyDataSetChanged();
                }
            });

        }
        public void add (View view){
            Intent intent = new Intent(this, AddToList.class);
            startActivityForResult(intent, 0);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0){
            if(resultCode == Activity.RESULT_OK){
                assert data != null;
                String text = data.getStringExtra("item");
                adapter.add(text);


            }
        }
    }
}
