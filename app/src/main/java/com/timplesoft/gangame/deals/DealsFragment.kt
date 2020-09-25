package com.timplesoft.gangame.deals

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.timplesoft.commons.BaseListFragment
import com.timplesoft.commons.DataBindingRecyclerAdapter
import com.timplesoft.gangame.BR
import com.timplesoft.gangame.Deal
import com.timplesoft.gangame.R

class DealsFragment: BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        val adapter = DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)
        return adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (listAdapter as DataBindingRecyclerAdapter<Deal>).items.addAll(getDummyDeals())
        listAdapter.notifyDataSetChanged()
    }

    fun getDummyDeals(): ArrayList<Deal> {
        return arrayListOf(
            Deal("Counter Strike",
                0.99F,
                9.99F,
                80 ,
                80,
                "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2012/08/184043-counter-strike-global-offensive-analizado.jpg?itok=ce8nkvDU")
        )
    }

}
