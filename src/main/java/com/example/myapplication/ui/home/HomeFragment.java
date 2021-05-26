package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import com.example.myapplication.ListAdapter;
import com.example.myapplication.Main;
import com.example.myapplication.Model;
import com.example.myapplication.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends ListFragment {


    private DatabaseReference mDataBase;
    private String UsKey = "User";
    private List<String> ListData;
    String st = "";


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListData = new ArrayList<>();
        mDataBase = FirebaseDatabase.getInstance("https://native-kira-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child(UsKey);

        String status = "famy";

        Main activity = (Main) getActivity();
        String uid = activity.getId();

        Toast.makeText(getContext(), mDataBase.child(uid).toString(), Toast.LENGTH_SHORT).show();
        mDataBase.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String status = dataSnapshot.child("status").getValue(String.class);
                st = status;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


        ValueEventListener vListener = new ValueEventListener() {
            List<Model> list = new ArrayList<>();

            String s = "famy";
            String gr = "grany";
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (list.size() > 0) list.clear();
                if(st.equals(s)){
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        User user = ds.getValue(User.class);
                        assert user != null;
                        if(user.status.equals(gr)) {
                            list.add(new Model(user.nam, user.age, user.inf, user.help));
                        }

                    }
                }

                ListAdapter adapter = new ListAdapter(getContext(), list);
                setListAdapter(adapter);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };
        mDataBase.addValueEventListener(vListener);
    }
}



