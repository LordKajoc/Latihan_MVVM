package com.lordkajoc.latihan_mvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lordkajoc.latihan_mvvm.R
import com.lordkajoc.latihan_mvvm.adapter.AdapterUser
import com.lordkajoc.latihan_mvvm.databinding.FragmentHomeBinding
import com.lordkajoc.latihan_mvvm.viewmodel.ViewModelUser

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    //lateinit var sharedPreferences: SharedPreferences
//    lateinit var firebaseAuth:FirebaseAuth
    lateinit var userAdapter: AdapterUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setVmtoAdapter()
//        (activity as AppCompatActivity).setSupportActionBar(binding.tbHome)

//        firebaseAuth = FirebaseAuth.getInstance()
//        if(firebaseAuth.currentUser == null){
//            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
//        }
//
//        sharedPreferences = requireContext().getSharedPreferences("dataUser", Context.MODE_PRIVATE)
//
//        var getUser = sharedPreferences.getString("user", "")
//        binding.textView.text = "Welcome, $getUser"
//
//        binding.ivIcprofile.setOnClickListener {
//            var addUser = sharedPreferences.edit()
//            addUser.putString("user", getUser)
//            addUser.apply()
//            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
//        }
//        val viewModelMovie = ViewModelProvider(this).get(ViewModelUser::class.java)
//        viewModelMovie.getDataUser()
//        viewModelMovie.getliveDataUser().observe(viewLifecycleOwner, Observer {
//            if (it != null) {
//                binding.rvListfilm.layoutManager =
//                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//                binding.rvListfilm.adapter = AdapterUser(it)
//            }
//        })

    }

    fun setVmtoAdapter() {
        val viewModelUser = ViewModelProvider(this).get(ViewModelUser::class.java)
        viewModelUser.getliveDataUser().observe(viewLifecycleOwner, Observer {
            userAdapter = AdapterUser(it)
            if (it != null) {
                binding.rvListfilm.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rvListfilm.adapter = AdapterUser(it)
            }
        })
        viewModelUser.getDataUser()
    }
}

//            newsAdapter.onDetailnews ={
//                var getData = it
//                var inten = Intent(this, DetailNewsActivity::class.java)
//                inten.putExtra("Detail",getData)
//                startActivity(inten)
//            }
