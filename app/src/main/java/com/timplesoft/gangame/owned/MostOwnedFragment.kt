package com.timplesoft.gangame.owned

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.timplesoft.commons.BaseListFragment
import com.timplesoft.commons.DataBindingRecyclerAdapter
import com.timplesoft.gangame.BR
import com.timplesoft.gangame.R
import com.timplesoft.gangame.TopGame

class MostOwnedFragment: BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        val adapter = DataBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)
        return adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (listAdapter as DataBindingRecyclerAdapter<TopGame>).items.addAll(getDummyTopGames())
        listAdapter.notifyDataSetChanged()
    }

    fun getDummyTopGames(): ArrayList<TopGame> {
        return arrayListOf(
            TopGame(title = "Counter Strike",
                owners = 216348746,
                publisher = "Valve",
                steamRating = 80,
                price = 9.99F,
                position = 1,
                thumb = "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2012/08/184043-counter-strike-global-offensive-analizado.jpg?itok=ce8nkvDU")
        )
    }

}