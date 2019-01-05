package com.example.user.cioscarr.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.user.cioscarr.Adapter.TabPageAdapter;
import com.example.user.cioscarr.R;

public class Booking_detail extends main_navDrawer {
    private TabPageAdapter tabPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Booking Detail");
        LayoutInflater inflater=(LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        View contentView=inflater.inflate(R.layout.activity_booking_detail,null,false);
        drawer.addView(contentView,0);

        tabPageAdapter=new TabPageAdapter(getSupportFragmentManager());
        mViewPager =(ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout= (TabLayout)findViewById(R.id.tabLayout) ;
        tabLayout.setupWithViewPager(mViewPager);


    }

    private void setupViewPager(ViewPager viewPager){
        TabPageAdapter adapter=new TabPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab_car_fragment(),"Car Detail");
        adapter.addFragment(new Tab_supplier_fragment(),"Supplier Detail");
        viewPager.setAdapter(adapter);
    }
}
