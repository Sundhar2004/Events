package myevents.example.com.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import myevents.example.com.database.NoteDataBase
import myevents.example.com.database.Repository

class EventViewModel(application: Application): AndroidViewModel(application) {
     private var repository: Repository? = null
    var allEvents: LiveData<List<Notes>>? = null

    init {
        val dao = NoteDataBase.getDataBase(application).getNotesDao()
        repository = Repository(dao)
        allEvents = repository!!.allEvent
    }

    fun insert(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository!!.insertEvent(note)
    }

    fun update(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository!!.updateEvent(note)
    }

    fun delete(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository!!.deleteEvent(note)
    }

}