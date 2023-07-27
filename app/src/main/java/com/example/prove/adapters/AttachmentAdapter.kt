package com.example.prove.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.prove.Attachment
import com.example.prove.R

class AttachmentAdapter(context: Context, attachments: List<Attachment>) :
    ArrayAdapter<Attachment>(context, 0, attachments) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView

        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.attachment_list_view_item, parent, false)
        }

        val currentAttachment = getItem(position)

        val textViewFileName = listItemView?.findViewById<TextView>(R.id.fileNameTextView)
        val textViewFilePath = listItemView?.findViewById<TextView>(R.id.filePathTextView)

        textViewFileName?.text = currentAttachment?.fileName
        textViewFilePath?.text = currentAttachment?.filePath

        return listItemView!!
    }
}