package com.example.cv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cv.models.Education

class EducationAdapter(private val mList: MutableList<Education>) : RecyclerView.Adapter<EducationAdapter.ViewHolder>() {

        //private lateinit var mListener : onItemClickListener

//        interface onItemClickListener{
//            fun onItemClick(position: Int)
//        }
//
//        fun setOnItemClickListener(listener: onItemClickListener)
//        {
//            mListener = listener
//        }

        // create new views
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            // inflates the card_view_design view
            // that is used to hold list item
            val view = LayoutInflater.from(parent.context).inflate(R.layout.education_recycler_view_item, parent, false)

            return ViewHolder(view)
        }

        // binds the list items to a view
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val ItemsViewModel = mList[position]

            // sets the image to the imageview from our itemHolder class
            holder.imageView.setImageResource(ItemsViewModel.image)

            // sets the text to the textview from our itemHolder class
            holder.textView.text = ItemsViewModel.name
            holder.textView2.text = ItemsViewModel.description
            holder.itemView.setOnClickListener {}

        }

        // return the number of the items in the list
        override fun getItemCount(): Int {
            return mList.size
        }

        // Holds the views for adding it to image and text
        class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            val imageView: ImageView = itemView.findViewById(R.id.imageview)
            val textView: TextView = itemView.findViewById(R.id.textView)
            val textView2: TextView = itemView.findViewById(R.id.textView2)

//            init {
//                itemView.setOnClickListener {
//                    listener.onItemClick(adapterPosition)
//                }
//            }
        }
    }

