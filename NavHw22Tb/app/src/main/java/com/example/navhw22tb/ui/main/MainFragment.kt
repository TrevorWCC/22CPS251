package com.example.navhw22tb.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navhw22tb.R
import com.example.navhw22tb.databinding.MainFragmentBinding
import androidx.navigation.Navigation


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button.setOnClickListener{
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()
            action.setMessage(binding.imageView.contentDescription.toString())
            action.image = R.drawable.android_image_1
            Navigation.findNavController(it).navigate(action)
        }
        binding.button2.setOnClickListener{
            val action2: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()
            action2.setMessage(binding.imageView2.contentDescription.toString())
            action2.image = R.drawable.android_image_2
            Navigation.findNavController(it).navigate(action2)
        }
        binding.button3.setOnClickListener{
            val action3: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()
            action3.setMessage(binding.imageView3.contentDescription.toString())
            action3.image = R.drawable.android_image_3
            Navigation.findNavController(it).navigate(action3)
        }

    }
        // TODO: Use the ViewModel
}

