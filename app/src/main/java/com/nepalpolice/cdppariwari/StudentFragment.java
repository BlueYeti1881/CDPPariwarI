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
public class StudentFragment extends Fragment {
 	ListView list;
	ListViewAdapter adapter;
	EditText editsearch;

	String[] contact_name;
    String[] contact_mobile;
	String[] contact_address;

	String[] contact_email;

	int[] contact_image;
    ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();

    public StudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.listview_main, container, false);

    	// Generate sample data


		contact_name = new String[] {" Akash Subedi  "," Amir Wagle  "," Amit tharu   "," Amrit Gurung   ","  Amrit Naharki   "," Arjun Dumre    ",
		" Arjun Gaire  "," Arun Shrestha  "," Ashish   "," Bhairab sunder singh thakuri    "," Bhawana sharma    "," Bhishma neupane    ",
		"bikram pandey   "," Bimal Thapa  "," Bishal paudel   "," Chandrashekhar bhagat   "," CHHABILAL BHANDARI   "," Dharma Raj Dhakal    ",
	" Dhiraj Ghimire  "," Dilip Gautam  "," Dinesh Gc   "," Dipesh kumar sah   ","  Ganesh Prasad Joshi   ","  Geeta Pandeya   ",
        "  Gopal bhusal "," Gopal BK  "," Gyan Neupane   ","Hari Prasad Kurmi    ","  Hari Timsina   "," Homchandra Adhikari     ",
		

//31-60

		" Homnath Dulal  "," Imran Khan  ","Indira adhikari    "," Indra Bahadur KC   "," Jeevan Bhandari    "," Kamal Dhamala    ",
        " Kamal Pandey  ","Khil Prasad Timalsina   ","Krishna Oli   "," Kshitij Pangeni   "," kula jaishi    ","  Kumar kc   ",
        "   Kumar Neupane "," Lalit Dhami  "," Lalit Singh Karki   "," Laxman bhandari   "," Lokendra Singh Dhami    ","  Madan Rawal   ",
    " Mahendra Rawat  "," Mahesh Giri  "," Mausam nembang limbu   "," Mohan Datt Bhatt   ","  Nabin Bhagat   ","   Narayan Basnet  ",
        "  Nirab Sharma ","Nirmala Kuikel   ","   Nirmala Regmi "," Niroj Humagain   "," Nishchal Paudel    "," Phanindra Devkota    ",

		//sec B
				" PINTU SHAH  ","  Prabin katuwal ","  Prajapati Dahal  "," Prajwal Shrestha   "," Prakash Bhushan thakur    ","  Prakash Dawadi   ",
        " Prakash joshi ","Pratibha Khanal   ","  Prem Prasad Ghimire   "," Pushkar Saud   ","  Radha Krishna Joshi   ","  Rajeeb Kunwar   ",
        " Sandeep Chaudhary Kurmi   ","SANTOSH   ","  Santosh kc  "," Sarita Bhatt   ","  Saroj Kumar Mandal   "," satyananand gupta   ",
    " Shiva bikram thapa  "," Sudhanand Mandal  ","  Sujan subedi  ","  Suman Adhikari  ","  Suraj Rai   ","  SURENDRA BAJAGAIN   ",
        "   Tibendra Adhikari","  Tika Ram Bhandari ","  Tirth Bhatta  ","  Yagya Bhattarai  ","  Yubraj Niroula   " };


		//Mobile


        contact_mobile = new String[] {"9814471157"," 9845568566"," 9848255559"," 9846181777"," 9860719556"," 9843379567",
    " 9867172723"," 9843536794"," 9842282466"," 9860690310"," 9844967689"," 9847555130",
    " 9847169877"," 9817170279"," 9805485800"," 9804792498"," 9846750382"," 9866538814",
    " 9806049372"," 9849004678"," 9807046009"," 9804335146"," 9863451432"," 9843072732",
    " 9863451351"," 9841311925"," 9847417361"," 9867217065"," 9844661766"," 9842480315",


    " 9862024436"," 9818371089"," 9865091956"," 9840022148"," 9865777998"," 9849181008",
    " 9867010002"," 9849877072"," 9866911724"," 9846557900"," 9848321317"," 9860009409",
    " 9849434472"," 9868896658"," 9868403342"," 9867388867"," 9840502838"," 9848780755",
    " 9848239461"," 9860015990"," 9810506747"," 9863468447"," 9804266333"," 9846544419",
    " 9849035900"," 9842755021"," 9846619680"," 9843528565"," 9861293363"," 9818872033",


    " 9845552818"," 9843917841"," 9862957413"," 9817353986"," 9814844243"," 9845733856",
    " 9843556775"," 9847233601"," 9846225878"," 9868772979"," 9848997942"," 9849534187",
    " 9815467290"," 9867420826"," 9846162982"," 9848993994"," 9804781113"," 9868185205",
    " 9818038147"," 9861785960"," 9840011485"," 9803692293"," 9843689576"," 9851089439",
    " 9844688290"," 9847838930"," 9865630273", "9816006551","9818710608" };


//Address
		contact_address = new String[] { 

"Rolpa"," Jhapa"," banke"," Lamjung"," Dhading"," Syangja",
" Palpa"," Kathmandu"," morang"," jajarkot "," Dang"," rupandehi",
" tansen"," Parbat"," Nawalparasi"," Rajbiraj"," Baglung"," Surkhet ",
" Jhapa"," Rukum"," Morang"," sunsari"," Kailali "," Dailekh ",
"  Dang"," Mahottari"," palpa"," Kapilvastu "," Jhapal"," Udayapur ",
 

 " morang"," Nepalgunj"," Kathmandu "," Salyan"," Kailali"," Okhaldhunga",
" Syangja"," Lalitpur"," Salyan"," syangja"," kalikot"," Kathmandu ",
" Rasuwa "," Baitadi"," kanchanpur"," palpa"," Kanchanpur"," Achham",
" surkhet"," Jajarkot"," Itahari"," Darchula"," bara"," Lamjung ",
" Kathmandu"," Jhapa"," Parbat"," Banepa"," Jhapa"," Salyan",


" Rautahat"," Myagdi"," morang"," Dharan"," dhanusha"," Nepal",
" kailali"," Gulmi"," Syangja"," kanchanpur "," kanchanpur"," Lalitpur",
" Kapilvastu "," RUPANDEHI"," Tanahun"," kanchanpur"," Saptari "," Nawalparasi ",
" Kathmandu"," Chhinmasta2"," Parbat "," Kirtipur"," Sankhuwasabha"," LALITPUR",
" Panchthar","  Dang"," Kailali"," Jhapa"," Jhapa"};


		//Email

				// Generate sample data
		contact_email = new String[] {



"Subediakash52@gmail.com","Wagleamir74@gmail.com "," AmitTharu20520506@gmail.com"," emailamrit7@gmail.com"," anaharki53@gmail.com"," arjundumre799@gmail.com",
" arjungaire03@gmail.com"," eeshanstha@gmail.com"," Bhattarai"," 9861367530sss@gmail.com "," Sharmaanima50@gmail.com"," bhishmaneupane77@gmail.com",
" pandeybikram193@gmail.com"," Bimalthapa444@gmail.com"," Paudelbishal565@gmail.com"," bhagatchandrashekhar99@gmail.com"," Chakendra16@yahoo.com"," dhakaldharma605@gmail.com",
" dhirug2@gmail.com"," dilip004678@gmail.com"," gcdinesh03@gmail.com"," kumardipeshsah@gmail.com"," Ganeshjoshi930@gmail.com"," geetapandey2053@gmail.com",
" bhusalgopal89@gmail.com"," gbk367@gmail.com"," gyanneupane61@gmail.com"," harichaudhary44496@gmail.com "," haritimsina351@gmail.com"," homchandra123@gmail.com ",


" Homnathdulal2049@gmail.com"," daimrankhan@gmail.com"," Adhindu2045@gmail.com"," Kcindra3@gmail.com"," jeevanvai45@gmail.com"," dhamalakamal@gmail.com",
" kp885193@gmail.com"," timalsinakhilprasad@gmail.com"," olikrishna98@gmail.com"," pangenikshitij3@gmail.com"," Jaishikula@gmail.com"," Kumaarkc47@gmail.com",
" Kumarneupane4344@gmail.com"," dhamilalit555@gmail.com"," karkilalitsingh53@gmail.com"," laxmanbhandari039@gmail .com"," lokendra.dhami@gmail.com"," rawalmadan25@gmail.com",
" mahendrarawat682@gmail.com"," maheshgiri200@gmail.com"," limbumausam04161222@gmail.com"," dattbhattmohan@gmail.com"," Smartnvn23@gmail.com"," narayanbasnet75@gmail.com",
" nirab1234@gmail.com"," kuikelnirmala13@gmail.com"," regmi.nirmala1@gmail.com"," humagainniroj71@gmail.com"," Nishchalpaudel1@gmail.com"," pd152207@gmail.com",



" shahpintu574@gmail.com"," katuwalprabin100@gmail.com","  prazz.pd@gmail.com"," Prajal.drn15@gmail.com"," prakashbhushan018@gmail.com"," bkprakashdawadi@gmail.com",
" Brokenheartprakash@gmail.com"," pratibhakhanal77@gmail.com"," premgh730@gmail.com"," pushkarsaud1995@gmail.com "," joshiradhakrishna11@gmail.com"," punkrajeeb76@gmail.com",
" chaudharysandeep621@gmail.com "," santoshpanth555@gmail.com"," santoshkc658@gmail.com"," bhattsarita11@gmail.com"," Sarojkumarmandal661@gmail.com"," iamsatyagupta@gmail.com",
" bikramthapashiva@gmail.com"," Nandasudha215@gmail.com"," Sujansubedi1995@gmail.com"," Smartsumanadhikari@gmail.com"," raisuraj732100@gmail.com "," bajsurendra 12345@gmail.com",
" tbndhkr@gmail.com"," bhandaritikaram1996@gmail.com"," tirthbhatta666@gmail.com"," yagyabhattarai29@gmail.com"," niroulayubraj96@gmail.com"
 };

//Image

		contact_image = new int[] {R.drawable.drawable_akash_subedi,R.drawable.drawable_amir_wagle,R.drawable.drawable_amit_tharu,R.drawable.drawable_amrit_gurung,R.drawable.drawable_amrit_nakharkhi,R.drawable.drawable_arjun_dumre,
                R.drawable.drawable_arjun_gaira,R.drawable.drawable_arun_shrestha,R.drawable.drawable_ashish_bhattari,R.drawable.drawable_bhairab_sunder,R.drawable.drawable_bhawana_sharma,R.drawable.drawable_bhishma_neupane,
                R.drawable.drawable_bikram_pandey,R.drawable.drawable_bimal_thapa,R.drawable.drawable_bishal_poudel,R.drawable.drawable_chandrashekhar_bhagat,R.drawable.drawable_chabilalal_bhandari,R.drawable.drawable_dharma_raj,
                R.drawable.drawable_dhiraj_ghimire ,R.drawable.drawable_dilip_gauta,R.drawable.drawable_dinesh_gc,R.drawable.drawable_dipesh_kumar,R.drawable.drawable_ganesh_prasad,R.drawable.drawable_geeta_pandeya,
                R.drawable.drawable_gopal_bhusal,R.drawable.drawable_gopal_bk,R.drawable.drawable_gyan_neupane,R.drawable.drawable_hari_prasad_kurmi,R.drawable.drawable_hari_timilsina,R.drawable.drawable_homchandra_adhikari,


                R.drawable.drawable_homnath_dulal,R.drawable.drawable_imran_khan,R.drawable.drawble_indira_adhikari,R.drawable.drawable_indra_bahadru,R.drawable.drawable_jeevan_bhandari,R.drawable.drawable_kamal_dhamala,
                R.drawable.drawable_kamal_pandey,R.drawable.drawable_khil_parsad,R.drawable.drawable_krishna_oli,R.drawable.drawable_kshitij_pangeni,R.drawable.drawble_kula_jaishi, R.drawable.drawable_kumar_kc,
                R.drawable.drawable_kumar_neupane,R.drawable.drawable_lalit_dhami,R.drawable.drawable_lalit_singh,R.drawable.drawable_laxman_bhandari,R.drawable.drawable_lokendra_dhami, R.drawable.drawable_madan_rawal,
                R.drawable.drawable_mahendra_rawat, R.drawable.drawable_mahesh_giri,R.drawable.drawable_mausam_nembang_limbu,R.drawable.drawable_mohan_datt_bhatt,R.drawable.drawable_nabin_bhagat, R.drawable.drawable_narayan_basne,
                R.drawable.drawable_nirab_sharma,R.drawable.drawable_nirmala_kuikel,R.drawable.drawable_nirmala_regmi,R.drawable.drawable_niroj_humagain,R.drawable.drawable_nischal_paudel, R.drawable.drawable_phanindra_devkota,

                R.drawable.drawable_pintu_shah,R.drawable.drawable_prabin_kautwal,R.drawable.drawable_prajapati_dahal,R.drawable.drawable_prajwal_shrestha,R.drawable.drawable_prakash_bhusan, R.drawable.drawable_prakash_dawadi ,
                R.drawable.drawable_prakash_joshi,R.drawable.drawable_pratibha_khanal,R.drawable.drawable_prem_prasad_ghimire,R.drawable.drawable_pushkar_saud,R.drawable.drawable_radha_krishna,R.drawable.drawable_rajeeb_kunwar,
                R.drawable.drawable_sandeep_chaudhary,R.drawable.drawble_santosh,R.drawable.drawable_santosh_kc,R.drawable.drawable_sarita_bhatt,R.drawable.drawable_saroj_kumar,R.drawable.drawable_satyananda_gupta,
                R.drawable.drawable_shiva_bikram_thapa,R.drawable.drawable_sudhananad,R.drawable.drawable_sujan_subedi,R.drawable.drawable_suman_adhikari,R.drawable.drawable_suraj_rai,R.drawable.drawable_surendra_bajagain,
                R.drawable.drawable_tiben_adhikari,R.drawable.drawable_tika_ram,R.drawable.drawable_tirth_bhatta,R.drawable.drawable_yagya_bhattari,R.drawable.drawable_yubraj_niroula



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
