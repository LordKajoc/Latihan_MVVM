package com.lordkajoc.latihan_mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lordkajoc.latihan_mvvm.databinding.ItemFilmBinding
import com.lordkajoc.latihan_mvvm.model.GetUserItemItem

class AdapterUser(var listUser: List<GetUserItemItem>?) :
    RecyclerView.Adapter<AdapterUser.ViewHolder>() {

    class ViewHolder(var binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bindFilms(itemFilms: UserResponseItem){
//            binding.user = itemFilms
//            binding.cardView.setOnClickListener{
//                val bundle = Bundle()
//                bundle.putSerializable("BUNDEL", itemFilms)
//                Navigation.findNavController(itemView).navigate(R.id.action_homeFragment_to_detailFragment, bundle)
////            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvnamauser.text = listUser!![position].name
        holder.binding.tvusername.text = listUser!![position].username
        holder.binding.tvusiauser.text = listUser!![position].age.toString()
        holder.binding.tvAddress.text = listUser!![position].address
//        holder.bindFilms(listUser[position])
//        holder.bindFilms(listFilm[position])
//        Glide.with(holder.itemView)
//            .load("https://image.tmdb.org/t/p/w500${listFilm[position].posterPath}")
//            .into(holder.binding.imgFilm)

//        holder.itemView.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putSerializable("BUNDEL", listFilm[position])
//            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_detailFragment, bundle)
//        }
    }

    override fun getItemCount(): Int {
        return listUser!!.size
    }

}