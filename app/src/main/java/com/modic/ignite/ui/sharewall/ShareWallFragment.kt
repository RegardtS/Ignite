package com.modic.ignite

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.modic.ignite.ui.sharewall.ShareWallAdapter
import com.modic.ignite.ui.sharewall.ShareWallViewModel
import kotlinx.android.synthetic.main.fragment_share_wall.*


class  ShareWallFragment : Fragment() {

    private lateinit var viewModel: ShareWallViewModel
    private val adapter = ShareWallAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.fragment_share_wall,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupRecyclerView()
        setupVM()

        share_text_et.setOnEditorActionListener { textView, action, _ ->
            var handled = false
            if (action == EditorInfo.IME_ACTION_SEND) {
                viewModel.postShare(share_text_et.text.toString())

                val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(textView.windowToken, 0)

                textView.text = ""

                handled = true
            }
            handled
        }

    }

    private fun setupRecyclerView(){
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, LinearLayoutManager(context).orientation))
    }

    private fun setupVM(){
        viewModel = ViewModelProviders.of(this).get(ShareWallViewModel::class.java)
        viewModel.initLoadShares()
        viewModel.shareList().observe(this, Observer {
            adapter.loadItems(it ?: emptyList() )
            adapter.notifyDataSetChanged()
        })
    }
}