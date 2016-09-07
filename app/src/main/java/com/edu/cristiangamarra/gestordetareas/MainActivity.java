package com.edu.cristiangamarra.gestordetareas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText  nombreEditex;
    EditText emaileditex;
    //EditText telefonoeditex;

    Button guardarBtn;
    ListView usuariosListView;
    List<String> usuarios = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreEditex = (EditText) findViewById(R.id.editTextNombre);
        emaileditex = (EditText) findViewById(R.id.editTextEmail);
      //  telefonoeditex = (EditText) findViewById(R.id.editTextTelefono);
        guardarBtn = (Button) findViewById(R.id.buttonBoton);


        usuariosListView = (ListView)findViewById((R.id.listViewLista));

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,usuarios);

        usuariosListView.setAdapter(adapter);


        guardarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreEditex.getText().toString();
                String email = emaileditex.getText().toString();
               // String telefono = telefonoeditex.getText().toString();

                if (!validarNombre(nombre)) {

                    nombreEditex.setError(getString(R.string.nombre_error));

                }else if (!validarEmail(email)) {
                    emaileditex.setError(getString(R.string.email_error));

               // }else if(!validarTelefono(telefono)) {
                  //  telefonoeditex.setError(getString(R.string.telefono_error));


                }else {
                    String mensaje = getString(R.string.bienvenido) + nombre + "" + email;
                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();


                    String datos = nombre + " " + email;
                    usuarios.add(datos);
                    adapter.notifyDataSetChanged();


                    nombreEditex.setText(null);
                    emaileditex.setText(null);
                   // telefonoeditex.setText(null);

                }


            }
        });
    }

    private boolean validarNombre(String nombre) {
        return !nombre.equals("");


    }
    private  boolean validarEmail(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();




    }
}
