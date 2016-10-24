package com.example.vectorov.eduproject_22092016.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vectorov.eduproject_22092016.Fragments.Fragment_tools;
import com.example.vectorov.eduproject_22092016.R;
import com.example.vectorov.eduproject_22092016.StoreTest;
import com.example.vectorov.eduproject_22092016.ToolsTest;
import com.example.vectorov.eduproject_22092016.ViewHolders.ViewHolder_store;

import java.util.ArrayList;

/**
 * Created by vectorov on 22.09.2016.
 */

class mOnOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        String res = "";
        if(view instanceof TextView)
        { res = ((TextView) view).getText().toString();}
        Toast.makeText(view.getContext().getApplicationContext(), res, Toast.LENGTH_SHORT).show();
    }
}

public class RecyclerToolsAdapter extends RecyclerView.Adapter {
    public ArrayList<ToolsTest> mStoreData;
    private Context mContext;

    public RecyclerToolsAdapter(ArrayList mStoreData, Context context) {
        this.mStoreData = mStoreData;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tools, parent, false);
        ViewHolder_store vh = new ViewHolder_store(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        View v = holder.itemView;
        /*
        ImageView imageView = (ImageView) v.findViewById(R.id.image_tool);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_tools fragment_tools = new Fragment_tools();
                FragmentTransaction fragTran = ((AppCompatActivity)mContext).getSupportFragmentManager().beginTransaction();
                fragTran.replace(R.id.fragment_contanier, fragment_tools, "fragment_tools").show(fragment_tools).commit();
            }
        });
        imageView.setImageURI(Uri.parse(mStoreData.get(position).getImageUrl()));
        */

        TextView textView = (TextView) v.findViewById(R.id.brand_tool);
        textView.setText(mStoreData.get(position).getBrand());
        textView.setOnClickListener(new mOnOnClickListener());

        textView = (TextView) v.findViewById(R.id.name_tool);
        textView.setText(mStoreData.get(position).getModel());
        textView.setOnClickListener(new mOnOnClickListener());

        textView = (TextView) v.findViewById(R.id.type_tool);
        textView.setText(mStoreData.get(position).getType());
        textView.setOnClickListener(new mOnOnClickListener());

        textView = (TextView) v.findViewById(R.id.model_tool);
        textView.setText(mStoreData.get(position).getModel());
        textView.setOnClickListener(new mOnOnClickListener());

        textView = (TextView) v.findViewById(R.id.price_tool);
        textView.setText(String.valueOf(mStoreData.get(position).getPrice()));
        textView.setOnClickListener(new mOnOnClickListener());

        textView = (TextView) v.findViewById(R.id.qty_tool);
        textView.setText(String.valueOf(mStoreData.get(position).getQuantity()));
        textView.setOnClickListener(new mOnOnClickListener());

        textView = (TextView) v.findViewById(R.id.storeID);
        textView.setText("storeId = "+String.valueOf(mStoreData.get(position).getStoreId()));
    }

    @Override
    public int getItemCount() {
        return mStoreData.size();
    }
}
