package br.com.othonbatista.listviewsimples;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instancia o ListView que está no XML da atividade (tela)
        // Camel case - ListViewParameters listView
        // Snake case - list_view_parameters list_view
        final ListView listView = (ListView) findViewById(R.id.listView);

        // Cria um Array (vetor) com palavras em inglês
        String[] palavras = new String[] {
                "André",
                "Antônio",
                "Ana Carla",
                "Beatriz",
                "Carlos",
                "Eduarda",
                "Eliane",
                "Francisco",
                "Horácio",
                "Irene",
                "Natanael",
                "Osmundo",
                "Rebeca",
                "Sara",
                "Thales",
                "Tábata",
                "Thomas",
                "Viviane",
                "Victor",
                "Wanderley",
                "York",
                "Xerxes",
                "Zoroastro"
        };

        // Cria um ArrayList
        final ArrayList<String> listaPalavras = new ArrayList<String>();

        // Preenche a lista com as palavras do Array
        for (int i = 0; i < palavras.length; ++i) {

            listaPalavras.add(palavras[i]);

        }

//        Equivalente ao for logo acima - For Each (Para cada elemento)
//        for (String elemento:palavras) {
//
//            listaPalavras.add(elemento);
//
//        }


        // StableArrayAdapter é uma classe com o código do Adapter
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, listaPalavras);

        // Atribui o adapter ao listView
        listView.setAdapter(adapter);

        // Atribuir o evento de tocar em um elemento da ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {

                // Uma constante com o item da ListView a partir do Adapter
                final String item = (String) adapterView.getItemAtPosition(posicao);

                // Apaga o elemento tocado com uma animação
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                listaPalavras.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });

            }
        });


    }
}