package com.petitemasrata.doit;


        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
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
class IniFragment extends Fragment {

    public IniFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final EditText txtName = (EditText) rootView.findViewById(R.id.txt_your_name);
        Button btnEnter = (Button) rootView.findViewById(R.id.btn_enter);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yourName = String.valueOf(txtName.getText());
                if (!yourName.equals("")){
                    Toast.makeText(getActivity(), "Hola " + yourName + "!", Toast.LENGTH_LONG).show();
                    // Si ya hay nombre, avanza al siguiente intent
                    Intent intent = new Intent(getActivity(), ActionActivity.class);

                    // Pero primero le pasa el dato del nombre del tipo o tipa
                    Bundle bundl = new Bundle();
                    bundl.putString("YourName", yourName);
                    intent.putExtra("Bundle", bundl);

                    startActivity(intent);
                }
            }
        });


        return rootView;
    }

}