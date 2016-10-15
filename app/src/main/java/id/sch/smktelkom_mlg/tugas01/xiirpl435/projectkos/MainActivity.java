package id.sch.smktelkom_mlg.tugas01.xiirpl435.projectkos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    Button bOK;
    TextView tvHasil;
    RadioButton rbW, rbL;
    CheckBox cbKMD, cbWF, cbM, cbCB;
    Spinner spDaerah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText)findViewById(R.id.editTextNama);
        bOK = (Button) findViewById(R.id.buttonOK);
        rbW = (RadioButton) findViewById(R.id.radioButtonWa);
        rbL = (RadioButton) findViewById(R.id.radioButtonLa);
        cbKMD = (CheckBox) findViewById(R.id.checkBoxKMD);
        cbWF = (CheckBox) findViewById(R.id.checkBoxWF);
        cbM = (CheckBox) findViewById(R.id.checkBoxM);
        cbCB = (CheckBox) findViewById(R.id.checkBoxCB);
        spDaerah = (Spinner) findViewById(R.id.spinnerDaerah);

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
        String hasill = " \n Fasilitas : \n";
        int startlen = hasill.length();

        if(rbW.isChecked()){
            hasil = rbW.getText().toString();
            if (cbKMD.isChecked()) hasill+=cbKMD.getText()+"\n";
            if (cbWF.isChecked()) hasill+=cbWF.getText()+"\n";
            if (cbM.isChecked()) hasill+=cbM.getText()+"\n";
            if (cbCB.isChecked()) hasill+=cbCB.getText()+"\n";

            if (hasil.length()==startlen) hasill+= "Tidak memilih fasilitas";
        }
        else if (rbL.isChecked()){
            hasil = rbL.getText().toString();
            if (cbKMD.isChecked()) hasill+=cbKMD.getText()+"\n";
            if (cbWF.isChecked()) hasill+=cbWF.getText()+"\n";
            if (cbM.isChecked()) hasill+=cbM.getText()+"\n";
            if (cbCB.isChecked()) hasill+=cbCB.getText()+"\n";

            if (hasil.length()==startlen) hasill+= "Tidak memilih fasilitas";
        }

        if (hasil == null){
            tvHasil.setText("Nama : " +nama+ "\n Belum memilih jenis kelamin");
        }
        else{
            tvHasil.setText("Nama : "+nama+"\n Jenis kelamin anda : "+hasil + hasill+ " Daerah Kos : " +spDaerah.getSelectedItem().toString());
        }
    }
}