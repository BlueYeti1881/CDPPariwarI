package com.nepalpolice.cdppariwari;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.nepalpolice.cdppariwari.child.ListViewAdapter;
import com.nepalpolice.cdppariwari.child.WorldPopulation;

import java.util.ArrayList;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class NonStaffFragment extends Fragment {
 	ListView list;
	ListViewAdapter adapter;
	EditText editsearch;

	String[] contact_name;
    String[] contact_mobile;
	String[] contact_address;

	String[] contact_email;

	int[] contact_image;
    ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();

    public NonStaffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.listview_main, container, false);

    	// Generate sample data


		contact_name = new String[] {"Shyam Pr. Shrestha","Ram  Pr. Shrestha","New TU Books","Photocopy Center"

//31-60

		
   };

        contact_mobile = new String[] { "9841559247","9841301562","014336318","9849028558"



        

        };


//Address
		contact_address = new String[] { "","","",""};


		//Email

				// Generate sample data
		contact_email = new String[] { "Physics Department, Kirtipur","Central Library, Kirtipur","Kirtipur","Kirtipur"
 };

//Image

		contact_image = new int[] {R.drawable.drawable_shyam_dai,R.drawable.drawable_male,R.drawable.drawable_male,R.drawable.drawable_male


            
        };
        // Locate the ListView in listview_main.xml
        list = (ListView) view.findViewById(R.id.listview);

     	for (int i = 0; i < contact_email.length; i++)
		{
			WorldPopulation wp = new WorldPopulation( contact_name[i], contact_mobile[i],
					contact_address[i],contact_email[i], contact_image[i]);
			// Binds all strings into an array
			arraylist.add(wp);
		}
        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(getActivity(), arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (EditText) view.findViewById(R.id.search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
   return view;
    }
}
