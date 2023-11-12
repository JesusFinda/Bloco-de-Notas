package ao.co.jesusfinda.aplm.bloco_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class AdcNovaNota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adc_nova_nota1);

        Button btnSave= findViewById(R.id.savebtn);

        btnSave.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         
         Intent intent = new Intent(AdcNovaNota.this,MainActivity.class);
         EditText editText1 = findViewById(R.id.titleinput);
         EditText editText2 = findViewById(R.id.descriptioninput);

         String titulo = editText1.getText().toString();
         String descricacao= editText2.getText().toString();
         intent.putExtra("titulo",titulo);
         intent.putExtra("descricacao",descricacao);
         startActivity(intent);
         finish();

     }
 });


    }
}