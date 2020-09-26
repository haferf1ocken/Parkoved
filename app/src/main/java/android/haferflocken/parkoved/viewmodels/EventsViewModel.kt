package android.haferflocken.parkoved.viewmodels

import android.haferflocken.parkoved.models.Event
import android.haferflocken.parkoved.models.Story
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventsViewModel : ViewModel() {

    private val titles = listOf("5 мест, куда сходить с девушкой")
    private val stories = mutableListOf<Story>()
    private val events = mutableListOf<Event>()

    fun fillStories(): MutableList<Story> {
        for (i in 0L..5L) {
            val story = Story(i, titles.random())
            stories.add(story)
        }
        return stories
    }

    fun fillEvents(): MutableList<Event> {
        for (i in 0L..5L) {
            val event = Event(i, titles.random())
            events.add(event)
        }
        return events
    }
}