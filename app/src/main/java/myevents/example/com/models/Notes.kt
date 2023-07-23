package myevents.example.com.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/** create table name(Entity) - column **/
@Entity("notes_table")
data class Notes(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "notes") val notes: String?,
    @ColumnInfo(name = "date") val date: String?

)
