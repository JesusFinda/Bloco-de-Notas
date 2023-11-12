package ao.co.jesusfinda.aplm.bloco_notas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

      ArrayList<String> listaTitulo = new ArrayList<>();
    static ArrayList<Nota> listaNotas = new ArrayList<>();

    public void listarElemento(ArrayList<Nota> listaDeNotas){

        for(int i=0; i<listaDeNotas.size(); i++){
                listaTitulo.add(listaDeNotas.get(i).getTitulo());
        }



        ListView telaImprimir= findViewById(R.id.listView);

        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaTitulo);
        telaImprimir.setAdapter(adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // listarElemento();


        Button btnAdcionarNota = findViewById(R.id.btnGuardarNota);
        btnAdcionarNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, AdcNovaNota.class);
                startActivity(intent1);
                finish();
            }

        });
        ListView listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemId=(int) id;

                String tituloSend= listaNotas.get(itemId).getTitulo();
                String descSend= listaNotas.get(itemId).getDescricao();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("tituloSend", tituloSend);
                intent.putExtra("descSend", descSend);

                startActivity(intent);
                finish();

            }
        });


        String titulo = getIntent().getStringExtra("titulo");
        String descricacao = getIntent().getStringExtra("descricacao");

            Nota nota= new Nota();
            nota.setTitulo(titulo);
            nota.setDescricao(descricacao);
            listaNotas.add(nota);
            listarElemento(listaNotas);







    }
}