package com.example.lifecycleawaretb.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecycleawaretb.databinding.MainFragmentBinding
import androidx.lifecycle.Observer
import com.example.lifecycleawaretb.LifeObserver

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lifecycle.addObserver(LifeObserver())
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        var resultObserver: Observer<String> = Observer<String>
        { result -> binding.output.text = result }
        viewModel.getResult().observe(viewLifecycleOwner, resultObserver)
        resultObserver = Observer<String>
        { result -> binding.output.text = result + "\n********\n"}


    }
}