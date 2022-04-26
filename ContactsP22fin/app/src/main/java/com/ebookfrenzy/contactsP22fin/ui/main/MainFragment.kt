package com.ebookfrenzy.contactsP22fin.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ebookfrenzy.contactsP22fin.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.fragment.app.viewModels
import com.ebookfrenzy.contactsP22fin.Contacts

import com.ebookfrenzy.contactsP22fin.databinding.MainFragmentBinding
import java.lang.Integer.parseInt

class MainFragment : Fragment() {

    private var adapter: CListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()

    }

    private fun listenerSetup() {

        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val number = binding.contactNumber.text.toString()

            if (name != "" && number != "") {
                val contact = Contacts(name, number)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                Toast.makeText(activity,
                    resources.getString(R.string.mistake),
                    Toast.LENGTH_LONG).show()
            }
        }

        binding.findButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            if (name.isEmpty())
                Toast.makeText(activity,
                    resources.getString(R.string.inputPlz),
                    Toast.LENGTH_LONG).show()
            else
                viewModel.findContact(name) }

        binding.AscButton.setOnClickListener { viewModel.sortingAsc() }

        binding.DescButton.setOnClickListener { viewModel.sortingDesc() }

    }

    private fun observerSetup() {

        viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let  {
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                } else
                    Toast.makeText(activity,
                        resources.getString(R.string.mistake),
                        Toast.LENGTH_LONG).show()
            }
        })

        viewModel.sortingAsc()?.observe(viewLifecycleOwner, Observer { contacts ->

            contacts?.let {
                adapter?.setContactList(it)
            }
        })

        viewModel.sortingDesc()?.observe(viewLifecycleOwner, Observer { contacts ->

            contacts?.let {
                adapter?.setContactList(it)
            }
        })
    }

    private fun recyclerSetup() {
        adapter = CListAdapter(R.layout.card_layout)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter

        adapter!!.settingListener(object: CListAdapter.onItemClickListener { //this almost drove me insane
            override fun onClick(string: String) {
                var itemID: Int = parseInt(string)
                viewModel.deleteContact(itemID)
            }
        })
    }
    private fun clearFields() {
        binding.contactName.setText("")
        binding.contactNumber.setText("")
    }
}