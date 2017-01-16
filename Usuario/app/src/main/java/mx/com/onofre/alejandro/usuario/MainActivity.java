package mx.com.onofre.alejandro.usuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSig = (Button) findViewById(R.id.btnSiguiente);
        Button btnDateOk = (Button) findViewById(R.id.btnDateOk);

        if (null!=getIntent() && null !=getIntent().getExtras()) {
            Bundle params = getIntent().getExtras();

            EditText txtAux = (EditText) findViewById(R.id.edtNombre);
            txtAux.setText(params.get("FullName").toString());
            txtAux = (EditText) findViewById(R.id.edtPhone);
            txtAux.setText(params.get("Phone").toString());
            txtAux = (EditText) findViewById(R.id.edtEmail);
            txtAux.setText(params.get("Email").toString());
            txtAux = (EditText) findViewById(R.id.edtUserDesc);
            txtAux.setText(params.get("UserDesc").toString());
            txtAux = (EditText) findViewById(R.id.edtBirthday);
            txtAux.setText(params.get("Birthday").toString());

            int dia = Integer.parseInt(txtAux.getText().subSequence(0,2).toString());
            int mes = Integer.parseInt(txtAux.getText().subSequence(3,5).toString())-1;
            int anio= Integer.parseInt(txtAux.getText().subSequence(6,10).toString());
            EditText strFecha = (EditText) findViewById(R.id.edtBirthday);
            DatePicker dtFecha = (DatePicker) findViewById(R.id.edtDate);
            dtFecha.updateDate(anio,mes,dia);
        }

        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDetail = new Intent( MainActivity.this, DetailActivity.class);
                EditText txtAux = (EditText) findViewById(R.id.edtNombre);
                intentDetail.putExtra("FullName", txtAux.getText().toString());
                txtAux = (EditText) findViewById(R.id.edtBirthday);
                intentDetail.putExtra("Birthday", txtAux.getText());
                txtAux = (EditText) findViewById(R.id.edtEmail);
                intentDetail.putExtra("Email", txtAux.getText());
                txtAux = (EditText) findViewById(R.id.edtPhone);
                intentDetail.putExtra("Phone", txtAux.getText());
                txtAux = (EditText) findViewById(R.id.edtUserDesc);
                intentDetail.putExtra("UserDesc", txtAux.getText());

                startActivity(intentDetail);
                finish();
            }

        });

        btnDateOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePicker dtFecha = (DatePicker) findViewById(R.id.edtDate);
                EditText strFecha = (EditText) findViewById(R.id.edtBirthday);
                strFecha.setText(String.format("%02d/%02d/%04d", dtFecha.getDayOfMonth(), 1+dtFecha.getMonth(), dtFecha.getYear())) ;
            }

        });
    }
}
