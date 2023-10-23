package com.example.shop.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import coil.load
import com.example.shop.R
import com.example.shop.databinding.FragmentDetailsBinding
import com.example.shop.model.Product

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailsBinding.inflate(inflater, container, false)
        var item = arguments?.getSerializable("product") as Product

        binding.nameDetail.text = item.title
        binding.img.load(item.thumbnail)
        binding.rank.text = item.rating.toString()
        binding.descriptionText.text = item.description
        binding.totalPriceCart.text = item.price.toString()

        binding.minus.setOnClickListener {
            if (binding.result.text.toString().toInt() > 1){
                binding.result.text = (binding.result.text.toString().toInt() - 1).toString()
                binding.totalPriceCart.text = (item.price * binding.result.text.toString().toInt()).toString()
            }else{
                binding.result.text = "1"
                binding.totalPriceCart.text = (binding.totalPriceCart.text.toString().toInt() * binding.result.text.toString().toInt()).toString()
            }
        }

        binding.plus.setOnClickListener {
            binding.result.text = (binding.result.text.toString().toInt() + 1).toString()
            binding.totalPriceCart.text = (item.price * binding.result.text.toString().toInt()).toString()
        }

        binding.back.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main, MainFragment())
                .commit()
        }

        binding.addToCart.setOnClickListener {
            Toast.makeText(requireContext(), "Product added to cart", Toast.LENGTH_SHORT).show()

        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}