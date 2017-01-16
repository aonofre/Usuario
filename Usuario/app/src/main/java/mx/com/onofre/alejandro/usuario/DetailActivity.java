package mx.com.onofre.alejandro.usuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private void GoToMain() {
        Intent intentDetail = new Intent( DetailActivity.this, MainActivity.class);


        TextView txtAux = (TextView) findViewById(R.id.txtFullName);
        intentDetail.putExtra("FullName", txtAux.getText().toString());
        txtAux = (TextView) findViewById(R.id.txtBirthday);
        intentDetail.putExtra("Birthday", txtAux.getText());
        txtAux = (TextView) findViewById(R.id.txtEmail);
        intentDetail.putExtra("Email", txtAux.getText());
        txtAux = (TextView) findViewById(R.id.txtPhone);
        intentDetail.putExtra("Phone", txtAux.getText());
        txtAux = (TextView) findViewById(R.id.txtUserDesc);
        intentDetail.putExtra("UserDesc", txtAux.getText());

        startActivity(intentDetail);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        Button btnEdit = (Button) findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMain();
            }
        });

        Bundle params = getIntent().getExtras();
        TextView txtAux;
        txtAux = (TextView) findViewById(R.id.txtFullName);
        txtAux.setText(params.get("FullName").toString());
        txtAux = (TextView) findViewById(R.id.txtPhone);
        txtAux.setText(params.get("Phone").toString());
        txtAux = (TextView) findViewById(R.id.txtEmail);
        txtAux.setText(params.get("Email").toString());
        txtAux = (TextView) findViewById(R.id.txtUserDesc);
        txtAux.setText(params.get("UserDesc").toString());

        txtAux = (TextView) findViewById(R.id.txtBirthday);
        txtAux.setText(params.get("Birthday").toString());

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            GoToMain();
        }
        return super.onKeyDown(keyCode, event);
    }


}
