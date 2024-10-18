package edu.iesam.dam2024.features.superHero.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.app.loadUrl
import edu.iesam.dam2024.databinding.ItemSuperheroBinding
import edu.iesam.dam2024.features.superHero.domain.SuperHero

class SuperHeroViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val itemSuperHero = ItemSuperheroBinding.bind(view)

    fun bind(superHero: SuperHero, onClick: (superHeroId: String) -> Unit) {
        itemSuperHero.apply {
            superherpImageItem.loadUrl(superHero.images.xs)
            superheroNameItem.text = superHero.name
            view.setOnClickListener {
                onClick(superHero.id)
            }
        }
    }

}