package myevents.example.com.adapter

import android.content.Context
import android.os.Build
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import myevents.example.com.R
import myevents.example.com.models.Notes
import kotlin.random.Random

class EventAdapter(private val context: Context, private val clickEvent: eventClickListener): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    private val notesList = ArrayList<Notes>()
    private val fullEvent = ArrayList<Notes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
       return EventViewHolder(
           LayoutInflater.from(context).inflate(R.layout.event_item,parent,false)
       )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentEvent = notesList[position]

        holder.apply {
            tvTittle.text = currentEvent.title
            tvTittle.isSelected = true

            tvNote.text = currentEvent.notes
            tvDate.text = currentEvent.date
            tvDate.isSelected = true

            cardView.setBackgroundColor(itemView.resources.getColor(randomColor(),null))

            cardView.setOnClickListener {
                clickEvent.onItemClick(notesList[holder.adapterPosition])
            }

            cardView.setOnLongClickListener {
                clickEvent.onLongClick(notesList[holder.adapterPosition],cardView)
                true
            }
        }
    }

    /** random color for cardView **/
    fun randomColor(): Int{
        val list =  ArrayList<Int>()
        list.add(R.color.blue1)
        list.add(R.color.brown1)
        list.add(R.color.green1)
        list.add(R.color.orange1)
        list.add(R.color.pink1)
        list.add(R.color.white1)
        list.add(R.color.yellow1)

        val seed = System.currentTimeMillis().toInt()
        val randomIndex = Random(seed).nextInt(list.size)

        return list[randomIndex]
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    fun updateList(newList: List<Notes>){
        fullEvent.clear()
        fullEvent.addAll(newList)

        notesList.clear()
        notesList.addAll(newList)

        notifyDataSetChanged()
    }

    /** set filter for search */
    fun filter(filter: String){
        notesList.clear()

        for (item in fullEvent){
            if (item.title?.lowercase()?.contains(filter.lowercase()) == true ||
                    item.notes?.lowercase()?.contains(filter.lowercase()) == true){
                notesList.add(item)
            }
        }
        notifyDataSetChanged()
    }

    inner class EventViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val cardView = itemView.findViewById<CardView>(R.id.card_event)
        val tvTittle = itemView.findViewById<TextView>(R.id.tv_tittle)
        val tvNote = itemView.findViewById<TextView>(R.id.tv_notes)
        val tvDate = itemView.findViewById<TextView>(R.id.tv_date)
    }

    interface eventClickListener{
        fun onItemClick(notes: Notes)
        fun onLongClick(notes: Notes,cardView: CardView)
    }
}