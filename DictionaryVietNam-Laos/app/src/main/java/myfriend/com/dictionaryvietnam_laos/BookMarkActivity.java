package myfriend.com.dictionaryvietnam_laos;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import myfriend.com.dictionaryvietnam_laos.adapter.CustomAdapterBookmark;
import myfriend.com.dictionaryvietnam_laos.database.DatabaseHelper;
import myfriend.com.dictionaryvietnam_laos.model.Word;

public class BookmarkActivity extends AppCompatActivity {
    CustomAdapterBookmark adapter;
    ArrayList<Word> arr;
    Word w;
    private DatabaseHelper myDatabase;
    private ListView listView_listBookmark;
    private int selected = -1;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.mycontext, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_context_delete) {

            myDatabase.unBookMark(w.getId());
            finish();
            startActivity(getIntent());
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        myDatabase = new DatabaseHelper(BookmarkActivity.this);
        checkDatabase();
        bindWidgets();
        arr = myDatabase.getListBookmark();
        adapter = new CustomAdapterBookmark(BookmarkActivity.this, R.layout.layout_listbookmark, arr);
        listView_listBookmark.setAdapter(adapter);
        setWidgetEventListner();


    }

    private void setWidgetEventListner() {
        listView_listBookmark.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BookmarkActivity.this, DetailActivity.class);
                Word word = arr.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("WORD", word);
                intent.putExtra("DATA", bundle);
                startActivity(intent);
            }
        });
        listView_listBookmark.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selected = position;
                w = arr.get(position);
                registerForContextMenu(listView_listBookmark);

                return false;
            }
        });
    }

    private void bindWidgets() {
        listView_listBookmark = (ListView) findViewById(R.id.listView_listBookmark);
    }

    private void checkDatabase() {
        try {
            myDatabase.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
    }

}

