package com.example.vectorov.eduproject_22092016.Fragments;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vectorov.eduproject_22092016.Adapters.RecyclerToolsAdapter;
import com.example.vectorov.eduproject_22092016.Config;
import com.example.vectorov.eduproject_22092016.Loaders.MyCursorLoader;
import com.example.vectorov.eduproject_22092016.R;
import com.example.vectorov.eduproject_22092016.ToolsContract;
import com.example.vectorov.eduproject_22092016.ToolsTest;
import com.example.vectorov.eduproject_22092016.Utils;

import java.util.ArrayList;

/**
 * Created by vectorov on 22.09.2016.
 */
public class Fragment_tools extends Fragment
        implements LoaderManager.LoaderCallbacks<Cursor>
{
    private RecyclerView recyclerView;
    private Context context = getActivity();

    public Fragment_tools() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(1, getArguments(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<ToolsTest> ar = new ArrayList<ToolsTest>();
        /*
        Bundle args = getArguments();
        String selection = null;
        String sortOrder = null;

        if (args != null) {
            selection = "storeId = " + args.getInt("storeId");
        }

        if(!Utils.isNetworkAvailable(getContext()))
        {
            sortOrder = ToolsContract.id+" DESC LIMIT 1";
        }

        Cursor cursor = getContext().getContentResolver().query(Config.TOOLS_URI, null, selection, null, sortOrder);

        while (cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(ToolsContract.id));
            int storeid = cursor.getInt(cursor.getColumnIndex(ToolsContract.storeId));
            String brand = cursor.getString(cursor.getColumnIndex(ToolsContract.brand));
            String model = cursor.getString(cursor.getColumnIndex(ToolsContract.model));
            String imageUrl = cursor.getString(cursor.getColumnIndex(ToolsContract.imageUrl));
            String type = cursor.getString(cursor.getColumnIndex(ToolsContract.type));
            float price = cursor.getFloat(cursor.getColumnIndex(ToolsContract.price));
            int quantity = cursor.getInt(cursor.getColumnIndex(ToolsContract.quantity));
            ar.add(new ToolsTest(id, storeid, brand, model, imageUrl, type, price, quantity));
        }
        */

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tools, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_tools);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        RecyclerToolsAdapter recyclerToolsAdapter = new RecyclerToolsAdapter(ar, getContext());
        recyclerView.setAdapter(recyclerToolsAdapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String selection = null;
        String sortOrder = null;

        if (args != null) {
            selection = "storeId = " + args.getInt("storeId");
        }

        if(!Utils.isNetworkAvailable(getContext()))
        {
            sortOrder = ToolsContract.id+" DESC LIMIT 1";
        }

        return new MyCursorLoader(getContext(), Config.TOOLS_URI, null, selection, null, sortOrder);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        while (cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(ToolsContract.id));
            int storeid = cursor.getInt(cursor.getColumnIndex(ToolsContract.storeId));
            String brand = cursor.getString(cursor.getColumnIndex(ToolsContract.brand));
            String model = cursor.getString(cursor.getColumnIndex(ToolsContract.model));
            String imageUrl = cursor.getString(cursor.getColumnIndex(ToolsContract.imageUrl));
            String type = cursor.getString(cursor.getColumnIndex(ToolsContract.type));
            float price = cursor.getFloat(cursor.getColumnIndex(ToolsContract.price));
            int quantity = cursor.getInt(cursor.getColumnIndex(ToolsContract.quantity));
            ((RecyclerToolsAdapter)recyclerView.getAdapter()).mStoreData.add(new ToolsTest(id, storeid, brand, model, imageUrl, type, price, quantity));
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
