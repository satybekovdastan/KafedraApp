package com.example.dastan.kafedraapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dastan.kafedraapp.DataBase.DataHelper;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RVNewsAdapter extends RecyclerView.Adapter<RVNewsAdapter.PersonViewHolder> {
    Context context;
    Vse vse;

    public class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView title_news;

        ImageView image_news;

        PersonViewHolder(final View itemView) {
            super(itemView);
            title_news = (TextView) itemView.findViewById(R.id.title_news);

            image_news = (ImageView) itemView.findViewById(R.id.image_news);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int i = getAdapterPosition();

                    Intent intent = new Intent(context, NewsSecondActivity.class);
                    intent.putExtra("vse", listVse.get(i));
                    Activity activity = (Activity) context;
                    activity.startActivity(intent);
                }
            });


        }


    }

    ArrayList<Vse> listVse;

    public RVNewsAdapter(Context context, ArrayList<Vse> listVse) {
        this.listVse = listVse;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        vse = new Vse();
        vse = listVse.get(i);
        personViewHolder.title_news.setText(vse.getTitle_news());

        if (!TextUtils.isEmpty(vse.getImage_news()))
            Picasso.with(context).load(vse.getImage_news()).error(R.drawable.news_2x).resize(110, 110).into(personViewHolder.image_news);
        else personViewHolder.image_news.setImageResource(R.drawable.news_2x);
    }


    @Override
    public int getItemCount() {
        return listVse.size();
    }
}
