package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.ApiData
import com.example.myapplication.databinding.FragmentUserListBinding
import com.example.myapplication.domain.network.Retrofit
import com.example.myapplication.ui.adapters.MyItemRecyclerViewAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * A fragment representing a list of Items.
 */
class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserListBinding.inflate(layoutInflater, container, false)

        setViewProperties();
        return binding.root
    }


    private fun setViewProperties() {

        CoroutineScope(Dispatchers.IO).launch {
            Retrofit().getUsers(10,0)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        MainScope().launch {
//            binding.recyclerView.adapter = MyItemRecyclerViewAdapter(callApi().body()!!)
        }

    }



}