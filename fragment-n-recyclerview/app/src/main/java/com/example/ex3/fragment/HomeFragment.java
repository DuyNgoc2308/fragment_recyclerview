package com.example.ex3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.ex3.Artist;
import com.example.ex3.R;
import com.example.ex3.adapter.ArtistAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private RecyclerView recArtist;
    private Button btnArtist, btnStage, btnActor;
    private GridLayoutManager gridLayoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        btnArtist = (Button) root.findViewById(R.id.btn_artist);
        btnStage = (Button) root.findViewById(R.id.btn_stage);
        btnActor = (Button) root.findViewById(R.id.btn_actor);
        recArtist = (RecyclerView) root.findViewById(R.id.rec_artist);

        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recArtist.setLayoutManager(gridLayoutManager);

        ArtistAdapter  adapter = new ArtistAdapter(getListArtist());
        recArtist.setAdapter(adapter);


        btnArtist.setOnClickListener(this);
        btnStage.setOnClickListener(this);
        btnActor.setOnClickListener(this);

        return root;
    }

    private List<Artist> getListArtist() {
        List<Artist> list = new ArrayList<>();
        list.add(new Artist(R.drawable.bp, "BLACPINK", Artist.TYPE_ARTIST));
        list.add(new Artist(R.drawable.bb, "BIGBANG", Artist.TYPE_ARTIST));
        list.add(new Artist(R.drawable.ik, "IKON", Artist.TYPE_ARTIST));
        list.add(new Artist(R.drawable.wn, "WINNER", Artist.TYPE_ARTIST));
        list.add(new Artist(R.drawable.ak, "AKMU", Artist.TYPE_ARTIST));
        list.add(new Artist(R.drawable.lsk, "LEE SUNG KYUNG", Artist.TYPE_STAGE));
        list.add(new Artist(R.drawable.lsk, "LEE SUNG KYUNG", Artist.TYPE_STAGE));
        list.add(new Artist(R.drawable.lsk, "LEE SUNG KYUNG", Artist.TYPE_STAGE));

        list.add(new Artist(R.drawable.js, "JISOO", Artist.TYPE_ACTOR));
        list.add(new Artist(R.drawable.js, "JISOO", Artist.TYPE_ACTOR));
        list.add(new Artist(R.drawable.js, "JISOO", Artist.TYPE_ACTOR));
        list.add(new Artist(R.drawable.js, "JISOO", Artist.TYPE_ACTOR));
        list.add(new Artist(R.drawable.js, "JISOO", Artist.TYPE_ACTOR));

        return list;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_artist:
                scrollToItem(0);
                break;
            case R.id.btn_stage:
                scrollToItem(5);
                break;
            case R.id.btn_actor:
                scrollToItem(8);
                break;
        }
    }

    private void scrollToItem(int index) {
        if(gridLayoutManager == null){
            return;
        }
        gridLayoutManager.scrollToPositionWithOffset(index, 0);
    }
}