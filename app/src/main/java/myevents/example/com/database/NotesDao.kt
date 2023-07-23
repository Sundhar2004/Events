package myevents.example.com.database

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import myevents.example.com.models.Notes

interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(note: Notes)

    @Delete
    suspend fun deleteNotes(note: Notes)

    @Query("Select * from notes_table order by id Asc")
    fun getAllData(): LiveData<List<Notes>>

    @Query("UPDATE notes_table Set title = :title, notes = :notes WHERE id = :id")
    suspend fun update(id: Int?, title: String?, notes: String?)
}