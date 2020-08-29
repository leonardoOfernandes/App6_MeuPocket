package br.edu.ifsp.arq.meupocket.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.edu.ifsp.arq.meupocket.R;
import br.edu.ifsp.arq.meupocket.dao.SiteDao;
import br.edu.ifsp.arq.meupocket.model.Site;

public class SiteActivity extends AppCompatActivity {
    private ListView sitesListView;

    //Referência para o elemento de RecyclerView
    private RecyclerView sitesRecyclerView;

    //Fonte de dados, essa lista possue os dados que são apresentados
    //na tela dos dispositivo.
    private List<Site> siteList;

    private ArrayAdapter<Site> siteArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);
        sitesListView = findViewById(R.id.list_sites);

        //Carrega a fonte de dados
        siteList = SiteDao.recuperateAll();
        //Instancia do adapter, aqui configura-se como os dados serão apresentados e também
        // qual a fonte de dados será utilizada.
        siteArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, siteList);
        //Com o adapter pronto, vinculamos ele ao nosso ListView. Após esse comando o
        // ListView já consegue apresentar os dados na tela.
        sitesListView.setAdapter(siteArrayAdapter);

        sitesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), siteList.get(i).getTitulo() + "\n" + siteList.get(i).getEndereco(),
                        Toast.LENGTH_SHORT).show();
            }
        });


    }



}