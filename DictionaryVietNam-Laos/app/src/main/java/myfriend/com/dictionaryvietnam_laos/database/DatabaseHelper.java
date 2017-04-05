package myfriend.com.dictionaryvietnam_laos.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import myfriend.com.dictionaryvietnam_laos.model.Word;

/**
 * Created by vatth on 3/31/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    String DB_Path;
    private static String DB_NAME = "db_TUDIEN.db";
    private SQLiteDatabase mDatabase;
    private final Context mContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.mContext = context;
        this.DB_Path = "data/data/" + context.getPackageName() + "/" + "databases/";
    }

    public void createDatabase() throws IOException {
        boolean dbExist = checkDatabase();
        if (dbExist) {
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    public void bookMark(int id) {
        ContentValues values = new ContentValues();
        values.put("BOOKMARK", 1);
        String sql = "UPDATE TUDIEN SET BOOKMARK = 1 WHERE ID = " + id;
        try {
            //mDatabase.execSQL(sql,null);
            mDatabase.update("TUDIEN", values, "ID =" + String.valueOf(id), null);
            mDatabase.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public void unBookMark(int id) {
        ContentValues values = new ContentValues();
        values.put("BOOKMARK", 0);
        String sql = "UPDATE TUDIEN SET BOOKMARK = 0 WHERE ID = " + id;
        try {
            //mDatabase.execSQL(sql,null);
            mDatabase.update("TUDIEN", values, "ID =" + String.valueOf(id), null);
            mDatabase.close();
        } catch (Exception e) {
            throw e;
        }
    }


    private void copyDataBase() throws IOException {
        InputStream myInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_Path + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    private boolean checkDatabase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_Path + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {

        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    public void openDataBase() throws SQLException {
        String myPath = DB_Path + DB_NAME;
        mDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);

    }

    @Override
    public synchronized void close() {
        if (mDatabase != null)
            mDatabase.close();
        super.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();

            }
    }

    public Word getWord(int _id) {
        Word w = null;
        Cursor cursor = mDatabase.query("TUDIEN", null, "ID = ? ", new String[]{String.valueOf(_id)}, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            w = new Word(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));

            cursor.moveToNext();
        }
        cursor.close();
        return w;
    }

    public ArrayList<Word> getListWords(String _vnword) {
        Word w = null;
        ArrayList<Word> arr = new ArrayList<>();
        Cursor cursor = mDatabase.query("TUDIEN", null, "VNWORD LIKE ? ", new String[]{_vnword + "%"}, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            w = new Word(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
            arr.add(w);
            cursor.moveToNext();
        }
        cursor.close();
        return arr;
    }

    public ArrayList<Word> getListBookmark() {
        Word w = null;
        ArrayList<Word> arr = new ArrayList<>();
        Cursor cursor = mDatabase.query("TUDIEN", null, "BOOKMARK = 1", null, null, null, null);
        cursor.moveToFirst();
        while ((!cursor.isAfterLast()))
        {
            w = new Word(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
            arr.add(w);
            cursor.moveToNext();
        }
        cursor.close();
        return  arr;
    }

}
