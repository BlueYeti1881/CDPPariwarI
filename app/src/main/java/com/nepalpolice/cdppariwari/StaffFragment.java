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
public class StaffFragment extends Fragment {
 	ListView list;
	ListViewAdapter adapter;
	EditText editsearch;

	String[] contact_name;
    String[] contact_mobile;
	String[] contact_address;

	String[] contact_email;

	int[] contact_image;
    ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();

    public StaffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.listview_main, container, false);

    	// Generate sample data


		contact_name = new String[] {"Sargaman Maharjan", "Amar Nepali", "Anita Misra ", "Mina Manander", "Mohan Bd Shrestha", 
        "Govinda Maharjan", "Gautam Thapa",   "Shreedhar Pd. Subedi",  "Laxmi Pandey",  "Mangal S. Maharjan",  
        "Sharmila Shrestha","Lalit Bd Gurung",  "Gyanendra Maharjan",  "Raj Kumar Budhathoki",   "Raj Deula",

//31-60

		
   };

        contact_mobile = new String[] { "9803736846","9841696441"," ","9813040374","9849087874",
        "9860811494","9841400142","9841401776","014336315","014330705",
        "014330625","014331054","9841468167",  "", "9841862681"



        

        };


//Address
		contact_address = new String[] { "Kathmandu","","","Kalimati","",
        "Bhaisepati","Kirtipur","Chitlang","Kirtipur","Kirtipur",
        "Kirtipur","Okhaldhunga","Kirtipur","Kathmandu","Teku"};


		//Email

				// Generate sample data
		contact_email = new String[] { "Asst. Administrator","Account Officer","Lab Officer","Head Assistant","Lab Assistant",
        "Senior Lab Boy","T. Technician","Senior Lab Boy","Office Assistant","Office Assistant",
        "Office Assistant","","Lab Assistant","","Office Assistant"
 };

//Image

		contact_image = new int[] {R.drawable.drawable_staff_sargaman,R.drawable.drawable_male,R.drawable.drawable_female,R.drawable.drawable_female,R.drawable.drawable_male,
                R.drawable.drawable_male,R.drawable.drawable_male,R.drawable.drawable_male,R.drawable.drawable_female,R.drawable.drawable_female,
                R.drawable.drawable_female,R.drawable.drawable_male,R.drawable.drawable_male,R.drawable.drawable_male,R.drawable.drawable_male


            
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
