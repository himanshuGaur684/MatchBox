package com.gaur.matchbox.all_matches

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaur.common.Resource
import com.gaur.domain.model.Venue
import com.gaur.domain.use_cases.DeleteVenueUseCase
import com.gaur.domain.use_cases.GetAllVenuesUseCase
import com.gaur.domain.use_cases.InsertVenueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AllMatchesViewModel @Inject constructor(
    private val getAllVenuesUseCase: GetAllVenuesUseCase,
    private val insertVenueUseCase: InsertVenueUseCase,
    private val deleteVenueUseCase: DeleteVenueUseCase
) :
    ViewModel() {


    val allVenues = MutableLiveData<AllMatchesState>()


    fun getAllVenues() {
        getAllVenuesUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    allVenues.postValue(AllMatchesState(isLoading = true))
                }
                is Resource.Error -> {
                    allVenues.postValue(AllMatchesState(error = it.message.toString()))
                }
                is Resource.Success -> {
                    allVenues.postValue(AllMatchesState(data = it.data))
                }
            }
        }.launchIn(viewModelScope)
    }

    fun insertVenue(venue: Venue) {
        insertVenueUseCase(venue).onEach {
            when (it) {
                is Resource.Loading -> {
                    allVenues.postValue(AllMatchesState(isLoading = true))
                }
                is Resource.Error -> {
                    allVenues.postValue(AllMatchesState(error = it.message.toString()))
                }
                is Resource.Success -> {
//                    allVenues.postValue(AllMatchesState(data = it.data))
                }
            }
        }.launchIn(CoroutineScope(Dispatchers.IO))

    }

    fun deleteVenue(venue: Venue) {
        deleteVenueUseCase(venue).onEach {
            when (it) {
                is Resource.Loading -> {
                    allVenues.postValue(AllMatchesState(isLoading = true))
                }
                is Resource.Error -> {
                    allVenues.postValue(AllMatchesState(error = it.message.toString()))
                }
                is Resource.Success -> {
//                    allVenues.postValue(AllMatchesState(data = it.data))
                }
            }
        }.launchIn(CoroutineScope(Dispatchers.IO))

    }


}