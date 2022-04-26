package com.ebookfrenzy.contactsP22

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contacts {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null


    var pNumber: Int = 0

    constructor() {}

    constructor(id: Int, productname: String, quantity: Int) {
        this.contactName = productname
        this.pNumber = quantity
    }

    constructor(productname: String, quantity: Int) {
        this.contactName = productname
        this.pNumber = quantity
    }
}