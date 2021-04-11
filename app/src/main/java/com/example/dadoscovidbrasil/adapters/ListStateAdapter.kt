package com.example.dadoscovidbrasil.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dadoscovidbrasil.R
import com.example.dadoscovidbrasil.models.State
import kotlinx.android.synthetic.main.fragment_state_item.view.*

class ListStateAdapter(
    private val states: List<State>,
    private val context: Context
) : RecyclerView.Adapter<ListStateAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val state = itemView.state_value
        val cases = itemView.cases_value
        val deaths = itemView.deaths_value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_state_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val state = states[position]
        holder.state.text = state.state
        holder.cases.text = state.cases.toString()
        holder.deaths.text = state.deaths.toString()
    }

    override fun getItemCount(): Int {
        return states.size
    }

}