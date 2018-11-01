package com.modic.ignite.ui.young_adults

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.modic.ignite.R
import kotlinx.android.synthetic.main.fragment_young_adults.*

class  YoungAdultsFragment : Fragment() {

    private val database = FirebaseDatabase.getInstance()
    private val myRef = database.getReference("young-adults/description")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.fragment_young_adults,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                if(value != null){
                    textView.text = value
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("Test", "Failed to read value.", error.toException())
            }
        })
    }
}