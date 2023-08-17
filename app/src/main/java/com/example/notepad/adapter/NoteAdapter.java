package com.example.notepad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notepad.R;
import com.example.notepad.model.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    List<Note> notes;
    LayoutInflater inflater;

    public NoteAdapter(Context ctx,List<Note> notes){
        this.notes=notes;
        this.inflater=LayoutInflater.from(ctx);

    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.txtTitle);
        }
    }

    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.note,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, int position) {
        holder.title.setText(notes.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
