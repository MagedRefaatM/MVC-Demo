package com.me.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Controller controller = new Controller();

    private EditText nameEditText;
    private EditText passwordEditText;

    private Button doneButton;

    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.edit_text_name);
        passwordEditText = findViewById(R.id.edit_text_password);

        errorTextView = findViewById(R.id.text_view_error);

        doneButton = findViewById(R.id.button_enter);
        doneButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                    controller.setNameAndPassword(nameEditText.getText().toString(), passwordEditText.getText().toString());

                    Model model = new Model(controller.getName(), controller.getPassword());

                    View view = new View(model.validateNameAndPassword());
                    errorTextView.setVisibility(android.view.View.VISIBLE);
                    errorTextView.setText(view.getMessage());
                }
        });
    }
}