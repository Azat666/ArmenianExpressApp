package com.example.student.arminianexpresapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.student.arminianexpresapp.R;
import com.example.student.arminianexpresapp.activity.InfoActivity;

public class AdapterInfo extends RecyclerView.Adapter<AdapterInfo.ImageHolder> {

    private Context context;
    private int[] a;

    public AdapterInfo(Context context, int[] a) {
        this.context = context;
        this.a = a;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageHolder holder, final int position) {
        holder.imageView.setImageResource(a[position]);

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ImageHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageHolder(final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_rec);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageView mainImage = ((InfoActivity) context).findViewById(R.id.image_info);
                    mainImage.setImageDrawable(imageView.getDrawable());
                }
            });
        }
    }
}
