package au.edu.jcu.sp3406.shopping_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add = findViewById(R.id.add);
        Button settings = findViewById(R.id.settings);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
    }

    public void addItem(View view){
        EditText text = findViewById(R.id.editText);
        String item = text.getText().toString();
        if(item.equals("")){
            Toast.makeText(this, "Please enter an item!", Toast.LENGTH_SHORT).show();
        }
        else {
            ListView list = findViewById(R.id.list);
            adapter.addAll(item);
            list.setAdapter(adapter);
            Toast.makeText(this, "Item added!", Toast.LENGTH_SHORT).show();
            text.setText("");
        }

    }
    }
