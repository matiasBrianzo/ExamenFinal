package usuario.example.examenfinal.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import usuario.example.examenfinal.databinding.FragmentGalleryBinding;
import usuario.example.examenfinal.modelo.Lugar;


public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private GalleryViewModel vm;
    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vm.getListaMutable().observe(getViewLifecycleOwner(), new Observer<List<Lugar>>() {
            @Override
            public void onChanged(List<Lugar> lugars) {
                RecyclerView rv = binding.rvLugares;
                GridLayoutManager glm = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
                rv.setLayoutManager(glm);
                LugarAdapter lad = new LugarAdapter(getContext(), lugars, getLayoutInflater());
                rv.setAdapter(lad);
            }
        });
        vm.armarLista();

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}