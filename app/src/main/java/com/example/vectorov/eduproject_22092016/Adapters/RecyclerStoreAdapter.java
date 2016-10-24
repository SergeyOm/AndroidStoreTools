package com.example.vectorov.eduproject_22092016.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vectorov.eduproject_22092016.DialogMail;
import com.example.vectorov.eduproject_22092016.DialogPhone;
import com.example.vectorov.eduproject_22092016.Fragments.Fragment_tools;
import com.example.vectorov.eduproject_22092016.R;
import com.example.vectorov.eduproject_22092016.StoreTest;
import com.example.vectorov.eduproject_22092016.ViewHolders.ViewHolder_store;

import java.util.ArrayList;

/**
 * Created by vectorov on 22.09.2016.
 * Modify Omelyanchuk on 22.10.2016.
 */
public class RecyclerStoreAdapter extends RecyclerView.Adapter
{
    public ArrayList<StoreTest> mStoreData;
    private Context mContext;
    FragmentManager fragmentManager;

    public RecyclerStoreAdapter(ArrayList mStoreData, Context context) {
        this.mStoreData = mStoreData;
        this.mContext = context;
        this.fragmentManager = ((AppCompatActivity)mContext).getSupportFragmentManager();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store, parent, false);
        ViewHolder_store vh = new ViewHolder_store(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        View v = holder.itemView;

        TextView textView = (TextView) v.findViewById(R.id.name_store);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_tools fragment_tools = new Fragment_tools();
                Bundle bundle = new Bundle();
                bundle.putInt("storeId", mStoreData.get(position).getId());
                fragment_tools.setArguments(bundle);

                FragmentTransaction fragTran = fragmentManager.beginTransaction();
                fragTran.replace(R.id.fragment_contanier, fragment_tools, "fragment_tools").show(fragment_tools).commit();
            }
        });
        textView.setText(mStoreData.get(position).getName());

        textView = (TextView) v.findViewById(R.id.address_store);
        textView.setText(mStoreData.get(position).getAddress());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogMail dlgMail = new DialogMail(mStoreData.get(position).getAddress());
                dlgMail.show(fragmentManager, "dlgMail");
            }
        });

        textView = (TextView) v.findViewById(R.id.phone_store);
        textView.setText(mStoreData.get(position).getPhone());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogPhone dlgPhone = new DialogPhone(mStoreData.get(position).getPhone());
                dlgPhone.show(fragmentManager, "dlgPhone");

            }
        });
    }

    @Override
    public int getItemCount() {
        return mStoreData.size();
    }
}
