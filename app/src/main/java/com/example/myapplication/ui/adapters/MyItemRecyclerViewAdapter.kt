package com.example.myapplication.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.myapplication.data.model.ApiData
import com.example.myapplication.databinding.FragmentUserTileBinding

import com.example.myapplication.placeholder.PlaceholderContent.PlaceholderItem
import com.example.myapplication.ui.fragments.UserListFragmentDirections

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: ApiData
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    lateinit var parent: ViewGroup;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.parent=parent

        return ViewHolder(
            FragmentUserTileBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values.users[position]
        holder.binding.root.setOnClickListener{
           val navController= Navigation.findNavController(it)
            navController.navigate(UserListFragmentDirections.actionItemFragmentToBlankFragment(values.users[position].id));
        }

    }

    override fun getItemCount(): Int = values.users.size

    inner class ViewHolder(val binding: FragmentUserTileBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }



    }

}