package com.ebookfrenzy.contactsP22fin

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contacts>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContact2: LiveData<List<Contacts>>?

    init {
        val db: ContactDatabase? =  ContactDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContact2 = contactDao?.getAllContacts()
    }

    fun insertContact(contacts: Contacts) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(contacts)
        }
    }

    private suspend fun asyncInsert(contacts: Contacts) {
        contactDao?.insertContact(contacts)
    }

    fun DeleteById(Id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(Id)
        }
    }
    private suspend fun asyncDelete(Id: Int) {
        contactDao?.DeleteById(Id)
    }

    fun findContact(name: String) {

        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    private suspend fun asyncFind(name: String): Deferred<List<Contacts>?> =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.findContact(name)
        }
    fun sortingAsc() {

        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncSortAsc().await()
        }
    }
    private suspend fun asyncSortAsc(): Deferred<List<Contacts>?> =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.sortingAsc()
        }

    fun sortingDesc() {

        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncSortDesc().await()
        }
    }

    private suspend fun asyncSortDesc(): Deferred<List<Contacts>?> =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.sortingDesc()
        }

}