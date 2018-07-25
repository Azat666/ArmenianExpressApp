package com.example.student.arminianexpresapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.student.arminianexpresapp.R;
import com.example.student.arminianexpresapp.activity.InfoActivity;
import com.example.student.arminianexpresapp.models.ProduktModel;
import com.example.student.arminianexpresapp.proviader.UserProvider;

import java.util.ArrayList;
import java.util.List;

public class ProduktAdapter extends RecyclerView.Adapter<ProduktAdapter.ViewHolder> implements Filterable {

    private Context context;
    private List<ProduktModel> list;
    private List<ProduktModel> searchList;

    public ProduktAdapter(Context context, List<ProduktModel> list) {
        this.context = context;
        this.list = list;
        searchList = list;
    }

    @Override
    public ProduktAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.produkt_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProduktAdapter.ViewHolder holder, final int position) {
        holder.textType.setText(list.get(position).getType());
        holder.textTitle.setText(list.get(position).getTitle());
        holder.imageId.setImageResource(list.get(position).getImageId()[0]);
        if (list.get(position).isliked) {
            holder.buttonFavorit.setImageResource(R.drawable.ic_favorite);
        }
        if (list.get(position).isToBasket) {
            holder.buttonCart.setImageResource(R.drawable.ic_add_shopping_);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton buttonFavorit;
        ImageButton buttonCart;
        ImageView imageId;
        TextView textTitle;
        TextView textType;

        public ViewHolder(View itemView) {
            super(itemView);
            buttonCart = itemView.findViewById(R.id.button_cart);
            buttonFavorit = itemView.findViewById(R.id.button_favorite);
            imageId = itemView.findViewById(R.id.image_smarphone);
            textTitle = itemView.findViewById(R.id.text_name);
            textType = itemView.findViewById(R.id.text_type);
            buttonFavorit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!list.get(getAdapterPosition()).isliked) {
                        buttonFavorit.setImageResource(R.drawable.ic_favorite);
                        UserProvider.list.get(getAdapterPosition()).isliked = true;
                    } else {
                        buttonFavorit.setImageResource(R.drawable.ic_favorite_border);
                        UserProvider.list.get(getAdapterPosition()).isliked = false;
                    }
                }
            });
            buttonCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!list.get(getAdapterPosition()).isToBasket) {
                        list.get(getAdapterPosition()).isToBasket = true;
                        buttonCart.setImageResource(R.drawable.ic_add_shopping_);
                    } else {
                        list.get(getAdapterPosition()).isToBasket = false;
                        buttonCart.setImageResource(R.drawable.ic_add_shopping_cart_black_24dp);
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i < UserProvider.list.size(); i++) {
                        if (list.get(getAdapterPosition()).getTitle().equals(UserProvider.list.get(i).getTitle())) {
                            UserProvider.position = i;
                        }
                    }
                    Intent intent = new Intent(context, InfoActivity.class);
                    context.startActivity(intent);
                }
            });


        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String searchText = String.valueOf(charSequence);
                if (searchText.isEmpty()) {
                    searchList = list;
                } else {
                    List<ProduktModel> newList = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getTitle().contains(searchText)) {
                            newList.add(list.get(i));
                        }
                    }
                    searchList = newList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = searchList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults filterResults) {
                list = (ArrayList<ProduktModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
