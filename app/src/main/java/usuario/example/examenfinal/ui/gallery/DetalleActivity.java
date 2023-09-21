package usuario.example.examenfinal.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import usuario.example.examenfinal.databinding.ActivityDetalleBinding;
import usuario.example.examenfinal.modelo.Lugar;


public class DetalleActivity extends AppCompatActivity {

    private ActivityDetalleBinding binding;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context=getApplicationContext();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Lugar lugar = (Lugar) bundle.getSerializable("lugar");

        String hora = lugar.getHoraApertura().toString();
        TextView horaDetalle = binding.tvhorario;

        Glide.with(context)
                .load(lugar.getFoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imagen);

        horaDetalle.setText(hora);




    }
}