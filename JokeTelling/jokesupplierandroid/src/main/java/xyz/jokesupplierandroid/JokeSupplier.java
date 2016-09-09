package xyz.jokesupplierandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeSupplier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_supplier);
        TextView joke= (TextView) findViewById(R.id.joke);
        Intent intent= getIntent();
        String jokeRetrieved = intent.getStringExtra("Joke");
        assert joke != null;
        joke.setText(jokeRetrieved);
    }
}
