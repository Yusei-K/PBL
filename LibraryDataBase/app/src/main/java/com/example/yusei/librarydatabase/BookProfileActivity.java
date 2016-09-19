package com.example.yusei.librarydatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BookProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_profile);

        Intent intent = getIntent();
        String bookTitle = intent.getStringExtra("bookTitle");
        String bookAuthor = intent.getStringExtra("bookAuthor");
        String bookIsbn = intent.getStringExtra("bookIsbn");

        TextView tvBookTitle = (TextView) findViewById(R.id.tvBookTitle);
        TextView tvBookAuthor = (TextView) findViewById(R.id.tvBookAuthor);
        TextView tvBookIsbn = (TextView) findViewById(R.id.tvBookIsbn);

        tvBookTitle.setText(bookTitle);
        tvBookAuthor.setText(bookAuthor);
        tvBookIsbn.setText(bookIsbn);
    }

    public void onBackButtonClick(View view) {
        finish();
    }

}