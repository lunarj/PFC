package com.example.visortagsandroid.app;

import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView oText = (TextView) findViewById(R.id.textView);

        String ficherosTexto = "Ficheros de imagenes encontrados:\n\n";

        ArrayList rutasImagenes = new ArrayList();

        /*dameFicheros(Environment.getExternalStorageDirectory().toString(),rutasImagenes);

        for (int i = 0; i < rutasImagenes.size(); i++)
            ficherosTexto += rutasImagenes.get(i);

        oText.setText(ficherosTexto);*/

        oText.setText(Environment.getExternalStorageDirectory().toString());

    }


    @Override
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public static void dameFicheros(String pathInicial, ArrayList rutasImagenes)
    {
        File directorioInicial = new File(pathInicial);
        if (directorioInicial.isDirectory())
        {
            File[] ficheros = directorioInicial.listFiles();
            for (int i = 0; i < ficheros.length; i++)
            {
                if (ficheros[i].isDirectory())
                    dameFicheros(ficheros[i].getPath(), rutasImagenes);
                else {
                    String ext = ficheros[i].getName().substring(ficheros[i].getName().lastIndexOf('.') + 1, ficheros[i].getName().length());
                    if (ext.equals("jpg") || ext.equals("png"))
                        rutasImagenes.add(ficheros[i].getPath());
                }
            }
        }
    }

}
