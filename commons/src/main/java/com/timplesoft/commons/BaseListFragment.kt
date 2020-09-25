package com.timplesoft.commons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.view.*

abstract class BaseListFragment : BaseFragment() {

    lateinit var listAdapter: RecyclerView.Adapter<*>

    override fun getLayoutResId(): Int {
        return R.layout.fragment_list
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(getLayoutResId())

        listAdapter = getAdapter()

        view?.list?.let {
            with ( view.list ) {
                adapter = listAdapter
                layoutManager = LinearLayoutManager(context)
            }

        }

        return view
    }

    abstract fun getAdapter(): RecyclerView.Adapter<*>


}
