package com.gov.dmrd.disastermanagement;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TestFragment4.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TestFragment4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestFragment4 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Bundle args;
    FragmentManager manager;
    Fragment mFragment;
    String[] sharok, subject, pdfUrl;

    Button village_protection, village_modification;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestFragment4.
     */
    // TODO: Rename and change types and number of parameters
    public static TestFragment4 newInstance(String param1, String param2) {
        TestFragment4 fragment = new TestFragment4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TestFragment4() {
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
        View view = inflater.inflate(R.layout.fragment_test_fragment4, container, false);
        args = new Bundle();
        manager = getFragmentManager();
        mFragment = new PDFFragment();
        village_protection = (Button)view.findViewById(R.id.button1);
        village_protection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.putString("URL", "https://docs.google.com/gview?embedded=true&url=http://modmr.portal.gov.bd/sites/default/files/files/modmr.portal.gov.bd/files/cd235cf2_852d_4fb3_9874_9805d5ea976e/TR%20implementation%20Guideline%202014.pdf");
                mFragment.setArguments(args);
                manager.beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack(mFragment.toString()).commit();
            }
        });
        village_modification = (Button)view.findViewById(R.id.button2);
        village_modification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.putString("URL", "https://docs.google.com/gview?embedded=true&url=http://modmr.portal.gov.bd/sites/default/files/files/modmr.portal.gov.bd/files/efcd85a7_59f2_4b22_8f9b_7e6397d83e17/FFW%20Guideline%202014.pdf");
                mFragment.setArguments(args);
                manager.beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack(mFragment.toString()).commit();
            }
        });
        LinearLayout ll = (LinearLayout)view.findViewById(R.id.relief_layout);
        sharok = getResources().getStringArray(R.array.sharok_no);
        pdfUrl = getResources().getStringArray(R.array.relief_urls);
        for (int i = 0; i < sharok.length; i++){
            final int j = i;
            LinearLayout innerLayout = new LinearLayout(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            int dpValue = 20; // margin in dips
            float d = getResources().getDisplayMetrics().density;
            int margin = (int)(dpValue * d); // margin in pixels
            params.setMargins(margin,0,margin,margin);
            innerLayout.setGravity(Gravity.TOP);
            innerLayout.setLayoutParams(params);
            innerLayout.setOrientation(LinearLayout.HORIZONTAL);
            innerLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.layout_bg));
            innerLayout.setPadding(margin,margin,margin,margin);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params1.setMargins(0,0,margin,0);
            ImageButton btn = new ImageButton(getActivity());
            btn.setImageResource(R.drawable.pdf_icon);
            btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_bg));
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(j==0) {
                        args.putString("URL", "https://docs.google.com/gview?embedded=true&url=" + pdfUrl[j].toString());
                    } else {
                        args.putString("URL", pdfUrl[j].toString());
                    }
                    mFragment.setArguments(args);
                    manager.beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack(mFragment.toString()).commit();
                }
            });
            innerLayout.addView(btn, params1);
            TextView tv1 = new TextView(container.getContext());
            tv1.setText(sharok[i]);
            tv1.setTextColor(getResources().getColor(R.color.text_color));
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            innerLayout.addView(tv1);
            ll.addView(innerLayout);
        }
        return view;
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
