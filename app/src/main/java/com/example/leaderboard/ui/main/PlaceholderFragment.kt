package com.example.leaderboard.ui.main

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.leaderboard.*
import com.example.leaderboard.ServiceBuilder.service
import com.example.leaderboard.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_leader_board.*
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_leader_board, container, false)
//
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val call:Call<List<TopLearners>> = service.getTopLearners()
        call.enqueue(object: Callback<List<TopLearners>>{
            override fun onResponse(call: Call<List<TopLearners>>, response: Response<List<TopLearners>>) {
//                val gson: Gson = Gson()
//                val learnerResultJson: String = gson.toJson(response.body())

                if (response.isSuccessful) {
                    val result = response.body()
                    val gson: Gson = Gson()
                    val learnerResultJson = gson.toJson(result)

                    Log.d("Top Learners", learnerResultJson )
                    Log.i("success", "Data fetch was successful")
                    Log.i("First", "First fetch")
                    viewManager = LinearLayoutManager(activity)
                    viewAdapter = LearnerAdapter(result!!)
                    recyclerView = recycler_view.apply {
                        setHasFixedSize(true)
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
                }

            }

            override fun onFailure(call: Call<List<TopLearners>>, t: Throwable) {
                Toast.makeText(activity, "Data fetch failed}", Toast.LENGTH_LONG).show()
                Log.e("PlaceHolder", "${t.localizedMessage}");
                Log.i("Failed", "did not fetch")
            }
            })







    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}