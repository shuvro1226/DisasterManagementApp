package com.gov.dmrd.disastermanagement;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TestFragment3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TestFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestFragment3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String[] name;
    String[] rank;
    String[] position, contact_office, contact_home, mobile, fax, email;


    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestFragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static TestFragment3 newInstance(String param1, String param2) {
        TestFragment3 fragment = new TestFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TestFragment3() {
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
        //View view=(View)inflater.inflate(R.layout.fragment_test_fragment3, container, false);
        int dpValue = 20; // margin in dips
        float d = getResources().getDisplayMetrics().density;
        int margin = (int)(dpValue * d); // margin in pixels
        LinearLayout innerLayout = new LinearLayout(getActivity());
        innerLayout.setOrientation(LinearLayout.VERTICAL);
        innerLayout.setScrollBarStyle(LinearLayout.SCROLLBARS_INSIDE_OVERLAY);
        innerLayout.setPadding(margin,margin,margin,margin);
        ScrollView sv = new ScrollView(getActivity());
        sv.setBackgroundColor(getResources().getColor(R.color.background));
        name = getResources().getStringArray(R.array.personnel_name);
        rank = getResources().getStringArray(R.array.personnel_rank);
        position = getResources().getStringArray(R.array.personnel_position);
        contact_office = getResources().getStringArray(R.array.personnel_contact_office);
        contact_home = getResources().getStringArray(R.array.personnel_contact_home);
        mobile = getResources().getStringArray(R.array.personnel_mobile);
        fax = getResources().getStringArray(R.array.personnel_fax);
        email = getResources().getStringArray(R.array.personnel_email);
        for (int i = 0; i < name.length; i++){
            LinearLayout ll = new LinearLayout(getActivity());
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params1.setMargins(0,0,0,margin);
            ll.setLayoutParams(params1);
            ll.setOrientation(LinearLayout.VERTICAL);
            ll.setBackgroundDrawable(getResources().getDrawable(R.drawable.layout_bg));
            ll.setPadding(margin,margin,margin,margin);
            TextView tv1 = new TextView(container.getContext());
            tv1.setText(name[i]);
            tv1.setTextColor(getResources().getColor(R.color.red));
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22);
            ll.addView(tv1);
            TextView tv2 = new TextView(container.getContext());
            tv2.setText(rank[i]);
            tv2.setTextColor(getResources().getColor(R.color.text_color));
            tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            ll.addView(tv2);
            TextView tv3 = new TextView(container.getContext());
            tv3.setText(position[i]);
            tv3.setTextColor(getResources().getColor(R.color.text_color));
            tv3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            ll.addView(tv3);
            TextView tv4 = new TextView(container.getContext());
            tv4.setText(contact_office[i]);
            tv4.setTextColor(getResources().getColor(R.color.text_color));
            tv4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            ll.addView(tv4);
            TextView tv5 = new TextView(container.getContext());
            tv5.setText(contact_home[i]);
            tv5.setTextColor(getResources().getColor(R.color.text_color));
            tv5.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            ll.addView(tv5);
            TextView tv6 = new TextView(container.getContext());
            tv6.setText(mobile[i]);
            tv6.setTextColor(getResources().getColor(R.color.text_color));
            tv6.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            ll.addView(tv6);
            TextView tv7 = new TextView(container.getContext());
            tv7.setText(fax[i]);
            tv7.setTextColor(getResources().getColor(R.color.text_color));
            tv7.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            ll.addView(tv7);
            TextView tv8 = new TextView(container.getContext());
            tv8.setText(email[i]);
            tv8.setTextColor(getResources().getColor(R.color.text_color));
            tv8.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            ll.addView(tv8);
            innerLayout.addView(ll);
        }
        sv.addView(innerLayout);
        return sv;
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
