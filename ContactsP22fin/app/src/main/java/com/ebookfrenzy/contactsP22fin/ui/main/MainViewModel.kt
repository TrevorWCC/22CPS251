package com.ebookfrenzy.contactsP22fin.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ebookfrenzy.contactsP22fin.Contacts
import com.ebookfrenzy.contactsP22fin.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contacts>>?
    private val searchResults: MutableLiveData<List<Contacts>>

    init {
        allContacts = repository.allContact2
        searchResults = repository.searchResults
    }

    fun insertContact(contacts: Contacts) {
        repository.insertContact(contacts)
    }

    fun findContact(name: String) {
        repository.findContact(name)
    }

    fun deleteContact(Id: Int) {
        repository.DeleteById(Id)
    }

    fun sortingAsc(): MutableLiveData<List<Contacts>>? {
        repository.sortingAsc()

        return searchResults
    }

    fun sortingDesc(): MutableLiveData<List<Contacts>>? {
        repository.sortingDesc()

        return searchResults
    }


    fun getSearchResults(): MutableLiveData<List<Contacts>> {
        return searchResults
    }

    fun getAllContacts(): LiveData<List<Contacts>>? {
        return allContacts
    }
}