package com.example.vectorov.eduproject_22092016;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by vectorov on 08.10.2016.
 */

public class DBContentProvider extends ContentProvider {
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static final String AUTHORITY = "com.example.vectorov.testcontentprovider";
    static final String STORES_PATH = "stores";
    static final String TOOLS_PATH = "tools";
    // Общий Uri
    public static final Uri STORES_CONTENT_URI = Uri.parse("content://"
            + AUTHORITY + "/" + STORES_PATH);
    public static final Uri TOOLS_CONTENT_URI = Uri.parse("content://"
            + AUTHORITY + "/" + TOOLS_PATH);
    private static final int URI_STORES = 1;
    private static final int URI_STORES_ID = 2;
    private static final int URI_TOOLS = 3;
    private static final int URI_TOOLS_ID = 4;

    // Типы данных
    // набор строк
    static final String STORE_CONTENT_TYPE = "vnd.android.cursor.dir/vnd."
            + AUTHORITY + "." + STORES_PATH;
    static final String TOOL_CONTENT_TYPE = "vnd.android.cursor.dir/vnd."
            + AUTHORITY + "." + TOOLS_PATH;

    // одна строка
    static final String STORE_CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd."
            + AUTHORITY + "." + STORES_PATH;
    static final String TOOL_CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd."
            + AUTHORITY + "." + TOOLS_PATH;

    private DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        uriMatcher.addURI(AUTHORITY, STORES_PATH, URI_STORES);
        uriMatcher.addURI(AUTHORITY, STORES_PATH + "/#", URI_STORES_ID);
        uriMatcher.addURI(AUTHORITY, TOOLS_PATH, URI_TOOLS);
        uriMatcher.addURI(AUTHORITY, TOOLS_PATH + "/#", URI_TOOLS_ID);

        dbHelper = new DBHelper(getContext());
        Toast.makeText(getContext(), "Вызвали провайдер", Toast.LENGTH_LONG);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String tableName;
        String id;

        switch (uriMatcher.match(uri)) {
            case URI_STORES: // общий Uri
                // если сортировка не указана, ставим свою - по имени
                if (TextUtils.isEmpty(sortOrder)) {
                    sortOrder = StoreContract.name + " ASC";
                }
                tableName = "stores";
                break;
            case URI_STORES_ID: // Uri с ID
                id = uri.getLastPathSegment();
                // добавляем ID к условию выборки
                if (TextUtils.isEmpty(selection)) {
                    selection = StoreContract.id+ " = " + id;
                } else {
                    selection = selection + " AND " + StoreContract.id + " = " + id;
                }
                tableName = "stores";
                break;
            case URI_TOOLS: // общий Uri
                // если сортировка не указана, ставим свою - по имени
                if (TextUtils.isEmpty(sortOrder)) {
                    sortOrder = ToolsContract.storeId + " ASC";
                }
                tableName = "tools";
                break;
            case URI_TOOLS_ID: // Uri с ID
                id = uri.getLastPathSegment();
                // добавляем ID к условию выборки
                if (TextUtils.isEmpty(selection)) {
                    selection = ToolsContract.id+ " = " + id;
                } else {
                    selection = selection + " AND " + ToolsContract.id + " = " + id;
                }
                tableName = "tools";
                break;
            default:
                throw new IllegalArgumentException("Wrong URI: " + uri);
        }
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(tableName, projection, selection,
                selectionArgs, null, null, sortOrder);
        // просим ContentResolver уведомлять этот курсор
        // об изменениях данных в CONTACT_CONTENT_URI
        cursor.setNotificationUri(getContext().getContentResolver(),
                STORES_CONTENT_URI);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case URI_STORES:
                return STORE_CONTENT_TYPE;
            case URI_STORES_ID:
                return STORE_CONTENT_ITEM_TYPE;
            case URI_TOOLS:
                return TOOL_CONTENT_TYPE;
            case URI_TOOLS_ID:
                return TOOL_CONTENT_ITEM_TYPE;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String tableName;
        Uri resultUri;
        if (uriMatcher.match(uri) == URI_STORES)
        {
            tableName = "stores";
            resultUri = STORES_CONTENT_URI;
        }
        else if (uriMatcher.match(uri) == URI_TOOLS)
        {
            tableName = "tools";
            resultUri = TOOLS_CONTENT_URI;
        }
        else
            throw new IllegalArgumentException("Wrong URI: " + uri);

        db = dbHelper.getWritableDatabase();
        long rowID = db.insert(tableName, null, values);
        resultUri = ContentUris.withAppendedId(resultUri, rowID);
        // уведомляем ContentResolver, что данные по адресу resultUri изменились
        getContext().getContentResolver().notifyChange(resultUri, null);
        return resultUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        String id;
        String tableName;
        switch (uriMatcher.match(uri)) {
            case URI_STORES:
                tableName = "stores";
                break;
            case URI_STORES_ID:
                tableName = "stores";
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection)) {
                    selection = StoreContract.id + " = " + id;
                } else {
                    selection = selection + " AND " + StoreContract.id + " = " + id;
                }
                break;
            case URI_TOOLS:
                tableName = "tools";
                break;
            case URI_TOOLS_ID:
                tableName = "tools";
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection)) {
                    selection = ToolsContract.id + " = " + id;
                } else {
                    selection = selection + " AND " + ToolsContract.id + " = " + id;
                }
                break;
            default:
                throw new IllegalArgumentException("Wrong URI: " + uri);
        }
        db = dbHelper.getWritableDatabase();
        int cnt = db.delete(tableName, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return cnt;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        String id;
        String tableName;
        switch (uriMatcher.match(uri)) {
            case URI_STORES:
                tableName = "stores";
                break;
            case URI_STORES_ID:
                tableName = "stores";
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection)) {
                    selection = StoreContract.id + " = " + id;
                } else {
                    selection = selection + " AND " + StoreContract.id + " = " + id;
                }
                break;
            case URI_TOOLS:
                tableName = "tools";
                break;
            case URI_TOOLS_ID:
                tableName = "tools";
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection)) {
                    selection = ToolsContract.id + " = " + id;
                } else {
                    selection = selection + " AND " + ToolsContract.id + " = " + id;
                }
                break;
            default:
                throw new IllegalArgumentException("Wrong URI: " + uri);
        }
        db = dbHelper.getWritableDatabase();
        int cnt = db.update(tableName, values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return cnt;
    }
}
