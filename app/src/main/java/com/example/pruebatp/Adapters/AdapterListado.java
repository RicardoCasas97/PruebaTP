package com.example.pruebatp.Adapters;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pruebatp.Entidades.ArrayReference;
import com.example.pruebatp.Entidades.ListaReferencias;
import com.example.pruebatp.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterListado extends RecyclerView.Adapter<AdapterListado.ViewHolder> {

    private List<ArrayReference> referencias;
    private Context context;


    public AdapterListado( Context context) {
        referencias= new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banco_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bank.setText(referencias.get(position).getBank());
        holder.reference.setText(referencias.get(position).getReference());




        try{
           // Log.i("Imagenes",referencias.get(position).getImages().get(0).getUrl3X3());
            if (referencias.get(position).getImages()!=null){
                if (referencias.get(position).getImages().get(0).getUrl3X3()!=null && !TextUtils.isEmpty(referencias.get(position).getImages().get(0).getUrl3X3())){
                    Glide.with(context).load(referencias.get(position).getImages().get(0).getUrl3X3())
                            .centerCrop()
                            .fitCenter()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(holder.imageView);
                }else {
                    holder.imageView.setImageResource(R.drawable.ic_baseline_broken_image_24);
                }
            }else {
                holder.imageView.setImageResource(R.drawable.ic_baseline_broken_image_24);
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void AgregarLista(List<ArrayReference> referencias){
        this.referencias.clear();
        this.referencias.addAll(referencias);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return referencias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView bank,reference;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bank = itemView.findViewById(R.id.bank);
            reference= itemView.findViewById(R.id.reference);
            imageView= itemView.findViewById(R.id.image);

        }
    }
}
