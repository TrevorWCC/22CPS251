package com.ebookfrenzy.contactsP22fin

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contacts {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    var contactId: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null

    var pNumber: String? = null

    constructor() {}

    constructor(contactId: Int, contactName: String?, pNumber: String?) {
        this.contactName = contactName
        this.pNumber = pNumber
    }

    constructor(contactName: String?, pNumber: String?) {
        this.contactName = contactName
        this.pNumber = pNumber
    }
}