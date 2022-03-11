package com.example.recylerviewapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Article> articleList;

    public Adapter(List<Article> articleList) {
        this.articleList = articleList;
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.title_jv.setText(articleList.get(position).getTitle());
        holder.pub_day_jv.setText(articleList.get(position).getPub_day());
        holder.link_jv.setText(articleList.get(position).getLink());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title_jv;
        private TextView pub_day_jv;
        private TextView link_jv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_jv =itemView.findViewById(R.id.title);
            pub_day_jv = itemView.findViewById(R.id.pub_day);
            link_jv = itemView.findViewById(R.id.link);
        }
    }
}
