package dev.smart.e_akademik.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import dev.smart.e_akademik.R;
import dev.smart.e_akademik.model.User;

/**
 * Created by Fnatic Anxdre on 3/31/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder>{
    private ArrayList<User> android;

    public Adapter(ArrayList<User> android) {
        this.android = android;
    }

    @Override
    public Adapter.Viewholder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_jadwal, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.Viewholder holder, int position) {
        holder.tv_name.setText(android.get(position).getName());
        holder.tv_api_level.setText(android.get(position).getApi());
        holder.tv_version.setText(android.get(position).getVer());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView tv_name,tv_version,tv_api_level;
        public Viewholder(View itemView) {
            super(itemView);

            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_version = (TextView)itemView.findViewById(R.id.tv_version);
            tv_api_level = (TextView)itemView.findViewById(R.id.tv_api_level);
        }
    }
}
