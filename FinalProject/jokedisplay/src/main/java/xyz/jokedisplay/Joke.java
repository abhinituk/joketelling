package xyz.jokedisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Joke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView jokeText = (TextView) findViewById(R.id.joke);
        Intent intent= getIntent();
        intent.getStringExtra("joke");
        assert jokeText != null;
        jokeText.setText(intent.getStringExtra("joke"));
    }
}
