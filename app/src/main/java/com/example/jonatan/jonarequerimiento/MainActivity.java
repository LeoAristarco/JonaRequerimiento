package com.example.jonatan.jonarequerimiento;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FragmentDetalleNumero.OnFragmentInteractionListener,
        FragmentList.OnFragmentInteractionListener, IComunicaFragments {

    FragmentList fragmentList;

    FragmentDetalleNumero fragmentDetalleNumero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentList = new FragmentList();

        fragmentDetalleNumero= new FragmentDetalleNumero();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.idContenedorFragment, fragmentList)
                .commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void OnClick(View view) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.buttonA: fragmentTransaction.replace(R.id.idContenedorFragment,fragmentList);
                break;
            case R.id.buttonB: fragmentTransaction.replace(R.id.idContenedorFragment,fragmentDetalleNumero);
                break;
        }

        fragmentTransaction.commit();
    }

    @Override
    public void enviarNumero(String numero) {

        Bundle paquete=new Bundle();
        paquete.putString("numero",numero);
        fragmentDetalleNumero.setArguments(paquete);

        //cargo el fragment en el Activity
        getSupportFragmentManager().beginTransaction().
                replace(R.id.idContenedorFragment,fragmentDetalleNumero).
                addToBackStack(null).commit();
    }

}
