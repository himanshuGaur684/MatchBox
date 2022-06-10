package com.gaur.matchbox.all_matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gaur.domain.model.Venue
import com.gaur.matchbox.all_matches.adapter.AllMatchesAdapter
import com.gaur.matchbox.databinding.FragmentAllMatchesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllMatchesFragment : Fragment() {

    private var _binding: FragmentAllMatchesBinding? = null
    private val binding: FragmentAllMatchesBinding
        get() = _binding!!
    private val viewModel: AllMatchesViewModel by viewModels()
    private var allMatchAdapter: AllMatchesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllMatchesBinding.inflate(inflater, container, false)
        return _binding?.root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        allMatchAdapter = AllMatchesAdapter(insertVenue = {
            viewModel.insertVenue(it)
        }, deleteVenue = {
            viewModel.deleteVenue(it)
        })

        initView()

        viewModel.getAllVenues()
        viewModel.allVenues.observe(viewLifecycleOwner) {
            it?.let {
                if (it.isLoading) {

                }
                if (it.error.isNotBlank()) {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }

                it.data?.let {
                    allMatchAdapter?.setContentList(it as MutableList<Venue>)
                }
            }
        }
    }

    private fun initView() {
        binding.rvAllMatches.adapter = allMatchAdapter
    }


}