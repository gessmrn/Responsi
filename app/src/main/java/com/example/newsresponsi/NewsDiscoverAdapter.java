package com.example.newsresponsi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsresponsi.model.news.ArticlesItem;

import java.util.ArrayList;

public class NewsDiscoverAdapter extends RecyclerView.Adapter<NewsDiscoverAdapter.ViewHolder> {

    private ArrayList<ArticlesItem> articlesItems = new ArrayList<>();
    private Context context;

    private static String BASE_IMAGE_URL = "https://ichef.bbci.co.uk/news/1024/branded_news/1756F/production/_112299559_gettyimages-1207934147.jpg";

    public NewsDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ArticlesItem> items) {
        articlesItems.clear();
        articlesItems.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(BASE_IMAGE_URL+articlesItems.get(position)
                .getContent())
                .into(holder.ivImage);

        holder.tvTitle.setText(articlesItems.get(position).getTitle());
        holder.tvPublisher.setText(String.valueOf(articlesItems.get(position).getAuthor()));
    }

    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvTitle, tvPublisher;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            ivImage = itemView.findViewById(R.id.itemlist_iv);
            tvTitle = itemView.findViewById(R.id.itemlist_tv_title);
            tvPublisher = itemView.findViewById(R.id.itemlist_tv_publisher);
        }
    }
}
