package com.gov.dmrd.disastermanagement;

import android.app.Activity;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TestFragment5.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TestFragment5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestFragment5 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FragmentManager manager;
    Fragment mFragment;
    Bundle args;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestFragment5.
     */
    // TODO: Rename and change types and number of parameters
    public static TestFragment5 newInstance(String param1, String param2) {
        TestFragment5 fragment = new TestFragment5();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TestFragment5() {
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
        View view = inflater.inflate(R.layout.fragment_test_fragment5, container, false);
        manager = getFragmentManager();
        mFragment = new PDFFragment();
        args = new Bundle();
        Button btn1 = (Button)view.findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.putString("URL", "https://docs.google.com/gview?embedded=true&url=http://modmr.portal.gov.bd/sites/default/files/files/modmr.portal.gov.bd/policies/051e98a7_33a1_4736_ab30_5d1dca5a9875/Humanitarian%20Assistance0001.pdf");
                mFragment.setArguments(args);
                manager.beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack(mFragment.toString()).commit();
            }
        });
        Button btn2 = (Button)view.findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.putString("URL", "https://docs.google.com/gview?embedded=true&url=http://modmr.portal.gov.bd/sites/default/files/files/modmr.portal.gov.bd/page/898dac54_302e_42d6_8604_a76b09482dda/667.pdf");
                mFragment.setArguments(args);
                manager.beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack(mFragment.toString()).commit();
            }
        });
        Button btn3 = (Button)view.findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.putString("URL", "https://drive.google.com/file/d/0B5C7CK0fyNrMRS0zMUcwSm5yTnhlR3ExTExma1hFTF9SMHlr/edit?usp=sharing");
                mFragment.setArguments(args);
                manager.beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack(mFragment.toString()).commit();
            }
        });
        Button btn4 = (Button)view.findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.putString("URL", "https://drive.google.com/file/d/0B5C7CK0fyNrMWThRVG0xMnJNbElRRkJvSVE0REUwM3AyYW93/edit?usp=sharing");
                mFragment.setArguments(args);
                manager.beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack(mFragment.toString()).commit();
            }
        });
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
