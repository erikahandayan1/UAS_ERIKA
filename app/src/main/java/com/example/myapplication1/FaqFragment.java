package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FaqFragment extends Fragment {
     private static final String TAG = "Fragment FAQ";

    public FaqFragment() {
        // empty public constructor
    }

     @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
         View rootView = inflater.inflate(R.layout.word_list, container,false);

         // Create a list of words
         final ArrayList<Word> words = new ArrayList<Word>();
         words.add(new Word("Apa itu Easy Mop ?", "Easy Mop merupakan aplikasi android yang memudah proses rental kendaraan"));
         words.add(new Word("Apa tujuan Easy Mop ?", "Easy Mop diharapkan dapat mempermudah proses rental kendaraan "));
         words.add(new Word("Kapan Easy Mop selesai Dibuat ?", "8 Desember 2019"));
         words.add(new Word("Siapa yang merancang Easy Mop", "Erika Handayani-09031181722007"));
         words.add(new Word("Bagaimana sistem pembayaran Easy Mop?", "pembayaran pada Easy Mop saat ini masih dilakukan secara manual, nota pembayaran dapat dikirim melalui E-mail"));
         words.add(new Word("Ada berapa kendaraan yang disewakan ?", "saat ini terdapat 3 mobil dan 3 motor"));

         // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
         // adapter knows how to create list items for each item in the list.
         WordAdapter adapter = new WordAdapter(getActivity(),words, R.color.colorList1);

         // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
         // There should be a {@link ListView} with the view ID called list, which is declared in the
         // activity_faq.xml layout file.
         ListView listView = (ListView) rootView.findViewById(R.id.list);

         // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
         // {@link ListView} will display list items for each {@link Word} in the list.
         listView.setAdapter(adapter);

         return rootView;
     }
}
