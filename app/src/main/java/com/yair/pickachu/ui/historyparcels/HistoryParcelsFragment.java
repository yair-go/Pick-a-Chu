package com.yair.pickachu.ui.historyparcels;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yair.pickachu.Entities.Parcel;
import com.yair.pickachu.R;
import com.yair.pickachu.ui.ParcelsAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryParcelsFragment extends Fragment {

    private HistoryParcelsViewModel mViewModel;
    private ParcelsAdapter mAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    public static HistoryParcelsFragment newInstance() {
        return new HistoryParcelsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.history_parcels_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) getView().findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ParcelsAdapter(getContext());
        recyclerView.setAdapter(mAdapter);

        mViewModel = ViewModelProviders.of(this).get(HistoryParcelsViewModel.class);
        mViewModel.getAllparcels().observe(this, new Observer<List<Parcel>>() {
            @Override
            public void onChanged(List<Parcel> parcels) {
                mAdapter.setParcels(parcels);
            }
        });
    }

}
