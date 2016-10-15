package id.sch.smktelkom_mlg.tugas01.xiirpl435.projectkos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    Button bOK;
    TextView tvHasil;
    RadioButton rbW, rbL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText)findViewById(R.id.editTextNama);
        bOK = (Button) findViewById(R.id.buttonOK);
        rbW = (RadioButton) findViewById(R.id.radioButtonWa);
        rbL = (RadioButton) findViewById(R.id.radioButtonLa);

        tvHasil = (TextView)findViewById(R.id.textViewHasil);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                doClick();
            }
        });

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String hasil = null;
        String nama = etNama.getText().toString();

        if(rbW.isChecked()){
            hasil = rbW.getText().toString();
        }
        else {
            hasil = rbL.getText().toString();
        }

        if (hasil == null){
            tvHasil.setText("Nama : " +nama+ "\n Belum memilih jenis kelamin");
        }
        else{
            tvHasil.setText("Nama : "+nama+"\n Jenis kelamin anda : "+hasil);
        }
    }
}