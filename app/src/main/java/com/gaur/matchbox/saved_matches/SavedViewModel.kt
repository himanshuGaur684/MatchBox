package com.gaur.matchbox.saved_matches

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaur.common.Resource
import com.gaur.domain.model.Venue
import com.gaur.domain.use_cases.DeleteVenueUseCase
import com.gaur.domain.use_cases.GetAllLocalVenuesUseCase
import com.gaur.domain.use_cases.GetAllVenuesUseCase
import com.gaur.domain.use_cases.InsertVenueUseCase
import com.gaur.matchbox.all_matches.AllMatchesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject constructor(
    private val getAllLocalVenuesUseCase: GetAllLocalVenuesUseCase,
    private val getAllVenuesUseCase: GetAllVenuesUseCase,
    private val insertVenueUseCase: InsertVenueUseCase,
    private val deleteVenueUseCase: DeleteVenueUseCase
) : ViewModel() {

     val venues = MutableLiveData<SavedVenueState>()


    fun getAllVenues() {
        getAllLocalVenuesUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    venues.postValue(SavedVenueState(isLoading = true))
                }
                is Resource.Error -> {
                    venues.postValue(SavedVenueState(error = it.message.toString()))
                }
                is Resource.Success -> {
                    venues.postValue(SavedVenueState(data = it.data))
                }
            }
        }.launchIn(viewModelScope)
    }


    fun insertVenue(venue: Venue) {
        insertVenueUseCase(venue).onEach {
            when (it) {
                is Resource.Loading -> {
                    venues.postValue(SavedVenueState(isLoading = true))
                }
                is Resource.Error -> {
                    venues.postValue(SavedVenueState(error = it.message.toString()))
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
                    venues.postValue(SavedVenueState(isLoading = true))
                }
                is Resource.Error -> {
                    venues.postValue(SavedVenueState(error = it.message.toString()))
                }
                is Resource.Success -> {
//                    allVenues.postValue(AllMatchesState(data = it.data))
                }
            }
        }.launchIn(CoroutineScope(Dispatchers.IO))

    }


}