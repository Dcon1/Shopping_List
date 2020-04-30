package au.edu.jcu.sp3406.shopping_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddToList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_list);
    }

    public void addItem(View view){
        EditText text = findViewById(R.id.editText);
        String textString = text.getText().toString();
        if(textString.equals("")){
            Toast.makeText(this, "Please enter an item!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Item added!", Toast.LENGTH_SHORT).show();
            text.setText("");
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            //String item2 = intent.getStringExtra(textString);
            intent.putExtra("item", textString);
            startActivity(intent);
        }

    }
}
