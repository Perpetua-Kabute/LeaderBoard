package com.example.leaderboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.name
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class LearnerAdapter(val topLearners: List<TopLearners>): RecyclerView.Adapter<LearnerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(topLearners[position])

    }

    override fun getItemCount(): Int {
        return topLearners.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.name)
        val image = itemView.findViewById<ImageView>(R.id.image)
        val hours = itemView.findViewById<TextView>(R.id.hours)

        fun bind(learner: TopLearners){
            name.text = learner.name
            Glide.with(itemView.context).load(learner.badgeUrl).into(image)
            val hour= learner.hours.toString()
            val country = learner.country
            hours.text = "${hour} ${country}"

        }

    }
}

