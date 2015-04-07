package com.gov.dmrd.disastermanagement;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TestFragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TestFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestFragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String[] ministry_structure;
    ArrayAdapter<String> adapter;
    Fragment mFragment;
    FragmentManager manager;
    Button structure, budget, citizen_charter, work_distribution, planning;
    Bundle args;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static TestFragment2 newInstance(String param1, String param2) {
        TestFragment2 fragment = new TestFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TestFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test_fragment2, container, false);
        manager = getFragmentManager();
        mFragment = new PDFFragment();
        args = new Bundle();
        structure = (Button)view.findViewById(R.id.button1);
        structure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.putString("URL", "https://docs.google.com/gview?embedded=true&url=http://modmr.portal.gov.bd/sites/default/files/files/modmr.portal.gov.bd/page/26cc4d99_9e09_41bd_9f47_6a13e4eb206a/gazate_to_create_modmr_-.pdf");
                mFragment.setArguments(args);
                manager.beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack(mFragment.toString()).commit();
            }
        });
        budget = (Button)view.findViewById(R.id.button2);
        budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.putString("URL", "https://docs.google.com/gview?embedded=true&url=http://modmr.portal.gov.bd/sites/default/files/files/modmr.portal.gov.bd/files/a6ca58b1_94bc_40ed_986c_69207ddafec3/merged.compressed.pdf");
                mFragment.setArguments(args);
                manager.beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack(mFragment.toString()).commit();
            }
        });
        citizen_charter = (Button)view.findViewById(R.id.button3);
        citizen_charter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.putString("URL", "https://docs.google.com/gview?embedded=true&url=http://modmr.portal.gov.bd/sites/default/files/files/modmr.portal.gov.bd/files/a10af50c_c7c6_4005_b42f_2ca3d98d638c/_______%2000%20_1_.pdf");
                mFragment.setArguments(args);
                manager.beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack(mFragment.toString()).commit();
            }
        });
        work_distribution = (Button)view.findViewById(R.id.button4);
        work_distribution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.putString("URL", "https://docs.google.com/gview?embedded=true&url=http://modmr.portal.gov.bd/sites/default/files/files/modmr.portal.gov.bd/page/dea9e4c1_e6a6_4e70_bc80_b086908abcb0/Kormo%20bonton%20Final%20-N.pdf");
                mFragment.setArguments(args);
                manager.beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack(mFragment.toString()).commit();
            }
        });
        planning = (Button)view.findViewById(R.id.button5);
        planning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.putString("URL", "https://docs.google.com/gview?embedded=true&url=http://modmr.portal.gov.bd/sites/default/files/files/modmr.portal.gov.bd/files/f3e9a165_31c6_4c32_a5ff_f11bbc8bb7d6/RTI%20Work%20Plan%202015_Nikosh01_1_.pdf");
                mFragment.setArguments(args);
                manager.beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack(mFragment.toString()).commit();
            }
        });
        ministry_structure = getResources().getStringArray(R.array.ministry_formulation);
        LinearLayout ll = (LinearLayout)view.findViewById(R.id.ministry_structure);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        int dpValue = 20; // margin in dips
        float d = getResources().getDisplayMetrics().density;
        int margin = (int)(dpValue * d); // margin in pixels
        params.setMargins(margin, margin, margin, margin);
        ll.setBackgroundDrawable(getResources().getDrawable(R.drawable.layout_bg));
        ll.setPadding(margin, margin, margin, margin);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setLayoutParams(params);
        for(int i = 0; i < ministry_structure.length; i++){
            TextView tv1 = new TextView(container.getContext());
            tv1.setText(Html.fromHtml(ministry_structure[i]));
            tv1.setTextColor(getResources().getColor(R.color.text_color));
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            ll.addView(tv1);
        }
        return view;
        //WebView wv = new WebView(getActivity());
        //wv.getSettings().setJavaScriptEnabled(true);
        //wv.getSettings().setPluginsEnabled(true);
        //wv.loadUrl("https://docs.google.com/gview?embedded=true&url=http://cabinet.portal.gov.bd/sites/default/files/files/cabinet.portal.gov.bd/page/4bd5ab63_5238_405c_80a1_9f026a4a0aca/Receive%20of%20Informatin_Rules.pdf");
        //return wv;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
