package edu.iesam.dam2024.features.superHero.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superHero.domain.SuperHero
import edu.iesam.dam2024.features.superHero.presentation.SuperHeroDiffUtil

class SuperHeroAdapter : ListAdapter<SuperHero, SuperHeroViewHolder>(SuperHeroDiffUtil()) {
    lateinit var onClick: (superHeroId: String) -> Unit

    fun setEvent(onClick: (superHeroId: String) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_superhero, parent, false)
        return SuperHeroViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(currentList[position], onClick)
    }

}