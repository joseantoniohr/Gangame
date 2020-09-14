package com.timplesoft.gangame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.timplesoft.gangame.deals.DealsFragment
import com.timplesoft.gangame.owned.MostOwnedFragment
import com.timplesoft.gangame.rated.TopRatedFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Static declaration
    companion object {
        const val DEFAULT_OPTION: Int = R.id.action_deals
    }

    val fragments: HashMap<Int, Fragment> = hashMapOf(
        Pair(R.id.action_deals, DealsFragment()),
        Pair(R.id.action_top_rated, TopRatedFragment()),
        Pair(R.id.action_most_owned, MostOwnedFragment())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        navigationView.selectedItemId = DEFAULT_OPTION
        navigationView.setOnNavigationItemSelectedListener {item ->
            val fragment: Fragment? = fragments[item.itemId]

            if ( fragment != null ) {
                replaceFragment(fragment)
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    fun initView() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        if ( currentFragment == null ) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, fragments[DEFAULT_OPTION])
                .commit()
        }
    }

}
