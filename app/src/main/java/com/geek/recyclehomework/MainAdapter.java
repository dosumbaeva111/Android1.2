package com.geek.recyclehomework;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {


    private ArrayList<Students> list = new ArrayList<>();
    itemClickListener itemClickListener;


    public void addListener(itemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public void addStudents(Students students){
        this.list.add(students);
        notifyDataSetChanged();

    }

    public void removeItem(int position){
        this.list.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.MyViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, surname;
        public MyViewHolder(View View) {
            super(View);
            name = View.findViewById(R.id.name);
            surname = View.findViewById(R.id.surname);
        }

        public void onBind(Students students) {
            name.setText(students.getName());
            surname.setText(students.getSurename());

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    itemClickListener.onLong(getAdapterPosition());
                    return true;
                }
            });
        }
    }

    interface itemClickListener{
        void onLong(int position);
    }


}