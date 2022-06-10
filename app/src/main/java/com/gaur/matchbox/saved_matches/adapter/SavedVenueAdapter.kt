package com.gaur.matchbox.saved_matches.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gaur.domain.model.Venue
import com.gaur.matchbox.R
import com.gaur.matchbox.databinding.ViewHolderMatchBinding




class SavedVenueAdapter(
    private var insertVenue:((Venue)->Unit)?=null,
    private var deleteVenue:((Venue)->Unit)?=null
) : RecyclerView.Adapter<SavedVenueAdapter.MyViewHolder>() {

    private var list = mutableListOf<Venue>()

    fun setContentList(list: MutableList<Venue>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val viewDataBinding: ViewHolderMatchBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SavedVenueAdapter.MyViewHolder {
        val binding =
            ViewHolderMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedVenueAdapter.MyViewHolder, position: Int) {
        val binding = holder.viewDataBinding
        val item = this.list[position]

        binding.tvId.text = item.id
        binding.appCompatTextView.text = item.name

        if(item.isSaved){
            binding.ivSaved.setImageResource(R.drawable.ic_baseline_star_24)
        }else{
            binding.ivSaved.setImageResource(R.drawable.ic_baseline_star_outline_24)
        }

        binding.ivSaved.setOnClickListener {
            if(item.isSaved){
                deleteVenue?.let { it(item) }
            }else{
                insertVenue?.let { it(item) }
            }
            item.isSaved = !item.isSaved
            notifyItemChanged(position)
        }


    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}