package br.com.othonbatista.listviewsimples;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.HashMap;
import java.util.List;

public class StableArrayAdapter extends ArrayAdapter<String> {

    // Dicionário (chave: valor) chave é String e o valor é Integer
    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    // Construtor da classe
    public StableArrayAdapter(
            Context context,
            int textViewResourceId,
            List<String> objects
    ) {
        super(context, textViewResourceId, objects);

        // Preenche o dicionário com o conteúdo da lista
        // Android : 0
        // IPhone : 1
        for (int i = 0; i < objects.size(); ++i) {

            mIdMap.put(objects.get(i), i);

        }

    }

    @Override
    public long getItemId(int position) {

        String item = getItem(position);

        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {

        return true;

    }

}
