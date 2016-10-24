package com.example.vectorov.eduproject_22092016.Fragments;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vectorov.eduproject_22092016.Adapters.RecyclerStoreAdapter;
import com.example.vectorov.eduproject_22092016.Config;
import com.example.vectorov.eduproject_22092016.Loaders.MyCursorLoader;
import com.example.vectorov.eduproject_22092016.R;
import com.example.vectorov.eduproject_22092016.StoreContract;
import com.example.vectorov.eduproject_22092016.StoreTest;
import com.example.vectorov.eduproject_22092016.Utils;

import java.util.ArrayList;

/**
 * Created by vectorov on 22.09.2016.
 */
public class Fragment_store extends Fragment
                            implements LoaderManager.LoaderCallbacks<Cursor>
{

    private RecyclerView recyclerView;
    private Context context = getActivity();

    public Fragment_store() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<StoreTest> ar = new ArrayList<StoreTest>();
        /*
        String selection = null;
        String sortOrder = null;
        if(!Utils.isNetworkAvailable(getContext()))
        {
            sortOrder = StoreContract.id+" DESC LIMIT 1";
        }
        Cursor cursor = getContext().getContentResolver().query(Config.STORES_URI, null, selection, null, sortOrder);

        while (cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(StoreContract.id));
            String name = cursor.getString(cursor.getColumnIndex(StoreContract.name));
            String address = cursor.getString(cursor.getColumnIndex(StoreContract.address));
            String phone = cursor.getString(cursor.getColumnIndex(StoreContract.phone));
            ar.add(new StoreTest(id, name, address, phone, null));
        }
        */

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_store);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //RecyclerStoreAdapter recyclerStoreAdapter = new RecyclerStoreAdapter(Config.getStoreData(), getContext());
        final RecyclerStoreAdapter recyclerStoreAdapter = new RecyclerStoreAdapter(ar, getContext());
        recyclerView.setAdapter(recyclerStoreAdapter);

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
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String selection = null;
        String sortOrder = null;
        if(!Utils.isNetworkAvailable(getContext()))
        {
            sortOrder = StoreContract.id+" DESC LIMIT 1";
        }
        return new MyCursorLoader(getContext(), Config.STORES_URI, null, selection, null, sortOrder);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor)
    {
        while (cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(StoreContract.id));
            String name = cursor.getString(cursor.getColumnIndex(StoreContract.name));
            String address = cursor.getString(cursor.getColumnIndex(StoreContract.address));
            String phone = cursor.getString(cursor.getColumnIndex(StoreContract.phone));
            ((RecyclerStoreAdapter)recyclerView.getAdapter()).mStoreData.add(new StoreTest(id, name, address, phone, null));
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
