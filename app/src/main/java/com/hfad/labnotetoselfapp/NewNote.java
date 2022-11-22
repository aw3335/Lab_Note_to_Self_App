package com.hfad.labnotetoselfapp;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class NewNote extends DialogFragment{

    private NoteAdapter note;

    public NewNote(NoteAdapter adNote)
    {
        note = adNote;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.add_new_note, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        EditText edtTitle = dialogView.findViewById(R.id.titleText);
        Spinner tvStatus = dialogView.findViewById(R.id.status);
        TextView edtDescr = dialogView.findViewById(R.id.editTextDesc);

        Button btnDone = dialogView.findViewById(R.id.btnDone);
        Button btnCancel = dialogView.findViewById(R.id.btnCancel);


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note1 = new Note(edtTitle.getText().toString(), tvStatus.getSelectedItem().toString(), edtDescr.getText().toString());
                Databse.addNote(note1);
                note.notifyItemInserted(Databse.getNotes().size());
                note.notifyItemRangeChanged(0, Databse.getNotes().size());
                dismiss();
            }
        });

        builder.setView(dialogView);

        return builder.create();
    }
}
