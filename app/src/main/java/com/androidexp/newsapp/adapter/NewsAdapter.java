package com.androidexp.newsapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.androidexp.newsapp.NewsClick.IONewsClick;
import com.androidexp.newsapp.R;
import com.androidexp.newsapp.model.Article;
import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Article> mListData;
    private IONewsClick ioNewsClick;

    public NewsAdapter(ArrayList<Article> mListData, IONewsClick ioNewsClick) {
        this.mListData = mListData;
        this.ioNewsClick = ioNewsClick;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Article article = mListData.get(position);
        holder.tvMainHeading.setText(mListData.get(position).getTitle());
        holder.tvContent.setText(mListData.get(position).getDescription());
        holder.tvAuthor.setText(mListData.get(position).getAuthor());
        holder.tvTime.setText(mListData.get(position).getPublishedAt());
        Glide.with(mContext).load(mListData.get(position).getUrlToImage()).into(holder.tvImage);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ioNewsClick.onNewsItemClick(article);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView tvMainHeading, tvContent, tvAuthor, tvTime;
        ImageView tvImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);

            tvMainHeading = itemView.findViewById(R.id.tvMainHeading);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvImage = itemView.findViewById(R.id.tvImage);
        }
    }
}
