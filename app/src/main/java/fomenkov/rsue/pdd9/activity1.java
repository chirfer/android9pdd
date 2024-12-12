package fomenkov.rsue.pdd9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity1 extends AppCompatActivity implements View.OnClickListener {
    private Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        int color = 0;
        Button clickedButton = (Button) view;

        // Reset the previously selected button's color (if any)
        if (lastClickedButton != null) {
            lastClickedButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent)); //or your default color
        }

        if (view.getId() == R.id.button1) {
            Toast.makeText(this, "Неправильно!", Toast.LENGTH_SHORT).show();
            color = ContextCompat.getColor(this, R.color.wrong);
        } else if (view.getId() == R.id.button2) {
            Toast.makeText(this, "Неправильно!", Toast.LENGTH_SHORT).show();
            color = ContextCompat.getColor(this, R.color.wrong);
        } else if (view.getId() == R.id.button3) {
            Intent intent = new Intent(activity1.this, activity2.class);
            startActivity(intent);
            finish();
        } else if (view.getId() == R.id.button4) {
            Toast.makeText(this, "Неправильно!", Toast.LENGTH_SHORT).show();
            color = ContextCompat.getColor(this, R.color.wrong);
        }

        clickedButton.setBackgroundColor(color);
        lastClickedButton = clickedButton;
    }

    private Button lastClickedButton = null;

}

