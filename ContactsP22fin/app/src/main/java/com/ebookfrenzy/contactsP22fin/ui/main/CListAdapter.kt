package com.ebookfrenzy.contactsP22fin.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.contactsP22fin.Contacts
import com.ebookfrenzy.contactsP22fin.R

class CListAdapter(private val contactCardLayout: Int) :
    RecyclerView.Adapter<CListAdapter.ViewHolder>() {

    private var contactList: List<Contacts>? = null
    var listener: onItemClickListener? = null

    fun settingListener(listener:onItemClickListener) {
        this.listener = listener
    }

    interface onItemClickListener {
        fun onClick(str: String)
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val iName = holder.itemName
        val iPhone = holder.itemPhone
        val iID = holder.itemID
        val iDel = holder.itemDel
        contactList.let {
            iName.text = it!![listPosition].contactName
            iPhone.text = it!![listPosition].pNumber
            iID.text = it!![listPosition].contactId.toString()
        }

        iDel.setOnClickListener(View.OnClickListener {
            val id = iID.text.toString()
            listener?.onClick(id)
        })
    }

    fun setContactList(contacts: List<Contacts>) {
        contactList = contacts
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactCardLayout, parent, false)
        return ViewHolder(view) 
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView = itemView.findViewById(R.id.contactName)
        var itemPhone: TextView = itemView.findViewById(R.id.contactNumber)
        var itemID: TextView = itemView.findViewById(R.id.contactID)
        var itemDel: ImageButton = itemView.findViewById(R.id.delete)
    }


}