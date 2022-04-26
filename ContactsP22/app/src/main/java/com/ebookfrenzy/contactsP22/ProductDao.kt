package com.ebookfrenzy.contactsP22

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert
    fun insertProduct(contacts: Contacts)

    @Query("SELECT * FROM products WHERE productName = :name")
    fun findProduct(name: String): List<Contacts>

    @Query("DELETE FROM contacts WHERE contactName = :name")
    fun deleteProduct(name: String)

    @Query("SELECT * FROM contacts")
    fun getAllProducts(): LiveData<List<Product>>
}

//adapter equals product list adapter
// R= R readout card readout