package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.ApiData
import com.example.myapplication.databinding.FragmentUserListBinding
import com.example.myapplication.domain.network.Retrofit
import com.example.myapplication.ui.adapters.MyItemRecyclerViewAdapter
import com.example.myapplication.viewmodel.UserViewModel
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
    lateinit var userViewModel: UserViewModel;
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
        initViewModel()
        observeViewModel()
        getData()

        binding.button.setOnClickListener {
            getData()
        }
    }


    private fun initViewModel() {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    }

    private fun observeViewModel(){
        userViewModel.observableApiData?.observe(this){

            if (it != null) {
                binding.recyclerView.layoutManager = LinearLayoutManager(context)
                binding.recyclerView.adapter = MyItemRecyclerViewAdapter(it)
            }
            else
            {
                Toast.makeText(context,"Something went wrong please restart the app.",Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
    private fun getData() {

        CoroutineScope(Dispatchers.IO).launch {
            Retrofit(userViewModel).getUsers(10, 0)
        }

    }


}