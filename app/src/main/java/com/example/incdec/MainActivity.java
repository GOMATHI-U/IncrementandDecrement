package com.example.incdec;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int counter=0;
    private TextView countertextview;
    @SuppressLint("MissingInfladedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        countertextview = findViewById(R.id.countertextView);
        Button incrementbutton = findViewById(R.id.incrementbutton);
        Button decrementbutton = findViewById(R.id.decrementbutton);
        incrementbutton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementCounter();
            }
        }));
        decrementbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementCounter();
            }
        });
    }
        private void incrementCounter(){
            counter++;
            updateCounterTextView();
        }
        private void decrementCounter(){
            if(counter>0){
                counter--;
                updateCounterTextView();

            }
        }
        private void updateCounterTextView(){ countertextview.setText(String.valueOf(counter));}


}