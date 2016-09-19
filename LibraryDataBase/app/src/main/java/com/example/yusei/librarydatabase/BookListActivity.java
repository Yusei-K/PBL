package com.example.yusei.librarydatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        ListView listView = (ListView) findViewById(R.id.listView);

        List<Map<String, String>> bookList = new ArrayList<Map<String, String>>();

        Map<String, String> book = new HashMap<String, String>();
        book.put("title", "やさしく学べる微分積分");
        book.put("author", "石田園子");
        book.put("isbn","9784320016330");
        bookList.add(book);

        book = new HashMap<String, String>();
        book.put("title", "リトル・ピープルの時代");
        book.put("author","宇野常寛");
        book.put("isbn","9784344423244");
        bookList.add(book);

        book = new HashMap<String, String>();
        book.put("title", "理工系の線形代数");
        book.put("author", "硲文夫");
        book.put("isbn","99784563002633");
        bookList.add(book);

        String[] from = {"title", "author"};
        int[] to = {android.R.id.text1, android.R.id.text2};
        SimpleAdapter adapter = new SimpleAdapter(BookListActivity.this, bookList, android.R.layout.simple_list_item_2, from, to);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);
            String bookTitle = item.get("title");
            String bookAuthor = item.get("author");
            String bookIsbn = item.get("isbn");

            Intent intent = new Intent(BookListActivity.this, BookProfileActivity.class);
            intent.putExtra("bookTitle", bookTitle);
            intent.putExtra("bookAuthor", bookAuthor);
            intent.putExtra("bookIsbn", bookIsbn);
            startActivity(intent);
        }
    }
}

