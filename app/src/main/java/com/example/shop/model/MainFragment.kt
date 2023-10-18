package com.example.shop.model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shop.R
import com.example.shop.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMainBinding.inflate(inflater, container, false)
        loadFragment(HomeFragment())

        binding.navigationmenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    loadFragment(HomeFragment())
                    true
                }
//                R.id.menu_orders -> {
//                    loadFragment(OrdersFragment())
//                    true
//                }
//                R.id.menu_profile -> {
//                    loadFragment(AccountFragment())
//                    true
//                }
                else -> {
                    false
                }
            }
        }
        return binding.root
    }

    private fun loadFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }


}