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
public class TeacherFragment extends Fragment {
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;

    String[] contact_name;
    String[] contact_mobile;
    String[] contact_address;

    String[] contact_email;

    int[] contact_image;
    ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();

    public TeacherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.listview_main, container, false);

        // Generate sample data


        contact_name = new String[]{"Prof. Dr. Binil Aryal", "Prof.Dr.Raju Khanal", "Prof.Dr.Narayan Adhikari","Madhav Ghimire", "Dr. Jeevan Jyoti Nakarmi", "Dr.Om Prakash Niraula", "Dr.Ram Prasad Regmi",
                "Mr. Ishwar Koirala", "Dr. Hari Pd Lamichhane", "Dr. Bal Ram Ghimire", "Mr. Ajay Kumar Jha", "Dr. Gopi Chandra Kaphle", "Dr. Nurapati Pantha",
                "Mr. Tika Lamichhane", "Mr. Rajendra Prasad Koirala", "Dr. Sanju Shrestha", "Mr. Hari Shankar Malik", "Mr. Pramod Kumar Thakur", "Ms. Sangeeta Maharjan",

//31-60

   };

                contact_mobile = new String[]{"+9779803228105", "+9779841411951", "9841500796","9851127345", "9841400497", "+97714429383", " ",
                        "9849073009", "+91114332694", "9848848733", " ", "9849000975", "+97714336326",

                        "9841356142", "9851099031", "+9779841406928", "9841505294", "9841721700", "9841652075",


                };


//Address
        contact_address = new String[]{"Head", "Professor", " ","Dr. Asst. Prof", " ", " ", " ",
                "Associate Prof.", "Associate Prof.", "Associate Prof.", "Associate Prof.", "Associate Prof.", "Assistant Prof.",
                "Asst.  Prof", "Asst. Prof", "Asst. Prof", "Asst. prof", "Asst. Prof", "Teaching Asst."};


        //Email

        // Generate sample data
        contact_email = new String[]{"aryalbinil@gmail.com","plasmanepal@hotmail.com", "npadhikari@gmail.com","Ghimire.mpg@gmail.com" ,"nakarmijj@yahoo.com", "niraula@yahoo.com", "regmi_rp@hotmali.com",
                "   ", "hlamichhanel@gmail.com", "balramghimire@gmail.com", "astroajay123@gmail.com", "gck2223@gmail.com", "mrnurapati@yahoo.com",
                "trlamichhane@tucdp.edu.np", "rajendrap_koirala@yahoo.com", "sanju12np@yahoo.com", "hsmallik@tucdp.edu.np", "thakur_pramod2001@yahoo.com", "sangeetamaharjan@gmail.com"
        };

//Image

        contact_image = new int[]{R.drawable.binil, R.drawable.raju, R.drawable.naraya,  R.drawable.drawable_madhav,R.drawable.jjn, R.drawable.drawable_male, R.drawable.drawable_male,
                R.drawable.ishwor, R.drawable.hhl, R.drawable.bge, R.drawable.drawable_ajay_jha, R.drawable.gopi, R.drawable.drawable_nurapati,
                R.drawable.tika, R.drawable.drawable_male, R.drawable.sanju, R.drawable.hari, R.drawable.pramod, R.drawable.drawable_female};
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
