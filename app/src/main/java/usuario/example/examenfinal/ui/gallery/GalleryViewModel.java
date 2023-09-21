package usuario.example.examenfinal.ui.gallery;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import usuario.example.examenfinal.modelo.Lugar;


public class GalleryViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<List<Lugar>> listaMutable;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        this.context= application.getApplicationContext();
    }

    public LiveData<List<Lugar>> getListaMutable() {
        if (listaMutable == null ) {
            listaMutable= new MutableLiveData<>();
        }
        return listaMutable;
    }

    public void armarLista() {
        List<Lugar> lista=new ArrayList<>();
        lista.add(new Lugar("LA TOMA", " capital del mármol ónix", "https://i.pinimg.com/originals/80/6d/ce/806dce66a7ed780e14da5a4b3e23234a.jpg", LocalTime.of(1,23,21)));
        lista.add(new Lugar("MERLO", "Tu Hotel en Merlo.", "https://wallpapers.com/images/featured/plzcoaffexgf4h81.jpg", LocalTime.of(2,23,21)));
        lista.add(new Lugar("BALDE", "Agua Termales", "https://wallpapers.com/images/featured/plzcoaffexgf4h81.jpg", LocalTime.of(3,23,21)));
        lista.add(new Lugar("LA TOMA", " capital del mármol ónix", "https://i.pinimg.com/originals/80/6d/ce/806dce66a7ed780e14da5a4b3e23234a.jpg", LocalTime.of(1,23,21)));
        lista.add(new Lugar("MERLO", "Tu Hotel en Merlo.", "https://wallpapers.com/images/featured/plzcoaffexgf4h81.jpg", LocalTime.of(2,23,21)));
        lista.add(new Lugar("BALDE", "Agua Termales", "https://wallpapers.com/images/featured/plzcoaffexgf4h81.jpg", LocalTime.of(3,23,21)));
        listaMutable.setValue(lista);
    }


}