package com.example.student.arminianexpresapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.arminianexpresapp.R;
import com.example.student.arminianexpresapp.adapter.ProduktAdapter;
import com.example.student.arminianexpresapp.models.ProduktModel;
import com.example.student.arminianexpresapp.proviader.UserProvider;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpresFragment extends Fragment {

    public ProduktAdapter produktAdapter;
    RecyclerView recyclerView;

    public static List<ProduktModel> listEF = UserProvider.list;

    public ExpresFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_expres, container, false);
        recyclerView = v.findViewById(R.id.recy_all);
        produktAdapter = new ProduktAdapter(getContext(), listEF);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(produktAdapter);

        return v;
    }

    public void updateAdapter() {
        recyclerView.setAdapter(new ProduktAdapter(getContext(), listEF));
    }

}
