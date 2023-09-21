package usuario.example.examenfinal.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.time.format.DateTimeFormatter;
import java.util.List;

import usuario.example.examenfinal.R;
import usuario.example.examenfinal.modelo.Lugar;


public class LugarAdapter extends RecyclerView.Adapter<LugarAdapter.ViewHolder>   {
    private Context context;
    private List<Lugar> listLugares;
    private LayoutInflater li;

    public LugarAdapter(Context context, List<Lugar> listLugares, LayoutInflater li) {
        this.context = context;
        this.listLugares = listLugares;
        this.li = li;
    }
    public interface OnItemClickListener {
        void onItemClick(Lugar lugar);
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item_lugar, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Lugar lugar = listLugares.get(position);
        holder.nombre.setText(listLugares.get(position).getNombre());
        holder.descripcion.setText(listLugares.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return listLugares.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre, descripcion, hora;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            nombre= itemView.findViewById(R.id.tvNombre);
            descripcion = itemView.findViewById(R.id.tvDescripcion);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Hola", "onClick: ");
                    Intent intent = new Intent(v.getContext(), DetalleActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("lugar", listLugares.get(getAdapterPosition()));

                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
