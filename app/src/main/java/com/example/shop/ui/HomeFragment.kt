package com.example.shop.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shop.R
import com.example.shop.adapters.PhonesAdapter
import com.example.shop.databinding.FragmentHomeBinding
import com.example.shop.model.Product
import com.example.shop.model.ProductData
import com.example.shop.networking.APIClient
import com.example.shop.networking.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var phoneList: List<Product>
    lateinit var searchList: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val api = APIClient.getInstance().create(APIService::class.java)
        phoneList = listOf()
        searchList = listOf()
        var adapter = PhonesAdapter(phoneList)
        var manager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.phoneRv.adapter = adapter
        binding.phoneRv.layoutManager = manager

        api.getAllProducts().enqueue(object : Callback<ProductData> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<ProductData>, response: Response<ProductData>) {
                if (response.isSuccessful && response.body() != null) {
                    phoneList = response.body()!!.products
                    binding.phoneRv.adapter = PhonesAdapter(phoneList)
                    Log.d("TAG1", phoneList[29].price.toString())
                }
            }

            override fun onFailure(call: Call<ProductData>, t: Throwable) {
                Log.d("TAG", "onFailure: $t")
            }
        })



        binding.search.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    api.searchByName(newText).enqueue(object : Callback<ProductData> {
                        override fun onResponse(
                            call: Call<ProductData>,
                            response: Response<ProductData>
                        ) {
                            if (response.isSuccessful && response.body() != null) {
                                searchList = response.body()!!.products
                                binding.topdealsText.visibility = View.INVISIBLE
                                var adapter1 = PhonesAdapter(searchList)
                                var manager = GridLayoutManager(
                                    requireContext(),
                                    2,
                                    GridLayoutManager.VERTICAL,
                                    false
                                )
                                binding.phoneRv.adapter = adapter1
                                binding.phoneRv.layoutManager = manager
                            }
                        }

                        override fun onFailure(call: Call<ProductData>, t: Throwable) {
                            Log.d("TAG", "onFailure: $t")
                        }

                    })
                    return true
                }
                return false
            }

        })

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}