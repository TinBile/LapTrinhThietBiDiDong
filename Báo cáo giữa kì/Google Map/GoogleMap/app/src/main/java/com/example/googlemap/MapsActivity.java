package com.example.googlemap;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        //ánh sạ các layout của ggmap
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng tin = new LatLng(10.799580, 106.673916);//tạo một vị trí có vĩ độ và kinh độ
        mMap.addMarker(new MarkerOptions().position(tin).title("Trường Đại Học Gia Định")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.tin1))
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tin,10));  // phóng to 18 lần
        //di chuyển màn hình tới vị trí của tên title
     //  mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);/* bảng đồ vệ tinh*/
       // mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);/* bảng đồ địa hình*/
       mMap.setMyLocationEnabled(true);//hiển thị vị trí hiện tại
        LatLng diadiemmoi = new LatLng(10.797943, 106.671818);
        mMap.addMarker(new MarkerOptions().position(diadiemmoi).title("Bệnh Viện Phú Nhuận")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.tin1))
        );
        mMap.addPolyline(new PolylineOptions().add((tin),new LatLng(10.799666, 106.672950),
                new LatLng(10.797854, 106.672741),diadiemmoi));

    }
}

