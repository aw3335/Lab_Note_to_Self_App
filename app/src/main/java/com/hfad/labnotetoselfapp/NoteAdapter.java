package com.hfad.labnotetoselfapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{

    private ArrayList<Note> noteList;

    public NoteAdapter()
    {
        noteList = Databse.getNotes();
        System.out.println("Done making list");
    }

    //Create empty view of a single row
    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note, parent, false);

        System.out.println("Done Creating a View");
        return new NoteViewHolder(view);

    }
    @Override
    public int getItemCount() {
        return noteList.size();
    }

    //Binds data to an empty row view
    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) //Position is the index in the list that you want to show
    {
        Note vd = noteList.get(position);
        holder.setData(vd, position);


        System.out.println("Done Populating a Row: " + position + "" + vd.getTitle());

    }



    class NoteViewHolder extends RecyclerView.ViewHolder
    {

        private TextView tvTitle;
        private TextView tvStatus;
        private TextView tvDesc;
        private ImageView imvDelete;

        private int currentPositionInList = -1;
        private Note currentDest = null;

        public NoteViewHolder(@NonNull View itemView)
        {
            super(itemView);
           tvTitle = itemView.findViewById(R.id.txt_title);
           tvStatus = itemView.findViewById(R.id.txt_status);
           tvDesc = itemView.findViewById(R.id.txt_text);
            imvDelete = itemView.findViewById(R.id.img_delete);

            imvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    noteList.remove(currentPositionInList);
                    notifyItemRemoved(currentPositionInList);
                    notifyItemRangeChanged(currentPositionInList, noteList.size());
                }
            });
        }

        public void setData(Note vd, int position)
        {
            tvTitle.setText(vd.getTitle());
            tvStatus.setText(vd.getStatus());
            tvDesc.setText(vd.getDescription());
            currentPositionInList = position;
            currentDest = vd;

        }

    }
}
