package com.example.arce.easy_cook;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MenuUser2 extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    Button btnBusquedaEspecifica;
    Button btnAgregar;
    Button btnBusqueda,btnBusquedaNombre;
    Button btnMostrarReceta;
    String nombre,correo,inicio;
    String idUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_user2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



       correo= getIntent().getStringExtra("correo");
        idUsuario=getIntent().getStringExtra("id_usuario");
        btnBusquedaEspecifica= (Button)findViewById(R.id.btnBusEspecifica);
        btnAgregar= (Button)findViewById(R.id.btnAgregar);
        btnBusqueda= (Button)findViewById(R.id.btnBusqueda);
        btnBusquedaNombre=(Button)findViewById(R.id.btnBusquedaNombre);
        btnMostrarReceta = (Button)findViewById(R.id.btnMostrarReceta);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        nombre= getIntent().getStringExtra("nombreUser");
        inicio= getIntent().getStringExtra("inicio");



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MenuUser2.this, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_perfil) {
            Intent busq = new Intent(MenuUser2.this , PerfilUSer.class);
            busq.putExtra("nombreUser", nombre);
            busq.putExtra("correo",correo);
            busq.putExtra("inicio",inicio);
            busq.putExtra("id_usuario", idUsuario);
            startActivity(busq);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void goLoginScreen() {
        Intent intent=new Intent(this,Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void Buscar(View boton) {
        Intent busq = new Intent(MenuUser2.this, BusquedaTipoReceta.class);
        startActivity(busq);
    }

    public void Agregar(View boton) {
        Intent busq = new Intent(MenuUser2.this, InsReceta.class);
        startActivity(busq);
    }

    public void BuscarPersonalizada(View boton) {
        Intent busq = new Intent(MenuUser2.this, BusquedaEspecificaReceta.class);
        startActivity(busq);
    }

    public void BuscarNombre(View boton) {
        Intent busq = new Intent(MenuUser2.this, Busqueda.class);
        startActivity(busq);
    }

    public void MostrarReceta(View boton) {
        Intent busq = new Intent(MenuUser2.this, Mostrar_receta.class);
        startActivity(busq);
    }
}
