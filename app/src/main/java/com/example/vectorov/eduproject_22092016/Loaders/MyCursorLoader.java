package com.example.vectorov.eduproject_22092016.Loaders;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

/**
 * Created by vectorov on 17.10.2016.
 */

public class MyCursorLoader extends android.support.v4.content.CursorLoader {
    public MyCursorLoader(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        super(context, uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    public Cursor loadInBackground() {
        return super.loadInBackground();
    }

}
