package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.ApiData
import com.example.myapplication.data.paging.ApiPagingAdapter
import com.example.myapplication.data.paging.PagingViewModel
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
    lateinit var pagingViewModel: PagingViewModel;
    lateinit var apiPagingAdapter: ApiPagingAdapter;
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
        try {
            initViewModel()
            observeViewModel()
            getData()


        } catch (e: Exception) {
                   e.printStackTrace()
        }
    }


    private fun initViewModel() {
        try {
            userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            pagingViewModel = ViewModelProvider(this) .get(PagingViewModel::class.java)
        } catch (e: Exception) {
                   e.printStackTrace()
        }
    }

    private fun observeViewModel(){
     /*   userViewModel.observableApiData?.observe(viewLifecycleOwner){

            try {
                if (it != null) {
                    binding.recyclerView.layoutManager = LinearLayoutManager(context)
                    binding.recyclerView.adapter = MyItemRecyclerViewAdapter(it)
                    binding.recyclerView.visibility=View.VISIBLE
                }
                else
                {
                    Toast.makeText(context,"Something went wrong please restart the app.",Toast.LENGTH_LONG)
                        .show()
                }
                binding.progressCircular.visibility=View.GONE
            } catch (e: Exception) {
                       e.printStackTrace()
            }
        }*/


        pagingViewModel.list.observe(viewLifecycleOwner, Observer {
            apiPagingAdapter.submitData(lifecycle,it)
        })
    }
    private fun getData() {

        try {
            binding.recyclerView.visibility=View.VISIBLE
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            binding.recyclerView.setHasFixedSize(true)
            apiPagingAdapter=ApiPagingAdapter()
            binding.recyclerView.adapter = apiPagingAdapter
        /*    CoroutineScope(Dispatchers.IO).launch {
                Retrofit(userViewModel).getUsers(10, 0)
            }*/
        } catch (e: Exception) {
                   e.printStackTrace()
        }

    }


}