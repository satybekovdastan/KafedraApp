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


public class RVSAdapter extends RecyclerView.Adapter<RVSAdapter.PersonViewHolder> {
    Context context;
    DataHelper dataHelper;
    Students vse;
    boolean status;
    public class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView personName;
        TextView personCategori;
        ImageView personPhoto;
        TextView personPrice;
        TextView personRegion;
        String TAG = "TAG";
        ImageView star;

        PersonViewHolder(final View itemView) {
            super(itemView);
//            cv = (CardView) itemView.findViewById(R.id.cv);
            personName = (TextView) itemView.findViewById(R.id.person_name);
            personCategori = (TextView) itemView.findViewById(R.id.person_categori);
            personPhoto = (ImageView) itemView.findViewById(R.id.person_avatar);
            personPrice = (TextView) itemView.findViewById(R.id.person_price);
            personRegion = (TextView) itemView.findViewById(R.id.person_region);


            dataHelper = new DataHelper(context);

            star = (ImageView) itemView.findViewById(R.id.star);
            star.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vse = new Students();
                    int id = getAdapterPosition();
                    vse = listVse.get(id);
                    boolean status = dataHelper.getStatusIzbrannoe(vse.getId());


                    dataHelper.readDataIzbrannoe();

                }
            });


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

    ArrayList<Students> listVse;

    public RVSAdapter(Context context, ArrayList<Students> listVse) {
        this.listVse = listVse;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_student, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        vse = new Students();
        vse = listVse.get(i);
        boolean status = dataHelper.getStatusIzbrannoe(vse.getId());


        personViewHolder.personName.setText(vse.getFio());



        personViewHolder.personPrice.setText(vse.getCourse());

        personViewHolder.personCategori.setText(vse.getGroup());

        if (!TextUtils.isEmpty(vse.getPhoto_students()))
            Picasso.with(context).load(vse.getPhoto_students()).error(R.drawable.place_holder).resize(110, 110).into(personViewHolder.personPhoto);
        else personViewHolder.personPhoto.setImageResource(R.drawable.place_holder);
    }



    @Override
    public int getItemCount() {
        return listVse.size();
    }
}
