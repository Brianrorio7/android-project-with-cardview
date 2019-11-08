package com.example.rorio;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
   private LayoutInflater inflater;
   private String[] sTitles;
   private String[] sContents;
   Adapter(Context context, String[] titles, String[] contents){
       this.inflater = LayoutInflater.from(context);
       this.sTitles = titles;
       this.sContents = contents;

   }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view, parent, false);
       ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       String title = sTitles[position];
       String content = sContents[position];
       holder.storyTitles.setText(title);
       holder.storyContents.setText(content);


    }

    @Override
    public int getItemCount() {
        return sTitles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       TextView storyTitles, storyContents;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), Details.class);
                    i.putExtra("titleOfStory", sTitles[getAdapterPosition()]);
                    i.putExtra("contentOfStory", sContents[getAdapterPosition()]);
                    v.getContext().startActivity(i);
                }
            });
            storyTitles = itemView.findViewById(R.id.storyTitle);
            storyContents = itemView.findViewById(R.id.storyContent);
        }
    }
}
