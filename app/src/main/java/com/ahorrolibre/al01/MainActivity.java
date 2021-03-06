package com.ahorrolibre.al01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


//PREGUNTA ALEX... when compiling the Gradle console shows 2 notes.. what's up with this?
//Note: /Users/Rafa/AndroidStudioProjects/AL01/app/src/main/java/com/ahorrolibre/al01/MainActivityFragment.java uses or overrides a deprecated API.
//Note: Recompile with -Xlint:deprecation for details.

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //PREGUNTA ALEX , que podemos hacer con el Floating Action button?
        // pudiera ser un boton que solo sale cuanto tienes tandas pendientes por aceptar?
        // "Acepta la invitacion".. si presionas te sale un pop up con la info de la tanda que estas por aceptar
        // Si aceptas y aun tienes otras invitaciones pendientes por aceptar sigue flotando.. SOLO desaparece cuando no tienes tandas por aceptar
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_tandas) {

        } else if (id == R.id.nav_crearnueva) {

        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_call) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:6641517772"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        } else if (id == R.id.nav_sms) {

            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setType("vnd.android-dir/mms-sms");
            smsIntent.putExtra("address", "6643471607"); //TODO change to 6641111638
            smsIntent.putExtra("sms_body","Pregunta para AhorroLibre..");
            startActivity(smsIntent);
            if (smsIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(smsIntent);

            }

        } else if (id == R.id.nav_email) {

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"rafa@ahorrolibre.com"}); //TODO change to soporte@ahorrolibre.com
            intent.putExtra(Intent.EXTRA_SUBJECT, "Pregunta del AhorroLIbre App");
            intent.putExtra(Intent.EXTRA_TEXT, "Estoy usando el Android App de AhorroLibre"+"\ntengo una pregunta:");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }


        } else if (id == R.id.nav_chat) {
            Uri webpage = Uri.parse("https://www.ahorrolibre.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
