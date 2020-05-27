package com.example.json_main;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String nombre, CursorFactory factory, int version) {

        /* super(context, nombre, factory, version); */
        super(context,nombre,factory,version);

    }

    //spublic AdminSQLiteOpenHelper(MainActivity.PlaceholderFragment placeholderFragment, String root, int i) {
        //super(placeholderFragment, root, i);
    //}

    @Override

    public void onCreate(SQLiteDatabase db) {
        /*
        EditText etLectura = (EditText)getActivity().findViewById(R.id.LecturaID);
                    EditText etfecha = (EditText)getActivity().findViewById(R.id.Fecha_Etiqueta);
                    EditText etInver = (EditText)getActivity().findViewById(R.id.invernadero);
                    EditText etConglo = (EditText)getActivity().findViewById(R.id.conglomerado);
                    EditText etPlanta = (EditText)getActivity().findViewById(R.id.planta_pimiento);
                    EditText etCiclo = (EditText)getActivity().findViewById(R.id.ciclo_agricola);
         */

        //aquí creamos la tabla
        db.execSQL("create table tableishion1(LecturaID integer primary key, Fecha_Etiqueta date, invernadero inteher, conglomerado integer, planta_pimiento integer, ciclo_agricola integer)");

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {

        db.execSQL("drop table if exists tableishion1");

        db.execSQL("create table tableishion1(LecturaID integer primary key, Fecha_Etiqueta date, invernadero inteher, conglomerado integer, planta_pimiento integer, ciclo_agricola integer)");

    }

}
