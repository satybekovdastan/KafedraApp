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


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {
    Context context;
//    DataHelper dataHelper;
    Vse vse;
    boolean status;
    public class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView personName;
        TextView personCategori;
        ImageView personPhoto;
        TextView personPrice;
        TextView personRegion;
        String TAG = "TAG";

        PersonViewHolder(final View itemView) {
            super(itemView);
//            cv = (CardView) itemView.findViewById(R.id.cv);
            personName = (TextView) itemView.findViewById(R.id.person_name);
            personCategori = (TextView) itemView.findViewById(R.id.person_categori);
            personPhoto = (ImageView) itemView.findViewById(R.id.person_avatar);
            personPrice = (TextView) itemView.findViewById(R.id.person_price);
            personRegion = (TextView) itemView.findViewById(R.id.person_city);


//            dataHelper = new DataHelper(context);




            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int i = getAdapterPosition();

                    Intent intent = new Intent(context, PersonActivity.class);
                    intent.putExtra("vse", listVse.get(i));
                    Activity activity = (Activity) context;
                    activity.startActivity(intent);

                }


            });


        }


    }

    ArrayList<Vse> listVse;

    public RVAdapter(Context context, ArrayList<Vse> listVse) {
        this.listVse = listVse;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_prepod, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        vse = new Vse();
        vse = listVse.get(i);
//        boolean status = dataHelper.getStatusIzbrannoe(vse.getId());


            personViewHolder.personName.setText(vse.getFio());



           personViewHolder.personPrice.setText(vse.getEmail());

        personViewHolder.personCategori.setText(vse.getPosition());

        personViewHolder.personRegion.setText(vse.getJob_training());

        if (!TextUtils.isEmpty(vse.getPhoto_url()))
            Picasso.with(context).load(vse.getPhoto_url()).error(R.drawable.place_holder).resize(110, 110).into(personViewHolder.personPhoto);
        else personViewHolder.personPhoto.setImageResource(R.drawable.place_holder);
    }



    @Override
    public int getItemCount() {
        return listVse.size();
    }
}
