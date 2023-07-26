package myevents.example.com.database

import androidx.lifecycle.LiveData
import myevents.example.com.models.Notes

class Repository(private val notesDao: NotesDao) {

    /** get all data - MVVM concept **/
    val allEvent: LiveData<List<Notes>> = notesDao.getAllData()

    /** insert data - MVVM concept **/
    suspend fun insertEvent(notes: Notes){
        notesDao.insertData(notes)
    }

    /** delete data - MVVM concept **/
    suspend fun deleteEvent(notes: Notes){
        notesDao.deleteNotes(notes)
    }

    /** update data - MVVM concept **/
    suspend fun updateEvent(notes: Notes){
        notesDao.update(notes.id,notes.title,notes.notes)
    }
}