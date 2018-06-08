package com.example.matsayya.ihorizonsdemo.modules.home.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import com.example.matsayya.ihorizonsdemo.R;
import com.example.matsayya.ihorizonsdemo.mvp.model.Item;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {
    Context context;
    List<Item> mList = new ArrayList<>();
    private LayoutInflater mlayoutInflater;
    public UserListAdapter(LayoutInflater layoutInflater) {
        this.mlayoutInflater = layoutInflater;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mlayoutInflater.inflate(R.layout.sublayout_userlist, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.bind(mList.get(position));
    }

    public void addMobiles(List<Item> itemResponseResults)
    {
        mList.addAll(itemResponseResults);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void clearUsers() {
        mList.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.txtName) protected TextView txtName;
        @BindView(R.id.txtDescription) protected TextView txtDescription;
        @BindView(R.id.txtForks) protected TextView txtForks;
        @BindView(R.id.imgAvtar) protected ImageView imgAvtar;

        private Context mcontext;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mcontext = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 /*   Intent intent = new Intent(context, PrescriptionListActivity.class);
                    intent.putExtra("user_id",arrayList.get(getAdapterPosition()).getId());
                    context.startActivity(intent);*/

                }
            });
        }
        public void bind(Item itemResponseResult)
        {
            txtName.setText(itemResponseResult.getName());
            txtDescription.setText(itemResponseResult.getDescription());
            txtForks.setText(mcontext.getResources().getString(R.string.forks) + itemResponseResult.getForksCount());

            Glide.with(mcontext).load(itemResponseResult.getOwner().getAvatarUrl())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imgAvtar);
        }
    }
}
