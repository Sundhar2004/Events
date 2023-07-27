package myevents.example.com.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import myevents.example.com.models.Notes

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(note: Notes)

    @Delete
    suspend fun deleteNotes(note: Notes)

    @Query("Select * from events_table order by id Asc")
    fun getAllData(): LiveData<List<Notes>>

    @Query("UPDATE events_table Set title = :title, notes = :notes WHERE id = :id")
    suspend fun update(id: Int?, title: String?, notes: String?)
}