package com.modic.ignite.ui.sharewall

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ShareWallViewModel : ViewModel() {

    private val shareList = MutableLiveData<List<String>>()
    private val database = FirebaseDatabase.getInstance()
    private val myRef = database.getReference("message")

    fun initLoadShares(){

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var items: MutableList<String> = mutableListOf()

                for (postSnapshot in dataSnapshot.children)  {
                    val value = postSnapshot.getValue(String::class.java)
                    items.add("$value")
                }
                shareList.value = items.asReversed()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("Test", "Failed to read value.", error.toException())
            }
        })
    }

    fun shareList(): LiveData<List<String>> = shareList

    fun postShare(text: String){
        myRef.push().setValue(text)
    }

}

