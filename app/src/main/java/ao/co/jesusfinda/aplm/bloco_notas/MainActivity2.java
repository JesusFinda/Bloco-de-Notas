package ao.co.jesusfinda.aplm.bloco_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txtTitulo = findViewById(R.id.txtTitulo);
        TextView txtDescri = findViewById(R.id.txtDescricacao);
        txtTitulo.setText(getIntent().getStringExtra("tituloSend"));
        txtDescri.setText(getIntent().getStringExtra("descSend"));

        Button btnOk = findViewById(R.id.save0k);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}