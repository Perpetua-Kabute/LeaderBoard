package com.example.leaderboardpackage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.name
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.leaderboard.R
import com.example.leaderboard.TopSkillIq

class SkillIqAdapter(val topSkillIq: List<TopSkillIq>): RecyclerView.Adapter<SkillIqAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(topSkillIq[position])

    }

    override fun getItemCount(): Int {
        return topSkillIq.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.name)
        val image = itemView.findViewById<ImageView>(R.id.image)
        val hours = itemView.findViewById<TextView>(R.id.hours)

        fun bind(skillIq: TopSkillIq){
            name.text = skillIq.name
            Glide.with(itemView.context).load(skillIq.badgeUrl).into(image)
            val hour= skillIq.score.toString()
            val country = skillIq.country
            hours.text = "${hour} ${country}"

        }

    }
}



