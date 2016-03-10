package com.ahorrolibre.al01;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private ArrayAdapter<String> mTandacardAdapter;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =inflater.inflate(R.layout.fragment_main, container, false);

        //Creating dummy data to populate the listView before we start using a api key and parsing JSON
        String [] tandacardNameArray = {
                "Nomtanda 1",
                "Nomtanda 2",
                "Nomtanda 3",
                "Nomtanda 5",
                "Nomtanda 6",
                "Nomtanda 7",
        };

        //PREGUNTA ALEX.. me da un warning aqui "Explicit Type Argument can be replaced with <>" pero el detalle lee..
        // "such <> syntax is not supported under Java 1.6 or earlier JVM's"
        // lo dejo asi?... y que es un JVM?
        List<String> tandacardList = new ArrayList<String>(
                Arrays.asList(tandacardNameArray));

        //Now creating the ArrayAdapter to populate the tandacard list item view with dummy data
        // BUT only doing the Tanda Name for now... later need to know how to change other data with ArrayAdapter

        mTandacardAdapter =
                new ArrayAdapter<String>(
                        // The current context (this fragment's parent activity)
                        getActivity(),
                        // ID of list item layout
                        R.layout.list_item_tandacard,
                        // ID of the only textview we are populating at this point, with the Tanda name (the rest stay the same)
                        R.id.list_item_tandacard_name,
                        //Tandacard names
                        tandacardList);

        //Get a reference to the ListView, and attaching the adapter
        ListView listView = (ListView) rootView.findViewById(
                R.id.listview_tanda_card);
        listView.setAdapter(mTandacardAdapter);

        return rootView;




    }
}