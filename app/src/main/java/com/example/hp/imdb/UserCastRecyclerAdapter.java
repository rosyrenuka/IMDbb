package com.example.hp.imdb;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by HP on 30-03-2018.
 */

public class UserCastRecyclerAdapter extends RecyclerView.Adapter<UserCastRecyclerAdapter.UserCastViewHolder>{


    Context context;
    ArrayList<TopCast.cast> list;

    public UserCastRecyclerAdapter(Context context, ArrayList<TopCast.cast> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public UserCastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cast_layout,parent,false);

        UserCastViewHolder holder = new UserCastViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserCastViewHolder holder, int position) {

        TopCast.cast castList =  list.get(position);

        String path = castList.getCastImage();

        holder.name.setText(castList.getName());
        holder.character.setText(castList.getCharacter());
        Picasso.get().load("https://image.tmdb.org/t/p/w500" + path).into(holder.imageview);
        Log.d("TAGGER",path);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(context,"holder item clicked",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class UserCastViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        ImageView imageview;
        TextView name;
        TextView character;

        public UserCastViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            imageview=itemView.findViewById(R.id.castImage);
            name=itemView.findViewById(R.id.name);
            character=itemView.findViewById(R.id.character);
        }
    }
}
