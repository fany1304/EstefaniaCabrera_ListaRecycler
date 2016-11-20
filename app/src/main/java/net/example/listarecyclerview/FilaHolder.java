package net.example.listarecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Fany on 20/11/2016.
 */

public class FilaHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView etiqueta = null;
    TextView tamanyo = null;
    ImageView icono = null;
    String template = null;

    FilaHolder(View fila) {
        super(fila);

        fila.setOnClickListener(this);

        etiqueta = (TextView) fila.findViewById(R.id.etiqueta);
        tamanyo = (TextView) fila.findViewById(R.id.tamanyo);
        icono = (ImageView) fila.findViewById(R.id.icono);
        template = tamanyo.getContext().getString(R.string.tamanyo_template);

    }

    public void bindModel(String item) {

        etiqueta.setText(item);
        tamanyo.setText(String.format(template, item.length()));

        if (item.length() > 4) {

            icono.setImageResource(android.R.drawable.btn_star_big_off);
        } else {

            icono.setImageResource(android.R.drawable.btn_star_big_on);
        }

    }

    @Override
    public void onClick(View view) {

        Toast.makeText(view.getContext(),
                String.format("Pulsado sobre la posición %d",
                        getAdapterPosition() +1),
                Toast.LENGTH_SHORT).show();

    }
}

