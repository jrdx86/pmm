package com.example.jordipc.spinnerdoble;
import android.content.ContentValues;
import android.content.Context;import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper {
    private Context mCtx = null;
    private static DataBaseHelperInternal mDbHelper = null;
    private SQLiteDatabase mDb = null;
    public DatabaseHelper(Context ctx) {
        this.mCtx = ctx;
    }
    private static class DataBaseHelperInternal extends SQLiteOpenHelper {
        DataBaseHelperInternal(Context context, String databaseName, int databaseVersion) {
            super(context, databaseName, null, databaseVersion);
        }
        public void onCreate(SQLiteDatabase db) {
            createTables(db);
            fillTables(db);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            deleteTables(db);
            createTables(db);
            fillTables(db);
        }
        private void createTables(SQLiteDatabase db) {
            db.execSQL(Globals.CREATE_TABLE_CLIENT);
            db.execSQL(Globals.CREATE_TABLE_COUNTRY);
            db.execSQL(Globals.CREATE_TABLE_COUNTRY_VISITED);


        }
        private void deleteTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + Globals.TABLE_CLIENT);
            db.execSQL("DROP TABLE IF EXISTS " + Globals.TABLE_COUNTRY);

            }
        private void fillTables(SQLiteDatabase db) {
//TODO
            db.beginTransaction();
            try {
                db.execSQL(Globals.FILL_TABLE_COUNTRY);


                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }
    }
    public DatabaseHelper open() {
        mDbHelper = new DataBaseHelperInternal(mCtx, Globals.DATABASE_NAME, Globals.DATABASE_VERSION);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        mDbHelper.close();
    }

    public Cursor getItems(String table, String[] columns, String selection, String[] selArgs,
                           String orderBy) {
        return mDb.query(table, columns, selection, selArgs, null, null, orderBy);
    }

    public long insertItem(String table, String[][] data) {
        ContentValues initialValues = new ContentValues();
        for (String[] field : data)
            initialValues.put(field[0], field[1]);
        return mDb.insert(table, null, initialValues);
    }

    public int updateItem(String table, String where, String[] whereArgs, String[][] data) {
        ContentValues contentValues = new ContentValues();
        for (String[] field : data)
            contentValues.put(field[0], field[1]);
        return mDb.update(table, contentValues, where, whereArgs);
    }

    public int delete(String table, String where, String[] whereArgs) {
        return mDb.delete(table, where, whereArgs);
    }
    public Cursor query(String query, String [] arg){
        return mDb.rawQuery(query, arg);
    }
}

