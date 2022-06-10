package com.gaur.matchbox.saved_matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gaur.matchbox.databinding.FragmentSavedBinding
import com.gaur.matchbox.saved_matches.adapter.SavedVenueAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SavedFragment : Fragment() {

    private var _binding: FragmentSavedBinding? = null
    private val binding: FragmentSavedBinding
        get() = _binding!!

    private val viewModel: SavedViewModel by viewModels()
    private var adapter: SavedVenueAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSavedBinding.inflate(inflater, container, false)
        return _binding?.root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = SavedVenueAdapter(deleteVenue = {
            viewModel.deleteVenue(venue = it)
        }, insertVenue = {
            viewModel.insertVenue(it)
        })
        initView()
        viewModel.venues.observe(viewLifecycleOwner) {
            it?.let {
                if (it.isLoading) {

                }
                if (it.error.isNotBlank()) {

                }

                it.data?.let {
                    adapter?.setContentList(it.toMutableList())
                }
            }
        }
    }

    private fun initView() {
        binding.rvSaved.adapter = adapter
    }


    override fun onResume() {
        super.onResume()
        viewModel.getAllVenues()
    }

}