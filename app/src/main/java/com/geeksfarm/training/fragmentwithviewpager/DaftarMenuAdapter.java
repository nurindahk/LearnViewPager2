package com.geeksfarm.training.fragmentwithviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DaftarMenuAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MenuMakanan.Makanan> daftarMakanan;

    public DaftarMenuAdapter(Context ctx, ArrayList<MenuMakanan.Makanan> data){
        this.context = ctx;
        this.daftarMakanan = data;

    }

    @Override
    public int getCount() {
        return daftarMakanan.size();
    }

    @Override
    public MenuMakanan.Makanan getItem(int position){
        MenuMakanan.Makanan makanan = (MenuMakanan.Makanan) daftarMakanan.get(position);
        return makanan;
    }
    /*public Object getItem(int position) {
        return daftarMakanan.get(position);
    }
*/
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.list_view_content_second_fragment,parent,false);
        }

        MenuMakanan.Makanan makanan = (MenuMakanan.Makanan) getItem(position);

        TextView tvNamaMakana = convertView.findViewById(R.id.tv_nama_makanan);
        TextView tvHarga = convertView.findViewById(R.id.tv_harga);

        tvNamaMakana.setText(makanan.getNama());
        tvHarga.setText(makanan.getHarga());

        return convertView;
    }
}
