package com.hfad.labnotetoselfapp;

import java.util.ArrayList;

public class Databse {

    private static ArrayList<Note> allNotes;

    public static ArrayList<Note> getNotes() {
        if (allNotes == null) {
            loadData();
        }
        return allNotes;
    }

    public static void loadData()
    {

        allNotes = new ArrayList<Note>();
        allNotes.add(new Note("Study for Calc Final", "Idea", "Houck’s exam is Friday Dec 16 th – start reviewing a week before hand."));
        allNotes.add(new Note("Finish Quizzo App", "Important", "Dr. Ryan wants it complete for Thursday so she can show us something"));
        allNotes.add(new Note("Complete Note to Self Lab", "TO-DO", "Dr. Ryan wants it complete so we can review in class tomorrow"));
        allNotes.add(new Note("Design Quiz", "TO-DO", "Design Quiz due friday. Should start working on it tonight if I get time."));
        allNotes.add(new Note("Reading Quiz", "Idea", "Reading Quiz on Friday. I should study tomorrow."));
        allNotes.add(new Note("Apply for Jobs", "TO-DO", "Need to get job soon so I should be applying yesterday"));
        allNotes.add(new Note("Shopping", "Idea", "Need milk, water, paper plates, tissues, etc..."));
        allNotes.add(new Note("Database Project", "Important", "Due Monday so I should do it tonight or tomorrow so we can be ahead"));
        allNotes.add(new Note("Pay Insurance", "TO-DO", "Money due in less then month. Should make sure I have enough money for payment."));
        allNotes.add(new Note("Work", "Important", "Starts at 7 and goes to 10, should get ready soon"));
    }

    public static void addNote(Note n)
    {
        allNotes.add(n);
    }
}