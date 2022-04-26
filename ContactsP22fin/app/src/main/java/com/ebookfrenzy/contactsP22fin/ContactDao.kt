package com.ebookfrenzy.contactsP22fin

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {

    @Insert
    fun insertContact(contact: Contacts)

    @Query("SELECT * FROM contacts WHERE contactName LIKE '%' || :name || '%'")
    fun findContact(name: String): List<Contacts>

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contacts>>

    @Query("SELECT * FROM contacts ORDER BY contactName ASC")
    fun sortingAsc(): List<Contacts>

    @Query("SELECT * FROM contacts ORDER BY contactName DESC")
    fun sortingDesc(): List<Contacts>

    @Query("DELETE FROM contacts WHERE contactId = :Id")
    fun DeleteById(Id: Int)


}

//adapter equals product list adapter
// R= R readout card readout