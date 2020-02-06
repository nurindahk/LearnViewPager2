package com.geeksfarm.training.fragmentwithviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private MyAdapter myAdapter;

    private TabLayout tabMenu;

    ArrayList<String> menuTitleData = new ArrayList<>();
    ArrayList<String> data = new ArrayList<>();

    ArrayList<MenuMakanan> kumpulanMenuMakanan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateTitle();
        generateData();

        generateMenu();


        viewPager = findViewById(R.id.view_pager);
        //myAdapter = new MyAdapter(getSupportFragmentManager()); // buat object adapter
        //myAdapter = MyAdapter.newInstance(getSupportFragmentManager(),menuTitleData,data);
        myAdapter = MyAdapter.newInstance(getSupportFragmentManager(),kumpulanMenuMakanan);


        viewPager.setAdapter(myAdapter);

        tabMenu = findViewById(R.id.tab_menu);
        tabMenu.setupWithViewPager(viewPager);
    }

    // membuat dummy title data
    private void generateTitle(){
        menuTitleData.add("Promo");
        menuTitleData.add("A La Carte");
        menuTitleData.add("Paket Hemat");
        menuTitleData.add("Ayam");
        menuTitleData.add("Makanan");
//        menuTitleData.add("Minuman");

    }

    private void generateData(){
        data.add("Data 1");
        data.add("Data 2");
        data.add("Data 3");
        data.add("Data 4");
        data.add("Data 5");
        data.add("Data 6");
    }

    private void generateMenu() {

        ArrayList<MenuMakanan.Makanan> menuAyam = new ArrayList<>();
        menuAyam.add(new MenuMakanan.Makanan("Ayam Goreng", "15000", "Ayam goreng adalah hidangan yang dibuat dari daging ayam dicampur tepung bumbu yang digoreng dalam minyak goreng panas. Beberapa rumah makan siap saji secara khusus menghidangkan ayam goreng", R.drawable.goreng));
        menuAyam.add(new MenuMakanan.Makanan("Ayam Rica-rica", "25000", "Ayam rica-rica adalah salah satu makanan khas Manado, Sulawesi Utara. Kata rica berasal dari bahasa Manado yang berarti atau pedas atau cabai.Resep untuk membuat ayam rica-rica sangat beragam, begitu pula cara memasaknya, persamaannya hanya terletak pada rasanya yang pedas. Ayam rica-rica biasa disajikan dengan nasi dan bahan pelengkap seperti bawang goreng dan mentimun.", R.drawable.ayamricarica));
        menuAyam.add(new MenuMakanan.Makanan("Ayam Bakar", "35000", "Ayam bakar adalah sebuah hidangan Asia Tenggara Maritim, terutama hidangan Indonesia atau Malaysia, dari ayam yang dipanggang di atas arang.", R.drawable.ayambakar));

        ArrayList<MenuMakanan.Makanan> menuMie = new ArrayList<>();
        menuMie.add(new MenuMakanan.Makanan("Mie Goreng", "15000", "Mi goreng berarti mi yang digoreng adalah makanan yang populer dan digemari di Indonesia, Malaysia, dan Singapura. Mi goreng terbuat dari mi kuning yang digoreng dengan sedikit minyak goreng, dan ditambahkan bawang putih, bawang merah, udang serta daging ayam atau daging sapi, irisan bakso, cabai, sayuran, tomat, telur ayam, dan acar.", R.drawable.miegoreng));
        menuMie.add(new MenuMakanan.Makanan("Mie Rica-rica", "15000", "Mie dicampur dengan sambal rica rica", R.drawable.mierica));
        menuMie.add(new MenuMakanan.Makanan("Mie Kuah", "15000", "Mi kuah merujuk kepada berbagai sup dengan mi dan bahan makanan lainnya yang disajikan dalam kuah bening", R.drawable.miekuah));

        ArrayList<MenuMakanan.Makanan> minuman = new ArrayList<>();
        minuman.add(new MenuMakanan.Makanan("Air Mineral", "10000", "Aqua" , R.drawable.air));
        minuman.add(new MenuMakanan.Makanan("Soft Drink", "15000", "Minuman ringan merupakan minuman yang tidak mengandung alkohol, dan lawan kata dari minuman keras. Pada umumnya, istilah ini hanya digunakan untuk minuman dingin (kopi, teh panas, coklat panas tidak dianggap sebagai minuman ringan).", R.drawable.soft));
        minuman.add(new MenuMakanan.Makanan("Jus", "20000", " jus adalah cairan yang terdapat secara alami dalam buah-buahan. Sari buah populer dikonsumsi manusia sebagai minuman.", R.drawable.jus));


        kumpulanMenuMakanan.add(new MenuMakanan("Ayam", menuAyam));
        kumpulanMenuMakanan.add(new MenuMakanan("Mie", menuMie));
        kumpulanMenuMakanan.add(new MenuMakanan("Minuman", minuman));

    }

}
