package com.petitemasrata.doit;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
class ActionFragment extends Fragment {

    public ActionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_action, container, false);

        Bundle bundl = getActivity().getIntent().getBundleExtra("Bundle");
        String nameText = bundl.getString("YourName");
        TextView txtName = (TextView) rootView.findViewById(R.id.txt_bienvenido);
        txtName.setText("Hola " + nameText + "!");

        Button btn_call = (Button) rootView.findViewById(R.id.btn_phonecall);
        Button btn_face = (Button) rootView.findViewById(R.id.btn_face);

        btn_face.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("facebook://facebook.com/inbox");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:5585653965");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);

            }
        });

        return rootView;
    }

}