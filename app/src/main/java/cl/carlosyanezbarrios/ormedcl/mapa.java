package cl.carlosyanezbarrios.ormedcl;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import cl.carlosyanezbarrios.ormedcl.databinding.ActivityMapaBinding;

public class mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng AndesSalud = new LatLng(-36.61503676834562, -72.10774489427455);
        LatLng PlazaArmas = new LatLng(-36.60649578903192, -72.1033331018263);
        LatLng RedSalud = new LatLng(-36.6078856938415,-72.10216906709594 );
        LatLng HermindaMartin = new LatLng(-36.608282015680075,-72.09201543936898 );
        LatLng Manantial = new LatLng(-36.60248133749946,-72.0996893179846 );

        mMap.addMarker(new MarkerOptions().position(AndesSalud).title("Clínica Andes Salud Chillán"));
        mMap.addMarker(new MarkerOptions().position(RedSalud).title("Centro Medico Red Salud Chillán"));
        mMap.addMarker(new MarkerOptions().position(HermindaMartin).title("Hospital Clínico Herminda Martín Chillán"));
        mMap.addMarker(new MarkerOptions().position(Manantial).title("Centro Medico Manantial"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PlazaArmas,14f));
    }
}