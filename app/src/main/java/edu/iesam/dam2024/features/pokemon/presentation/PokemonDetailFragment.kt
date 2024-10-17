package edu.iesam.dam2024.features.pokemon.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.loadUrl
import edu.iesam.dam2024.databinding.FragmentPokemonDetailBinding
import edu.iesam.dam2024.features.movies.presentation.ErrorApp
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonDetailFragment : Fragment(){
    val args: PokemonDetailFragmentArgs by navArgs()

    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel: PokemonDetailViewModel

    private var _binding : FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonFactory = PokemonFactory(requireContext())
        viewModel = pokemonFactory.builPokemonDetailViewModel()
        setupObserver()
        args.pokemonId?.let {
            viewModel.viewCreated(it)
        }

    }

    private fun setupObserver(){
        val pokemonObserver = Observer<PokemonDetailViewModel.UiState>{
            uiState ->
            uiState.pokemon?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto error
            } ?: run {
                //ocultar error
            }
            if (uiState.isLoading) {
                //muestro el cargando
                Log.d("@dev", "Cargando ...")
            } else {
                //oculto  el cargando
                Log.d("@dev", "Cargando ...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner,pokemonObserver)
    }

    private fun bindData(pokemon: Pokemon){
        binding.apply {
            pokemonImageDetail.loadUrl(pokemon.image)
            pokemonNameDetail.text = pokemon.name
            pokemonPoder1.text = pokemon.poderes.poder1
            pokemonPoder2.text = pokemon.poderes.poder2
            pokemonPoder3.text = pokemon.poderes.poder3
            pokemonPoder4.text = pokemon.poderes.poder4

        }
    }
    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}