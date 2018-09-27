package com.example.ytole01.recyclerviewwithdepartaments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.BaseViewHolder> {


    private WeakReference<Context> context;
    private List<Item> list = new ArrayList<>();

    public void setList(List<Item> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public Adapter(Context context) {
        this.context = new WeakReference<>(context);
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new TitleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.title, parent, false));
        } else {
            return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getType().equals(Item.Type.TITLE))
            return 0;
        else
            return 1;
    }






    class ItemViewHolder extends BaseViewHolder implements View.OnClickListener {
        TextView name;

        public ItemViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_txt_id);
            itemView.setOnClickListener(this);
        }

        @Override
        void bind(BaseViewHolder holder, int position) {
            if (holder instanceof ItemViewHolder) {
                ItemViewHolder h = (ItemViewHolder) holder;
                Item item = list.get(position);
                h.name.setText(item.getName());
                if (item.isVisible()) {
                    h.itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, (int) context.get().getResources().getDimension(R.dimen.filtr_cell_height)));
                } else {
                    h.itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, 0));
                }
            }
        }

        @Override
        public void onClick(View view) {

        }
    }

    class TitleViewHolder extends BaseViewHolder implements View.OnClickListener {
        TextView title;
        public TitleViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_id);
            itemView.setOnClickListener(this);
        }

        @Override
        void bind(BaseViewHolder holder, int position) {
            if (holder instanceof TitleViewHolder) {
                TitleViewHolder h = (TitleViewHolder) holder;
                Item item = list.get(position);
                h.title.setText(item.getName());
            }
        }

        @Override
        public void onClick(View view) {
            showHide(getAdapterPosition());
        }
    }

    private void showHide(int position) {
        int count = 0;
        for (Item item : list) {
            if (item.getDepartment().equals(list.get(position).getDepartment()) && item.getType().equals(Item.Type.ITEM)) {
                item.setVisible(!item.isVisible());
                count++;
            }
        }
        notifyItemRangeChanged(position + 1, count);
//        notifyDataSetChanged();
    }

    abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(View itemView) {
            super(itemView);
        }

        abstract void bind(BaseViewHolder holder, int position);
    }

}
