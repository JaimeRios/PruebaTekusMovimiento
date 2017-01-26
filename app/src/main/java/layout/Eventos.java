package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.jshuin.pruebatekusmovimiento.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class Eventos extends Fragment {




    public Eventos() {
        // Required empty public constructor
    }

    @BindView(R.id.EventosBotonMostrar)
    Button botonMostrarEventos;
    @BindView(R.id.EventosBotonBorrar)
    Button botonBorarEventos;
    @BindView(R.id.EventosLista)
    ListView listaEventos;

    RequestQueue requestQueue;
    private static final String URL="http://proyectos.tekus.co/Test/api/notifications/";
    StringRequest stringRequest;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eventos,container, false);
        ButterKnife.bind(this,view);
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        return view;
    }

    @OnClick(R.id.EventosBotonMostrar)
    public void mostrar(){
        stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity().getApplicationContext(),"Sus datos han sido guardados",Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(),""+error,Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                HashMap<String,String> envio = new HashMap<>();
                envio.put("NotificationId",String.valueOf(1));
                envio.put("Date","2016-12-07 14:45:00");
                envio.put("Duration",String.valueOf(3));
                envio.put("Authorization","Basic 900590282");
                return envio;

            }
        };
        requestQueue.add(stringRequest);

    }

    @OnClick(R.id.EventosBotonBorrar)
    public void borrar(){

    }

}
