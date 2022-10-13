package com.example.lab2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import utilities.TextCounter;
import utilities.WordCounter;


public class MainActivity extends AppCompatActivity {

    private Spinner spSelectionOptions;
    private EditText edPhrase;
    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edPhrase = findViewById(R.id.edPhrase);
        this.tvMain = findViewById(R.id.tvMain);

        this.spSelectionOptions = (Spinner) findViewById(R.id.spSelectionOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spSelectionOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        String selectedOption = this.spSelectionOptions.getSelectedItem().toString();
        String defaultCharSelectedOption = getResources().getString(R.string.characters_selection);
        String defaultWordSelectedOption = getResources().getString(R.string.words_selection);


        if (selectedOption.equals(defaultWordSelectedOption)) {
            String userInputText = this.edPhrase.getText().toString();
            if (TextUtils.isEmpty(userInputText)) {
                this.tvMain.setText("String is empty!");
                Toast.makeText(this, "String is empty!", Toast.LENGTH_SHORT).show();
            } else {
                String words = WordCounter.wordcount(userInputText);
                this.tvMain.setText(words);
            }
        }

        if (selectedOption.equals(defaultCharSelectedOption)) {
            String userInputText = this.edPhrase.getText().toString();
            if (TextUtils.isEmpty(userInputText)) {
                this.tvMain.setText("String is empty!");
                Toast.makeText(this, "String is empty!", Toast.LENGTH_SHORT).show();
            } else {
                String charsCount = TextCounter.getCharsCount(userInputText);
                this.tvMain.setText(charsCount);
            }
        }
    }
}