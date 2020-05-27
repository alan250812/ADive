package com.example.json_main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import static android.bluetooth.BluetoothDevice.ACTION_ACL_CONNECTED;
import static android.bluetooth.BluetoothDevice.ACTION_PAIRING_REQUEST;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void Blues(AcceptThread acceptThread){
    BluetoothAdapter ConBlue = BluetoothAdapter.getDefaultAdapter();
    if (ConBlue == null){
        Intent trys = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivity(trys);
        }
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

    /**
     * A placeholder fragment containing a simple view.
     */
    @SuppressLint("ValidFragment")
    public class PlaceholderFragment extends Fragment implements View.OnClickListener {

        private TextView resultView;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Button btn = (Button) rootView.findViewById(R.id.btnSubmit);
            btn.setOnClickListener(this);
            resultView = (TextView) rootView.findViewById(R.id.json_result);
            return rootView;
        }

        // Damos de alta los usuarios en nuestra aplicación
        public void alta(View v) {
            try {

                AdminSQLiteOpenHelper ad = new AdminSQLiteOpenHelper(null,"root",null,1);

                SQLiteDatabase bd = ad.getWritableDatabase();

                EditText etLectura1 = (EditText)getActivity().findViewById(R.id.LecturaID);
                EditText etfecha1 = (EditText)getActivity().findViewById(R.id.Fecha_Etiqueta);
                EditText etInver1 = (EditText)getActivity().findViewById(R.id.invernadero);
                EditText etConglo1 = (EditText)getActivity().findViewById(R.id.conglomerado);
                EditText etPlanta1 = (EditText)getActivity().findViewById(R.id.planta_pimiento);
                EditText etCiclo1 = (EditText)getActivity().findViewById(R.id.ciclo_agricola);

                int l,i,con,plant,ciclo;
                String f;
                l = Integer.parseInt(etLectura1.getText().toString());
                f = etfecha1.getText().toString();
                i = Integer.parseInt(etInver1.getText().toString());
                con = Integer.parseInt(etConglo1.getText().toString());
                plant = Integer.parseInt(etPlanta1.getText().toString());
                ciclo = Integer.parseInt(etCiclo1.getText().toString());

                ContentValues registro = new ContentValues();

                registro.put("LecturaId",l);
                registro.put("Fecha_Lectura",f);
                registro.put("Invernadero",i);
                registro.put("Conglomerado",con);
                registro.put("Planta",plant);
                registro.put("ciclo",ciclo);



                // los inserto en la base de datos
                bd.insert("tableishion1", null, registro);

                bd.close();

                // ponemos los campos a vacío para insertar el siguiente usuario
                etLectura1.setText(""); etfecha1.setText(""); etInver1.setText(""); etConglo1.setText("");
                etPlanta1.setText("");  etCiclo1.setText("");

                Context context = getApplicationContext();
                CharSequence text = "Datos Guardados!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }catch (Exception e){

            }



        }

        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                //se verifica que hubo clicl en el boton
                case R.id.btnSubmit:

                    try {

                        AdminSQLiteOpenHelper ad = new AdminSQLiteOpenHelper(null,"root",null,2);

                        SQLiteDatabase bd = ad.getWritableDatabase();

                        EditText etLectura1 = (EditText)getActivity().findViewById(R.id.LecturaID);
                        EditText etfecha1 = (EditText)getActivity().findViewById(R.id.Fecha_Etiqueta);
                        EditText etInver1 = (EditText)getActivity().findViewById(R.id.invernadero);
                        EditText etConglo1 = (EditText)getActivity().findViewById(R.id.conglomerado);
                        EditText etPlanta1 = (EditText)getActivity().findViewById(R.id.planta_pimiento);
                        EditText etCiclo1 = (EditText)getActivity().findViewById(R.id.ciclo_agricola);

                        int l,i,con,plant,ciclo;
                        String f;
                        l = Integer.parseInt(etLectura1.getText().toString());
                        f = etfecha1.getText().toString();
                        i = Integer.parseInt(etInver1.getText().toString());
                        con = Integer.parseInt(etConglo1.getText().toString());
                        plant = Integer.parseInt(etPlanta1.getText().toString());
                        ciclo = Integer.parseInt(etCiclo1.getText().toString());

                        ContentValues registro = new ContentValues();

                        registro.put("LecturaId",l);
                        registro.put("Fecha_Lectura",f);
                        registro.put("Invernadero",i);
                        registro.put("Conglomerado",con);
                        registro.put("Planta",plant);
                        registro.put("ciclo",ciclo);



                        // los inserto en la base de datos
                        bd.insert("tableishion1", null, registro);

                        bd.close();

                        // ponemos los campos a vacío para insertar el siguiente usuario
                        etLectura1.setText(""); etfecha1.setText(""); etInver1.setText(""); etConglo1.setText("");
                        etPlanta1.setText("");  etCiclo1.setText("");

                        Context context = getApplicationContext();
                        CharSequence text = "Datos Guardados!";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }catch (Exception e){

                    }
                    /*String result;
                    result = "";
                    EditText etLectura = (EditText)getActivity().findViewById(R.id.LecturaID);
                    EditText etfecha = (EditText)getActivity().findViewById(R.id.Fecha_Etiqueta);
                    EditText etInver = (EditText)getActivity().findViewById(R.id.invernadero);
                    EditText etConglo = (EditText)getActivity().findViewById(R.id.conglomerado);
                    EditText etPlanta = (EditText)getActivity().findViewById(R.id.planta_pimiento);
                    EditText etCiclo = (EditText)getActivity().findViewById(R.id.ciclo_agricola);

                    int l,i,con,plant,ciclo;
                    String f;
                    l = Integer.parseInt(etLectura.getText().toString());
                    f = etfecha.getText().toString();
                    i = Integer.parseInt(etInver.getText().toString());
                    con = Integer.parseInt(etConglo.getText().toString());
                    plant = Integer.parseInt(etPlanta.getText().toString());
                    ciclo = Integer.parseInt(etCiclo.getText().toString());

                    JSONObject json = new JSONObject();
                    //JSONArray jsarray = new JSONArray();
                    try{
                        json.put("LecturaId",l);
                        json.put("Fecha_Lectura",f);
                        json.put("Invernadero",i);
                        json.put("Conglomerado",con);
                        json.put("Planta",plant);
                        json.put("ciclo",ciclo);
                        //alta(v);

                        //jsarray.put("hola");
                        //jsarray.put(100);
                        //jsarray.put(-10);

                        //json.put("array",jsarray);
                    }catch (JSONException error){}


                    resultView.setText(json.toString());*/
                    //return alta(v);
                    break;
            }

        }
    }

}