package com.yair.pickachu.ui.historyparcels;

import android.app.Application;

import com.yair.pickachu.Entities.Parcel;
import com.yair.pickachu.Model.ParcelRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class HistoryParcelsViewModel extends AndroidViewModel {
    private ParcelRepository repository;
    private LiveData<List<Parcel>> allparcels;

    public HistoryParcelsViewModel(@NonNull Application application) {
        super(application);
        repository = new ParcelRepository(getApplication());
        repository.getHistoryParcels();
        allparcels = repository.getAllParcels();
    }

    public LiveData<List<Parcel>> getAllparcels() {
        return allparcels;
    }
}
